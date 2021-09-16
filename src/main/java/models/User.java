package models;

public class User {
    String email;
    String password;

    //____________________________________________ fluent style ________________________________________________
    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    //____________________________________________ fluent style ________________________________________________
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
