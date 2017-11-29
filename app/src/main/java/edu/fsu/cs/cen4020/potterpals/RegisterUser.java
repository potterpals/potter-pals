package edu.fsu.cs.cen4020.potterpals;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by sap15e on 10/24/2017.
 */

public class RegisterUser extends AppCompatActivity {
    private Cursor mCursor;
    EditText password;
    EditText password2;
    EditText name;
    EditText email;
    RadioButton male;
    RadioButton female;
    CheckBox terms;
    Context context = this;

    int randomCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button reset = (Button) findViewById(R.id.button_reset);
        Button register = (Button) findViewById(R.id.button_submit);

        password = (EditText) findViewById(R.id.pass_input1);
        password2 = (EditText) findViewById(R.id.pass_input2);
        name = (EditText) findViewById(R.id.edit_name);
        email = (EditText) findViewById(R.id.edit_email);
        male = (RadioButton) findViewById(R.id.radio_male);
        female = (RadioButton) findViewById(R.id.radio_female);
        terms = (CheckBox) findViewById(R.id.check_agree);


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


        //REGISTER BUTTON CHECKS TO SEE IF USER HAS ENTERED EVERY FIELD AND IF THEY HAVE AND
        //THE PASSWORDS MATCH, THEN THE USER WILL BE INSTERTED INTO THE DATABASE.
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean allIsGood = true;
                String nameStr = name.getText().toString();
                String emailStr = email.getText().toString();
                String passwordStr = password.getText().toString();
                String password2Str = password2.getText().toString();

                Boolean maleSelected = male.isChecked();
                Boolean femaleSelected = female.isChecked();

                String genderStr;
                Boolean agreeToTermsChecked = terms.isChecked();

                // preliminary field checking
                if (nameStr.length() == 0) {
                    name.setError("Please enter a Name!");
                    allIsGood = false;
                }

                if (emailStr.length() == 0) {
                    email.setError("Please enter a email!");
                    allIsGood = false;
                }

                if (validateEmail(emailStr) == false){
                    email.setError("Email entered is invalid. Try Again.");
                    allIsGood = false;
                }

                if (passwordStr.length() == 0) {
                    password.setError("Please enter a password!");
                    allIsGood = false;
                }

                if (password2Str.length() == 0) {
                    password2.setError("Please enter a password!");
                    allIsGood = false;
                }
                if ((!passwordStr.equals("") && !password2Str.equals("")) && !passwordStr.equals(password2Str)) {
                    password2.setError("The passwords do not match!");
                    allIsGood = false;

                    if (maleSelected || femaleSelected) {
                        female.setError(null);
                    }

                    if (agreeToTermsChecked) {
                        terms.setError(null);
                    }
                }

                if (!maleSelected && !femaleSelected) {
                    female.setError("Please select a gender!");
                    allIsGood = false;
                }

                if (!agreeToTermsChecked) {
                    terms.setError("Please agree to the terms!");
                    allIsGood = false;
                }

                if (allIsGood) {

                    String[] mProjection;
                    String mSelectionClause;
                    String[] mSelectionArgs;

                    mProjection = new String[]{MyContentProvider.COLUMN_EMAIL};
                    mSelectionClause = MyContentProvider.COLUMN_EMAIL + " = ?";
                    mSelectionArgs = new String[]{emailStr};

                    // query database to see if email already exists
                    mCursor = context.getContentResolver().query(MyContentProvider.CONTENT_URI,
                            mProjection, mSelectionClause, mSelectionArgs, null);

                    Boolean idAlreadyExists = false;
                    if (mCursor != null) {
                        while (mCursor.moveToNext()) {
                            if (mCursor.getString(0).equals(emailStr)) {
                                idAlreadyExists = true;
                            }
                        }
                    }

                    if (idAlreadyExists) {
                        email.setError("This email is already registered");
                    } else {
                        ContentValues values = new ContentValues();

                        if (maleSelected) {
                            genderStr = "Male";
                        } else {
                            genderStr = "Female";
                        }
                        String house = "";

                        // add content values to insert and pass on
                        values.put(MyContentProvider.COLUMN_EMAIL, emailStr.trim());
                        values.put(MyContentProvider.COLUMN_PASSWORD, passwordStr.trim());
                        values.put(MyContentProvider.COLUMN_NAME, nameStr.trim());
                        values.put(MyContentProvider.COLUMN_GENDER, genderStr.trim());
                        values.put(MyContentProvider.COLUMN_HOUSE, house.trim());
                        Uri newUri = getContentResolver().insert(MyContentProvider.CONTENT_URI, values);

                        //send email here and prompt the user to enter the verification code received in this email
                        sendEmail();

                        Toast.makeText(context,"You have successfully registered!",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }

    /*
     STEP 1: Email Authentication

     * This function is used to check if the email entered is a valid email using REGEX
     * Patterns.EMAIL_ADDRESS matches the pattern:
     *     USERNAME [** char or num **] + "@" + DOMAIN [** char/num ** ] "." [** char/num **]
     *
     * Error messages enabled otherwise
     */

    public final static boolean validateEmail(String email) {
        if (TextUtils.isEmpty(email))
            return false;
        else
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /*
     STEP 2: Email Authentication
     Functions: getCode() >> return type: int
                sendEmail()

     * This function is going to send out a "Test" email to the user entered email
     * This test email contains a code - the user will then enter this code to prove validity of email
     *
     * Code is entered in a dialog pop-up
     * Code is generated randomly using java.util.Random library
     */
    public void getCode(){
        Random random = new Random();
        //generates a random number in [0,99]
        randomCode = random.nextInt(100);
    }

    /* This intent will open an application already existing on the device to send out an email
     * All the fields such as sender, subject, and the body of the email will be filled out by this function
      */
    public void sendEmail(){
        Log.e("Register User: ","Send Email function is being activated");
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Verification email - Potter Pals.");
        intent.putExtra(Intent.EXTRA_TEXT, "The verification code is: " + randomCode);

        try{
            startActivity(Intent.createChooser(intent, "Send email: "));
        }catch (android.content.ActivityNotFoundException e){
            Toast.makeText(RegisterUser.this, "There are no email clients available", Toast.LENGTH_LONG ).show();
        }

    }

}
