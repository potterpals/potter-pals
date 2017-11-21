package edu.fsu.cs.cen4020.potterpals;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sap15e on 11/1/2017.
 */

public class LoginUser extends AppCompatActivity
{
    private Cursor mCursor;
    EditText email;
    EditText password;
    Context context = this;
    private String username;
    public static String name= "NAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button login = (Button) findViewById(R.id.button_login);
        email = (EditText) findViewById(R.id.edit_name);
        password = (EditText) findViewById(R.id.edit_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String empIDStr = email.getText().toString();
                String accessCodeStr = password.getText().toString();

                Boolean allIsGood = true;

                // ERROR CHECKING
                if (empIDStr.equals("")) {
                    allIsGood = false;
                    email.setError("Enter an email");

                }

                if (accessCodeStr.equals("")) {
                    allIsGood = false;
                    password.setError("Enter an password");
                }

                //IF NO ERRORS,THEN MAKE QUERY TO DATABASE TO SEE IF USER'S EMAIL AND PASSWORD MATCH
                if (allIsGood) {
                    String[] mProjection;
                    String mSelectionClause;
                    String[] mSelectionArgs;

                    int id = 0;

                    /*
                        MAKE ARGUMENTS TO BE PASSED ONTO QUERY:
                        mProjection includes 3 parameters to ensure that the username is retrieved
                        for the user logging using his/her email and password fields only.
                     */

                    mProjection = new String[]{"_ID", MyContentProvider.COLUMN_EMAIL,
                            MyContentProvider.COLUMN_PASSWORD, MyContentProvider.COLUMN_NAME};

                    mSelectionClause = MyContentProvider.COLUMN_EMAIL + " = ? AND " +
                            MyContentProvider.COLUMN_PASSWORD + " = ? ";

                    mSelectionArgs = new String[]{empIDStr, accessCodeStr};

                    // query database for supplied login information
                    mCursor = context.getContentResolver().query(MyContentProvider.CONTENT_URI,
                            mProjection, mSelectionClause, mSelectionArgs, null);

                    Boolean loginSuccess = false;
                    if (mCursor != null) {
                        while (mCursor.moveToNext()) {
                            //THIS IF STATEMENT CHECKS FOR THE EMAIL AND PASSWORD USER TYPED IN AND IF BOTH  MATCH THEN SUCCESS
                            if (mCursor.getString(1).equals(empIDStr) && mCursor.getString(2).equals(accessCodeStr))
                            {
                                username = mCursor.getString(3);    //tester string that shows the username on login toast
                                loginSuccess = true;
                            }
                        }
                    }

                    if(!loginSuccess) {
                        email.setError("Incorrect email or password");
                        password.setError("Incorrect email or password");
                    }
                    else {
                       Toast.makeText(context,"Login Successful! \n Username is: " + username, Toast.LENGTH_LONG).show();
                       //START NEW ACTIVITY HERE
                        // USE BUNDLE TO PASS ON USER'S NAME
                        Intent intent = new Intent(context,MainActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString(name,username);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }

                }
            }
        });

    }
}
