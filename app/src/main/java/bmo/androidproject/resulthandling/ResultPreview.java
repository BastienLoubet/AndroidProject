package bmo.androidproject.resulthandling;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

import bmo.androidproject.resulthandling.Result;

/**
 * Created by Garry on 4/19/2017.
 */

public class ResultPreview extends LinearLayout {

    public ResultPreview(Result oResult, Context context) {
        super(context);
        TextView oText = new TextView(this.getContext());
        oText.setText(oResult.toString());
        this.addView(oText);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

    }
}
