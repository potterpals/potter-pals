package edu.fsu.cs.cen4020.potterpals;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;


/**
 * Created by sap15e on 11/1/2017.
 */

public class HouseQuiz extends AppCompatActivity
{
    Button next;
    int GryffCount=0;
    int HuffCount=0;
    int SlythCount=0;
    int RavenCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        next = (Button) findViewById(R.id.Next);
        final RadioButton sel1 = (RadioButton)findViewById(R.id.sel1);
        final RadioButton sel2 = (RadioButton)findViewById(R.id.sel2);
        final RadioButton sel3 = (RadioButton)findViewById(R.id.sel3);
        final RadioButton sel4 = (RadioButton)findViewById(R.id.sel4);

        next.setVisibility(View.INVISIBLE);

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
    }
}
