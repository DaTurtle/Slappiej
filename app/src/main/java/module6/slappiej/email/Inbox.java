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

    private static String[] list = {"First", "Second", "Third"};

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
        return list;
    }

}