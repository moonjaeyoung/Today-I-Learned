package reactive;

import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오전 2:20
 * @Homepage : https://github.com/gusdnd852
 */
public class ReactiveX {
    public static void main(String[] args) {
        Observable.just("Hello") // 데이터 플로우의 시작, just 같은경우는 매개변수로 등록된 상수를 첫번째 노드로 플로우를 시작함.
                .map(hello -> hello + " World") // 데이터의 가공, 기존 "Hello"에 "World"를 더해줌.
                .doOnNext(System.out::println) // 액션, 여기에서는 데이터를 출력하는 액션을 취하고있음.
                .subscribe(); // 이 플로우를 구독하기 시작함.


        // observing 하는 방법
        Model model = new Model();

        model.observable()
                .observeOn(Schedulers.newThread()) // 이 쓰레드에서 구독 시작
                .filter(n -> n % 2 == 0) // 짝수만 걸러냄
                .map(data -> data + 100) // 150을 더함
                .doOnNext(n -> System.out.println(n + " : " + Thread.currentThread().getName())) // Next 호출시 쓰레드 이름과 함께 데이터 출력
                .observeOn(Schedulers.io()) // 쓰레드 변경
                .doOnCompleted(() -> System.out.println("종료 : " + Thread.currentThread().getName())) // Complete 호출시 이름과 함꼐 "종료" 출력
                .subscribe(); // 이 플로우를 구독하기 시작함.

        model.setA(5);
        model.setA(6);
        model.setA(7);
        model.setA(8);
        model.setA(200);
    }

    static class Model {
        private PublishSubject<Integer> changeObservable = PublishSubject.create();
        // 옵저버 패턴이랑 똑같음.
        private int a = 0;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            if (a > 100) {
                changeObservable.onCompleted();
            } else {
                this.a = a;
                changeObservable.onNext(a);
            }
        }

        public Observable<Integer> observable() {
            return changeObservable;
        }
    }
}
