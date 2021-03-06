package git_lab.colorcheck;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.app.Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class Game extends AppCompatActivity {

    //String[][] colName = new String[4][2];
    //String[][] colName = {{"red","R.drawable.red"},{"green","R.drawable.green"},{"blue","R.drawable.blue"},{"yellow","R.drawable.yellow"}};
    String[] colText = {"red","green","blue","yellow","black","brown","burgundy","grey","olive","orange","pink","purple","salmon","white","akwamaryna","amethyst","chocolate","coral","lavender","navy","lemon"};
    Integer[] colSc={R.drawable.red,R.drawable.green,R.drawable.blue,R.drawable.yellow,R.drawable.black,R.drawable.brown,R.drawable.burgundy,R.drawable.grey,R.drawable.olive,R.drawable.orange,R.drawable.pink,R.drawable.purple,R.drawable.salmon,R.drawable.white,R.drawable.akwamaryna,R.drawable.amethyst,R.drawable.brown,R.drawable.coral,R.drawable.lavender,R.drawable.navy,R.drawable.chocolate,R.drawable.lemon};
    Integer[] colCol={Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW,Color.BLACK,Color.parseColor("#964B00"),Color.parseColor("#800000"),Color.GRAY,Color.parseColor("#808000"),Color.parseColor("#FE7F00"),Color.parseColor("#ff9bb2"),Color.parseColor("#b916bf"),Color.parseColor("#FFA07A"),Color.parseColor("#000000"),Color.parseColor("#7FFFD4"),Color.parseColor("#9966CC"),Color.parseColor("#7B3F00"),Color.parseColor("#F88379"),Color.parseColor("#B57EDC"),Color.parseColor("#000080"),Color.parseColor("#CAE00D")};

    Random rand = new Random();
    int r1 = rand.nextInt(20); // Gives n such that 0 <= n < 20
    int r2 = rand.nextInt(20);//liczba kolorów
    int r3 = rand.nextInt(20);//liczba kolorów
    int r4 = rand.nextInt(20);//liczba kolorów
    int r5 = rand.nextInt(20);//liczba kolorów
    int r7 = rand.nextInt(20);//liczba kolorów
    int r8 = rand.nextInt(20);//liczba kolorów
    int[] colLos={r1,r2,r3,r4};
    int[] los ={r1,r2,r3,r4};
    int r6= rand.nextInt(3);//liczba pól


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        r1 = colLos[0];
        r2 = colLos[1];
        r3 = colLos[2];
        r4 = colLos[3];

        los[r6]=r5;

        r1 = los[0];
        r2 = los[1];
        r3 = los[2];
        r4 = los[3];

        while ( r1 == r2 || r1 == r3 || r1 == r4 || r2 == r3 || r2 == r4 || r3 == r4)
        {
            if (r1 == r2) r1 = rand.nextInt(20);
            if (r1 == r3) r1 = rand.nextInt(20);
            if (r1 == r4) r1 = rand.nextInt(20);
            if (r2 == r3) r2 = rand.nextInt(20);
            if (r2 == r4) r2 = rand.nextInt(20);
            if (r3 == r4) r3 = rand.nextInt(20);
        }

        if(r1!=r5&&r2!=r5&&r3!=r5&&r4!=r5)
        {
            r1=r5;
        }

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

        while (r8==r7)
        {
            r8 = rand.nextInt(20);
        }

        ColorName.setBackgroundColor(colCol[r8]);

        TextView Licznik = (TextView) findViewById(R.id.Licznik);
        String ll = String.valueOf(Global.Score);
        Licznik.setText(ll);

         Global.thread= new Thread(){
            public void run(){
                try {
                    sleep(Global.Time);
                    Go();
                    Global.thread.interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
       Global.licznik = (int) (long) System.currentTimeMillis(); ///////////
        Global.thread.start();

        Global.T=100;

        Global.Pb= (ProgressBar) findViewById(R.id.progBar);

        upBar();
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
                Global.licznik=(int) (long)System.currentTimeMillis() - Global.licznik;
                if(Global.Tryb==0)
                {
                    Global.Score++;
                    Global.Time=Global.licznik+125;
                }
                if(Global.Tryb==1)
                {
                    Global.Score+=2;
                    Global.Time=Global.licznik+75;
                }
                Global.thread.interrupt();
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
                Global.licznik=(int) (long)System.currentTimeMillis() - Global.licznik;
                if(Global.Tryb==0)
                {
                    Global.Score++;
                    Global.Time=Global.licznik+125;
                }
                if(Global.Tryb==1)
                {
                    Global.Score+=2;
                    Global.Time=Global.licznik+75;
                }
                Global.thread.interrupt();
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
                Global.licznik=(int) (long)System.currentTimeMillis() - Global.licznik;
                if(Global.Tryb==0)
                {
                    Global.Score++;
                    Global.Time=Global.licznik+125;
                }
                if(Global.Tryb==1)
                {
                    Global.Score+=2;
                    Global.Time=Global.licznik+75;
                }
                Global.thread.interrupt();
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
                Global.licznik=(int) (long)System.currentTimeMillis() - Global.licznik;
                if(Global.Tryb==0)
                {
                    Global.Score++;
                    Global.Time=Global.licznik+125;
                }
                if(Global.Tryb==1)
                {
                    Global.Score+=2;
                    Global.Time=Global.licznik+75;
                }
                Global.thread.interrupt();
                startActivity(getIntent());
            }

            else
            {
                Go();
            }

        }

        public void Go()
        {
            Global.thread.interrupt();
            Intent intent = new Intent(this, gameOver.class);
            startActivity(intent);

        }
        public void upBar()
        {
            Global.threadP= new Thread(){
                public void run(){
                    try {
                        sleep(Global.Time/106); //Dziel
                        Global.Pb.setProgress(Global.T);
                        Global.T=Global.T-1;
                        Global.threadP.interrupt();
                        if(Global.T>=0)
                        {
                            upBar();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Global.threadP.start();

        }



    }




