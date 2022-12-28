package com.example.diganaopraseve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random numeroRandomico = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSim = findViewById(R.id.buttonSim);
        Button buttonNao = findViewById(R.id.buttonNao);
        ImageView imgBom = findViewById(R.id.imgBom);

        buttonSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSim.setVisibility(View.GONE);
                buttonNao.setVisibility(View.GONE);
                imgBom.setVisibility(View.VISIBLE);
            }
        });
        buttonNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = retornaRandomico(Resources.getSystem().getDisplayMetrics().widthPixels, 20);
                int y = retornaRandomico(Resources.getSystem().getDisplayMetrics().heightPixels, 40);
                buttonNao.setX(x);
                buttonNao.setY(y);
            }
        });
    }

    public int retornaRandomico(int range, int multiplo) {
        int numeroGerado = numeroRandomico.nextInt((convertePixel(range)) * multiplo);
        return numeroGerado;
    }

    public int convertePixel(int numero) {
        float dip = 14f;
        Resources r = getResources();
        numero = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dip,
                r.getDisplayMetrics()
        );
        return numero;
    }
}