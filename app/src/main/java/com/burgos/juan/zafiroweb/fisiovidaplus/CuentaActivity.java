package com.burgos.juan.zafiroweb.fisiovidaplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CuentaActivity extends AppCompatActivity {

    EditText txtCorreo;
    EditText txtPassword;
    EditText txtNombre;
    EditText txtEstatura;
    EditText txtFecNac;
    EditText txtPeso;
    RadioGroup rgpGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        //Asignacion de campos para validación.
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEstatura = (EditText) findViewById(R.id.txtEstatura);
        txtFecNac = (EditText) findViewById(R.id.txtFecNac);
        rgpGenero = (RadioGroup) findViewById(R.id.rbgGenero);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cuenta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        final String correo = txtCorreo.getText().toString();
        final String pass = txtPassword.getText().toString();
        final String nombre = txtNombre.getText().toString();
        final String fecNac = txtFecNac.getText().toString();
        final String peso = txtPeso.getText().toString();
        final String estatura = txtEstatura.getText().toString();
       //

        int id = item.getItemId();

        if (id == R.id.itmAddCuenta) {
            if (txtCorreo.getText().toString().equals("") ||
                    txtPassword.getText().toString().equals("") ||
                    txtNombre.getText().toString().equals("") ||
                    txtEstatura.getText().toString().equals("") ||
                    txtFecNac.getText().toString().equals("") ||
                    txtPeso.getText().toString().equals("") ||
                    rgpGenero.getCheckedRadioButtonId() == -1
                    ) {
                Toast.makeText(CuentaActivity.this, R.string.MsgCamposCuenta, Toast.LENGTH_LONG).show();
            }
            else
            {
                if (Double.parseDouble(txtEstatura.getText().toString()) >= 2.80 ||
                        Double.parseDouble(txtEstatura.getText().toString()) <= 0.450) {
                    Toast.makeText(CuentaActivity.this, R.string.MsgErrorEstatura, Toast.LENGTH_LONG).show();
                }
                else
                {
                        new Thread(new Runnable() {

                            DBManager creaCuenta = new DBManager();

                            @Override
                            public void run() {
                                creaCuenta.guardarCuenta(
                                        correo,
                                        pass,
                                        nombre,
                                        Double.parseDouble(estatura),
                                        fecNac,
                                        Double.parseDouble(peso),
                                        "" + rgpGenero.getCheckedRadioButtonId()
                                );
                            }
                        }
                        ).start();
                        limpiaCampos();
                        Toast.makeText(CuentaActivity.this,/*R.string.MsgDatosGuardados*/nombre, Toast.LENGTH_LONG).show();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void limpiaCampos()
    {
        txtCorreo.setText("");
        txtPassword.setText("");
        txtNombre.setText("");
        txtEstatura.setText("");
        txtFecNac.setText("");
        txtPeso.setText("");
        rgpGenero.clearCheck();
    }
}
