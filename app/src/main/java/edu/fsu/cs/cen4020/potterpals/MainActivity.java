package edu.fsu.cs.cen4020.potterpals;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.TextView;
import static edu.fsu.cs.cen4020.potterpals.R.array.book_nums;



public class MainActivity extends AppCompatActivity {

    public ListView bookList;
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signUp = (Button) findViewById(R.id.signup);
        Button login = (Button) findViewById(R.id.login);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterUser.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginUser.class);
                startActivity(intent);
            }
        });
        RadioButton readSumm = (RadioButton)findViewById(R.id.radioFemale);
        RadioButton takeQuiz = (RadioButton) findViewById(R.id.quiz);

        readSumm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BookList.class);
                startActivity(intent);


            }
        });

        takeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HouseQuiz.class);
                startActivity(intent);


            }
        });





    }
}
