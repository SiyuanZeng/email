package com.epam.preprod.firefox.model;

/**
 * Created by Oksana_Nytrebych on 5/26/2016.
 */
public class User {


    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
