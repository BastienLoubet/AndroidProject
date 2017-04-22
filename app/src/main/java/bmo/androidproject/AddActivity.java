package bmo.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bmo.androidproject.fileaccess.Info;
import bmo.androidproject.resulthandling.ListResult;
import bmo.androidproject.resulthandling.Result;
import bmo.androidproject.resulthandling.SwimEnum;

/**
 * Created by Olivier on 19/04/2017.
 */

public class AddActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        initButton();
    }

    private void initButton() {
        Button oButton = (Button) findViewById(R.id.detailButton);
        oButton.setText(getString(R.string.addButton));
        //Add button observer
        oButton.setOnClickListener(new bmo.androidproject.EntryObserver.AddMyListener(this));

        oButton = (Button) findViewById(R.id.detailButton2);
        oButton.setVisibility(View.GONE);

    }
}
