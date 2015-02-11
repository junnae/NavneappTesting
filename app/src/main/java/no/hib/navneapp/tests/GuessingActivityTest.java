package no.hib.navneapp.tests;

import android.content.Intent;
import android.test.ActivityUnitTestCase;

import no.hib.navneapp.GuessingActivity;
import no.hib.navneapp.ImageModeActivity;

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



}
