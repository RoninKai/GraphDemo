package com.view.graph;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RoundView rvPic;
    private TriangleView tvPic;
    private PolygonView pvPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPic = (RoundView) findViewById(R.id.rv_pic);
        tvPic = (TriangleView) findViewById(R.id.tv_pic);
        pvPic = (PolygonView) findViewById(R.id.pv_pic);
    }

    public void allSetPic(View view){
        //// TODO: 2018/5/18 频繁点击会闪退 （libc错误）
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.goddess);
        rvPic.setBitmap(bitmap);
        tvPic.setBitmap(bitmap);
        pvPic.setBitmap(bitmap);
    }
}
