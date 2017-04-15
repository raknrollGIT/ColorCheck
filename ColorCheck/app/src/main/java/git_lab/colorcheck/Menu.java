package git_lab.colorcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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




}
