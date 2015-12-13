package module6.slappiej.email;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import module6.slappiej.R;
import module6.slappiej.contacts.ContactObject;
import module6.slappiej.contacts.ContactSelector;

public class WriteMail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_writemail);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode  == Activity.RESULT_OK) {
            ContactObject contact = data.getParcelableExtra("contact");
            final EditText contactName = (EditText)findViewById(R.id.addressText);
            contactName.setText(contact.getEmailAddress());
        }
    }

    public void selectContact(View view) {
        Intent intent = new Intent(this, ContactSelector.class);
        startActivityForResult(intent, 0);
    }
}
