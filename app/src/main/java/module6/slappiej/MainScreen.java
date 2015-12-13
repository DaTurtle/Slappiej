package module6.slappiej;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import module6.slappiej.email.EmailMain;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void gotoEmail(View view) {
        Intent intent = new Intent(this, EmailMain.class);
        startActivity(intent);
    }

    public void gotoTransport(View view) {
        Intent intent = new Intent(this, EmailMain.class);
        startActivity(intent);
    }

    public void gotoChat(View view) {
        Intent intent = new Intent(this, EmailMain.class);
        startActivity(intent);
    }

    public void gotoVideo(View view) {
        Intent intent = new Intent(this, EmailMain.class);
        startActivity(intent);
    }

    public void gotoNews(View view) {
        Intent intent = new Intent(this, EmailMain.class);
        startActivity(intent);
    }

    public void gotoMusic(View view) {
        Intent intent = new Intent(this, EmailMain.class);
        startActivity(intent);
    }
}
