package com.example.fontchange;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button changeFontSizeButton;
    private Button changeColorButton;
    private boolean isLargeFont = false;
    private boolean isColorChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        changeFontSizeButton = findViewById(R.id.changeFontSizeButton);
        changeColorButton = findViewById(R.id.changeColorButton);

        changeFontSizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLargeFont) {
                    textView.setTextSize(20);
                } else {
                    textView.setTextSize(40);
                }
                isLargeFont = !isLargeFont;
            }
        });

        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isColorChanged) {
                    textView.setTextColor(Color.BLACK);
                } else {
                    textView.setTextColor(Color.RED);
                }
                isColorChanged = !isColorChanged;
            }
        });
    }
}
