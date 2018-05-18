package com.view.graph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * author : zhoukai
 * time   : 2018/05/18
 * desc   :
 */
public class TriangleView extends View {

    private Paint paint;
    private Bitmap bitmap;

    public TriangleView(Context context) {
        super(context);
        init();
    }

    public TriangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TriangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        path.moveTo(getWidth() / 2,0);
        path.lineTo(0,getHeight());
        path.lineTo(getWidth(),getHeight());
        path.close();
        if(bitmap != null){
            paint.setShader(new BitmapShader(BitmapUtils.zoomImage(bitmap,getWidth(),getHeight()), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        }
        canvas.drawPath(path,paint);
        paint.reset();
    }

    public TriangleView setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        postInvalidate();
        return this;
    }

}