package com.view.graph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * author : zhoukai
 * time   : 2018/05/17
 * desc   :
 */
public class RoundView extends View {

    private Paint paint;
    private Bitmap bitmap;

    public RoundView(Context context) {
        super(context);
        init();
    }

    public RoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap != null) {
            paint.setShader(new BitmapShader(BitmapUtils.zoomImage(bitmap, getWidth(), getHeight()), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, paint);
        paint.reset();
    }

    public RoundView setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        postInvalidate();
        return this;
    }

}