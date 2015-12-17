package module6.slappiej.email;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import module6.slappiej.R;

/**
 * Created by Jan-Willem on 12-12-2015.
 */
public class Inbox extends Activity {

    private List<EmailObject> emails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_inbox);
        exampleEmails();
        List<EmailObject> items = getInbox();
        final ArrayAdapter<EmailObject> adapter = new ArrayAdapter<>(this, R.layout.inbox_view , items);
        final ListView inboxList = (ListView) findViewById(R.id.inboxList);
        inboxList.setClickable(true);
        inboxList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EmailObject item = adapter.getItem(position);
                readMail(item);
            }
        });
        inboxList.setAdapter(adapter);
    }

    private List<EmailObject> getInbox() {
        return emails;
    }

    private void exampleEmails() {
        emails.add(EmailObject.EMAIL_1);
        emails.add(EmailObject.EMAIL_2);
        emails.add(EmailObject.EMAIL_3);
    }

    private void readMail(EmailObject email) {
        Intent intent = new Intent(this, ReadMail.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }

    public void finish(View view) {
        this.finish();
    }

}