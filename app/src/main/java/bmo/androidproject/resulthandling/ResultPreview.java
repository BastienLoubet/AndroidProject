package bmo.androidproject.resulthandling;

import android.content.Context;
import android.content.Intent;

import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

import bmo.androidproject.DetailActivity;
import bmo.androidproject.R;

/**
 * Created by Garry on 4/19/2017.
 */

public class ResultPreview extends TableRow {

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


    private void CreateTextView(String sText) {

        TextView oText = new TextView(new ContextThemeWrapper(this.getContext(), R.style.textPreview));
        oText.setText(sText);
        this.addView(oText);
    }

    //Initialise l'objet layout et modifie les vues nessecaires
    private void initView() {

        //CreateTextView(Integer.toString(oResult.getId()));

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        Date oDate = new Date(oResult.getDate());
        CreateTextView(df.format(oDate));

        CreateTextView(Integer.toString(oResult.getTime()));

        CreateTextView(Integer.toString(oResult.getDistance()));

        CreateTextView(oResult.getSwinStyle(getContext()));


        if (oResult.isCompetition()) {
            CreateTextView(Integer.toString(oResult.getRanking()));
            CreateTextView(oResult.getLigue());

        }

    }

    //l'objet resultat a afficher
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_UP) {
            Intent oIntent = new Intent(oContext, DetailActivity.class);
            oIntent.putExtra("ResultId", oResult.getId());
            oContext.startActivity(oIntent);
        }
        return true;
    }
}


