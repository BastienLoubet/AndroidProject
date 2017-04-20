package bmo.androidproject.resulthandling;

import android.content.Context;

import bmo.androidproject.R;

/**
 * L'enumeration qui contient les nages
 * Correspond au string array SwimStyle dans les fichier ressources
 */

public enum SwimEnum {
    Crawl,Backstroke,Butterfly,Breaststroke;

    //La fonction qui fait le lien avec le string array
    //retourne le string "SwimUnknown" si la nage n'est pas trouve
    public String getName(Context oContext){
        String[] aSwimStyle = oContext.getResources().getStringArray(R.array.SwimStyle);
        if(this.ordinal() < aSwimStyle.length)
            return aSwimStyle[this.ordinal()];
        return oContext.getResources().getString(R.string.SwimUnknown);
    }


}
