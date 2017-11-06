package edu.fsu.cs.cen4020.potterpals;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static edu.fsu.cs.cen4020.potterpals.BookList.BOOK;
import static edu.fsu.cs.cen4020.potterpals.R.array.book_nums;

/**
 * Created by sap15e on 11/1/2017.
 */

public class BookSummary extends AppCompatActivity
{
    final static String book1= "Harry Potter and the Sorcerers Stone";
    final static String book2= "Harry Potter and the Chamber of Secrets";
    final static String book3= "Harry Potter and the Prisoner of Azkaban";
    final static String book4= "Harry Potter and the Goblet of Fire";
    final static String book5= "Harry Potter and the Order of the Phoenix";
    final static String book6= "Harry Potter and the Half-Blood Prince";
    final static String book7= "Harry Potter and the Deathly Hallows";
    LayoutInflater inflator;
    TextView bookSumm;
    EditText remind;
    EditText edit_place;
    AlertDialog alertDialog;
    Button no;
    Button yes;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_summ);

        //TEXTVIEW TO DISPLAY BOOK SUMMARY
        bookSumm = (TextView) findViewById(R.id.textView);

        bookSumm.setMovementMethod(new ScrollingMovementMethod());
        bookSumm.setVisibility(View.INVISIBLE);
        //GETTING THE INTENT AND GETTING THE STRING FROM IT
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null)
        {
            //SAVING THE STRING IN THE BUNDLE INTO A STRING AND COMAPRING THAT TO DIFFERENT BOOK TITLES
            String book = bundle.getString(BOOK);

            //COMPARE THE BOOK STRING TO SEE WHICH BOOK IT IS AND DEPENDING ON WHICH BOOK IT IS
            //THE TEXTVIEW WILL BE SET TO THE APPROPIATE SUMMARY.
            //compare strings
            if (book.equals(book1)) {
                showDialog();
                bookSumm.setText(R.string.book1Summ);
            }else if (book.equals(book2)) {
                showDialog();
                bookSumm.setText(R.string.book2Summ);
            }else if (book.equals(book3)) {
                showDialog();
                bookSumm.setText(R.string.book3Summ);
            }else if (book.equals(book4)) {
                showDialog();
                bookSumm.setText(R.string.book4Summ);
            }else if (book.equals(book5)) {
                showDialog();
                bookSumm.setText(R.string.book5Summ);
            }else if (book.equals(book6)) {
                showDialog();
                bookSumm.setText(R.string.book6Summ);
            }else if (book.equals(book7)) {
                showDialog();
                bookSumm.setText(R.string.book7Summ);
            }
        }
    };
    void showDialog()
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        inflator = getLayoutInflater();
        View dialogView=inflator.inflate (R.layout.dialog,null);
        dialog.setView(dialogView);
        TextView text = dialogView.findViewById(R.id.text);
        text.setText("Are you sure you want to read the book summary?");
        no = dialogView.findViewById(R.id.button2);
        yes = dialogView.findViewById(R.id.button);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookSumm.setVisibility(View.VISIBLE);
                alertDialog.dismiss();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Toast.makeText(context,"going back", Toast.LENGTH_LONG).show();

            }
        });
        dialog.create();
        alertDialog= dialog.show();

    }
}
