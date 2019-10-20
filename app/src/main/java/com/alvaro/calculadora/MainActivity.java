package com.alvaro.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, suma, resta,
            multiplicacion, division, resultado, borrar, sin, cos, tan, ln, pi;

    private final char sumar = '+';
    private final char restar = '-';
    private final char multiplicar = '*';
    private final char dividir = '/';
    private final char igual = 0;
    private double num1 = Double.NaN;
    private double num2;
    private char operacion;
    private TextView campo1;
    private EditText campo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
        if (getApplication().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            accionesLand();
        }
    }

    private void acciones() {
        cero.setOnClickListener(this);
        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);
        suma.setOnClickListener(this);
        resta.setOnClickListener(this);
        multiplicacion.setOnClickListener(this);
        division.setOnClickListener(this);
        resultado.setOnClickListener(this);
        borrar.setOnClickListener(this);
    }

    private void accionesLand() {
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        ln.setOnClickListener(this);
        pi.setOnClickListener(this);
    }

    private void instancias() {
        cero = this.findViewById(R.id.btncero);
        uno = this.findViewById(R.id.btnuno);
        dos = this.findViewById(R.id.btndos);
        tres = this.findViewById(R.id.btntres);
        cuatro = this.findViewById(R.id.btncuatro);
        cinco = this.findViewById(R.id.btncinco);
        seis = this.findViewById(R.id.btnseis);
        siete = this.findViewById(R.id.btnsiete);
        ocho = this.findViewById(R.id.btnocho);
        nueve = this.findViewById(R.id.btnnueve);
        suma = this.findViewById(R.id.btnsumar);
        resta = this.findViewById(R.id.btnrestar);
        multiplicacion = this.findViewById(R.id.btnmultiplicar);
        division = this.findViewById(R.id.btndividir);
        borrar = this.findViewById(R.id.btnborrar);
        resultado = this.findViewById(R.id.btnresultado);
        campo1 = findViewById(R.id.testview);
        campo2 = findViewById(R.id.edittext);
        sin = this.findViewById(R.id.btnsin);
        cos = this.findViewById(R.id.btncos);
        tan = this.findViewById(R.id.btntan);
        ln = this.findViewById(R.id.btnln);
        pi = this.findViewById(R.id.btnpi);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btncero:
                campo2.setText(campo2.getText().toString() + "0");
                break;
            case R.id.btnuno:
                campo2.setText(campo2.getText().toString() + "1");
                break;
            case R.id.btndos:
                campo2.setText(campo2.getText().toString() + "2");
                break;
            case R.id.btntres:
                campo2.setText(campo2.getText().toString() + "3");
                break;
            case R.id.btncuatro:
                campo2.setText(campo2.getText().toString() + "4");
                break;
            case R.id.btncinco:
                campo2.setText(campo2.getText().toString() + "5");
                break;
            case R.id.btnseis:
                campo2.setText(campo2.getText().toString() + "6");
                break;
            case R.id.btnsiete:
                campo2.setText(campo2.getText().toString() + "7");
                break;
            case R.id.btnocho:
                campo2.setText(campo2.getText().toString() + "8");
                break;
            case R.id.btnnueve:
                campo2.setText(campo2.getText().toString() + "9");
                break;
            case R.id.btnsumar:
                operar();
                operacion = sumar;
                campo2.setText(campo2.getText().toString() + "+");
                campo2.setText(null);
                break;
            case R.id.btnrestar:
                operar();
                operacion = restar;
                campo2.setText(campo2.getText().toString() + "-");
                campo2.setText(null);
                break;
            case R.id.btndividir:
                operar();
                operacion = dividir;
                campo2.setText(campo2.getText().toString() + "/");
                campo2.setText(null);
                break;
            case R.id.btnmultiplicar:
                operar();
                operacion = multiplicar;
                campo2.setText(campo2.getText().toString() + "*");
                campo2.setText(null);
                break;
            case R.id.btnresultado:
                operar();
                operacion = igual;
                campo1.setText(campo1.getText().toString() + String.valueOf(num2) + "=" + String.valueOf(num1));
                campo2.setText(null);
            case R.id.btnborrar:
                if(campo2.getText().length() > 0){
                    CharSequence name = campo2.getText().toString();
                    campo2.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    num1 = Double.NaN;
                    num2 = Double.NaN;
                    campo2.setText(null);
                    resultado.setText(null);
                }
        }

    }

    private void operar() {
        if (!Double.isNaN(num1)) {
            num2 = Double.parseDouble(campo2.getText().toString());

            switch (operacion) {
                case sumar:
                    num1 = num1 + num2;
                    break;
                case restar:
                    num1 = num1 - num2;
                    break;
                case multiplicar:
                    num1 = num1 * num2;
                    break;
                case dividir:
                    num1 = num1 / num2;
                    break;
                case igual:
                    break;
            }
        }
        else{
            num1 = Double.parseDouble(campo2.getText().toString());
        }
    }
}
