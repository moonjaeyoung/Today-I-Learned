import java.sql.*;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-11 오전 3:40
 * @Homepage : https://github.com/gusdnd852
 */

public class BaseDAO {
    static {
        try {
            Class.forName(SQL.DRIVER);
        } catch (ClassNotFoundException ignore) {
        }
    }

    //Statemet 객체
    // executeUpdate = SQL 실행후 테이블의 내용만 변경되는 경우 (insert, delete, update)
    // eventQuery = SQL 실행후 결과값이 생길때 (select) -> resultSet으로 반환됨.

    // eventQuery 객체의 메소드
    // 1. next : 다음 레코드로 이동 (인스턴스, 행렬의 행)
    // 2. previous : 이전 레코드로 이동
    // 3. first : 처음으로 이동
    // 4. last : 마지막으로 이동
    // 5. get : 데이터를 가져옴


    public void connect() {     //try with resource 문 사용.
        //try 안의 모든 작업이 끝나면 알아서 스트림을 닫아줌
        try (Connection connection = DriverManager.getConnection(SQL.URL, SQL.ID, SQL.PW);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from MEMBER")) {
            //SQL 인텔리센스 진짜 최고다.

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                System.out.println(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
