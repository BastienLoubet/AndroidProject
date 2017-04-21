package bmo.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Olivier on 19/04/2017.
 */

public class GraphActivity extends Activity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("GraphActivity", "onCreate() ended");
        Toast.makeText(this, "Graph des stats", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.graph_layout);
        // setPreview();
    }

}
