package edu.fsu.cs.cen4020.potterpals;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static edu.fsu.cs.cen4020.potterpals.R.array.book_nums;

/**
 * Created by sap15e on 10/28/2017.
 */

public class BookList extends AppCompatActivity {
    public ListView bookList;
    //ArrayAdapter<CharSequence> adapter;
    final Context context = this;
    public static String BOOK = "BOOK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books);
        bookList = (ListView) findViewById(R.id.list_url);

        //LOAD ADAPTER WITH BOOKS
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getBaseContext(), book_nums, android.R.layout.simple_list_item_1);

        bookList.setAdapter(adapter);
        bookList.setClickable(true);

        //ONCE USER CLICKS ON A BOOK TITLE,BOOK TITLE IS BUNDLED UP AND SENT TO THE BOOKSUMMARY FILE WHICH DISPLAYS SUMMARY OF WHATEVER
        //BOOK TITLE IS RECEIVED FROM BUNDLE
        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String book = ((TextView) view).getText().toString();
                Intent intent = new Intent(context,BookSummary.class);
                Bundle bundle = new Bundle();
                bundle.putString(BOOK,book);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    };
}
