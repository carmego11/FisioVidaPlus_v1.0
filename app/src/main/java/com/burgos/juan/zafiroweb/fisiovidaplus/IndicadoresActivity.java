package com.burgos.juan.zafiroweb.fisiovidaplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IndicadoresActivity extends AppCompatActivity {

    EditText txtViceral;
    EditText txtCorporal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicadores);

        txtViceral = (EditText) findViewById(R.id.txtGrasaViceral);
        txtCorporal = (EditText) findViewById(R.id.txtMuscuCorporal);
    }

    public void onGuardarMusculaturaCorporal(View view)
    {
        if(txtCorporal.getText().toString().equals(""))
        {
            Toast.makeText(IndicadoresActivity.this, R.string.MsgCamposCuenta, Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(Integer.parseInt(txtCorporal.getText().toString()) < 0 ||
                    Integer.parseInt(txtCorporal.getText().toString()) > 100
                    )
            {
                Toast.makeText(IndicadoresActivity.this, R.string.MsgValPorcMusc, Toast.LENGTH_SHORT).show();
            }
            else
            {
                final int corporal = Integer.parseInt(txtCorporal.getText().toString());

                new Thread(new Runnable() {

                    DBManager guardaPresion = new DBManager();

                    @Override
                    public void run() {
                        guardaPresion.guardarIndicadoresCorporal(
                                1,
                                corporal
                        );
                    }
                }
                ).start();
                limpiaCampos();
                //Guardar en base de datos
            }
        }
    }

    public void onGuardarViceral(View view)
    {
        if(txtViceral.getText().toString().equals(""))
        {
            Toast.makeText(IndicadoresActivity.this, R.string.MsgCamposCuenta, Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(Integer.parseInt(txtViceral.getText().toString()) < 0 ||
                    Integer.parseInt(txtViceral.getText().toString()) > 100
                    )
            {
                Toast.makeText(IndicadoresActivity.this, R.string.MsgValViceral, Toast.LENGTH_SHORT).show();
            }
            else
            {
                final int viceral = Integer.parseInt(txtViceral.getText().toString());

                new Thread(new Runnable() {

                    DBManager guardaPresion = new DBManager();

                    @Override
                    public void run() {
                        guardaPresion.guardarIndicadoresViceral(
                                1,
                                viceral
                        );
                    }
                }
                ).start();
                limpiaCampos();
                //Guardar en base de datos
            }
        }
    }

    private void limpiaCampos()
    {
        txtViceral.setText("");
        txtCorporal.setText("");
    }
}
