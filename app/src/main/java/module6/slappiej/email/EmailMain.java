package module6.slappiej.email;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import module6.slappiej.R;

public class EmailMain extends Activity {

    public static final EmailObject email1 = new EmailObject("Bert", "Taart", "Komt u morgen ook taart eten?\nLijkt me erg gezellig!\nGroeten,\nBert");
    public static final EmailObject email2 = new EmailObject("Truus", "Thee", "Komt u morgen ook thee drinken?\nLijkt me erg gezellig!\nGroeten,\nTruus");
    public static final EmailObject email3 = new EmailObject("Joop", "Bingo", "Komt u morgen ook bingo spelen?\nLijkt me erg gezellig!\nGroeten,\nJoop");

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
        Intent intent = new Intent(this, WriteMail.class);
        startActivity(intent);
    }

    public void gotoBin(View view) {
        Intent intent = new Intent(this, WriteMail.class);
        startActivity(intent);
    }
}
