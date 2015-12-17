package module6.slappiej.email;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import module6.slappiej.R;

public class EmailMain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_main);
    }

    public void gotoInbox(View view) {
        Intent intent = new Intent(this, Inbox.class);
        startActivity(intent);
    }

    public void gotoWriteMail(View view) {
        Intent intent = new Intent(this, WriteMail.class);
        startActivity(intent);
    }

    public void gotoSent(View view) {
        Intent intent = new Intent(this, SentMail.class);
        startActivity(intent);
    }

    public void gotoBin(View view) {
        Intent intent = new Intent(this, WriteMail.class);
        startActivity(intent);
    }

    public void finish(View view) {
        this.finish();
    }
}
