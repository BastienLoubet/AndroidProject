package bmo.androidproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import bmo.androidproject.fileaccess.Load;

/**
 * Created by Garry on 4/19/2017.
 */

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("HomeActivity", "onCreate() ended");
        Toast.makeText(this, "Yeahhh !!!!", Toast.LENGTH_LONG).show();
        setContentView(new MapView(this));
    }



    private class MapView extends View {

        public MapView(Context context) {
            super(context);
        }



        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.home);
            canvas.drawBitmap(bitmap, 0, 0, null);
        }
    }
}
