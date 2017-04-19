package bmo.androidproject;

import android.content.Context;

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
