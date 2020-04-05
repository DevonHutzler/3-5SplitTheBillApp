package com.example.a3_5splitthebillapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.KeyguardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class Input extends AppCompatActivity {
    double billTotal, people, split;
    double tip = .18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        final EditText total = (EditText) findViewById(R.id.billTotal);     //bill total
        final EditText party = (EditText) findViewById(R.id.partySize);     //party size

        Button calculate = (Button) findViewById(R.id.btnSplit);
        calculate.setOnClickListener(new View.OnClickListener() {
            final TextView displayTotal = (TextView) findViewById(R.id.output);
            @Override
            public void onClick(View v) {
                //calculate 18% and divide among party members
                billTotal = Double.parseDouble(total.getText().toString());
                people = Double.parseDouble(party.getText().toString());

                tip *= billTotal;   //tip amount
                split = (billTotal + tip) / people; //adds tip, divides among people

                DecimalFormat money = new DecimalFormat("$###,###.##");
                displayTotal.setText("Tip amount: "+money.format(tip)+"\nIndividual: "+money.format(split));
                //resets
                tip = .18;
                split = 0;
            }
        });
    }
}
