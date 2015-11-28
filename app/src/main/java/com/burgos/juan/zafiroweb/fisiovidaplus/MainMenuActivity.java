package com.burgos.juan.zafiroweb.fisiovidaplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void onAyudaPresion(View view) {
        Toast.makeText(MainMenuActivity.this, R.string.txtAyudaPresion, Toast.LENGTH_LONG).show();
    }

    public void onAyudaGlucometria(View view) {
        Toast.makeText(MainMenuActivity.this, R.string.txtAyudaGlucometria, Toast.LENGTH_LONG).show();
    }

    public void onAyudaIMC(View view) {
        Toast.makeText(MainMenuActivity.this, R.string.txtAyudaIMC, Toast.LENGTH_LONG).show();
    }

    public void onAyudaIndicadores(View view) {
        Toast.makeText(MainMenuActivity.this, R.string.txtAyudaIndicadores, Toast.LENGTH_LONG).show();
    }

    public void onPresion(View view) {
        Intent intento = new Intent(this, PresionActivity.class);
        startActivity(intento);
    }

    public void onGlucometria(View view)
    {
        Intent intento = new Intent(this, GlucometriaActivity.class);
        startActivity(intento);
    }

    public void onIMC(View view)
    {
        Intent intento = new Intent(this, ImcActivity.class);
        startActivity(intento);
    }

    public void onIndicadores(View view)
    {
        Intent intento = new Intent(this, IndicadoresActivity.class);
        startActivity(intento);
    }
}
