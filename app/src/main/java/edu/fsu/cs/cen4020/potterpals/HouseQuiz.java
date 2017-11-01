package edu.fsu.cs.cen4020.potterpals;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by sap15e on 11/1/2017.
 */

public class HouseQuiz extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        TextView title = (TextView) findViewById(R.id.title);



    }
}
