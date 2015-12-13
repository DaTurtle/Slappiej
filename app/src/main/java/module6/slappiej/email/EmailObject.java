package module6.slappiej.email;

/**
 * Created by Jan-Willem on 13-12-2015.
 */
public class EmailObject {
    private String sender;
    private String subject;
    private String body;

    public EmailObject(String sender, String subject, String body) {
        this.sender = sender;
        this.subject = subject;
        this.body = body;
    }

    public EmailObject() {
    }

    public String getSender() {
        return sender;
    }

    public EmailObject setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public EmailObject setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getBody() {
        return body;
    }

    public EmailObject setBody(String body) {
        this.body = body;
        return this;
    }
}
