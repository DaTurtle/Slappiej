package module6.slappiej.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import module6.slappiej.R;
import module6.slappiej.email.WriteMail;

/**
 * Created by Jan-Willem on 13-12-2015.
 */

public class ContactSelector extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_selector);
        ContactObject[] items = getContacts();
        final ArrayAdapter<ContactObject> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , items);
        final ListView contactList = (ListView) findViewById(R.id.contactList);
        contactList.setClickable(true);
        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactObject item = adapter.getItem(position);
                selectContact(item);
            }
        });
        contactList.setAdapter(adapter);
    }

    private void selectContact(ContactObject item) {
        Intent intent = new Intent();
        intent.putExtra("contact", item);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public ContactObject[] getContacts() {
        ContactObject[] cntcts = new ContactObject[3];
        cntcts[0] = ContactObject.first;
        cntcts[1] = ContactObject.second;
        cntcts[2] = ContactObject.third;
        return cntcts;
    }
}
