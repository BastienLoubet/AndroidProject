package bmo.androidproject.resulthandling;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Garry on 4/19/2017.
 */

public class ResultPreview extends LinearLayout {

    private Result oResult;

    public ResultPreview(Result oResult, Context context) {
        super(context);
        this.oResult = oResult;
        initView();

    }

    //Initialise l'objet layout et modifie les vues nessecaire
    private void initView(){
        TextView oText = new TextView(this.getContext());
        oText.setText(oResult.getComment());
        this.addView(oText);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

    }
}
