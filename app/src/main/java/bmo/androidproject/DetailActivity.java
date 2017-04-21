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

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("DetailActivity", "onCreate() ended");
        Toast.makeText(this, "Stats en détail", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.detail_layout);
        //setPreview();
    }
}
