package cs.easel; /**
 * Created by Devan on 3/5/2015.
 */

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.content.Context;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import com.larswerkman.holocolorpicker.ColorPicker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class DrawPanel extends View {
    ArrayList<Path> paths = new ArrayList<Path>();
    ArrayList<Integer> colors = new ArrayList<Integer>();
    ArrayList<Float> sizes = new ArrayList<Float>();
    public Path path = new Path();
    Paint paint = new Paint();
    public static float currentSize = 20f;
    public static int currentColor = Color.BLACK;
    static boolean erase = false;
    public static Canvas myCanvas;
    Bitmap scaled;
    public static boolean isPicker = false;


    //Helper function for creating appropriate path - cosine interpolation
    //of two adjacent points
    //TODO: Implement cosine interpolation into the paths below
    public double cosineInterpolation(double x1, double x2, double normal)
    {
        double ft = normal * 3.1415927;
        double f = (1 - Math.cos(ft)) * .5;
        return  x1 * (1 - f) + x2 * f;
    }

    public DrawPanel(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public DrawPanel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setWillNotDraw(false);
    }

    public DrawPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    public static void changeColor(int color) {
        currentSize = 20f;
        currentColor = color;
    }

    public static void changeEraser() {
        currentSize = 70f;
        currentColor = Color.WHITE;
    }




    //TODO: Find how to set the paint size and color at object initialization - this is wasting a lot of time changing color for no reason
    @Override
    public void onDraw(Canvas canvas) {
        if (!isPicker) {
            super.onDraw(canvas);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawColor(Color.WHITE);
            for(int i = 0; i < paths.size(); ++i) {
                paint.setColor(colors.get(i));
                paint.setStrokeWidth(sizes.get(i));
                canvas.drawPath(paths.get(i), paint);

            }
            paint.setColor(currentColor);
            paint.setStrokeWidth(currentSize);
            canvas.drawPath(path, paint);
        }



    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.reset();
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                paths.add(path);
                //Random rnd = new Random();
                //paint.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                colors.add(paint.getColor());
                sizes.add(paint.getStrokeWidth());
                path = new Path();
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
}