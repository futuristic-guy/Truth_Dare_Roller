package com.example.truthdareroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private Random randomNumberGenerator = new Random();
    private int lastPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newPosition = randomNumberGenerator.nextInt(3600)+360;
                int piviotX = imageView.getWidth()/2;
                int piviotY = imageView.getHeight()/2;
                Animation rotate = new RotateAnimation(lastPosition,newPosition,piviotX,piviotY);
                rotate.setDuration(2000);
                rotate.setFillAfter(true);
                rotate.setAnimationListener(
                        new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                button.setEnabled(false);
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                  button.setEnabled(true);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        }
                );

                imageView.startAnimation(rotate);

            }
        });


    } //onCreate ends




}