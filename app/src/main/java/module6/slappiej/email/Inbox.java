package module6.slappiej.email;

import android.app.Activity;
import android.content.DialogInterface;
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
        String[] items = getInbox();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , items);
        final ListView inboxList = (ListView) findViewById(R.id.listView);
        inboxList.setClickable(true);
        inboxList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = inboxList.getItemAtPosition(position);
                String item = o.toString();
            }
        });
        inboxList.setAdapter(adapter);
    }

    private String[] getInbox() {
        String[] emails = new String[3];
        emails[0] = EmailMain.email1.getSubject();
        emails[1] = EmailMain.email2.getSubject();
        emails[2] = EmailMain.email3.getSubject();
        return emails;
    }

}