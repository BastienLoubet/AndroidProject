package bmo.androidproject.resulthandling;

/**
 * Created by Garry on 4/19/2017.
 */

class Competition {
    //Le classement obtenue sur 8 participants
    private int iRanking;
    //Le nom de la ligue, du tournoi
    private String sLigue;

    //Constructeur
    Competition(int iRanking,String sLigue){
        this.iRanking = iRanking;
        this.sLigue = sLigue;
    }

    public int getRanking() {
        return iRanking;
    }

    public String getLigue() {
        return sLigue;
    }
}
