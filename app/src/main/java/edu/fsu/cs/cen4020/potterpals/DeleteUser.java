package edu.fsu.cs.cen4020.potterpals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static edu.fsu.cs.cen4020.potterpals.LoginUser.name;

/**
 * Created by sap15e on 11/28/2017.
 */

public class DeleteUser extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        TextView question = (TextView) findViewById(R.id.leave);
        Button leave = (Button) findViewById(R.id.leave);
        Button stay = (Button) findViewById(R.id.stay);
        stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Bye!!",Toast.LENGTH_SHORT).show();
                ActivityCompat.finishAffinity(DeleteUser.this);
            }
        });
    }

}
