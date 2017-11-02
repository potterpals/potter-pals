package edu.fsu.cs.cen4020.potterpals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sap15e on 10/24/2017.
 */

public class RegisterUser extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button reset = (Button) findViewById(R.id.button_reset);
        final EditText confirmEmail = (EditText)findViewById(R.id.confirm_email);
        final EditText name = (EditText)  findViewById(R.id.edit_name);
        final EditText email = (EditText) findViewById(R.id.edit_email);
        final RadioButton male = (RadioButton) findViewById(R.id.radio_male);
        final RadioButton female = (RadioButton) findViewById(R.id.radio_female);

        //IF USER WANTS TO DELETE EVERYTHING THEY INPUTTED THAT THEY TYPED OR SELECTED THEN THIS BUTTON DOES IT
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.setText("");
                name.setText("");
                confirmEmail.setText("");
                male.setChecked(false);
                female.setChecked(false);
                email.setText("");


            }
        });





    }
}
