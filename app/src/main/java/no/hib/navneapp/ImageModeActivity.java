package no.hib.navneapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;


public class ImageModeActivity extends Activity {




    Person a = new Person("Aleksander", R.drawable.tumblr_1);
    Person s = new Person("Simen", R.drawable.tumblr_2);
    Person k = new Person("Karl", R.drawable.tumblr_3);
    Person[]  persons = { a, s, k};
    Button nextButton;
    boolean clicked = false;




    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_mode);
        nextButton = (Button) findViewById(R.id.buttonProgress2);
        nextButton.setText("Next level");

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(ImageModeActivity.this, "" + persons[position].toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image_mode, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
         //   return true;
       // }

        return super.onOptionsItemSelected(item);
    }


    public void onClick(View v) {

        if (!clicked) {
            if (v.getId() == R.id.buttonProgress2) {
                Intent intent = new Intent(this, GuessingActivity.class);
                startActivity(intent);
                finish();


            }


        }
    }

}
