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

import java.util.Arrays;


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
    int count = 0;
    int answerCount=1;
    String largest;
//String [Question][Answers]. Should be [9][4] i.e. 10 by 5
    String[][] QuestionArray = {
        {"You find a Remembrall on the ground but there is no one around to claim it. What do you do?", "Actively look for the owner to ensure no one else takes it", "Keep the Remembrall for yourself", "Report the Remembrall as lost and hand it over to one of the professors", "Play with the Remembrall for a while before trying to return it"},

        {"Which of these Hogwarts classes do you enjoy the most?", "Charms", "Defense against the Dark Arts", "History of Magic", "Potions"},

        {"Which magical creature do you feel the most drawn to?", "Phoenix", "Basilisk", "Hippogriff", "Centaur"},

        {"You hear some fellow classmates mischievously sneaking out of the dormitory late at night. What do you do?", "Follow them and try to convince them to go back to bed", "Join them and their antics", "Have an existential crisis because you want to report them but to do so would require you to leave the dorm which is breaking the rules", "Go back to sleep"},

        {"You and group of friends are traveling down a path together. Which role sounds the most like you?", "Trying to convince the others to investigate the mysterious object you spotted in the nearby trees", "Playing pranks on the others", "Navigating using the map you bought to ensure you don't get lost", "Initiating games so no one gets bored along the way"},

        {"What do you think of muggles?", "Wizzards and muggles are equal", "Muggles suck","They live interesting lives that should be studied", "Make great friends just like everyone else"},

        {"It's your first day at Hogwarts? What will you do?", "Explore the castle", "Bully mudbloods", "Begin studying for classes", "Try to make new friends"},

        {"What do you want people to remember you for?", "Legendary tales of your adventures", "Remarkable achievements you accomplished", "Your expansive knowledge", "Your good deeds"},

        {"Amortentia is the most powerful love potion in the world and it smells different depending on what attracts a specific person. Which of the following scents would you find most attractive?", "Camp fire", "An exquisite perfume/cologne", "Old books", "Home cooked meals"},

        {"What statement best defines you?", "'I can'", "'I will'", "'I know'", "'I feel'"}
    };

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
        question.setText(QuestionArray[count][0]);
        sel1.setText(QuestionArray[count][answerCount]);
        sel2.setText(QuestionArray[count][answerCount+1]);
        sel3.setText(QuestionArray[count][answerCount+2]);
        sel4.setText(QuestionArray[count][answerCount+3]);



        sel1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked)
                                                {
                                                    //INCREMENT THE COUNT FOR GRYFINDOR;
                                                    GryffCount++;
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
                                                    //INCREMENT THE COUNT FOR SLYTHERIN
                                                    SlythCount++;
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
                                                    //INCREMENT THE COUNT FOR RAVENCLAW
                                                    RavenCount++;
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
                                                    //INCREMENT THE COUNT FOR HUFFLEPUFF
                                                    HuffCount++;
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
                if (count < 10) {
                    //If question limit is not reached; display next question & corresponding answers
                    question.setText(QuestionArray[count][0]);
                    sel1.setText(QuestionArray[count][answerCount]);
                    sel2.setText(QuestionArray[count][answerCount+1]);
                    sel3.setText(QuestionArray[count][answerCount+2]);
                    sel4.setText(QuestionArray[count][answerCount+3]);
                }
                else if (count == 10){
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
                if (largest.equals("Gryffindor"))
                {
                    house.setVisibility(View.VISIBLE);
                }

            }
        });

    }


}
