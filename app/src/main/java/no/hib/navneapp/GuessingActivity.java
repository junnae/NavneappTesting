package no.hib.navneapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class GuessingActivity extends Activity {


    Person a = new Person("Aleksander", R.drawable.tumblr_1);
    Person s = new Person("Simen", R.drawable.tumblr_2);
    Person k = new Person("Karl", R.drawable.tumblr_3);
    Person[]  persons = { a, s, k};
    int randomInt = 0;
    Button first;
    Button second;
    Button third;
    boolean clicked = false;
    int imageId;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(3);
        ImageView img = (ImageView) findViewById(R.id.imageView);
        int sel = persons[randomInt].getPicture();
        img.setImageResource(sel);
        imageId = sel;
        nextButton = (Button) findViewById(R.id.buttonProgress3);
        nextButton.setText("Restart");


         first = (Button)findViewById(R.id.button);
         second = (Button)findViewById(R.id.button2);
         third = (Button)findViewById(R.id.button3);

        first.setText(persons[0].toString());
        second.setText(persons[1].toString());
        third.setText(persons[2].toString());

    }


    public int getImageId(){
        return imageId;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guessing, menu);
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
       //     return true;
     //   }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {


        if (!clicked) {


            switch (v.getId()) {
                case R.id.button:
                    first.setText("");
                    second.setText("");
                    third.setText("");
                    if (randomInt == 0) {
                        first.setText("Correct!");
                    } else {
                        first.setText("Wrong..");
                    }

                    break;
                case R.id.button2:
                    first.setText("");
                    second.setText("");
                    third.setText("");
                    if (randomInt == 1) {
                        second.setText("Correct!");
                    } else {
                        second.setText("Wrong..");
                    }

                    break;
                case R.id.button3:

                    first.setText("");
                    second.setText("");
                    third.setText("");
                    if (randomInt == 2) {
                        third.setText("Correct!");
                    } else {
                        third.setText("Wrong..");
                    }


                    break;
            }

            clicked = true;
        }

        else{
            finish();
            startActivity(getIntent());
        }

    }


    public void onClick2(View v) {

        if (!clicked) {
            if (v.getId() == R.id.buttonProgress3) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();

            }


        }
    }
}
