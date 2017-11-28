package edu.fsu.cs.cen4020.potterpals;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by vidhigandhi on 11/17/17.
 */

public class Quiz2 extends AppCompatActivity {

    Button next2, end2;
    TextView question2;
    RadioGroup selections;
    LayoutInflater in;
    Button close;
    AlertDialog mydialog;
    Context context = this;

    int count = 0;
    int numCorrect = 0;
    boolean correct = false;

    //Array with questions and answers String[question #][question and answers]
    String[][] TriviaArray = {
            {"What is the difference between the Philosopher's stone and the Sorcerer's stone?","One brings people back to life, the other can make the Elixir of life", "One is used for light magic, the other is used for dark magic", "These are different names for the same stone", "There is no such thing as the philosopher's stone"},
            {"Which of these is not one of the Deathly Hallows?", "The Cloak of Invisibility", "The Sorcerer's Stone", "The Elder Wand", "The Resurrection Stone"},
            {"What job does Harry Potter have in the epilogue of Harry Potter and the Deathly Hallows?", "Auror", "Professor", "Wandmaker", "Herbologist"},
            {"Which of these wizards share the same Patronus?", "Lord Voldemort and Bellatrix Lestrange", "Harry Potter and Sirius Black", "Hermione Granger and Professor McGonagall", "Severus Snape and Lily Potter"},
            {"How many Weasley children are there?", "5", "6", "7", "8"},
            {"Which of these wizards does not belong to Hufflepuff House?", "Nymphadora Tonks", "Luna Lovegood", "Cedric Diggory", "Pomona Sprout"},
            {"Which of these is not an Unforgivable Curse?", "Imperio", "Avada Kedavra", "Sectumsempra", "Crucio"},
            {"What is the name of Hermione Granger's cat?", "Crookshanks", "Hedwig", "Mrs. Norris", "Tufty"},
            {"At the end of Harry Potter and the Deathly Hallows, who is the owner of the Elder Wand?", "Lord Voldemort", "Severus Snape", "Draco Malfoy", "Harry Potter"},
            {"When is Harry Potter's birthday?", "July 31", "June 11", "May 5", "June 16"}
    };

    //Array with correct answers 1 = first option, 2 = second option, etc.
    int[] correctAnswers = {3, 2, 1, 4, 3, 2, 3, 1, 4, 1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz2);

        selections = (RadioGroup) findViewById(R.id.selections);

        next2 = (Button) findViewById(R.id.Next);
        end2 = (Button) findViewById(R.id.results);
        question2 = (TextView) findViewById(R.id.question_text);

        final RadioButton sel1 = (RadioButton)findViewById(R.id.sel1);
        final RadioButton sel2 = (RadioButton)findViewById(R.id.sel2);
        final RadioButton sel3 = (RadioButton)findViewById(R.id.sel3);
        final RadioButton sel4 = (RadioButton)findViewById(R.id.sel4);

        next2.setVisibility(View.INVISIBLE);
        end2.setVisibility(View.INVISIBLE);

        question2.setText(TriviaArray[count][0]);
        sel1.setText(TriviaArray[count][1]);
        sel2.setText(TriviaArray[count][2]);
        sel3.setText(TriviaArray[count][3]);
        sel4.setText(TriviaArray[count][4]);

        sel1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked)
                                                {
                                                    //Check if first option is correct answer
                                                    if(correctAnswers[count] == 1) {
                                                        ++numCorrect;
                                                        correct = true;
                                                    }

                                                    next2.setVisibility(View.VISIBLE);
                                                }
                                            }
                                        }
        );

        sel2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked)
                                                {
                                                    //Check if second option is correct answer
                                                    if(correctAnswers[count] == 2) {
                                                        ++numCorrect;
                                                        correct = true;
                                                    }

                                                    next2.setVisibility(View.VISIBLE);
                                                }
                                            }
                                        }
        );

        sel3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked)
                                                {
                                                    //Check if third option is correct answer
                                                    if(correctAnswers[count] == 3) {
                                                        ++numCorrect;
                                                        correct = true;
                                                    }

                                                    next2.setVisibility(View.VISIBLE);
                                                }
                                            }
                                        }
        );
        sel4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked)
                                                {
                                                    //Check if fourth option is correct answer
                                                    if(correctAnswers[count] == 4) {
                                                        ++numCorrect;
                                                        correct = true;
                                                    }

                                                    next2.setVisibility(View.VISIBLE);
                                                }
                                            }
                                        }
        );

        next2.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {

                                 // check to see if the wrong answer was submitted, display correct answer if incorrect

            if(selections.getCheckedRadioButtonId()==-1)
            {
                Toast.makeText(getApplicationContext(),"Please select something",Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(!correct)
                    displayAnswer(correctAnswers,TriviaArray,count);
                else
                    correct = false;
                ++count;
                if (count < 10) {
                    //If question limit is not reached; display next question & corresponding answers
                    question2.setText(TriviaArray[count][0]);
                    selections.clearCheck();
                    sel1.setText(TriviaArray[count][1]);
                    sel2.setText(TriviaArray[count][2]);
                    sel3.setText(TriviaArray[count][3]);
                    sel4.setText(TriviaArray[count][4]);

                }
                else if (count == 10){
                    //"get results button becomes visible
                    end2.setVisibility(View.VISIBLE);
                    //"Next" button is invisible to any clicks - can go no further
                    next2.setVisibility(View.INVISIBLE);
                }
            }
                                     }//end view
                         }//end listener
        );

        end2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel1.setVisibility(View.INVISIBLE);
                sel2.setVisibility(View.INVISIBLE);
                sel3.setVisibility(View.INVISIBLE);
                sel4.setVisibility(View.INVISIBLE);
                question2.setText("You answered " + numCorrect + " out of 10 correctly!");

            }
        });
    }

    void displayAnswer(int[] correctAnswers, String[][]TriviaArray, int count)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        in = getLayoutInflater();
        View dialogView = in.inflate (R.layout.ans_dialog,null);
        dialog.setView(dialogView);


        TextView t1 = dialogView.findViewById(R.id.option_ans);
        //set the contents of t1 text here according to the correct answer preference
        //Format to set the contents: t1.setText(Correct option choice);
        t1.setText(TriviaArray[count][correctAnswers[count]]);

        close = dialogView.findViewById(R.id.nav_button);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                mydialog.dismiss();
            }
        });
        dialog.create();
        mydialog = dialog.show();


    }

}

