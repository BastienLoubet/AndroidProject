package bmo.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import bmo.androidproject.resulthandling.Result;
import bmo.androidproject.resulthandling.ResultPreview;
import bmo.androidproject.resulthandling.SwimEnum;

/**
 * Created by Olivier on 19/04/2017.
 */

public class ListingActivity extends Activity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("HomeActivity", "onCreate() ended");
        Toast.makeText(this,getString(R.string.accmess),Toast.LENGTH_LONG).show();
        setContentView(R.layout.listing_layout);
        setPreview();
    }

    private void setPreview(){
     //   LinearLayout oLayout = (LinearLayout) findViewById(R.id.preview);
        //ListResult oList = new ListResult(this);
       // oLayout.addView(new ResultPreview(new Result(0,1000,1000, SwimEnum.Backstroke,27174352,"Un super commentaire  !"),this));
        //oLayout.addView(new ResultPreview(new Result(1,9000,1000, SwimEnum.Backstroke,22717432,"Un autre super commentaire  !",1,"Occitanie"),this));
    }
}
