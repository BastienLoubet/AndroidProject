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

public class ModifyMyListener extends MyListener {

    private int iId;

    public ModifyMyListener(Activity oA,int iId) {
        super(oA);
        this.iId = iId;
    }

    @Override
    public void onClick(View v) {
        Info oInfo = getInfoFromEntry(v);
        if(oInfo != null) {
            ListResult oListRes = new ListResult(v.getContext());
            oListRes.ModifyResult(iId,oInfo.getTime(), oInfo.getDistance(), SwimEnum.values()[oInfo.getSwimstyle()], oInfo.getDate(), oInfo.getComment(),oInfo.getRanking(),oInfo.getLigue());
            Toast.makeText(v.getContext(), oActivity.getString(R.string.confirmation), Toast.LENGTH_SHORT).show();
            oActivity.finish();
        }
    }
}
