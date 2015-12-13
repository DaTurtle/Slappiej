package module6.slappiej.email;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import module6.slappiej.R;

/**
 * Created by Jan-Willem on 13-12-2015.
 */

public class ReadMail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_readmail);
        Intent i = getIntent();
        EmailObject email = i.getParcelableExtra("email");
        TextView title = (TextView) findViewById(R.id.TitleText);
        TextView body = (TextView) findViewById(R.id.BodyText);
        String titleText = "" + email.getSender() + ": " + email.getSubject();
        title.setText(titleText);
        body.setText(email.getBody());
    }
}
