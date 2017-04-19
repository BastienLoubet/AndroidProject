package bmo.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import bmo.androidproject.fileaccess.Load;

/**
 * Created by Garry on 4/19/2017.
 */

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
    }

    private void loadData(){
        Load oLoad = new Load();
        oLoad.file();
    }
}
