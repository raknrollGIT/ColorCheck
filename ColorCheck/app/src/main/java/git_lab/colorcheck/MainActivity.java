package git_lab.colorcheck;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    BazaV2 gDB; //Baza

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gDB = new BazaV2(this); //Baza

        Thread thread= new Thread(){
            public void run(){
                try {
                    sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent= new Intent(".jezyki");
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }
    @Override
    public void onPause(){
        super.onPause();
        finish();
    }

    public void menu(View view) {

    }

    public void openBrowser(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://pusheen.cba.pl/FH/"));
        startActivity(intent);
        System.exit(0);
    }
}


