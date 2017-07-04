package com.u2androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.u2androidproject.widget.DragImageView;

public class DragImgActivity extends AppCompatActivity {

    private DragImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_drag_img);

        imageview = (DragImageView) findViewById(R.id.imageview);


        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        Glide.with(this).load(image).into(imageview);

        /*DragImageView dragImageView = new DragImageView(this);
        dragImageView.setmActivity(this);*/

        //屏幕的宽度
//        dragImageView.setScreen_H();
//        dragImageView.setScreen_W();


    }
}
