package com.example.myapplication;
import android.content.Intent;
import android.os.Handler;
import android.widget.TextView;

import android.os.Bundle;
import android.view.WindowManager;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, slogan;

    private static int SPLASH_SCREEN = 5000;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        topAnim = AnimationUtils.loadAnimation(this,R.anim.anim_main_home_page);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        image = findViewById(R.id.imageView);
        logo = findViewById(R.id.textView);
        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan = findViewById(R.id.textView2);
        slogan.setAnimation(bottomAnim);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_SCREEN);


    }

}