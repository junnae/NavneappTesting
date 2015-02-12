package no.hib.navneapp.tests;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.ImageView;

import no.hib.navneapp.GuessingActivity;
import no.hib.navneapp.R;

/**
 * Created by caese_000 on 11.02.2015.
 */
public class GuessingActivityTest extends ActivityUnitTestCase<GuessingActivity>{

    Intent mLaunchIntent;


    public GuessingActivityTest(){super(GuessingActivity.class);}


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mLaunchIntent = new Intent(getInstrumentation()
                .getTargetContext(), GuessingActivity.class);


    }


    public void testActivityLaunched(){
        startActivity(mLaunchIntent, null, null);
        assertEquals(getActivity().getClass().getSimpleName(), "GuessingActivity");

    }


    public void testDisplayImage(){
        startActivity(mLaunchIntent,null,null);
        ImageView imageview = (ImageView) getActivity().findViewById(R.id.imageView);
        Drawable pic = imageview.getDrawable();
        assertNotNull(pic);
    }


    public void testButtonstext(){
        startActivity(mLaunchIntent,null,null);
        Button firstbutton = (Button) getActivity().findViewById(R.id.button);
        Button secondbutton =(Button) getActivity().findViewById(R.id.button2);
        Button thirdbutton = (Button) getActivity().findViewById(R.id.button3);

        assertEquals( firstbutton.getText(), "Aleksander");
        assertEquals(secondbutton.getText(), "Simen");
        assertEquals(thirdbutton.getText(), "Karl");

    }


    public void testFunctionality() {
        startActivity(mLaunchIntent, null, null);
        ImageView imageview = (ImageView) getActivity().findViewById(R.id.imageView);
        int pic = getActivity().getImageId();
        boolean ok = false;
        boolean first = false;
        boolean second = false;
        boolean third = false;
    //tests if one of the pictures show up
        if (pic == R.drawable.tumblr_1) {
            ok = true;
            first = true;
        } else if (pic == R.drawable.tumblr_2) {
            ok = true;
            second = true;
        } else if (pic == R.drawable.tumblr_3){
            ok = true;
            third = true;
    }
        else{}

        assertTrue( ok);

        //now we test pressing the correct button
        //could be put in it's own method and use setup but I can't run startActivity in setup anyway!

        Button firstbutton = (Button) getActivity().findViewById(R.id.button);
        Button secondbutton =(Button) getActivity().findViewById(R.id.button2);
        Button thirdbutton = (Button) getActivity().findViewById(R.id.button3);

        if(first){
            firstbutton.performClick();
            assertEquals(firstbutton.getText().toString(), "Correct!");
        }

        else if(second)
        {

            secondbutton.performClick();
            assertEquals(secondbutton.getText().toString(), "Correct!");
        }
        else if(third){
            thirdbutton.performClick();
            assertEquals(thirdbutton.getText().toString(), "Correct!");
        }
        else{}




    }


    public void testWrongClicked(){

        startActivity(mLaunchIntent, null, null);
        ImageView imageview = (ImageView) getActivity().findViewById(R.id.imageView);
        int pic = getActivity().getImageId();


        //now we test pressing the wrong button
        //could be put in it's own method and use setup but I can't run startActivity in setup anyway!

        Button firstbutton = (Button) getActivity().findViewById(R.id.button);
        Button secondbutton =(Button) getActivity().findViewById(R.id.button2);
        Button thirdbutton = (Button) getActivity().findViewById(R.id.button3);

        if(pic == R.drawable.tumblr_2){
            firstbutton.performClick();
            assertEquals(firstbutton.getText().toString(), "Wrong..");
        }

        else
        {

            secondbutton.performClick();
            assertEquals(secondbutton.getText().toString(), "Wrong..");
        }




    }


    public void testNextActivityWasLaunchedWithIntent() {
        startActivity(mLaunchIntent, null, null);
        final Button launchNextButton =
                (Button) getActivity()
                        .findViewById(R.id.buttonProgress3);
        launchNextButton.performClick();
        getInstrumentation().waitForIdleSync();
        final Intent launchIntent = getStartedActivityIntent();
        assertNotNull("Intent was null", launchIntent);
        assertTrue(isFinishCalled());


    }


}
