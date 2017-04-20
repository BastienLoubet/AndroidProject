package bmo.androidproject.resulthandling;

import android.content.Context;

import bmo.androidproject.fileaccess.Info;
import bmo.androidproject.fileaccess.MonHelper;

/**
 * Un objet interface entre monHelper et Les objets results
 * cette classe est responsable de la creations des objets result a renvoyer au reste de l'application
 */

public class ListResult {

    private Context oContext;
    private MonHelper oHelper;

    //Le constructeur requier un context valide pour pourvoir invoque le SQL helper
    public ListResult(Context oContext){
        this.oContext = oContext;
        this.oHelper = new MonHelper(oContext);
    }

    private Result createResultFromInfo(int iId,Info oInfo){
        if(oInfo.getRanking() == 0)
            return new Result(iId,oInfo.getTime(),oInfo.getDistance(),SwimEnum.values()[oInfo.getSwimstyle()],oInfo.getDate(),oInfo.getComment());
        return new Result(iId,oInfo.getTime(),oInfo.getDistance(),SwimEnum.values()[oInfo.getSwimstyle()],oInfo.getDate(),oInfo.getComment(),oInfo.getRanking(),oInfo.getLigue());
    }

    //Retourne l'objet resultat a l'indice donne
    public Result getResultbyId(int iId){
        Info oInfo = oHelper.getTableRow(iId);
        if (oInfo != null){
            return createResultFromInfo(iId,oInfo);
        }
        return null;
    }

    public boolean addResult(int iId, int iTime,int iDistance,SwimEnum oSwinStyle, long lDate, String sComment){
        oHelper.insertResult(iTime,iDistance,oSwinStyle.ordinal(),lDate,sComment,0,"");
        return true;
    }

}
