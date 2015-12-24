package cs.easel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class DrawTest extends Activity {


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
        Intent intent = new Intent(this, DrawTest.class);
        startActivity(intent);
        finish();
    }

    public void saveButtonOnClick (View view) {
        DrawPanel newPanel = new DrawPanel(this);
        newPanel.screenGrab();

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    Intent intent = new Intent(this, Launcher.class);
                    finish();
                    startActivity(intent);
            }

        }
        return true;
    }
}
