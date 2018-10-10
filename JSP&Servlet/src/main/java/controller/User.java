package controller;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-10 오후 10:47
 * @Homepage : https://github.com/gusdnd852
 */
public class User {

    private Object properties;

    private User(Builder builder) {
        this.properties = builder.properties;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Object properties;

        public Builder() {

        }

        public Builder setProperties(Object properties) {
            this.properties = properties;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
