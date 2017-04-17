package git_lab.colorcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Trudnosc extends AppCompatActivity{

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trudnosc);
    }

    public void openGame(View view){
        Global.Score=0;
        Global.Time= 2500;
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
}
