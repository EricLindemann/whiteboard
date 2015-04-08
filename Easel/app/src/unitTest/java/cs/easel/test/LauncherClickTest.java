package cs.easel.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;


import cs.easel.Launcher;
import cs.easel.R;

/**
 * Created by eric on 4/2/15.
 */
public class LauncherClickTest extends ActivityUnitTestCase<Launcher> {


    public LauncherClickTest() {
        super(Launcher.class);
    }


    public void testDrawTestWasLaunchedOnClick(){
        final Intent mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), Launcher.class);
        startActivity(mLaunchIntent,null,null);
        final Button launchNextButton = (Button)getActivity().findViewById(R.id.button);
        launchNextButton.performClick();
        final Intent launchIntent = getStartedActivityIntent();
        assertNotNull(launchIntent);


    }

    public void testExit(){
        final Intent mLaunchIntent = new Intent(getInstrumentation().getTargetContext(),Launcher.class);
        startActivity(mLaunchIntent,null,null);
        final Button exitButton = (Button)getActivity().findViewById(R.id.button2);
        exitButton.performClick();
        assertTrue(isFinishCalled());
    }

}
