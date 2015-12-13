package module6.slappiej.email;

import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import module6.slappiej.R;

/**
 * Created by Jan-Willem on 12-12-2015.
 */
public class Inbox extends Activity {

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_inbox);
        EmailObject[] items = getInbox();
        final ArrayAdapter<EmailObject> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , items);
        final ListView inboxList = (ListView) findViewById(R.id.listView);
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

    private void readMail(EmailObject email) {
        Intent intent = new Intent(this, ReadMail.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }

    private EmailObject[] getInbox() {
        EmailObject[] emails = new EmailObject[3];
        emails[0] = EmailMain.email1;
        emails[1] = EmailMain.email2;
        emails[2] = EmailMain.email3;
        return emails;
    }

}