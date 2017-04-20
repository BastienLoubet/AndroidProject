package bmo.androidproject.resulthandling;

import java.util.ArrayList;

/**
 * Un singleton qui est recharger a chaque fois que nessecaire
 * Note que l'application va peut etre effacer ce singleton de temps en temps
 * Cette classe doit donc etre responsable de se charger elle meme integralement
 * si elle n'existe plus.
 * Elle doit donc aussi se sauvegarder des qu'elle change.
 */

public class ListResult {
    private static ListResult oInstance;

    private ArrayList<Result> aResults;


    private ListResult(){

    }


    //Retourne l'objet resultat a l'indice donnne
    public Result getResultbyId(int iId){
        return aResults.get(iId);
    }
}
