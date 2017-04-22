package bmo.androidproject.resulthandling;

import android.content.Context;

import java.util.ArrayList;

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

    private Result createResultFromInfo(Info oInfo){
        if(oInfo.getRanking() == 0)
            return new Result(oInfo.getId(),oInfo.getTime(),oInfo.getDistance(),SwimEnum.values()[oInfo.getSwimstyle()],oInfo.getDate(),oInfo.getComment());
        return new Result(oInfo.getId(),oInfo.getTime(),oInfo.getDistance(),SwimEnum.values()[oInfo.getSwimstyle()],oInfo.getDate(),oInfo.getComment(),oInfo.getRanking(),oInfo.getLigue());
    }

    //Retourne l'objet resultat a l'indice donne
    public Result getResultbyId(int iId){
        Info oInfo = oHelper.getTableRow(iId);
        if (oInfo != null){
            return createResultFromInfo(oInfo);
        }
        return null;
    }

    //Ajout d'un resultat avec competition
    public boolean addResult(int iTime,int iDistance,SwimEnum oSwinStyle, long lDate, String sComment, int iRanking,String sLigue){
        oHelper.insertResult(iTime,iDistance,oSwinStyle.ordinal(),lDate,sComment,iRanking,sLigue);
        return true;
    }

    //Ajout d'un resultat sans competion, la ligue est vide et le ranking est 0
    public boolean addResult(int iTime,int iDistance,SwimEnum oSwinStyle, long lDate, String sComment){
        return addResult(iTime, iDistance, oSwinStyle,  lDate,  sComment, 0,"");
    }

    public int getResultNbr(){
        return oHelper.getTableSize();
    }

    //Convertie un tableau d'info en tableau de Result
    private ArrayList<Result> convertInfoArraytoResult(ArrayList<Info> aInfo){
        ArrayList<Result> aRes = new ArrayList<>();
        for(Info oInfo: aInfo){
            aRes.add(createResultFromInfo(oInfo));
        }
        return aRes;
    }

    //Recupere les iNbr dernier resultat, si pas de resultat renvoi un tableau vide
    public ArrayList<Result> getLastResult(int iNbr){
        ArrayList<Info> aInfo = oHelper.getLastRow(iNbr);
        if(aInfo != null){
            return convertInfoArraytoResult(aInfo);
        }
        return new ArrayList<Result>();
    }

    //Surcharge de getLastResult prend les trois derniers par defaut
    public ArrayList<Result> getLastResult(){
        return getLastResult(3);
    }

    //retourne un tableau de tout les resultats trie par date
    public ArrayList<Result> getAllResult(){
        ArrayList<Info> aInfo = oHelper.getAllRow();
        if(aInfo != null){
            return convertInfoArraytoResult(aInfo);
        }
        return new ArrayList<Result>();
    }

    //Fonction qui appelle la modification dans la base de donne
    public void ModifyResult(int iId,int iTime,int iDistance,SwimEnum oSwinStyle, long lDate, String sComment, int iRanking,String sLigue){
        oHelper.ModifyResult(iId,iTime,iDistance,oSwinStyle.ordinal(),lDate,sComment,iRanking,sLigue);
    }

    //Fonction qui appelle l'effacement dans la base de donnnees
    public void deleteById(int iId){
        oHelper.deleteById(iId);
    }

}
