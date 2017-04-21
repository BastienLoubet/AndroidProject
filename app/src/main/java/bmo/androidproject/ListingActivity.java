package bmo.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
        Toast.makeText(this, "Liste stats", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.listing_layout);
        setPreview();


    }

    private TextView CreateTextView(String sText) {

        TextView oText = new TextView(new ContextThemeWrapper(this, R.style.textPreview));
        oText.setText(sText);
        return oText;
    }

    private TableRow createLegendRow(){
        TableRow oRow = new TableRow(new ContextThemeWrapper(this,R.style.legendeStyle));
        oRow.addView(CreateTextView("whatever"));
        oRow.addView(CreateTextView("whatever2"));
        oRow.addView(CreateTextView("whatever3"));
        return oRow;
    }

    //Ajoute les derniers resultat au linear layout de preview
    private void setPreview(){
        LinearLayout oLayout = (LinearLayout) findViewById(R.id.listing);
        oLayout.removeAllViews();
        oLayout.addView(createLegendRow());
       ListResult oList = new ListResult(this);
        ArrayList<Result> aRes = oList.getAllResult();
        Toast.makeText(this, Integer.toString(aRes.size()), Toast.LENGTH_SHORT).show();

        for(Result oRes: aRes){
            oLayout.addView(new ResultPreview(oRes,this));
        }
       // oLayout.addView(new ResultPreview(new Result(0,1000,1000, SwimEnum.Backstroke,27174352,"Un super commentaire  !"),this));
        //oLayout.addView(new ResultPreview(new Result(1,9000,1000, SwimEnum.Backstroke,22717432,"Un autre super commentaire  !",1,"Occitanie"),this));
    }



}
