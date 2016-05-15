package com.rgt.nenad.realgymtrainerv2;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    String lineIWant;
    String nameIWant;
    int LineCount = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hiding ActionBar
        getSupportActionBar().hide();

        //Setting text and font into Quotes TextViews
        Typeface tf = Typeface.createFromAsset(getAssets(),
                "Fonts/veteran_typewriter.ttf");
        TextView tv = (TextView) findViewById(R.id.textViewQuotes);
        tv.setTypeface(tf);



        TextView tv2 = (TextView) findViewById(R.id.textViewNames);
        tv2.setTypeface(tf);

        //selecting random quotes
        int RandIndex=(int)Math.ceil(Math.random()*LineCount);
        if(RandIndex % 2 != 0)
        {
            RandIndex++;
        }

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("motivational_quotes.txt")));
            for(int i = 0; i < RandIndex; ++i)
                br.readLine();

             lineIWant = br.readLine();
            nameIWant = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tv.setText(lineIWant);
        tv2.setText(nameIWant);


    }
}
