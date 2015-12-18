package module6.slappiej.email;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jan-Willem on 13-12-2015.
 */
public class EmailObject implements Parcelable{

    public static final EmailObject EMAIL_1 = new EmailObject("dennis@student.utwente.nl", "Taart", "Komt u morgen ook taart eten?\nLijkt me erg gezellig!\nGroeten,\nBert");
    public static final EmailObject EMAIL_2 = new EmailObject("Truus@live.nl", "Thee", "Komt u morgen ook thee drinken?\nLijkt me erg gezellig!\nGroeten,\nTruus");
    public static final EmailObject EMAIL_3 = new EmailObject("Joopvanhethek@hotmail.com", "Bingo", "Komt u morgen ook bingo spelen?\nLijkt me erg gezellig!\nGroeten,\nJoop");

    private String sender;
    private String subject;
    private String body;

    public EmailObject(String sender, String subject, String body) {
        this.sender = sender;
        this.subject = subject;
        this.body = body;
    }

    public EmailObject(Parcel in) {
        sender = in.readString();
        subject = in.readString();
        body = in.readString();
    }

    public String toString() {
        return "" + sender + ": " + subject;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sender);
        dest.writeString(subject);
        dest.writeString(body);
    }

    public static final Parcelable.Creator<EmailObject> CREATOR = new Parcelable.Creator<EmailObject>() {

        @Override
        public EmailObject createFromParcel(Parcel source) {
            return new EmailObject(source);
        }

        @Override
        public EmailObject[] newArray(int size) {
            return new EmailObject[size];
        }
    };
}
