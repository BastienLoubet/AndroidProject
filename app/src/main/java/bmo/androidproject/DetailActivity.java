package bmo.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Olivier on 19/04/2017.
 */

public class DetailActivity extends Activity {

    private int iId;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("DetailActivity", "onCreate() ended");
        iId = getIntent().getIntExtra("ResultId",-1);
        Toast.makeText(this, "Stats en détail. recue l\'id "+Integer.toString(iId), Toast.LENGTH_SHORT).show();
        setContentView(R.layout.detail_layout);

    }
}
