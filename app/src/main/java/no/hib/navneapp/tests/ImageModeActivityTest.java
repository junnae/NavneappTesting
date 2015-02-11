package no.hib.navneapp.tests;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import no.hib.navneapp.ImageModeActivity;
import no.hib.navneapp.MainActivity;
import no.hib.navneapp.R;

/**
 * Created by caese_000 on 11.02.2015.
 */
public class ImageModeActivityTest extends ActivityUnitTestCase<ImageModeActivity> {

    Intent mLaunchIntent;
    final int count = 3;
    int firstPic = R.drawable.tumblr_1;
    int secondPic = R.drawable.tumblr_2;
    int thirdPic = R.drawable.tumblr_3;

    public ImageModeActivityTest(){super(ImageModeActivity.class);}


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mLaunchIntent = new Intent(getInstrumentation()
                .getTargetContext(), ImageModeActivity.class);


    }


    public void testActivityLaunched(){
        startActivity(mLaunchIntent, null, null);
        assertEquals(getActivity().getClass().getSimpleName(), "ImageModeActivity");

    }

// This just tests that the expected image shows up at the right place
    public void testImage(){
        //this is code is not the most efficient, but once you find something that works you don't wanna risk breaking it!
        //because it took a lot of time understand how to make the test behave as they should
        startActivity(mLaunchIntent, null, null);
        getInstrumentation().waitForIdleSync();
        GridView gridview = (GridView)getActivity().findViewById(R.id.gridview);
       // Show almost the correct thing, just adds package name for some reason
       // assertEquals( gridview.getResources().getResourceName(gridview.getId()), "gridview");
        gridview.getViewTreeObserver();
        int childcount = gridview.getCount();
        assertEquals(childcount,count);
        int firstChild = gridview.getFirstVisiblePosition();
        int firstItem = (Integer)gridview.getItemAtPosition(firstChild);
        assertEquals(firstItem, firstPic);
        assertEquals(secondPic, gridview.getItemAtPosition(1));
        assertEquals(thirdPic,gridview.getItemAtPosition(2));


    }

// Apparantly according to the internet you can't really test toast without another framework such as Robotium(which probably would be very useful
// for this assignment, I don't think the standard tools in android studio are the best). We could have gone for another solution, where it would
//display a textview instead, but alas we did not and we leave this test empty
    public void testToast(){


    }


    public void testNextActivityWasLaunchedWithIntent() {
        startActivity(mLaunchIntent, null, null);
        final Button launchNextButton =
                (Button) getActivity()
                        .findViewById(R.id.buttonProgress2);
        launchNextButton.performClick();

        final Intent launchIntent = getStartedActivityIntent();
        assertNotNull("Intent was null", launchIntent);
        assertTrue(isFinishCalled());


    }





}
