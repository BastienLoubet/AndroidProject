package bmo.androidproject.fileaccess;

/**
 * Classe interface entre MonHelper et List review
 */

public class Info {
    private int time;
    private int distance;
    private int swimstyle;
    private long date;
    private String comment;
    private int ranking;
    private String ligue;

    Info(int time,int distance,int swimstyle,long date,String comment,int ranking,String ligue){
        this.time = time;
        this.distance=distance;
        this.date = date;
        this.comment = comment;
        this.ranking = ranking;
        this.ligue = ligue;
    }

    //getters
    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }

    public int getSwimstyle() {
        return swimstyle;
    }

    public long getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public int getRanking() {
        return ranking;
    }

    public String getLigue() {
        return ligue;
    }
}
