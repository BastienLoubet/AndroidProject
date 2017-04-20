package bmo.androidproject;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import bmo.androidproject.fileaccess.Load;

/**
 * Created by Garry on 4/19/2017.
 */

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("HomeActivity", "onCreate() ended");
        Toast.makeText(this,getString(R.string.accmess),Toast.LENGTH_LONG).show();
        setContentView(R.layout.home_layout);
        setListeners();
    }


private void setListeners(){
    // une classe anonyme écoute le bouton de la liste
    Button bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext() , ListingActivity.class);
            startActivity(intent);
        }
    });

    // une classe anonyme écoute le bouton du graph
    Button bt2 = (Button) findViewById(R.id.button2);
    bt2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext() , GraphActivity.class);
            startActivity(intent);
        }
    });

    // une classe anonyme écoute le bouton ajouter
    Button bt3 = (Button) findViewById(R.id.button3);
    bt3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext() , AddActivity.class);
            startActivity(intent);
        }
    });





}





}
