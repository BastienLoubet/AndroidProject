package bmo.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bmo.androidproject.fileaccess.Info;
import bmo.androidproject.resulthandling.ListResult;
import bmo.androidproject.resulthandling.Result;
import bmo.androidproject.resulthandling.SwimEnum;

/**
 * Created by Olivier on 19/04/2017.
 */

public class AddActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        initSpinner();
        initButton();
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
        oButton.setText(getString(R.string.addButton));
        //Add button observer
        oButton.setOnClickListener(new MyListener());
    }

    class MyListener implements View.OnClickListener {

        private int getInt(int iRes){
            EditText oText = (EditText) findViewById(iRes);
            try {
                return Integer.parseInt(oText.getText().toString());
            }catch (NumberFormatException e){
                return -1;
            }
        }

        private Info getInfoFromEntry(View v){
            int time = getInt(R.id.detailTime);
            if(time == -1){
                Toast.makeText(v.getContext(),getString(R.string.errorTime),Toast.LENGTH_SHORT).show();
                return null;
            }
            int distance = getInt(R.id.detailDistance);
            if(distance == -1){
                Toast.makeText(v.getContext(),getString(R.string.errorDistance),Toast.LENGTH_SHORT).show();
                return null;
            }
            EditText oComment = (EditText) findViewById(R.id.detailComment);
            String comment = oComment.getText().toString();
            Spinner oSpin = (Spinner) findViewById(R.id.detailSwimStyle);
            SwimEnum oSwim = SwimEnum.values()[oSpin.getSelectedItemPosition()];
            EditText oDate = (EditText) findViewById(R.id.detailDate);
            long lDate = 0;
            Date oMyDate;
            if(oDate.getText().toString().equals("")){
                oMyDate = new Date();
                lDate = oMyDate.getTime();
            }else {
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
                try {
                    oMyDate = df.parse(oDate.getText().toString());
                    lDate = oMyDate.getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                    String sMes = getString(R.string.wrongFormat, df.format(new Date()));
                    Toast.makeText(v.getContext(), sMes, Toast.LENGTH_SHORT).show();
                    return null;
                }
            }
            CheckBox oCheck = (CheckBox) findViewById(R.id.isCompetition);
            if(! oCheck.isChecked())
                return new Info(0,time,distance,oSwim.ordinal(),lDate,comment,0,"");

            int ranking = getInt(R.id.detailRanking);
            if(ranking == -1){
                Toast.makeText(v.getContext(),getString(R.string.errorRanking),Toast.LENGTH_SHORT).show();
                return null;
            }

            EditText oLigue = (EditText) findViewById(R.id.detailLigue);
            String sLigue = oLigue.getText().toString();

            return new Info(0,time,distance,oSwim.ordinal(),lDate,comment,ranking,sLigue);
        }

        @Override
        public void onClick(View v) {

            Info oInfo = getInfoFromEntry(v);
            if(oInfo != null) {
                ListResult oListRes = new ListResult(v.getContext());
                oListRes.addResult(oInfo.getTime(), oInfo.getDistance(), SwimEnum.values()[oInfo.getSwimstyle()], oInfo.getDate(), oInfo.getComment(),oInfo.getRanking(),oInfo.getLigue());
                Toast.makeText(v.getContext(), getString(R.string.confirmation), Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
