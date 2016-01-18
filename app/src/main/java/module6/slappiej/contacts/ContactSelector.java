package module6.slappiej.contacts;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

import module6.slappiej.R;

/**
 * Created by Jan-Willem on 13-12-2015.
 */

public class ContactSelector extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_selector);
        ContactObject[] items = getContacts();
        final ArrayAdapter<ContactObject> adapter = new ArrayAdapter<>(this, R.layout.inbox_view , items);
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

    public ArrayList<String> getNameEmailDetails() {
        ArrayList<String> emlRecs = new ArrayList<String>();
        HashSet<String> emlRecsHS = new HashSet<String>();
        Context context = getApplicationContext();
        ContentResolver cr = context.getContentResolver();
        String[] PROJECTION = new String[] { ContactsContract.RawContacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.PHOTO_ID,
                ContactsContract.CommonDataKinds.Email.DATA,
                ContactsContract.CommonDataKinds.Photo.CONTACT_ID };
        String order = "CASE WHEN "
                + ContactsContract.Contacts.DISPLAY_NAME
                + " NOT LIKE '%@%' THEN 1 ELSE 2 END, "
                + ContactsContract.Contacts.DISPLAY_NAME
                + ", "
                + ContactsContract.CommonDataKinds.Email.DATA
                + " COLLATE NOCASE";
        String filter = ContactsContract.CommonDataKinds.Email.DATA + " NOT LIKE ''";
        Cursor cur = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, PROJECTION, filter, null, order);
        if (cur.moveToFirst()) {
            do {
                // names comes in hand sometimes
                String name = cur.getString(1);
                String emlAddr = cur.getString(3);

                // keep unique only
                if (emlRecsHS.add(emlAddr.toLowerCase())) {
                    emlRecs.add(emlAddr);
                }
            } while (cur.moveToNext());
        }

        cur.close();
        return emlRecs;
    }

    public ContactObject[] getContacts() {
        ContactObject[] cntcts = new ContactObject[3];
        cntcts[0] = ContactObject.first;
        cntcts[1] = ContactObject.second;
        cntcts[2] = ContactObject.third;
        return cntcts;
    }
}
