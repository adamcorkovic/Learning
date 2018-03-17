package com.example.kompy.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] mArray = {"First Item", "Second Item", "Third Item", "Fourth Item", "Fifth Item", "..."};

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        setUpList();
    }

    private void setUpList() {
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mArray);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener((adapterView, view, i, l) -> openDialogForItem(i));
    }

    private void openDialogForItem(int position) {
        new AlertDialog.Builder(this)
                .setTitle(mArray[position])
                .setMessage(R.string.some_text)
                .setNegativeButton(R.string.ok, (dialogInterface, i) -> Toast.makeText(getApplicationContext(), mArray[position], Toast.LENGTH_SHORT).show())
                .setPositiveButton(R.string.cancel, null)
                .show();
    }
}
