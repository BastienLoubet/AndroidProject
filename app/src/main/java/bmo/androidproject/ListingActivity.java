package bmo.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import bmo.androidproject.resulthandling.ListResult;
import bmo.androidproject.resulthandling.Result;
import bmo.androidproject.resulthandling.ResultPreview;
import bmo.androidproject.resulthandling.SwimEnum;

/**
 * Created by Olivier on 19/04/2017.
 */

public class ListingActivity extends Activity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ListingActivity", "onCreate() ended");
        setContentView(R.layout.listing_layout);
        setPreview();


    }

    @Override
    protected void onResume() {
        super.onResume();
        setPreview();
    }

    private TextView CreateTextView(String sText) {
        TextView oText = new TextView(new ContextThemeWrapper(this, R.style.legendStyle));
        //TextView oText = new TextView(this);
        oText.setText(sText);
        return oText;
    }

    private TableRow createLegendRow(){
        TableRow oRow = new TableRow(this);
        oRow.addView(CreateTextView(getString(R.string.listdate)));
        oRow.addView(CreateTextView(getString(R.string.listtime)));
        oRow.addView(CreateTextView(getString(R.string.listdist)));
        oRow.addView(CreateTextView(getString(R.string.listswim)));
        oRow.addView(CreateTextView(getString(R.string.listrank)));
        oRow.addView(CreateTextView(getString(R.string.listleag)));
        return oRow;
    }

    //Ajoute les derniers resultat au linear layout de preview
    private void setPreview(){
        LinearLayout oLayout = (LinearLayout) findViewById(R.id.listing);
        oLayout.removeAllViews();
        oLayout.addView(createLegendRow());
       ListResult oList = new ListResult(this);
        ArrayList<Result> aRes = oList.getAllResult();

        Toast.makeText(this, getResources().getQuantityString(R.plurals.listingMessage,aRes.size(),aRes.size()), Toast.LENGTH_SHORT).show();

        for(Result oRes: aRes){
            oLayout.addView(new ResultPreview(oRes,this));
        }
       // oLayout.addView(new ResultPreview(new Result(0,1000,1000, SwimEnum.Backstroke,27174352,"Un super commentaire  !"),this));
        //oLayout.addView(new ResultPreview(new Result(1,9000,1000, SwimEnum.Backstroke,22717432,"Un autre super commentaire  !",1,"Occitanie"),this));
    }



}
