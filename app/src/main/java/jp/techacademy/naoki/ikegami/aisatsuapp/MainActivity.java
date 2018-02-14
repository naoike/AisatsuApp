package jp.techacademy.naoki.ikegami.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.TextView);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (2<=hourOfDay && hourOfDay<= 9  ) {
                            textView.setText("おはよう");
                        } else if(10<=hourOfDay &&hourOfDay<= 17 ) {
                            textView.setText("こんにちわ");
                        } else if (18 <= hourOfDay || 0<= hourOfDay  ) {
                            textView.setText("こんばんは");
                        }
                    }
                }, 13, 0, true);
        timePickerDialog.show();
    }
}
