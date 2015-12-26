package cs.easel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DrawTest extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_test);
        View myPanel = findViewById(R.id.view);
        myPanel.setDrawingCacheEnabled(true);
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

    public void eraserButtonOnClick(View view) { DrawPanel.changeEraser(); }

    public void eraseButtonOnClick(View view) {
        Intent intent = new Intent(this, DrawTest.class);
        startActivity(intent);
        finish();
    }

    public void saveButtonOnClick (View view) throws IOException {
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "Easel");

        View myPanel = findViewById(R.id.view);
        Bitmap nBitmap = myPanel.getDrawingCache();
        Canvas canvas = new Canvas(nBitmap);
        myPanel.draw(canvas);
        System.out.println(canvas);

        try {
            if (!mediaStorageDir.exists()) {
                mediaStorageDir.mkdirs();
            }
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());
            File mediaFile = new File(mediaStorageDir.getPath()
                    + File.separator + "drawing" + timeStamp + ".png");
            FileOutputStream out = new FileOutputStream(mediaFile);

            nBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();


            // Update gallery
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri contentUri = Uri.fromFile(mediaFile);
            mediaScanIntent.setData(contentUri);
            getApplicationContext().sendBroadcast(mediaScanIntent);

            Toast.makeText(this, "Drawing saved to: /Pictures/Easel/drawing" + timeStamp + ".png",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Not saved",
                    Toast.LENGTH_SHORT).show();
        }

    }




}

