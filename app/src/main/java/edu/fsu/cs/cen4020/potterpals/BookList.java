package edu.fsu.cs.cen4020.potterpals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import static edu.fsu.cs.cen4020.potterpals.R.array.book_nums;

/**
 * Created by sap15e on 10/28/2017.
 */

public class BookList extends AppCompatActivity {
    public ListView bookList;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books);
        bookList = (ListView) findViewById(R.id.list_url);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(), book_nums, android.R.layout.simple_list_item_1);
        bookList.setAdapter(adapter);
        bookList.setClickable(true);


    };
}
