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

    private ArrayList<EmailObject> emails = new ArrayList<>();
    private ArrayAdapter<EmailObject> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_inbox);
        exampleEmails();
        List<EmailObject> items = getInbox();
        adapter = new ArrayAdapter<>(this, R.layout.inbox_view , items);
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

    private ArrayList<EmailObject> getInbox() {
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

    public void SearchInbox(View view) {
        Intent intent = new Intent(this, SearchMail.class);
        intent.putParcelableArrayListExtra("email", getInbox());
        startActivityForResult(intent, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                adapter.clear();
                ArrayList<EmailObject> emails = data.getParcelableArrayListExtra("emails");
                if (emails != null) {
                    adapter.addAll(emails);
                }
            }
        }
    }

    public void finish(View view) {
        this.finish();
    }

}