package com.ompanem.inchesconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesText;
    private TextView resultText;
    private Button calculateButton;
    private String inchesString;

    private Toast emptyMsg;
    private double meters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findViews();
        emptyMsg = Toast.makeText(this, "Please enter a value for inches", Toast.LENGTH_LONG);
        setupButtonClickListener();

    }



    public void findViews()
    {
        inchesText = findViewById(R.id.edit_text_inches);
        resultText = findViewById(R.id.text_view_result);
        calculateButton = findViewById(R.id.button_calculate);
    }

    public void setupButtonClickListener(){
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inchesString = inchesText.getText().toString();

                if(inchesString.isEmpty()) {
                    emptyMsg.show();
                }
                else {
                     meters = convertToMeters();
                    displayResult();
                }
            }
        });
    }

    public double convertToMeters() {
        int inches = Integer.parseInt(inchesString);
        return inches*0.0254;
    }

    public void displayResult(){
        DecimalFormat df = new DecimalFormat("#.00");
        String formattedMeters = df.format(meters);
        resultText.setText(formattedMeters + " meters");
    }
    public boolean isEmpty(){
        return inchesString.length() == 0;
    }
}