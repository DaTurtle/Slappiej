package module6.slappiej.contacts;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jan-Willem on 13-12-2015.
 */
public class ContactObject implements Parcelable {

    public static final ContactObject first = new ContactObject("bert", "van dalen", "bertvandalen@hetnet.nl");
    public static final ContactObject second = new ContactObject("kees", "Reimink", "reimink@kees.nl");
    public static final ContactObject third = new ContactObject("truus", "Nobbe", "truusn@gmail.com");

    private String firstName;
    private String lastName;
    private String emailAddress;

    public ContactObject(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        emailAddress = in.readString();
    }

    public ContactObject() {

    }

    public ContactObject(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public String toString() {
        return "" + firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(emailAddress);
    }

    public static final Parcelable.Creator<ContactObject> CREATOR = new Parcelable.Creator<ContactObject>() {

        @Override
        public ContactObject createFromParcel(Parcel source) {
            return new ContactObject(source);
        }

        @Override
        public ContactObject[] newArray(int size) {
            return new ContactObject[size];
        }
    };
}
