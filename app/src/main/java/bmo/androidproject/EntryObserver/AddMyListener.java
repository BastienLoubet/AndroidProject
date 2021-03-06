package bmo.androidproject.EntryObserver;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import bmo.androidproject.R;
import bmo.androidproject.fileaccess.Info;
import bmo.androidproject.resulthandling.ListResult;
import bmo.androidproject.resulthandling.SwimEnum;

/**
 * Created by Garry on 4/21/2017.
 */

public class AddMyListener extends MyListener {

    public AddMyListener(Activity oA) {
        super(oA);
    }

    @Override
    public void onClick(View v) {

        Info oInfo = getInfoFromEntry(v);
        if(oInfo != null) {
            ListResult oListRes = new ListResult(v.getContext());
            oListRes.addResult(oInfo.getTime(), oInfo.getDistance(), SwimEnum.values()[oInfo.getSwimstyle()], oInfo.getDate(), oInfo.getComment(),oInfo.getRanking(),oInfo.getLigue());

            oActivity.finish();
        }
    }
}
