package reactive;

import com.sun.xml.internal.ws.encoding.soap.SerializationException;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 처음에는 JSP + Javascript + 서블릿에 데이터베이스까지 연결해서 진짜처럼 짜서 보여줄까 했는데
 * 전체적인 아키텍쳐가 어떻게 돌아가는지 이해하고, 핵심 라이브러리인 RxJava가 무엇인지 이해하시는데는
 * 자바 코드로 먼저 보고 나중에 JSP 서블릿으로 구현된 코드를 보는게 좋을 것 같아서 먼저 자바파일로 작성했습니다.
 * 다음번에 서블릿 JSP 로 구현한 예제도 만들어 드릴게요 ~
 * 
 * 
 * 
 * 먼저 MVC 패턴에 대한 이해가 없으신분들을 위해 설명드리자면,
 * 
 * View는 이름 그대로 사용자에게 보이는 부분입니다. 사용자는 이 View를 보고 데이터를 입력하거나
 * 버튼을 눌러서 웹 어플리케이션 서버로 어떠한 데이터의 처리나 가공을 요청 할 수 있죠.
 * 
 * Controller는 View에게서 요청받은 데이터를 받아와서 적절한 모델을 찾아 데이터의 처리를 요청합니다.
 * 그리고 Model의 데이터 처리작업이 끝나면, 다시 뷰에게 response를 보내서 뷰를 업데이트 합니다.
 * 
 * Model은 컨트롤러에게 View의 데이터를 넘겨받아 적절한 처리(비즈니스 로직)를 거친후에
 * 컨트롤러에게 알립니다.
 * 
 * 흔히들 모델에서 비즈니스로직이 실행된다고 하고, 콘트롤러에서 프레젠테이션 로직이 실행된다고 하는데
 * 비즈니스로직과 프레젠테이션 로직이 무엇일까요?
 * 
 * 비즈니스 로직이란 서버 및 데이터베이스 같은 백엔드로직,
 * 주로 사용자에게 보이지 않는 데이터 처리로직을 비즈니스로직이라고 말합니다.
 * 
 * 반대로 프레젠테이션 로직은 뷰를 업데이트 시키는 일련의 과정을 프레젠테이션 로직이라고합니다.
 * 프레젠테이션 말 그 뜻대로 뷰로 하여금 무언가를 사용자에게 보여주는 로직입니다.
 * 
 * 뭐 MVC 패턴을 사용하는 이유는 당연하겠죠?
 * 각자가 각자의 역할만 진행하여 코드의 유지보수가 보다 수월해지고,
 * 만약 비즈니스 로직이 수정되어야하면 모델만, ui가 수정되어야하면 뷰만 수정하는 식으로
 * 깔끔하게 유지보수 할 수 있겠죠? 그리고 코드의 가독성 또한 비약적으로 상승합니다.
 */
class SignUp_MVC {
    static boolean network = true;
    static boolean db = true;
    static boolean serialization = true;
    // 임의로 지정한 각종 상태값입니다.
    // 변경해서 테스트 해보세요.

    /**
     * 메인 함수 :  뷰에서 회원가입 버튼이 눌린 상황이라고 가정합니다.
     */
    public static void main(String[] args) {
        new View().signUp();
    }

    /**
     * 원래는 MVC 컴포넌트와 Entity 클래스, 팩토리클래스등이 모두 분리된 자바 파일에 있어야하는데,
     * 여기저기 움직이면서 보기 힘들 것 같아서 한개의 자바파일안에 static 이너 클래스로 구현하였습니다.
     * 위부터 그냥 쭉 읽는게 더 편할듯 해서 글까지 포함해서 이런식으로 써봤습니다.
     */
    static class View {
        Scanner scanner = new Scanner(System.in);

        /**
         * 입력을 받고 클릭버튼을 누른다고 가정합니다.
         * 실제 JSP코드에서는 <form>태그로 대체될 것이고 클릭 이벤트는 <input type="submit"> 으로 대체될 것입니다.
         * input 태그의 속성중 method 속성을 "post"로 지정하면 doPost를 호출 할 수 있습니다.
         * 
         * doPost 같은 경우 url에 쿼리(넘겨받은 email, pw 같은 데이터)가 노출되지 않아서 조금더 보안에 유리합니다.
         * 이와 반대로 doGet같은 경우는 www.naver.com/search?query="검색" 같은 방식으로 쿼리가 url에 노출되어
         * 보안에 불리하기 떄문에, 실제 개발중에 반드시 doPost를 사용하여야합니다.
         */
        void signUp() {
            System.out.println("이메일 : ");
            String email = scanner.nextLine();
            System.out.println("패스워드 : ");
            String password = scanner.nextLine();

            new Controller().doPost(email, password);
        }
    }

    /**
     * 콘트롤러 클래스입니다. 서블릿으로 구현될 예정입니다.
     * 콘트롤러 클래스에 두개의 ExecutorService를 만들어 놓았는데, 각각 백그라운드와 UI 업데이트용 쓰레드로 따로 사용할 예정입니다.
     * 스케쥴러 같은경우는 제가 유틸로 각각 목적에 맞게 여러개를 생성해 놓을 것이니 신경 쓰지 않아도 될거에요. 그냥 갖다 쓰면됩니다 ^__^
     * 
     * 여기에서 Executor 까지 설명하기에는 너무 내용이 많고 어려우니
     * 혹시 Executor에 대해 궁금하신분은 구글을 참고하시거나 아래를 참고하세요 !
     *
     * @see java.util.concurrent.ExecutorService
     * @see java.util.concurrent.Executor
     */
    static class Controller {

        static ExecutorService background = Executors.newSingleThreadExecutor(r -> new Thread(r, "BACKGROUND"));
        static ExecutorService UI = Executors.newSingleThreadExecutor(r -> new Thread(r, "UI"));

        /**
         * 뷰로부터 요청(request)가 들어왔고 doPost 메소드가 실행됩니다.
         * 실제 서블릿의 doPost 메소드를 생각하시면 됩니다. 물론 실제 서블릿에서는 request.getParameter()로 정보를 가져오겠죠?
         * doPost 메소드가 실행되면, email과 password를 하나의 리스트로 만들어서 모델(DAO)에게 데이터 처리를 요청합니다.
         * 여기서 모델은 회원가입용 모델입니다. 이 usecase 에서는 회원가입 이외의 작업이 존재하지 않기 때문에 모델이름을
         * 그냥 Model이라고 정의하였습니다.
         * 
         * Model.get() 메소드를 호출해서 모델객체를 생성해주고(싱글톤) 옵저버블 메소드를 호출하여 옵저버와 연결해줍니다.
         * 그리고 onNext를 실행하여 데이터를 입력해줍니다. (email과 password를 리스트로 만들어서 전달하였음)
         *
         * @param email    사용자에게 입력받은 이메일입니다.
         * @param password 사용자에게 입력받은 패스워드입니다.
         */
        void doPost(String email, String password) {
            Model.get()
                    .observable()
                    .onNext(Arrays.asList(email, password));
        }

        /**
         * 사실 doPost 메소드보다 이 생성자가 먼저 호출이 되겠죠?
         * doPost 메소드에서 모델에 있는 옵저버객체에게 데이터를 건내주며 일을 시켰는데,
         * 그 일을 어떻게 어떤 순서로 어떤 쓰레드에서 작업할지 생성자에서 먼저 정해주는 과정입니다.
         * 즉, 이 회원가입 이벤트의 전체 이벤트 흐름을 한눈에 확인 할 수 있습니다.
         * 
         * 여기에서 바로 RxJava 라이브러리를 사용했는데, 기존방식으로 하려면 콜백 안에 콜백 안에 콜백 안에 콜백 안에....
         * 엄청 복잡해집니다. 그래서 많은 사람들이 이 MVC를 구현할 때 디자인패턴중에서 커맨드패턴 (기존에 우리가 배웠던 스트레티지패턴과 거의 동일)
         * 을 이용하여 비즈니스 로직을 수행하는 모델에게 인터페이스를 넘겨서 실행하는 방식으로 구성하는데,
         * 엄청 많은 커맨드를 만들어내야해서 코드도 복잡해지고 보기에도 좋지 않습니다.
         * 
         * 자 차례대로 따라가면서 찬찬히 읽어봅시다.
         */

        // 화살표(람다식)랑 ::(메소드레퍼런스) 문법이 나와서 당황스러우실수 있는데,
        // 자바8 이후로 지원되는 함수형 프로그래밍 기법들입니다.
        // 힘수형 프로그래밍 기법에 대해 궁금하신분은
        // https://github.com/gusdnd852/Today-I-Learned/blob/master/RX/src/main/java/functional/FirstCitizen.java
        // https://github.com/gusdnd852/Today-I-Learned/blob/master/RX/src/main/java/reactive/ReactiveX.java
        // https://www.youtube.com/watch?v=bCatYAGpg-A&index=2&list=PLRIMoAKN8c6O8_VHOyBOhzBCeN7ShyJ27
        // 여기를 참고하세요! 아래 영상은 재생목록 전부다 너무 좋은 영상들이라 다 보시는것도 추천! (케빈 - 모던자바 강의)

        Controller() {
            Model.get().observable() // 옵저버 객체에 연결합니다.
                    .observeOn(Schedulers.from(UI)) // 첫번째로 쓰레드를 UI로 설정합니다.
                    .doOnNext(o -> showProgress()) // 프로그레스바를 보여줍니다.
                    .observeOn(Schedulers.from(background)) // 쓰레드를 백그라운드로 전환합니다.
                    .doOnNext(o -> Model.get().signUp(o)) // onNext에서 들어온 데이터를 이용해 회원가입을 시도합니다.
                    .observeOn(Schedulers.from(UI)) // 원래 이 부분은 없어야하는데 동시에 작업이 돌아가고 있다는 것을 보여주기 위해 프로그레스가 진행중임을 알립니다.
                    .doOnNext(o->showProgress()) // 물론 프로그레스는 UI에서 돌고 있겠죠?
                    .observeOn(Schedulers.from(background)) // 백그라운드 쓰레드로 전환합니다.
                    .doOnNext(o -> Model.get().save(o)) // 데이터베이스에 저장합니다.
                    .map(o -> Entity.builder() // 시리얼라이제이션을 위해 데이터를 엔티티로 만들어줍니다.
                            .setEmail(o.get(0))
                            .setPassword(o.get(1))
                            .build())
                    .observeOn(Schedulers.from(UI)) // 마찬가지로 UI쓰레드에서 돌고 있다는 것을 알리기 위해..
                    .doOnNext(o->showProgress()) // 프로그레스가 현재 실행중입니다.
                    .observeOn(Schedulers.from(background)) // 백그라운드로 전환
                    .doOnNext(o -> Model.get().serialize(o)) // 시리얼라이제이션을 시도합니다.
                    .observeOn(Schedulers.from(UI)) // 프로그레스는 계속 실행중
                    .doOnNext(o->showProgress()) // UI쓰레드에서 실행중입니다.
                    .observeOn(Schedulers.from(background)) // 백그라운드 쓰레드로 이동하여
                    .doOnNext(o -> Model.get().complete()) // 모델에게 작업이 끝남을 알립니다.
                    .observeOn(Schedulers.from(UI)) // 쓰레드를 UI로 전환합니다.
                    .doOnCompleted(this::updateView) // 성공시 액션 : 뷰를 업데이트 합니다.
                    .doOnError(this::onError) // 실패시 액션 : 에러를 보여줍니다.
                    .doOnTerminate(() -> background.shutdown()) // 쓰레드를 다 사용하였으니 셧다운시킵니다. -> 원래 스케줄러같은경우 원래는 정적으로 만들어놓고
                    .doOnTerminate(() -> UI.shutdown())// 쓰레드를 다 사용하였으니 셧다운시킵니다. -> 웹어플리케이션에서 계속 사용합니다. 지금은 예시이기 때문에 쓰레드를 닫아서 프로그램을 끝내줍니다.
                    .subscribe(); // 이 이벤트 흐름을 옵저버 객체에게 구독하도록 합니다.

            /*
             * 뭔가 엄청 길고 어려워 보였는데 한줄 한줄 읽으면 그다지 어렵지 않죠?
             *
             * 콘트롤러에서 request (사용자에게 요청)을 받게 되면, 필요한 모델에게 데이터의 가공및 처리를
             * 요구하고 작업이 끝날때까지 프로그레스바 등을 띄워서 사용자를 기다리게 만들어야합니다.
             * 그리고 모델에서 작업(백그라운드)이 모두 끝나면, 이제 response를 보내 뷰를 업데이트해서
             * 사용자에게 성공 및 실패를 알려야합니다. 엄청 당연해 보이지만 막상 구현해보려면
             * 비동기 작업이 필요하여 상당히 어렵습니다.
             *
             * 자 그럼 여기에서 비동기 적인 스킬이 왜 필요한지 알아볼까요?
             * 작업 saveDB() 와 updateView()가 있다고 해보겠습니다.
             *
             * 1 model.saveDB();
             * 2 updateView();
             *
             * 이렇게 되겠죠?
             * 그러면 데이터베이스에 데이터를 저장을 모두 마친뒤에 뷰를 업데이트 하게 될까요?
             * 아닙니다.
             *
             * saveDB()의 작업이 모두 끝난뒤에 updateView()가 호출되는 것이 아니라,
             * saveDB()의 호출이 모두 끝나고 updateView()가 호출됩니다.
             * 가령 데이터베이스에 저장하는 작업이 3초가 걸린다면, 3초를 기다리지 않고
             * 0.0...01초만에 saveDB()메소드를 호출하고, 호출이 끝난뒤에 updateView()가 호출됩니다.
             * 그렇다면 우리가 원치 앟는 결과가 발생하겠죠?
             *
             * 때문에 이렇게 실행해주어야 합니다.
             *
             * saveDB(){
             * ...작업중....
             * updateView();
             * } 선언부
             *
             * ...
             *
             * saveDB();
             * 호춟부
             *
             * 이렇게 saveDB() 메소드 내부에서 모든 작업이 끝난뒤에 뷰를 업데이트 하는 코드를 짜야합니다.
             * 자 그럼 이렇게 하면 되지 뭐 이렇게 어렵게 이런 라이브러리를 쓰고 그러냐.. 라고 할 수 있는데,
             * 아시는지 모르겠지만, 우리는 웹 어플리케이션에서 동적으로 뷰를 업데이트 하기 위해서 response 라는 내장객체를 사용하는데,
             * 이 response는 서블릿이나 jsp의 스크립트릿(<% %>) 내부에서만 사용할 수 있습니다.
             *
             * 하지만 저 saveDB 메소드는 모델에 있습니다. 그러면 response 객체를 모델로 넘겨서 사용해야 할까요?
             * 아니요. 에러가 나면서 안됩니다. response 객체는 오로지 서블릿과 jsp의 스크립트릿 내부에서만 사용할 수 있게
             * 설계 되었습니다. 그러면 어떻게 할까요?? 아까 말한대로 커맨드 패턴을 사용할 수 있겠죠?
             *
             * Runnable updateView(HttpResponse response){
             *      return () -> response.method();
             * }
             * 이렇게 뷰를 업데이트 하는 러너블 인터페이스를 작성한뒤에 model에게 이 러너블 인터페이스를 넘긴뒤
             * 모델에서 runnable.run(); 을 실행하면 되겠죠? 그런데 만약 뷰를 업데이트하는 작업이 100개 라면?
             * 쓰레드 여러개를 동시에 돌리는 복잡한 작업의 경우엔? 막막합니다..
             *
             * 저 인터페이스를 백개나 만들어서 모델에 setAction1(R r1), setAction2(R r2), setAction3(R r3) .... 등
             * 백개의 인터페이스 세터 메소드를 만들 수도 없는 노릇이고 쓰레드 관련 문제는 더 노답입니다.
             * 그래서 나온 것이 이 ReactiveX (RX) 라이브러리입니다.
             * 차례대로 어떤 메소드가 어떤 쓰레드에서 어떻게 돌아가는지 순서대로 지정해줄수 있어서 굉장히 편리합니다.
             * 어려워 보이는데 간단한 사용법만 익히면 편하게 사용할 수 있습니다.
             *
             * 리액티브 프로그래밍을 자바에 도입한 라이브러리인데, 리액티브 프로그래밍이란 기존의 명령형프로그램처럼
             * 위에서부터 코드를 쭉 읽어나가는 것이 아니라, 여기저기에 필요한 코드들이 구현되어있고, 어떤 상황이 발생시
             * (Complete, Error 등등) 거기에 맞는 코드가 실행되는 새로운 프로그래밍 패러다임입니다.
             *
             * 요즘 대두되는 반응성면에서 훨씬 좋은 모습을 보여주고, 코드의 유지보수면에서도 훨씬 나은 모습을 보여줍니다.
             * 시간이 나면 리액티브 프로그래밍에 대해서랑 더 자세한 RxJava 사용법에 대해서 알려드리도록 할게요 !
             * **/
        }

        /**
         * 뷰를 업데이트 하는 로직입니다.
         * 모든작업이 끝나고 실행될 것이며, 프로그레스바를 내리고 뷰를 업데이트 시킵니다.
         * 실제 프로젝트에서는 response 객체가 이 역할을 수행하겠죠?
         */
        void updateView() {
            System.out.println("작업성공, 프로그레스바를 종료합니다 : " + Thread.currentThread().getName());
            System.out.println("작업 성공, 뷰를 업데이트합니다. : " + Thread.currentThread().getName());
        }

        /**
         * 작업이 시작됐는데 아무런 반응이 없으면 사용자는 이게 렉이 걸린건지 잘 되고있는지 알 수가 없죠.
         * 작업이 시작되면 프로그레스바를 호출하여 지금이 작업중이라는 것을 알려줘야합니다.
         * 프로그레스바는 사실 눈에 보여주는 용도이고, 작업은 모델클래스에서 비즈니스 로직부분에서 진행이 되겠죠.
         * 마찬가지로 이 부분도 response 객체가 수행할 예정입니다.
         */
        void showProgress() {
            System.out.println("프로그레스바 : " + Thread.currentThread().getName());
        }

        /**
         * 에러 발생시에 호출될 메소드입니다. 지금은 모든 에러후 처리가 단순히 메시지를 프린트해주는 것이기 떄문에
         * 메소드를 따로 안나눠놨는데, 복잡한 작업이 요구될 경우에는 여러개의 에러메소드를 만들고, 이 onError 메소드에서
         * 그 메소드를 호출하는 방식으로 사용됩니다.
         * response 객체를 사용하여 메시지를 호출하거나, <%@ page errorPage %> 지시어를 사용해 에러페이지로 이동합니다.
         *
         * @param throwable 엑셉션의 종류를 알리는 파라미터입니다. Throwable의 종류에 따라 다른 에러 메시지가 호출됩니다.
         */
        void onError(Throwable throwable) {
            if (throwable instanceof IllegalAccessException)
                System.out.println("네트워크 접속 에러가 발생하였습니다.");

            else if (throwable instanceof IllegalArgumentException)
                System.out.println("데이터베이스 접속에 실패하였습니다.");

            else if (throwable instanceof SerializationException)
                System.out.println("데이터를 저장하지 못햇습니다. 다시 입력해주세요..");

            else System.out.println("알수 없는 에러가 발생하였습니다.");

            System.out.println("프로그레스바를 종료합니다 : " + Thread.currentThread().getName());
        }
    }

    /**
     * 모델입니다. 비즈니스 로직을 수행합니다.
     */
    static class Model {
        private static Model singleton = null;
        // 자기 자신의 참조를 가지고있습니다.

        private Model() {
        } // 생성자를 막습니다.

        /**
         * 모델(DAO)는 보통 싱글톤으로 구현을 합니다. 회원가입버튼을 누를때 이 모델이 생성되는데
         * 이 모델에서 진행되는 작업의 내용은 모두 같은데 굳이 같은 객체를 여러개 생성할 필요가 없겠죠?
         * 또, 회원가입같은경우는 회원가입 화면에서만 사용이 되겠지만, 다른 모델같은 경우는
         * 이 컨트롤러 저 컨트롤러에서 불려가서 사용이 되는데  정적인 유일객체로 만들면 데이터가 보존되어
         * 다른클래스에서도 해당 정보에 손쉽게 엑세스 할수 있기 떄문에 싱글톤으로 구현합니다.
         *
         * @return singleton 싱글톤 객체를 리턴합니다.
         */
        public static Model get() {
            if (singleton == null) singleton = new Model();
            return singleton;
        }

        /**
         * 옵저버 역할을 하는 PublishSubject 객체입니다.
         * Rx 라이브러리에는 4가지정도의 Subject 객체가 있는데, 그 특징은 다음에 자세히 설명 드리겠습니다.
         * 지금은 이 객체가 아까 그 콘트롤러에서 정해준 대로 일을 수행하도록 콘트롤러를의 이벤트 스트림을 관찰(구독)하고 있고,
         * 콘트롤러로부터 데이터의 입력(onNext)를 대기하고 있는 객체라는 것만 알아두면 됩니다.
         */
        // 혹시 옵저버패턴에 대해서 더 보고싶은분은 아래를 참고하세요 !
        //https://github.com/gusdnd852/Today-I-Learned/blob/master/RX/src/main/java/observer/ObserverImpl.java
        //https://github.com/gusdnd852/Today-I-Learned/blob/master/RX/src/main/java/observer/ObserverPattern.java
        // //https://www.youtube.com/watch?v=4w4AV1HURJs&index=18&list=PLsoscMhnRc7pPsRHmgN4M8tqUdWZzkpxY
        // (박가람 - 자바 디자인패턴의 이해)
        private PublishSubject<List<String>> observer = PublishSubject.create();

        /**
         * 서브젝트를 리턴하는 게터메소드입니다.
         *
         * @return observer 옵저버 역할을 하는 서브젝트 객체를 리턴합니다.
         */
        public PublishSubject<List<String>> observable() {
            return observer;
        }

        /**
         * 회원가입을 시작하는 signUp 메소드입니다. 시간이 상당히 걸리는 헤비한 작업임을 알리기 위해
         * 여기에서는 sleep() 메소드를 사용해 의도적으로 시간을 지연시켰습니다.
         * 네트워크 상태가 true이면 작업을 실행하고 false이면 잘못된 접근에 대한 예외를 발생시킵니다.
         *
         * @param info onNext 메소드는 파라미터가 하나밖에 없기떄문에 리스트형태로 데이터를 입력받습니다.
         */
        public void signUp(List<String> info) {
            if (network) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("작업 시작, 네트워크 연결중 : " + Thread.currentThread().getName());
            } else observer.onError(new IllegalAccessException("Network Access ERROR"));
        }

        /**
         * 네트워크 접속이 성공하면 호출됩니다. 여기에서는 데이터베이스에 접근을 시도합니다.
         * 마찬가지로 2초의 지연을 주었고 db의 상태에 따라 분기가 성공, 실패로 나뉩니다.
         * 성공시에는 오브젝트 직렬화를 시도하고 실패시 잘못된 매개변수 관련 예외를 발생시킵니다.
         *
         * @param info 위의 메소드에서 받아온 데이터를 이용하여 Entity 객체를 만들고 직렬화를 시도합니다.
         */
        public void save(List<String> info) {
            if (db) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("작업 중, 데이터베이스 접속중 : " + Thread.currentThread().getName());

            } else observer.onError(new IllegalArgumentException("Argument ERROR"));
        }

        /**
         * 오브젝트를 직렬화하는 메소드입니다. 오브젝트를 직렬화하여 데이터베이스에 기입합니다.
         * 아마 라이브러르는 잭슨이나 Gson을 사용하지 않을까 싶습니다.
         * 직렬화가 끝난뒤에 회원가입에 성공한 이메일과 패스워드를 띄워줍니다.
         * 이 작업도 마찬가지로 serialization이 가능한 상태인지 불가능한 상태인지에 따라 분기가 나뉘는데
         * 성공시 옵저버에게 작업이 모두 끝남을 알리고 실패시에는 직렬화 관련 예뢰를 발생시킵니다.
         *
         * @param entity 직렬화할 오브젝트입니다. 여기에서는 유저정보에 대한 엔티티입니다.
         */
        public void serialize(Entity entity) {
            if (serialization) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("접속완료, 직렬화 후 저장중 : " + Thread.currentThread().getName());
                System.out.println("저장된 email : " + entity.email + " : " + Thread.currentThread().getName());
                System.out.println("저장된 password : " + entity.password + " : " + Thread.currentThread().getName());
            } else observer.onError(new SerializationException("Serialization ERROR"));
        }

        /**
         * 작업이 모두 종료되었음을 옵저버 객체에게 알립니다.
         * complete가 되면 어떻게 행동하라고 미리 콘트롤러 클래스에서 알려줬기 때문에
         * 그대로 실행합니다.
         */
        public void complete() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            observer.onCompleted();
        }
    }

    /**
     * 유저의 정보를 담은 엔티티 클래스입니다.
     * 빌더패턴을 사용하여 구현하였는데, 기존 게터세터같은 경우 객체를 생성한 이후에도
     * 이 객체가 가진 프로퍼티(데이터)가 변경 될 수 있죠. 보통 이러한 객체에는 생성자를 사용하여
     * 객체의 데이터를 동결시킵니다. 생성시에 데이터가 입력되고, 이후에는 수정할 수 없습니다.
     * 
     * Entity entity = new Entity(email, password);
     * 이후에 setEmail 등 불가.
     * 
     * 이 경우에는 예시이기 떄문에 email과 password 밖에 없지만, 정말 회원가입을 구현한다면 이름도 받고
     * 자기소개도 받고 여러가지 데이터를 입력 받을 수 있는데 생성자에 너무 많은 데이터가 들어가게 되면
     * 이제 생성자에 몇번째 파라미터가 무엇이엇는지 헷갈리게 됩니다.
     * 
     * Entity entity = new Entity(str1, str2, str3, str4, str5, str6 ....);
     * 때문에 이러한 문제를 해결하기 위하여 명시적으로 객체의 생성시에 모든 프로퍼티를 입력하면서,
     * 명시적으로 그것이 어던 프로퍼티인지 보면서 객체를 생성 할 수 있게 끔 해줍니다.
     * 또 this를 리턴하여 계속 메소드를 순서대로 체이닝하여 붙여서 사용할 수 있기때문에 굉장히 편리하게 사용할 수 있습니다.
     */
    static class Entity {
        private String email;
        private String password;

        private Entity(Builder builder) {
            this.email = builder.email;
            this.password = builder.password;
        }

        public static Builder builder() {
            return new Builder();
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public static class Builder {

            private String email;
            private String password;

            public Builder setEmail(String email) {
                this.email = email;
                return this;
            }

            public Builder setPassword(String password) {
                this.password = password;
                return this;
            }

            public Entity build() {
                return new Entity(this);
            }
        }
    }
}
// 출력 결과 :
//
//        이메일 :
//        example@naver.com
//         패스워드 :
//        123456789
//        프로그레스바 : UI
//        작업 시작, 네트워크 연결중 : BACKGROUND
//        프로그레스바 : UI
//        작업 중, 데이터베이스 접속중 : BACKGROUND
//        프로그레스바 : UI
//        접속완료, 직렬화 후 저장중 : BACKGROUND
//        저장된 email : example@naver.com : BACKGROUND
//        저장된 password : 123456789 : BACKGROUND
//        프로그레스바 : UI
//        작업성공, 프로그레스바를 종료합니다 : UI
//        작업 성공, 뷰를 업데이트합니다. : UI
//
//        Process finished with exit code 0