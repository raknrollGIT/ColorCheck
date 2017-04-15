package git_lab.colorcheck;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Random;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;





public class Game extends AppCompatActivity {

    //String[][] colName = new String[4][2];
    //String[][] colName = {{"red","red.png"},{"green","green.png"},{"blue","blue.png"},{"yellow","yellow.png"}};
    //String[][] colName = {{"red","R.drawable.red"},{"green","R.drawable.green"},{"blue","R.drawable.blue"},{"yellow","R.drawable.yellow"}};
    String[] colText = {"red","green","blue","yellow"};
    Integer[] colSc={R.drawable.red,R.drawable.green,R.drawable.blue,R.drawable.yellow};

    //Integer sc=R.drawable.red ;
    //Integer sc = Integer.valueOf(colName[0][1]);

    Random rand = new Random();
    int r1 = rand.nextInt(3); // Gives n such that 0 <= n < 20
    int r2 = rand.nextInt(3);
    int r3 = rand.nextInt(3);
    int r4 = rand.nextInt(3);
    int r5 = rand.nextInt(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ImageView LG = (ImageView) findViewById(R.id.LG);
        //imageView.setImageDrawable(getResources().getDrawable(sc));
        LG.setImageResource(colSc[r1]);
        ImageView PG = (ImageView) findViewById(R.id.PG);
        PG.setImageResource(colSc[r2]);
        ImageView LD = (ImageView) findViewById(R.id.LD);
        LD.setImageResource(colSc[r3]);
        ImageView PD = (ImageView) findViewById(R.id.PD);
        PD.setImageResource(colSc[r4]);
        TextView ColorName = (TextView) findViewById(R.id.ColorName);
        ColorName.setText(colText[r5]);
        TextView Licznik = (TextView) findViewById(R.id.Licznik);
        Licznik.setText("Tu liczby");
    }
}
