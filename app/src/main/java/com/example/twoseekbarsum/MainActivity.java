package com.example.twoseekbarsum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

private int progress1;
private int progress2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textViewMain;
        final TextView textViewMain_ = findViewById(R.id.textViewMain);
        SeekBar seekBar = findViewById(R.id.seekBar);
        final TextView textViewSeekBar = findViewById(R.id.textView2);
        SeekBar seekBar2 = findViewById(R.id.seekBar2);
        final TextView textViewSeekBar2 = findViewById(R.id.textView3);
        seekBar.setMax(600);
        seekBar.setProgress(5);
        seekBar2.setMax(900);
        seekBar2.setProgress(5);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress1, boolean fromUser) {
               getSummaryTwoSeekBarValue(progress1,progress2);
                textViewSeekBar.setText(Integer.toString(progress1));
                Log.i("Seeker1: ", Integer.toString(progress1));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress2, boolean fromUser) {

          getSummaryTwoSeekBarValue(progress1,progress2);
                textViewSeekBar2.setText(Integer.toString(progress2));
                Log.i("Seeker2: ", Integer.toString(progress2));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public String getSummaryTwoSeekBarValue(int progress1, int progress2) {
      this.progress1=progress1;
      this.progress2=progress2;

        final TextView textViewMain_ = findViewById(R.id.textViewMain);
        int total = progress1 + progress2;
        String totalString = String.valueOf(total);
        Log.i("", totalString);
        textViewMain_.setText(String.valueOf(totalString));
        return totalString;
    }
}