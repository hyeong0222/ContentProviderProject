package com.example.contentproviderproject;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateListView();
    }

    private void populateListView() {

        ListView inboxListView = findViewById(R.id.listViewInbox);

        Uri uriSMSURI = Uri.parse("content://sms/inbox");

        Cursor cursor = getContentResolver().query(uriSMSURI,
                null, null, null, null);

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,
                cursor,
                new String[] {"body", "address"},
                new int[]{android.R.id.text1, android.R.id.text2},
                0);

        inboxListView.setAdapter(cursorAdapter);

    }
}
