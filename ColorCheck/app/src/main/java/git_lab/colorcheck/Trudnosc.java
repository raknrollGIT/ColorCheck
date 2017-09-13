package git_lab.colorcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Trudnosc extends AppCompatActivity{

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trudnosc);
    }

    public void openGameNormal(View view){
        Global.Score=0;
        Global.Time=1500;
        Global.Tryb=0;
        EditText zaw = (EditText) findViewById(R.id.editTextNicki);
        if (zaw.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }
        Global.Nick = zaw.getText().toString();
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

    public void openGameHard(View view){
        Global.Score=0;
        Global.Time=1000;
        Global.Tryb=1;
        EditText zaw = (EditText) findViewById(R.id.editTextNicki);
        if (zaw.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }
        Global.Nick = zaw.getText().toString();
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
}
