package com.example.karin.indata;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.*;
import java.util.*;

public class MyActivity extends Activity {

    Scanner sc;
    TextView rutan;
    Button button;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        // the image is invisible from start, see XML
        image = (ImageView) findViewById(R.id.imageView);

        // when pressing button, read file, change text and image
        button = (Button) findViewById(R.id.btnChangeImage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rutan = (TextView) findViewById(R.id.rutan); // import the textview into java code
                Log.d("ReadFileLog", "Innan on-click");
                BufferedReader br = null;

                // when click on button, read from file and change textview and imageview
                try {
                    Log.d("ReadFileLog", "I try-satsen");
                    // get the image from the assets folder
                    InputStream iS = getAssets().open("data.txt");

                    Log.d("ReadFileLog", "innan buffered reader");
                    // create a buffered reader for the file
                    br = new BufferedReader(new InputStreamReader(iS));
                    String line;
                    Log.d("ReadFileLog", "Innan while");

                    // when able to read from file, set text in TextField to content from file
                    while((line = br.readLine()) != null)
                    {
                        Log.d("ReadFileLog", "I while-loopen");
                        rutan.setText(line);
                    }

                    Log.d("ReadFileLog", "Det gick bra!");

                    // set the invisible image to visible
                    image.setVisibility(View.VISIBLE);
                }
                catch (Exception e)
                {
                    // if not able to read from file, program will crash and write exception in log
                    Log.d("ReadFileLog", "exception", e);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}