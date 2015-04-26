package cs.easel.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.ImageView;

import cs.easel.Launcher;
import cs.easel.R;

/**
 * Created by eric on 4/2/15.
 */
public class LauncherTest extends ActivityInstrumentationTestCase2<Launcher> {

    Launcher activity;

    public LauncherTest(){
        super(Launcher.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }
    /* Commented this portion out because I deleted the "Draw" button.
       Think it's better UI design to just click easeL logo to go to
       the draw screen - Raymond

    public void testButtonNotNull(){
        Button button = (Button) activity.findViewById(R.id.button);
        assertNotNull(button);
    }

    public void testButton2NotNull(){
        Button button2 = (Button) activity.findViewById(R.id.button);
        assertNotNull(button2);
    } */

    public void testImageViewNotNull(){
        ImageView imageView = (ImageView) activity.findViewById(R.id.imageView);
        assertNotNull(imageView);
    }

}
