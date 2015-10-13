package com.example.michal.simplelistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{

    // Define the androidListView.
    ListView mListView;

    // Elements that will be displayed in android ListView.
    String[] Countries = new String[] {"India", "Australia", "New Zealand", "Indonesia", "China",
            "Russia", "Japan", "South Korea"};

    // Ids of flag Images that are placed in res > drawable folder. They return the int value.
    int[] FlagId = new int[] {R.drawable.flag_india, R.drawable.flag_australia, R.drawable
            .flag_newzealand, R.drawable.flag_indonesia, R.drawable.flag_china, R.drawable
            .flag_russia, R.drawable.flag_japan, R.drawable.flag_southkorea};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);

        // Declare Array adapter.
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this,android.R.layout
                .simple_list_item_1, Countries);

        // Setting the android ListView's adapter to the newly created adapter.
        mListView.setAdapter(countryAdapter);
       mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
       {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id)
          {
              // The position where the list item is clicked is obtained from the parameter
              // position of the android ListView.
              int itemPosition = position;

              // Get the string value of the item where the user clicked.
              String itemValue = (String)mListView.getItemAtPosition(position);

              // In order to start displaying a new acitivty we need an intent.
              Intent intent = new Intent(getApplicationContext(),CountryActivity.class);

              // Putting the Id of an image as an extra in the intent.
              intent.putExtra("flag", FlagId[position]);

              // Here we will pass the previously created intent as the parameter.
              startActivity(intent);
          }
       });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
} // End class MainActivity.
