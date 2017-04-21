package bmo.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;

import bmo.androidproject.fileaccess.Info;
import bmo.androidproject.resulthandling.ListResult;
import bmo.androidproject.resulthandling.Result;
import bmo.androidproject.resulthandling.SwimEnum;

/**
 * Created by Olivier on 19/04/2017.
 */

public class DetailActivity extends Activity {

    private int iId;
    private Result oResult;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("DetailActivity", "onCreate() ended");
        iId = getIntent().getIntExtra("ResultId", -1);
        ListResult oList = new ListResult(this);
        oResult = oList.getResultbyId(iId);
        setContentView(R.layout.detail_layout);
        initSpinner();
        if (oResult != null) {
            initView();
            initButton();
        }
    }

    //Initialise la liste deroulante de chois des nages
    private void initSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.detailSwimStyle);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.SwimStyle, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    private void initButton() {
        Button oButton = (Button) findViewById(R.id.detailButton);
        oButton.setText(getString(R.string.buttonModify));
        //Add button observer
        oButton.setOnClickListener(new bmo.androidproject.EntryObserver.ModifyMyListener(this, iId));
    }

    private void setEditText(int iId, Object sString) {
        EditText oText = (EditText) findViewById(iId);
        oText.setText(sString.toString());
    }

    private void initView() {
        setEditText(R.id.detailTime, oResult.getTime());
        setEditText(R.id.detailDistance, oResult.getDistance());
        setEditText(R.id.detailComment, oResult.getComment());
        Spinner oSpin = (Spinner) findViewById(R.id.detailSwimStyle);
        oSpin.setSelection(oResult.getEnumSwinStyle().ordinal());
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        setEditText(R.id.detailDate, df.format(new Date(oResult.getDate())));
        CheckBox oCheck = (CheckBox) findViewById(R.id.isCompetition);
        if (oResult.isCompetition()) {
            oCheck.setChecked(true);
            setEditText(R.id.detailRanking, oResult.getRanking());
            setEditText(R.id.detailLigue, oResult.getLigue());
        }

    }
}
