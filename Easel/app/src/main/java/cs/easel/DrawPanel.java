package cs.easel; /**
 * Created by Devan on 3/5/2015.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DrawPanel extends SurfaceView {
    public Path path = new Path();
    Paint paint = new Paint();
    SurfaceHolder holder;


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
        holder = getHolder();
        setWillNotDraw(false);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(5f);
    }

    public DrawPanel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setWillNotDraw(false);
    }

    public DrawPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20f);
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
}