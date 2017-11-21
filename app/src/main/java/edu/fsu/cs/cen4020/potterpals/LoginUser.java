package edu.fsu.cs.cen4020.potterpals;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button login = (Button) findViewById(R.id.button_login);
        email =(EditText) findViewById(R.id.edit_name);
        password= (EditText) findViewById(R.id.edit_password);

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
                    String name = "";

                    //MAKE ARGUMENTS TO BE PASSED ONTO QUERY
                    mProjection = new String[]{"_ID", MyContentProvider.COLUMN_EMAIL, MyContentProvider.COLUMN_PASSWORD};
                    mSelectionClause = MyContentProvider.COLUMN_EMAIL + " = ? AND " + MyContentProvider.COLUMN_PASSWORD + " = ?";
                    mSelectionArgs = new String[]{empIDStr, accessCodeStr};

                    // query database for supplied login information
                    mCursor = context.getContentResolver().query(MyContentProvider.CONTENT_URI,
                            mProjection, mSelectionClause, mSelectionArgs, null);

                    Boolean loginSuccess = false;
                    if (mCursor != null) {
                        while (mCursor.moveToNext()) {
                            //THIS IF STATEMENT CHECKS FOR THE EMAIL AND PASSWORD USER TYPED IN AND IF BOTH  MATCH THEN SUCCESS
                            if (mCursor.getString(1).equals(empIDStr) && mCursor.getString(2).equals(accessCodeStr)) {
                                id = mCursor.getInt(0);
                                loginSuccess = true;
                            }
                        }
                    }

                    if(!loginSuccess) {
                        email.setError("Incorrect email or password");
                        password.setError("Incorrect email or password");
                    } else {
                       Toast.makeText(context,"Login Successful!",Toast.LENGTH_LONG).show();

                    }

                }
            }
        });

    }
}
