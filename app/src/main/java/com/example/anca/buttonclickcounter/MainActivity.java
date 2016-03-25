package com.example.anca.buttonclickcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView txt;
    private int count = 0;
    private ViewGroup.LayoutParams initLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        initLayout = btn.getLayoutParams();

        final int width = dm.widthPixels/2 + 2*btn.getWidth();
        final int height = dm.heightPixels/2 + 2*btn.getHeight();

        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += 1;
                String result = "The button was tapped " + count + " time";

                if(count != 1){
                    result += "s!";
                }

                txt.setText(result);


                Random r = new Random();
                int top = r.nextInt(height) + btn.getHeight();
                int left = r.nextInt(width);

                btn.setX(left);
                btn.setY(top);
            }
        };

        btn.setOnClickListener(ourOnClickListener);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toastMessage = Toast.makeText(this, "The count has now been reset" , Toast.LENGTH_LONG);


            count = 0;
            txt.setText("The button was tapped " + count + " times");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
