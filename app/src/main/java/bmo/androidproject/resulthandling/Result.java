package bmo.androidproject.resulthandling;

import android.content.Context;

/**
 * Created by Garry on 4/19/2017.
 */

public class Result {

    //La competition associe null si entrainement
    private Competition oCompetition;
    //Le temps en milliseconde
    private int iTime;
    //La distance nage de l'epreuves en metre
    private int iDistance;
    //Le style de nage dans l'enumeration SwimEnum
    private SwimEnum oSwinStyle;
    //La date en secondes de l'entrainement
    private long lDate;
    //Un commentaire libre
    private String sComment;


    //Les getters

    public int getTime() {
        return iTime;
    }

    public int getDistance() {
        return iDistance;
    }

    public String getSwinStyle(Context oContext) {
        return oSwinStyle.getName(oContext);
    }

    public long getDate() {
        return lDate;
    }

    public String getsComment() {
        return sComment;
    }
}
