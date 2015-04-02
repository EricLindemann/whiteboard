package cs.easel;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import cs.easel.test;


public class DrawTest extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_draw_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void redButtonOnClick(View view) {
        DrawPanel.changeRed();
    }

    public void greenButtonOnClick(View view) {
        DrawPanel.changeGreen();
    }

    public void blueButtonOnClick(View view) {
        DrawPanel.changeBlue();
    }

    public void blackButtonOnClick(View view) {
        DrawPanel.changeBlack();
    }

    public void eraseButtonOnClick(View view) {
        DrawPanel.erase();
    }
}
