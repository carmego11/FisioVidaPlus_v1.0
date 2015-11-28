package com.burgos.juan.zafiroweb.fisiovidaplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    boolean spActive,spPaused;
    long spTime = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        spPaused = false;
        spActive = true;

        Thread splashTimer = new Thread() {
            public void run() {
                try {
                    long ms = 0;
                    while (spActive && ms < spTime) {
                        sleep(100);
                        if (!spPaused) {
                            ms += 100;
                        }

                    }

                    startActivity(new Intent("com.google.app.fisio_vida.CLEARSPLASH"));
                    finish();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        };
        splashTimer.start();
        setContentView(R.layout.activity_splash);
        return;
    }
    protected void onStop() {
        super.onStop();
    }
    protected void onPause() {
        super.onPause();
        spPaused = true;
    }
    protected void onResume() {
        super.onResume();
        spPaused = false;
    }
    protected void onDestroy() {
        super.onDestroy();
    }
}
