package git_lab.colorcheck;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Application;



public class Menu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void openGame(View view){
        Intent intent = new Intent(this, Trudnosc.class);
        startActivity(intent);
    }



    public void openRanking(View view){
        Intent intent = new Intent(this, Ranking.class);
        startActivity(intent);
    }

    public void openTworcy(View view){
        Intent intent = new Intent(this, Tworcy.class);
        startActivity(intent);
    }

    public void openHowTo(View view){
        Intent intent = new Intent(this, HowTo.class);
        startActivity(intent);
    }

    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        if (exit) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }


}

