package cs.easel.test;

import android.content.Intent;
import android.graphics.Color;
import android.test.ActivityUnitTestCase;
import android.widget.Button;


import cs.easel.DrawPanel;
import cs.easel.DrawTest;
import cs.easel.R;
/**
 * Created by eric on 4/8/15.
 */
public class DrawTestClickTest extends ActivityUnitTestCase<DrawTest> {

    public DrawTestClickTest() {super (DrawTest.class);}


/*
    public void testBlackButtonChangeOnClick() {
        final Intent mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), DrawTest.class);
        startActivity(mLaunchIntent,null,null);
        final Button launchNextButton = (Button)getActivity().findViewById(R.id.colorButton);
        launchNextButton.performClick();
        assertEquals(Color.BLACK, DrawPanel.currentColor);
    }*/


}
