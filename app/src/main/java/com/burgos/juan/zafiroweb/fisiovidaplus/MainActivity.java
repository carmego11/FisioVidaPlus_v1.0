package com.burgos.juan.zafiroweb.fisiovidaplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuario;
    EditText pass;
    String user;
    String passw;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignamos los campos para poder manipularlos
        usuario = (EditText) findViewById(R.id.txtUsuario);
        pass = (EditText) findViewById(R.id.txtPass);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.itmInf)
        {
            Toast.makeText(MainActivity.this, "Fisio Vida Plus\nDesarrollado por:\n" +
                    "Juan Sebastián Burgos\n" +
                    "Carlos Medina\n\n" +
                    "Agradecimientos a:\n" +
                    "Adriana Mena Figueroa\n" +
                    "Fisioterapeuta Profesional", Toast.LENGTH_LONG).show();

        }
        if(id == R.id.exit)
        {
            System.exit(0);
        }

        if(id == R.id.reco)
        {
            Intent email= new Intent(Intent.ACTION_SEND);
            email.setType("text/plain");
            email.putExtra(Intent.EXTRA_SUBJECT, "PQR Fisio Vida");
            email.putExtra(Intent.EXTRA_TEXT, "Hola Carlos y Juan,");
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{"carmego11@hotmail.com"});
            startActivity(email);        }


        return super.onOptionsItemSelected(item);
    }



    public void onIniciar(View view)
    {
        if (usuario.getText().toString().equals("") || pass.getText().toString().equals(""))
        {
            Toast.makeText(MainActivity.this, R.string.MsgUsuPassErrados, Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Iniciar Sesion", Toast.LENGTH_LONG).show();
            Intent intento = new Intent(this, MainMenuActivity.class);
            startActivity(intento);
        }
    }

    public void onCrearCuenta(View view)
    {
        Intent intento = new Intent(this, CuentaActivity.class);
        startActivity(intento);
    }

    public void sesion()
    {
        new Thread(new Runnable() {
            DBManager cargaDatos = new DBManager();

            @Override
            public void run() {
                setUser(cargaDatos.consultaPeso(1));
                setPassw(cargaDatos.consultaEstatura(1));
            }
        }).start();
    }

    public void id()
    {
        new Thread(new Runnable() {
            DBManager cargaDatos = new DBManager();

            @Override
            public void run() {
                setUser(cargaDatos.consultaPeso(1));
                setPassw(cargaDatos.consultaEstatura(1));
            }
        }).start();
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

}
