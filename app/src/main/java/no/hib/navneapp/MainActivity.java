package no.hib.navneapp;

import android.app.Activity;
import android.content.Intent;
//import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class MainActivity extends Activity {


    Person a = new Person("Aleksander", R.drawable.tumblr_1);
    Person s = new Person("Simen", R.drawable.tumblr_2);
    Person k = new Person("Karl", R.drawable.tumblr_3);
    Person[]  persons = { a, s, k};
    ImageView img;
    Button next;
    boolean clicked = false;
    int imageId;
    int sel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.custom);
        next = (Button) findViewById(R.id.buttonProgress);
        next.setText("Next level");

        ArrayAdapter<Person> itemAdapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, persons);
        ListView listView = ( ListView ) findViewById(R.id.listview);
        listView.setAdapter(itemAdapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Person o = (Person) parent.getAdapter().getItem(position);
                sel = o.getPicture();
                imageId = sel;

                img.setImageResource(sel);
                img.setVisibility(View.VISIBLE);
                //String item = ((TextView)view).getText().toString();
                //int item = parent.getAdapter().getItem(position).
                //Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();


            }
        });

    }


    public int getImageId(){
        return imageId;
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
        if (id == R.id.imagemode) {
            Intent intent = new Intent(this, ImageModeActivity.class);
           startActivity(intent);
        }

        if(id == R.id.guessingmode){
            Intent intent = new Intent(this, GuessingActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    public void onClick(View v) {

        if (!clicked) {
            if (v.getId() == R.id.buttonProgress) {
                Intent intent = new Intent(this, ImageModeActivity.class);
                startActivity(intent);
                finish();

            }


        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */

}
