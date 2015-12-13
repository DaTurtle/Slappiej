package module6.slappiej.email;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jan-Willem on 13-12-2015.
 */
public class EmailObject implements Parcelable{
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
