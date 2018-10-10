package model;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-06 오전 11:45
 * @Homepage : https://github.com/gusdnd852
 */
public class UserBean {
    // 빈이란 : 데이터의 속성과 연산으로 이루어진 클래스를 말함.
    // 이러한 데이터클래스를 빈이라고 함.

    private String name;
    private String id;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
