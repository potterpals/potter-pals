package edu.fsu.cs.cen4020.potterpals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by sap15e on 10/24/2017.
 */

public class RegisterUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button reset = (Button) findViewById(R.id.button_reset);

        final EditText password = (EditText)findViewById(R.id.pass_input1);
        final EditText password2 = (EditText)findViewById(R.id.pass_input2);
        final EditText name = (EditText)findViewById(R.id.edit_name);
        final EditText email = (EditText) findViewById(R.id.edit_email);
        final RadioButton male = (RadioButton) findViewById(R.id.radio_male);
        final RadioButton female = (RadioButton) findViewById(R.id.radio_female);
        final CheckBox terms = (CheckBox) findViewById(R.id.check_agree);


        //IF USER WANTS TO DELETE EVERYTHING THEY INPUTTED THAT THEY TYPED OR SELECTED THEN THIS BUTTON DOES IT
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.setText("");
                name.setText("");
                password.setText("");
                password2.setText("");
                male.setChecked(false);
                female.setChecked(false);
                terms.setChecked(false);
            }
        });

    }
}
