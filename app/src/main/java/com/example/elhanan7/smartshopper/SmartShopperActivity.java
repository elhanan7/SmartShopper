package com.example.elhanan7.smartshopper;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SmartShopperActivity extends AppCompatActivity {

    final private int RED_COLOR = 0x88FF0000;
    final private int GREEN_COLOR = 0x8800FF00;
    final private int BLUE_COLOR = 0x880000FF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_shopper);

        Button compare = (Button) findViewById(R.id.compareButton);
        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double r1, r2;

                try {
                    EditText q1 = (EditText) findViewById(R.id.txtQ1);
                    EditText p1 = (EditText) findViewById(R.id.txtP1);
                    EditText q2 = (EditText) findViewById(R.id.txtQ2);
                    EditText p2 = (EditText) findViewById(R.id.txtP2);

                    double q1d = Double.parseDouble(q1.getText().toString());
                    double p1d = Double.parseDouble(p1.getText().toString());
                    double q2d = Double.parseDouble(q2.getText().toString());
                    double p2d = Double.parseDouble(p2.getText().toString());

                    if (p1d == 0 || p2d == 0)
                        return;
                    r1 = q1d / p1d;
                    r2 = q2d / p2d;
                }
                catch (NumberFormatException e) {
                    return;
                }

                LinearLayout left = (LinearLayout) findViewById(R.id.leftPane);
                LinearLayout right = (LinearLayout) findViewById(R.id.rightPane);

                if (r1 == r2) {
                    left.setBackgroundColor(BLUE_COLOR);
                    right.setBackgroundColor(BLUE_COLOR);
                }
                else if (r1 > r2) {
                    left.setBackgroundColor(RED_COLOR);
                    right.setBackgroundColor(GREEN_COLOR);
                }
                else {
                    left.setBackgroundColor(GREEN_COLOR);
                    right.setBackgroundColor(RED_COLOR);
                }
            }
        });

        View.OnFocusChangeListener listener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                LinearLayout left = (LinearLayout) findViewById(R.id.leftPane);
                LinearLayout right = (LinearLayout) findViewById(R.id.rightPane);

                left.setBackgroundResource(android.R.drawable.editbox_background_normal);
                right.setBackgroundResource(android.R.drawable.editbox_background_normal);
            }
        };

        EditText q1 = (EditText) findViewById(R.id.txtQ1);
        EditText p1 = (EditText) findViewById(R.id.txtP1);
        EditText q2 = (EditText) findViewById(R.id.txtQ2);
        EditText p2 = (EditText) findViewById(R.id.txtP2);

        q1.setOnFocusChangeListener(listener);
        p1.setOnFocusChangeListener(listener);
        q2.setOnFocusChangeListener(listener);
        p2.setOnFocusChangeListener(listener);
    }
}
