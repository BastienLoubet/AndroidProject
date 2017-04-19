package bmo.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Garry on 4/19/2017.
 */

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        SwimEnum.Backstroke.getName(this);
        super.onCreate(savedInstanceState);
    }
}
