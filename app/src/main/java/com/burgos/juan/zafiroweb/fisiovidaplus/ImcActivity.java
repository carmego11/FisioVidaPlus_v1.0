package com.burgos.juan.zafiroweb.fisiovidaplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ImcActivity extends AppCompatActivity {

    String peso;
    String estatura;
    Double IMC;
    TextView lblIMC;
    TextView lblresIMC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        calculoIMC();
    }

    public void calculoIMC()
    {
        new Thread(new Runnable() {
            DBManager cargaDatos = new DBManager();

            @Override
            public void run() {
                setPeso(cargaDatos.consultaPeso(1));
                setEstatura(cargaDatos.consultaEstatura(1));
            }
        }).start();
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public void setIMC(Double IMC) {
        this.IMC = IMC;
    }

    public String getPeso() {
        return peso;
    }

    public String getEstatura() {
        return estatura;
    }

    public Double getIMC() {
        return IMC;
    }

    public void onCalcular(View view)
    {
        if(this.peso == null || this.estatura == null) {

        }else
        {
            Double IMC = Double.parseDouble(this.peso) / Math.pow(Double.parseDouble(this.estatura),2);
            lblIMC = (TextView) findViewById(R.id.lblIMC);
            lblresIMC=(TextView) findViewById(R.id.lblresIMC);

            if(IMC<=18.5){
                lblIMC.setText(IMC.toString());
                lblresIMC.setText("Usted tiene Peso Bajo\n Visite su nutriocionista");
            }
            else if(IMC>18.5 && IMC<=24.9){
                lblIMC.setText(IMC.toString());
                lblresIMC.setText("Peso Normal\n Excelente!!!, siga conservando sus buenos habitos");
            }else if(IMC>25 && IMC<=29.9){
                lblIMC.setText(IMC.toString());
                lblresIMC.setText("Usted posee Sobrepeso\n Visite su nutriocionista\nEvite aumentar de peso");
            }else if(IMC>30 && IMC<=34.5){
                lblIMC.setText(IMC.toString());
                lblresIMC.setText("Alerta!! Usted posee Obesidad Grado 1(Leve)\n Visite su nutriocionista\nEvite aumentar de peso");
            }else if(IMC>35 && IMC<=39.9){
                lblIMC.setText(IMC.toString());
                lblresIMC.setText("Obesidad Grado 2(Media)\n Visite su nutriocionista\nPuede poseer un descontrol Tiroideo");
            }else if(IMC>=40){
                lblIMC.setText(IMC.toString());
                lblresIMC.setText("Obesidad Grado 3(Mórbida)\n Visite su nutriocionista\nDe manera urgente necesita un control\nEstablezca una rutina de ejercicios SUPERVISADA");
            }

        }

    }
}
