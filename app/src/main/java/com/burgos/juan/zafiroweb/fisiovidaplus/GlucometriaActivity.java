package com.burgos.juan.zafiroweb.fisiovidaplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GlucometriaActivity extends AppCompatActivity {

    EditText txtGlucometria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glucometria);

        txtGlucometria = (EditText) findViewById(R.id.txtGlucometria);
    }

    public void onGuardarGlucometria(View view)
    {
        if (txtGlucometria.getText().toString().equals(""))
        {
            Toast.makeText(GlucometriaActivity.this, R.string.MsgCamposGluco, Toast.LENGTH_SHORT).show();

        } else if(Integer.parseInt(txtGlucometria.getText().toString()) < 55 ||
                Integer.parseInt(txtGlucometria.getText().toString()) > 200)
        {
            Toast.makeText(GlucometriaActivity.this, R.string.MsgValGluco, Toast.LENGTH_SHORT).show();
        }
        else
        {
            final int glucometria = Integer.parseInt(txtGlucometria.getText().toString());

            new Thread(new Runnable() {

                DBManager guardaPresion = new DBManager();

                @Override
                public void run() {
                    guardaPresion.guardarGlucometria(
                            1,
                            glucometria
                    );
                }
            }
            ).start();
            limpiaCampos();
            //Guardar en la base de datos
        }
    }

    private void limpiaCampos()
    {
        txtGlucometria.setText("");
    }
}
