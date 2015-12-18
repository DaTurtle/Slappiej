package module6.slappiej.email;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import module6.slappiej.R;

/**
 * Created by Jan-Willem on 18-12-2015.
 */

public class SearchMail extends Activity {

    private ArrayList<String> senders;
    private ArrayList<String> subjects;
    private ArrayList<String> bodies;
    private ArrayList<EmailObject> emails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_searchmail);
        Intent i = getIntent();
        emails = i.getParcelableArrayListExtra("email");
        senders = new ArrayList<>();
        subjects = new ArrayList<>();
        bodies = new ArrayList<>();
        if (emails != null) {
            for (EmailObject e : emails) {
                senders.add(e.getSender());
                subjects.add(e.getSubject());
                bodies.add(e.getBody());
            }
        }

    }


    public void searchSender(View view) {
        Intent intent = new Intent();
        if (emails != null) {
            EditText searchbar = (EditText)findViewById(R.id.searchInput);
            String search = "" + searchbar.getText().toString();
            for (int i = senders.size()-1; i >= 0; i--) {
                if (!senders.get(i).contains(search)) {
                    emails.remove(i);
                }
            }
            intent.putExtra("emails", emails);
        }
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void searchSubjects(View view) {
        Intent intent = new Intent();
        if (emails != null) {
            EditText searchbar = (EditText)findViewById(R.id.searchInput);
            String search = "" + searchbar.getText().toString();
            for (int i = subjects.size()-1; i >= 0; i--) {
                if (!subjects.get(i).contains(search)) {
                    emails.remove(i);
                }
            }
            intent.putExtra("emails", emails);
        }
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void searchBodies(View view) {
        Intent intent = new Intent();
        if (emails != null) {
            EditText searchbar = (EditText)findViewById(R.id.searchInput);
            String search = "" + searchbar.getText().toString();
            for (int i = bodies.size()-1; i >= 0; i--) {
                if (!bodies.get(i).contains(search)) {
                    emails.remove(i);
                }
            }
            intent.putExtra("emails", emails);
        }
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}