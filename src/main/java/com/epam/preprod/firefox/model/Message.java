package com.epam.preprod.firefox.model;

/**
 * Created by Oksana_Nytrebych on 5/26/2016.
 */
public class Message {

    private String to;
    private String subject;
    private String body;

    public Message(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
