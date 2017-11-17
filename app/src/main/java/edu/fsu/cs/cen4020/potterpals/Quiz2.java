package edu.fsu.cs.cen4020.potterpals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by vidhigandhi on 11/17/17.
 */

public class Quiz2 extends AppCompatActivity {

    Button next2, end2;
    TextView question2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz2);

        next2 = (Button) findViewById(R.id.Next_q2);
        end2 = (Button) findViewById(R.id.results_q2);
        question2 = (TextView) findViewById(R.id.question_text_q2);

    }

}
