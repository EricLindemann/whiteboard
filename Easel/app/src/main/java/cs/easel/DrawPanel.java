package cs.easel; /**
 * Created by Devan on 3/5/2015.
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DrawPanel extends SurfaceView implements SurfaceHolder.Callback{
    public float xcoord, ycoord;

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

    @Override
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(xcoord,ycoord,20,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        xcoord = event.getX();
        ycoord = event.getY();
        invalidate();
        return true;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub

    }
}