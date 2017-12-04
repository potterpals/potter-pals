package edu.fsu.cs.cen4020.potterpals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


/**
 * Created by sap15e on 11/1/2017.

 */

public class HouseQuiz extends AppCompatActivity
{
    Button next, end;
    TextView question;
    ImageView house;
    RadioGroup selections;
    int GryffCount=0;
    int HuffCount=0;
    int SlythCount=0;
    int RavenCount=0;
    int count = 0;
    int answerCount=1;
    String largest;
    private static final String TAG = "MyActivity";
//String [Question][Answers]. Should be [9][5] i.e. 10 by 6
    //default order is gryffindor, slytherin, ravenclaw, hufflepuff
    //Added a field to indicate the order of the associated houses for the answers in the form GSRH (gryffindor, slytherin, etc.
    String[][] QuestionArray = {
        {"You find a Remembrall on the ground but there is no one around to claim it. What do you do?",
                "Play with the Remembrall for a while before trying to return it",
                "Actively look for the owner to ensure no one else takes it",
                "Report the Remembrall as lost and hand it over to one of the professors",
                "Keep the Remembrall for yourself",
                "HGRS"},

        {"Which of these Hogwarts classes do you enjoy the most?",
                "Defense against the Dark Arts",
                "Charms",
                "Potions",
                "History of Magic",
                "SGHR"},

        {"Which magical creature do you feel the most drawn to?",
                "Centaur",
                "Hippogriff",
                "Phoenix",
                "Basilisk",
                "HRGS"},

        {"You hear some fellow classmates mischievously sneaking out of the dormitory late at night. What do you do?",
                "Follow them and try to convince them to go back to bed",
                "Go back to sleep",
                "Join them and their antics",
                "Have an existential crisis because you want to report them but to do so would require you to leave the dorm which is breaking the rules",
                "GHSR"},

        {"You and group of friends are traveling down a path together. Which role sounds the most like you?",
                "Navigating using the map you bought to ensure you don't get lost",
                "Trying to convince the others to investigate the mysterious object you spotted in the nearby trees",
                "Playing pranks on the others",
                "Initiating games so no one gets bored along the way",
                "RGSH"},

        {"What do you think of muggles?",
                "Muggles suck",
                "Wizzards and muggles are equal",
                "Make great friends just like everyone else",
                "They live interesting lives that should be studied",
                "SGHR"},

        {"It's your first day at Hogwarts? What will you do?",
                "Explore the castle",
                "Bully mudbloods",
                "Begin studying for classes",
                "Try to make new friends",
                "GSRH"},

        {"What do you want people to remember you for?",
                "Your good deeds",
                "Legendary tales of your adventures",
                "Your expansive knowledge",
                "Remarkable achievements you accomplished",
                "HGRS"},

        {"Amortentia is the most powerful love potion in the world and it smells different depending on what attracts a specific person. Which of the following scents would you find most attractive?",
                "Old books",
                "An exquisite perfume/cologne",
                "Camp fire",
                "Home cooked meals",
                "RSGH"},

        {"What statement best defines you?",
                "'I feel'",
                "'I can'",
                "'I know'",
                "'I will'",
                "HGRS"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        next = (Button) findViewById(R.id.Next);
        end = (Button) findViewById(R.id.results);
        selections = (RadioGroup) findViewById(R.id.selections);
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
        question.setText(QuestionArray[count][0]);
        sel1.setText(QuestionArray[count][answerCount]);
        sel2.setText(QuestionArray[count][answerCount+1]);
        sel3.setText(QuestionArray[count][answerCount+2]);
        sel4.setText(QuestionArray[count][answerCount+3]);


        /*
            When a radio button is selected, function 'incrementHouse' is passed the corresponding order
            of the answers and info for which letter to check. I.e. if user picks selection 3 and order is RGHS,
            increment house will look at the third letter, see that it's Hufflepuff, and increment
            the counter for that house.
            */
        sel1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked)
                                                {
                                                    incrementHouse(QuestionArray[count][5], 1); //5th index is always the order GSRH, etc.
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
                                                    incrementHouse(QuestionArray[count][5], 2);
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
                                                    incrementHouse(QuestionArray[count][5], 3);
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
                                                    incrementHouse(QuestionArray[count][5], 4);
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
                if(selections.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(),"Please select something",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ++count;
                    if (count < 9) {
                        //If question limit is not reached; display next question & corresponding answers
                        question.setText(QuestionArray[count][0]);
                        selections.clearCheck();
                        sel1.setText(QuestionArray[count][answerCount]);
                        sel2.setText(QuestionArray[count][answerCount+1]);
                        sel3.setText(QuestionArray[count][answerCount+2]);
                        sel4.setText(QuestionArray[count][answerCount+3]);


                    }
                    else if (count == 9){
                        //"get results button becomes visible
                        if(GryffCount >= SlythCount && GryffCount >= HuffCount && GryffCount >= RavenCount)
                            largest="Gryffindor";
                        else if(SlythCount >= GryffCount && SlythCount >= HuffCount && SlythCount >= RavenCount)
                            largest="Slytherin";
                        else if(HuffCount >= GryffCount && HuffCount >= SlythCount && HuffCount >= RavenCount)
                            largest="Hufflepuff";
                        else if(RavenCount >= GryffCount && RavenCount >= SlythCount && RavenCount >= HuffCount)
                            largest="Ravenclaw";
                        end.setVisibility(View.VISIBLE);
                        //"Next" button is invisible to any clicks - can go no further
                        next.setVisibility(View.INVISIBLE);
                    }
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
                question.setText("You're sorted into..." + largest);
                house.setVisibility(View.VISIBLE);
                if (largest.equals("Gryffindor"))
                {
                    house.setImageResource(R.drawable.gryff);
                }
                else if(largest.equals("Slytherin"))
                {
                    house.setImageResource(R.drawable.slyth);

                }
                else if (largest.equals("Ravenclaw"))
                {
                    house.setImageResource(R.drawable.raven);
                }
                else
                {
                    house.setImageResource(R.drawable.huff);
                }

            }
        });
        end.setVisibility(View.INVISIBLE);

    }

    public void incrementHouse(String order, int index){
        //correcting index associated with radio buttons (1-4) to the indexes for the string 'order' (0-3)
        index -= 1;
        Log.d(TAG, "index=" + index);
        if(order.charAt(index)=='G')
            GryffCount++;
        else if(order.charAt(index)=='S')
            SlythCount++;
        else if(order.charAt(index)=='R')
            RavenCount++;
        else
            HuffCount++;
    }

}
