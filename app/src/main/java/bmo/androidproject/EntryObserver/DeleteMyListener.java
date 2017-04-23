package bmo.androidproject.EntryObserver;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import bmo.androidproject.R;
import bmo.androidproject.resulthandling.ListResult;

/**
 * Created by Garry on 4/22/2017.
 */

public class DeleteMyListener extends MyListener {


    private int iId;

    public DeleteMyListener(Activity oA,int iId) {
        super(oA);
        this.iId = iId;
    }

    @Override
    public void onClick(View v) {
        ListResult oList = new ListResult(v.getContext());
        oList.deleteById(iId);

        oActivity.finish();
    }
}
