package bmo.androidproject.resulthandling;

import android.content.Context;

import bmo.androidproject.R;

/**
 * Created by Garry on 4/19/2017.
 */

public enum SwimEnum {
    Crawl,Backstroke,Butterfly,Breaststroke;

    public String getName(Context oContext){
        String[] aSwimStyle = oContext.getResources().getStringArray(R.array.SwimStyle);
        return aSwimStyle[this.ordinal()];
    }


}
