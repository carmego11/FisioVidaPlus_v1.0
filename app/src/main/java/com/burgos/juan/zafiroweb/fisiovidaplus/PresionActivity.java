package com.burgos.juan.zafiroweb.fisiovidaplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PresionActivity extends AppCompatActivity {

    EditText txtSistolica;
    EditText txtDiastolica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presion);

        txtSistolica = (EditText) findViewById(R.id.txtSistolica);
        txtDiastolica = (EditText) findViewById(R.id.txtDiastolica);
    }

    public void onGuardarPresion(View view)
    {
        if(txtDiastolica.getText().toString().equals("") || txtSistolica.getText().toString().equals(""))
        {
            Toast.makeText(PresionActivity.this, R.string.MsgCamposCuenta, Toast.LENGTH_SHORT).show();
        }
        else if(Integer.parseInt(txtSistolica.getText().toString()) < 0 || Integer.parseInt(txtSistolica.getText().toString()) > 200)
        {
            Toast.makeText(PresionActivity.this, R.string.MsgValSistolica, Toast.LENGTH_SHORT).show();
        }
        else if(Integer.parseInt(txtDiastolica.getText().toString()) < 0 || Integer.parseInt(txtDiastolica.getText().toString()) > 150)
        {
            Toast.makeText(PresionActivity.this, R.string.MsgValDiastolica, Toast.LENGTH_SHORT).show();
        }
        else
        {
            final int sistolica = Integer.parseInt(txtSistolica.getText().toString());
            final int diastolica = Integer.parseInt(txtDiastolica.getText().toString());
            new Thread(new Runnable() {

                DBManager guardaPresion = new DBManager();

                @Override
                public void run() {
                    guardaPresion.guardarPresion(
                            1,
                            sistolica,
                            diastolica
                    );
                }
            }
            ).start();
            limpiaCampos();
            Toast.makeText(PresionActivity.this,R.string.MsgDatosGuardados, Toast.LENGTH_LONG).show();
        }

        //Toast.makeText(PresionActivity.this, "Valores de presion", Toast.LENGTH_SHORT).show();
    }

    private void limpiaCampos() {
        txtSistolica.setText("");
        txtDiastolica.setText("");
    }
}
