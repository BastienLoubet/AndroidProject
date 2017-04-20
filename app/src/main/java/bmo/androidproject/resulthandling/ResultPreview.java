package bmo.androidproject.resulthandling;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

import bmo.androidproject.DetailActivity;

/**
 * Created by Garry on 4/19/2017.
 */

public class ResultPreview extends LinearLayout {

    //Le resultat affiche par l'objet
    private Result oResult;
    //Le contexte de l'objet, nessecaire pour changer d'activite
    private Context oContext;

    //Le constructeur nessecite un context
    public ResultPreview(Result oResult, Context context) {
        super(context);
        this.oResult = oResult;
        this.oContext = context;
        initView();

    }

    //Initialise l'objet layout et modifie les vues nessecaires
    private void initView(){
        TextView oText = new TextView(this.getContext());
        oText.setText(oResult.getSwinStyle(oContext));
        this.addView(oText);
    }

    //l'objet resultat a afficher
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Intent oIntent = new Intent(oContext, DetailActivity.class);
        oIntent.putExtra("Result",oResult);
        oContext.startActivity(oIntent);
        return true;

    }
}
