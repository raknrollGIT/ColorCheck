package git_lab.colorcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class jezyki extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jezyki);
    }

    public void menu(View view) {
        Intent intent= new Intent(this,Menu.class);
        startActivity(intent);
    }
    @Override
    public void onPause(){
        super.onPause();
        finish();
    }
}
