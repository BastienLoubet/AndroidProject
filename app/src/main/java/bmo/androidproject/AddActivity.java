package bmo.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import bmo.androidproject.resulthandling.ListResult;
import bmo.androidproject.resulthandling.SwimEnum;

/**
 * Created by Olivier on 19/04/2017.
 */

public class AddActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        initSpinner();
        initButton();
    }

    //Initialise la liste deroulante de chois des nages
    private void initSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.detailSwimStyle);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.SwimStyle, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    private void initButton() {
        Button oButton = (Button) findViewById(R.id.detailButton);
        oButton.setText(getString(R.string.addButton));
        //Add button observer
        oButton.setOnClickListener(new MyListener());
    }

    class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ListResult oListRes = new ListResult(v.getContext());
            oListRes.addResult(123,456, SwimEnum.Backstroke,1232432543,"Un super commentaire");
            Toast.makeText(v.getContext(),"il y en a "+Integer.toString(oListRes.getResultNbr()),Toast.LENGTH_SHORT).show();
        }
    }
}
