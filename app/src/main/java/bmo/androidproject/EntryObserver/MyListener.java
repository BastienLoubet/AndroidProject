package bmo.androidproject.EntryObserver;

import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import bmo.androidproject.R;
import bmo.androidproject.fileaccess.Info;
import bmo.androidproject.resulthandling.ListResult;
import bmo.androidproject.resulthandling.SwimEnum;

/**
 * Created by Garry on 4/21/2017.
 */

public abstract class MyListener implements View.OnClickListener {

    protected Activity oActivity;

    public MyListener(Activity oA){
        oActivity = oA;
    }

    protected int getInt(int iRes){
        EditText oText = (EditText) oActivity.findViewById(iRes);
        try {
            return Integer.parseInt(oText.getText().toString());
        }catch (NumberFormatException e){
            return -1;
        }
    }

    protected Info getInfoFromEntry(View v){
        int time = getInt(R.id.detailTime);
        if(time == -1){
            Toast.makeText(v.getContext(),oActivity.getString(R.string.errorTime),Toast.LENGTH_SHORT).show();
            return null;
        }
        int distance = getInt(R.id.detailDistance);
        if(distance == -1){
            Toast.makeText(v.getContext(),oActivity.getString(R.string.errorDistance),Toast.LENGTH_SHORT).show();
            return null;
        }
        EditText oComment = (EditText) oActivity.findViewById(R.id.detailComment);
        String comment = oComment.getText().toString();
        Spinner oSpin = (Spinner) oActivity.findViewById(R.id.detailSwimStyle);
        SwimEnum oSwim = SwimEnum.values()[oSpin.getSelectedItemPosition()];
        EditText oDate = (EditText) oActivity.findViewById(R.id.detailDate);
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
                String sMes = oActivity.getString(R.string.wrongFormat, df.format(new Date()));
                Toast.makeText(v.getContext(), sMes, Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        CheckBox oCheck = (CheckBox) oActivity.findViewById(R.id.isCompetition);
        if(! oCheck.isChecked())
            return new Info(0,time,distance,oSwim.ordinal(),lDate,comment,0,"");

        int ranking = getInt(R.id.detailRanking);
        if(ranking <= 0){
            Toast.makeText(v.getContext(),oActivity.getString(R.string.errorRanking),Toast.LENGTH_SHORT).show();
            return null;
        }

        EditText oLigue = (EditText) oActivity.findViewById(R.id.detailLigue);
        String sLigue = oLigue.getText().toString();

        return new Info(0,time,distance,oSwim.ordinal(),lDate,comment,ranking,sLigue);
    }

    @Override
    abstract public void onClick(View v) ;
}
