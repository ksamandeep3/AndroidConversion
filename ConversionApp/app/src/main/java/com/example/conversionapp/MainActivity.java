package com.example.conversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText fahHN, celHN;
    Button ConBtn, ClrBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fahHN = findViewById(R.id.fahHN);
        celHN = findViewById(R.id.celHN);
        ConBtn = findViewById(R.id.conBtn);
        ClrBtn = findViewById(R.id.clrBtn);

        //register the button clear as click listener
        ClrBtn.setOnClickListener(this);
        ConBtn.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.clrBtn:
                fahHN.setText("");
                celHN.setText("");
                break;
            case R.id.conBtn:
                if(fahHN.getText().toString().equals(""))
                {
                    //convert from  celcius to farhenhiet to
                    double cel = Double.parseDouble(celHN.getText().toString());
                    double fah = cel*(9.0/5.0)+32;
                    Double result = new Double(fah);
                    fahHN.setText(result.toString());


                }
                else if(celHN.getText().toString().equals(""))
                {
                    //convert fromfarehenhiet  to  celsius
                    double fah = Double.parseDouble(fahHN.getText().toString());
                    double cel = (fah-30)*(5/9);
                    Double result = new Double(cel);
                    celHN.setText(String.valueOf(result));
                }
                else // if both are empty
                    Toast.makeText(this, "Please enter the temperature you want to convert", Toast.LENGTH_SHORT).show();
        }
    }
}
