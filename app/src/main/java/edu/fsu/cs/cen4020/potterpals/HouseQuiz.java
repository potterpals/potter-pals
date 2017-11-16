package edu.fsu.cs.cen4020.potterpals;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * Created by sap15e on 11/1/2017.
 */

public class HouseQuiz extends AppCompatActivity
{
    Button next, end;
    TextView question;
    ImageView house;
    int GryffCount=0;
    int HuffCount=0;
    int SlythCount=0;
    int RavenCount=0;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        next = (Button) findViewById(R.id.Next);
        end = (Button) findViewById(R.id.results);
        question = (TextView) findViewById(R.id.question_text);
        house = (ImageView) findViewById(R.id.imageView4);
        house.setVisibility(View.INVISIBLE);
        final RadioButton sel1 = (RadioButton)findViewById(R.id.sel1);
        final RadioButton sel2 = (RadioButton)findViewById(R.id.sel2);
        final RadioButton sel3 = (RadioButton)findViewById(R.id.sel3);
        final RadioButton sel4 = (RadioButton)findViewById(R.id.sel4);

        //initially all button = invisible
        next.setVisibility(View.INVISIBLE);
        end.setVisibility(View.INVISIBLE);


        //Question assigned to the textview
        question.setText("Question " + count);
        sel1.setText("answer 1 - declared from: HouseQuiz.java. Count: " + count);
        sel2.setText("answer 2 - declared from: HouseQuiz.java. Count: " + count);
        sel3.setText("answer 3 - declared from: HouseQuiz.java. Count: " + count);
        sel4.setText("answer 4 - declared from: HouseQuiz.java. Count: " + count);



        sel1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked)
                                                {
                                                    //INCREMENT THE COUNT FOR GRYFINDOR;
                                                    next.setVisibility(View.VISIBLE);
                                                }
                                            }
                                        }
        );

        sel2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked)
                                                {
                                                    //INCREMENT THE COUNT FOR HUFFLEPUFF
                                                    next.setVisibility(View.VISIBLE);
                                                }
                                            }
                                        }
        );

        sel3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked)
                                                {
                                                    //INCREMENT THE COUNT FOR SLYTHERIN
                                                    next.setVisibility(View.VISIBLE);
                                                }
                                            }
                                        }
        );
        sel4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked)
                                                {
                                                    //INCREMENT THE COUNT FOR RAVENCLAW
                                                    next.setVisibility(View.VISIBLE);
                                                }
                                            }
                                        }
        );

        /*
            Implementing questions : Flow of events
                If questions are less than 10 then next button should take user to the next question
                If all 10 questions are displayed -> "get results" button becomes visible
                "Get results" takes user to view house they belong to
                */
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++count;
                if (count <= 10) {
                    //If question limit is not reached; display next question & corresponding answers
                    question.setText("Question " + count);
                    sel1.setText("answer 1 - declared from: HouseQuiz.java. Count: " + count);
                    sel2.setText("answer 2 - declared from: HouseQuiz.java. Count: " + count);
                    sel3.setText("answer 3 - declared from: HouseQuiz.java. Count: " + count);
                    sel4.setText("answer 4 - declared from: HouseQuiz.java. Count: " + count);
                }
                else if (count > 10){
                    //"get results button becomes visible"
                    end.setVisibility(View.VISIBLE);
                    //"Next" button is invisible to any clicks - can go no further
                    next.setVisibility(View.INVISIBLE);
                }
            }//end view
        }//end listener
        );

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel1.setVisibility(View.INVISIBLE);
                sel2.setVisibility(View.INVISIBLE);
                sel3.setVisibility(View.INVISIBLE);
                sel4.setVisibility(View.INVISIBLE);
                question.setText("You're sorted into...");
                house.setVisibility(View.VISIBLE);
            }
        });

    }


}
