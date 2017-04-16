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
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.app.Application;



public class Game extends AppCompatActivity {

    //String[][] colName = new String[4][2];
    //String[][] colName = {{"red","red.png"},{"green","green.png"},{"blue","blue.png"},{"yellow","yellow.png"}};
    //String[][] colName = {{"red","R.drawable.red"},{"green","R.drawable.green"},{"blue","R.drawable.blue"},{"yellow","R.drawable.yellow"}};
    String[] colText = {"red","green","blue","yellow"};
    Integer[] colSc={R.drawable.red,R.drawable.green,R.drawable.blue,R.drawable.yellow};
    Integer[] colCol={Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW};


    //Integer sc=R.drawable.red ;
    //Integer sc = Integer.valueOf(colName[0][1]);

    Random rand = new Random();
    int r1 = rand.nextInt(3); // Gives n such that 0 <= n < 20
    int r2 = rand.nextInt(3);//liczba kolorów
    int r3 = rand.nextInt(3);
    int r4 = rand.nextInt(3);
    int r5 = rand.nextInt(3);//liczba kolorów
    int r7 = rand.nextInt(3);
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
        ImageView LG = (ImageView) findViewById(R.id.LG);
        //imageView.setImageDrawable(getResources().getDrawable(sc));
        LG.setImageResource(colSc[r1]);
        LG.setTag(colSc[r1]);
        ImageView PG = (ImageView) findViewById(R.id.PG);
        PG.setImageResource(colSc[r2]);
        PG.setTag(colSc[r2]);

        ImageView LD = (ImageView) findViewById(R.id.LD);
        LD.setImageResource(colSc[r3]);
        LD.setTag(colSc[r3]);

        ImageView PD = (ImageView) findViewById(R.id.PD);
        PD.setImageResource(colSc[r4]);
        PD.setTag(colSc[r4]);
        TextView ColorName = (TextView) findViewById(R.id.ColorName);
        ColorName.setText(colText[r5]);
        ColorName.setTextColor(colCol[r7]);
        TextView Licznik = (TextView) findViewById(R.id.Licznik);

        String ll = String.valueOf(Global.Score);

        Licznik.setText(ll);
        //Licznik.setText("LIcz");
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

    public void Check(View view){
        ImageButton b = new ImageButton(this);
        Global.Score++;

        finish();
        startActivity(getIntent());
        /*if(Spr==r5){
            Global.Score++;
            finish();
            startActivity(getIntent());
        }*/
    }

}
