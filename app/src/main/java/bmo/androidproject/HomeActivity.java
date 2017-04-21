package bmo.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import bmo.androidproject.resulthandling.ListResult;
import bmo.androidproject.resulthandling.Result;
import bmo.androidproject.resulthandling.ResultPreview;

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
        setPreview();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setPreview();
    }

    //Ajoute les derniers resultat au linear layout de preview
    private void setPreview(){
        LinearLayout oLayout = (LinearLayout) findViewById(R.id.preview);
        oLayout.removeAllViews();
        ListResult oList = new ListResult(this);
        ArrayList<Result> aRes = oList.getLastResult();
        for(Result oRes: aRes){
            oLayout.addView(new ResultPreview(oRes,this));
        }
        //oLayout.addView(new ResultPreview(new Result(0,1000,1000, SwimEnum.Backstroke,27174352,"Un super commentaire  !"),this));
        //oLayout.addView(new ResultPreview(new Result(1,9000,1000, SwimEnum.Backstroke,22717432,"Un autre super commentaire  !",1,"Occitanie"),this));
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
