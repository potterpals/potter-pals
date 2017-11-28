package edu.fsu.cs.cen4020.potterpals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static edu.fsu.cs.cen4020.potterpals.LoginUser.name;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView usersname = (TextView) findViewById(R.id.textView5);
        usersname.setVisibility(View.INVISIBLE);
        Button signUp = (Button) findViewById(R.id.signup);
        Button login = (Button) findViewById(R.id.login);

        //SIGNUP BUTTON STARTS ACTIVITY WITH SIGN IN FORM
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterUser.class);
                startActivity(intent);
            }
        });

        //LOGIN BUTTON STARTS INTENT WITH ACTIVITY FOR LOGIN
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginUser.class);
                startActivity(intent);
            }
        });

        //Radio Button start corresponding intent associated with the selections
        RadioButton readSumm = (RadioButton) findViewById(R.id.radioFemale);
        RadioButton takeQuiz = (RadioButton) findViewById(R.id.quiz);
        RadioButton invite = (RadioButton) findViewById(R.id.invite);
        RadioButton takeQuiz2 = (RadioButton) findViewById(R.id.quiz2);
        RadioButton twitter = (RadioButton) findViewById(R.id.radioButton);
        //CLICKING ON THIS SHOWS LIST OF BOOKS
        readSumm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BookList.class);
                startActivity(intent);


            }
        });

        //LETS USER TAKE QUIZ AFTER SELECTING THIS
        takeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HouseQuiz.class);
                startActivity(intent);


            }
        });

        //LETS USER INVITE THEIR FRIENDS TO THE APP BY SENDING OUT EMAIL
        invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Invite.class);
                startActivity(intent);

            }
        });

        //USER CAN TAKE TO QUIZ 2 FEATURE
        takeQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Quiz2.class);
                startActivity(intent);


            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TwitterFeed.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null)
        {
            String username =bundle.getString(name);
            Toast.makeText(getApplicationContext(),"Welcome! " + username, Toast.LENGTH_LONG).show();
            usersname.setVisibility(View.VISIBLE);
            usersname.setText("Welcome " + username + "!");
        }
    }
}
