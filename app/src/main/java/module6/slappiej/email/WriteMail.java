package module6.slappiej.email;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import module6.slappiej.R;
import module6.slappiej.contacts.ContactObject;
import module6.slappiej.contacts.ContactSelector;

public class WriteMail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_writemail);
        Intent i = getIntent();
        if (i.getBooleanExtra("hasName", false)) {
            String name = i.getStringExtra("name");
            EditText address = (EditText) findViewById(R.id.addressText);
            address.setText(name);
        }
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

    public void sendMail(View view) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Bevestigen")
                .setMessage("Weet u zeker dat u deze mail wilt verzenden?")
                .setPositiveButton("Ja", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText address = (EditText) findViewById(R.id.addressText);
                        EditText subject = (EditText) findViewById(R.id.subjectText);
                        EditText mailBody = (EditText) findViewById(R.id.mailBodyText);

                        SentMail.newMail(new EmailObject(address.getText().toString(),
                                subject.getText().toString(), mailBody.getText().toString()));
                        setContentView(R.layout.activity_email_main);
                        finish();
                    }

                })
                .setNegativeButton("Nee", null)
                .show();
    }

    public void finish(View view) {
        this.finish();
    }
}
