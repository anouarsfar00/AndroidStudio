package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText TXTprénom = (EditText) findViewById(R.id.ET_Prenom);
        RadioButton RadioHomme = (RadioButton) findViewById(R.id.RB_masculin);
        RadioButton RadioFemme = (RadioButton) findViewById(R.id.RB_féminin);
        CheckBox CheckFrançais = (CheckBox) findViewById(R.id.check_FR);
        CheckBox CheckAnglais = (CheckBox) findViewById(R.id.check_AN);
        CheckBox CheckEspagnole = (CheckBox) findViewById(R.id.check_ES);
        Button Btn_valider = (Button) findViewById(R.id.BT_valider);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.CSRT_layout);
        Btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String prenom= TXTprénom.getText().toString();
               String honorifiqueFR="";
               if(RadioHomme.isChecked())
               {
                   honorifiqueFR="cher";
               }
               else if(RadioFemme.isChecked()){
                   honorifiqueFR="chère";
               }
               Snackbar snackbar= Snackbar
                       .make(constraintLayout, "Bonjour "+honorifiqueFR+" "+prenom,Snackbar.LENGTH_LONG);
               snackbar.show();
            }
        });
    }
}
