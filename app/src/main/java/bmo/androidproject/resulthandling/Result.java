package bmo.androidproject.resulthandling;

import android.content.Context;

import java.io.Serializable;

/**
 * La classe qui contient les donnes du resultat
 * Note que celle ci est serializable pour pouvoir etre passe en argument dans une intent entre activite
 */

public class Result implements Serializable{

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
    //l'id unique du resultat
    private int iId;


    //Le constructeur complet, note qu'il fait appel au constructeur sans competition
    public Result(int iId,int iTime,int iDistance,SwimEnum oSwinStyle, long lDate, String sComment, int iRanking, String sLigue){
        this(iId,iTime,iDistance,oSwinStyle,lDate,sComment);
        oCompetition = new Competition(iRanking,sLigue);
    }

    //Le constructeur sans la competition
    public Result(int iId, int iTime,int iDistance,SwimEnum oSwinStyle, long lDate, String sComment){
        this.iId = iId;
        this.iTime = iTime;
        this.iDistance = iDistance;
        this.oSwinStyle = oSwinStyle;
        this.lDate = lDate;
        this.sComment = sComment;
        oCompetition=null;
    }

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

    public SwimEnum getEnumSwinStyle() {
        return oSwinStyle;
    }

    public long getDate() {
        return lDate;
    }

    public String getComment() {
        return sComment;
    }

    public int getId() {
        return iId;
    }

    //On encapsule la competition

    //Test si le ressultat est une competition
    public boolean isCompetition(){
        if (oCompetition == null)
            return false;
        return true;
    }

    //obtient le classement de la competition retourne 0 si pas de competition
    public int getRanking(){
        if(isCompetition())
            return oCompetition.getRanking();
        return 0;
    }

    //Obtient la ligue, retourne une chaine vide si pas une competition
    public String getLigue(){
        if(isCompetition())
            return oCompetition.getLigue();
        return "";
    }

}
