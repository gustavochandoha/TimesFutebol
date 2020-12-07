package com.example.timesfutebol.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.timesfutebol.R;
import com.example.timesfutebol.model.Times;

public class detalhes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);


        TextView txtTime = findViewById(R.id.textViewTime);
        TextView txtEstado = findViewById(R.id.textViewLocal);
        ImageView escudo = findViewById(R.id.imageViewTime);
        TextView titulos = findViewById(R.id.textViewTitulos);

        Bundle args = getIntent().getBundleExtra("args tela1");
        if(args!= null){

            Times times = (Times) args.getSerializable("Time");

            String time = String.valueOf(times.getName());
            String cidade =String.valueOf(times.getOwner());
            String titulosconquistados = String.valueOf(times.getTitulo());
            int img = times.getImg();

            titulos.setText(titulosconquistados);
            escudo.setImageResource(img);
            txtEstado.setText(cidade);
            txtTime.setText(time);



        }





    }


    public void voltar(View view){

        Intent i=new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();


    }

}