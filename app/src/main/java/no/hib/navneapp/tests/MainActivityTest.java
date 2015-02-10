package no.hib.navneapp.tests;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.test.ActivityUnitTestCase;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import no.hib.navneapp.ImageModeActivity;
import no.hib.navneapp.MainActivity;
import no.hib.navneapp.Person;
import no.hib.navneapp.R;

/**
 * Created by caese_000 on 10.02.2015.
 */
public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {

    Intent mLaunchIntent;
    //private MainActivity mAc;
    //Sadly the persona are just hard coded as of now
    Person a = new Person("Aleksander", R.drawable.tumblr_1);
    Person s = new Person("Simen", R.drawable.tumblr_2);
    Person k = new Person("Karl", R.drawable.tumblr_3);
    ListView listView;
    TextView child0;
    TextView child1;
    TextView child2;





    public MainActivityTest () {
        super(MainActivity.class );
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mLaunchIntent = new Intent(getInstrumentation()
                .getTargetContext(), MainActivity.class);

    }

    public void testNames () throws InterruptedException {
        startActivity(mLaunchIntent, null, null);
        getInstrumentation().waitForIdleSync();
        listView = (ListView) getActivity().findViewById(R.id.listview);
        child0 =(TextView) listView.getAdapter().getView(0, null, null);
        child1 =(TextView) listView.getAdapter().getView(1, null, null);
        child2 =(TextView) listView.getAdapter().getView(2, null, null);
        String firstText = child0.getText().toString();
        String secondText = child1.getText().toString();
        String thirdText = child2.getText().toString();
        assertEquals("Aleksander", firstText);
        assertEquals("Simen", secondText);
        assertEquals("Karl", thirdText);



    }


    public void testMatch() throws InterruptedException {
        startActivity(mLaunchIntent, null, null);
        //final Button launchNextButton =
          //      (Button) getActivity()
            //            .findViewById(R.id.imagemode);
        getInstrumentation().waitForIdleSync();

        listView = (ListView) getActivity().findViewById(R.id.listview);

       // assertTrue(listView.getAdapter().getView(0, null, null).performClick());

               assertTrue(listView.performItemClick(
                listView.getAdapter().getView(0, null, null),
                0,
                listView.getAdapter().getItemId(0)
        ) );

        getInstrumentation().waitForIdleSync();

        ImageView imgView = (ImageView) getActivity().findViewById(android.R.id.custom);
        //Drawable draw = imgView.getDrawable();

        assertNotNull(imgView);

       // int picture = R.drawable.tumblr_1;
        //assertEquals (" "  +picture + " " + compare, compare, picture);


    }

/*
    public void testNextActivityWasLaunchedWithIntent() {
        startActivity(mLaunchIntent, null, null);
        final Button launchNextButton =
                (Button) getActivity()
                        .findViewById(R.id.imagemode);
        launchNextButton.performClick();

        final Intent launchIntent = getStartedActivityIntent();
        assertNotNull("Intent was null", launchIntent);
        assertTrue(isFinishCalled());


    }
    */





}