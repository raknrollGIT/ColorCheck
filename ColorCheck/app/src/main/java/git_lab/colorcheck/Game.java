package git_lab.colorcheck;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Random;
import java.lang.Object;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.app.Application;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Timer;
import java.util.TimerTask;


public class Game extends AppCompatActivity {

    //String[][] colName = new String[4][2];
    //String[][] colName = {{"red","R.drawable.red"},{"green","R.drawable.green"},{"blue","R.drawable.blue"},{"yellow","R.drawable.yellow"}};
    String[] colText = {"red","green","blue","yellow","black","brown","burgundy","grey","olive","orange","pink","purple","salmon","white"};
    Integer[] colSc={R.drawable.red,R.drawable.green,R.drawable.blue,R.drawable.yellow,R.drawable.black,R.drawable.brown,R.drawable.burgundy,R.drawable.grey,R.drawable.olive,R.drawable.orange,R.drawable.pink,R.drawable.purple,R.drawable.salmon,R.drawable.white};
    Integer[] colCol={Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW,Color.BLACK,Color.parseColor("#964B00"),Color.parseColor("#800000"),Color.GRAY,Color.parseColor("#808000"),Color.parseColor("#FE7F00"),Color.parseColor("#ff9bb2"),Color.parseColor("#b916bf"),Color.parseColor("#FFA07A"),Color.WHITE};

    Random rand = new Random();
    int r1 = rand.nextInt(13); // Gives n such that 0 <= n < 20
    int r2 = rand.nextInt(13);//liczba kolorów
    int r3 = rand.nextInt(13);//liczba kolorów
    int r4 = rand.nextInt(13);//liczba kolorów
    int r5 = rand.nextInt(13);//liczba kolorów
    int r7 = rand.nextInt(13);//liczba kolorów
    int r8 = rand.nextInt(13);//liczba kolorów
    int[] los ={r1,r2,r3,r4};
    int r6= rand.nextInt(3);//liczba pól


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        los[r6]=r5;
        r1 = los[0];
        r2 = los[1];
        r3 = los[2];
        r4 = los[3];
        //Global.Dz = 1;

        ImageView LG = (ImageView) findViewById(R.id.LG);
        LG.setImageResource(colSc[r1]);
        Global.LGt=colText[r1];

        ImageView PG = (ImageView) findViewById(R.id.PG);
        PG.setImageResource(colSc[r2]);
        Global.PGt=colText[r2];

        ImageView LD = (ImageView) findViewById(R.id.LD);
        LD.setImageResource(colSc[r3]);
        Global.LDt=colText[r3];

        ImageView PD = (ImageView) findViewById(R.id.PD);
        PD.setImageResource(colSc[r4]);
        Global.PDt=colText[r4];

        TextView ColorName = (TextView) findViewById(R.id.ColorName);
        ColorName.setText(colText[r5]);
        ColorName.setTextColor(colCol[r7]);
        ColorName.setBackgroundColor(colCol[r8]);

        while (r8==r7)
        {
            r8 = r8+1;
            ColorName.setBackgroundColor(colCol[r8]);
        }
        /*
        TextView Licznik = (TextView) findViewById(R.id.Licznik);
        String ll = String.valueOf(Global.Score);
        Licznik.setText(ll);

        Handler Hang = new Handler();
        Hang.postDelayed(new Runnable() {
            public void run() {
                Go();
            }
        }, 3000);

        Thread thread= new Thread(){
            public void run(){
                try {
                    sleep(Global.Time);
                    Go();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Go();
                }
            }
        };
        thread.start();


        Global.timer = new Timer();
        Global.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Go();
            }
        }, Global.Time);
*/
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

    public void CheckLG(View view)
    {
        if(Global.LGt==colText[r5])
        {
            Global.Score++;
            Global.Time=Global.Time-13;
            finish();
            startActivity(getIntent());
        }

        else
        {
            Go();
        }

    }
    public void CheckLD(View view)
    {
        if(Global.LDt==colText[r5])
        {
            Global.Score++;
            Global.Time=Global.Time-13;
            finish();
            startActivity(getIntent());
        }

        else
        {
            Go();
        }
    }
    public void CheckPG(View view)
    {
        if(Global.PGt==colText[r5])
        {
            Global.Score++;
            Global.Time=Global.Time-13;
            finish();
            startActivity(getIntent());
        }

        else
        {
            Go();
        }

    }
    public void CheckPD(View view)
    {
        if(Global.PDt==colText[r5])
        {
            Global.Score++;
            Global.Time=Global.Time-13;
            finish();
            startActivity(getIntent());
        }

        else
        {
            Go();
        }

    }

    public void Go()
    {
        //if(Global.Dz==1){
            //Global.timer.cancel();
            //Global.Dz=0;
            Intent intent = new Intent(this, gameOver.class);
            startActivity(intent);
        //}
    }




}