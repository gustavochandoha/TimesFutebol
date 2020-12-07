package com.example.timesfutebol.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timesfutebol.R;
import com.example.timesfutebol.RecyclerItemClickListener;
import com.example.timesfutebol.adapter.AdpterTimes;
import com.example.timesfutebol.model.Times;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Desenvolvido por Gustavo Kepka Chandoha
    //GRR20176925


    private RecyclerView recyclerViewTimes;
    private List<Times> timesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewTimes = findViewById(R.id.recyclerViewTimes);

        this.createTimes();
       AdpterTimes adapter = new AdpterTimes(timesList);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerViewTimes.setLayoutManager(layoutManager);

        recyclerViewTimes.setHasFixedSize(true);

        recyclerViewTimes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));


        recyclerViewTimes.setAdapter(adapter);

        recyclerViewTimes.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerViewTimes,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Times obj = timesList.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Selecionado " + obj.getName(),
                                        Toast.LENGTH_SHORT
                                ).show();

                             Bundle args = new Bundle();
                             args.putSerializable("Time",obj);

                             Intent it = new Intent(getApplicationContext(), detalhes.class);
                             it.putExtra("args tela1",args);
                             startActivity(it);



                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Clique longo",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );





    }

    public void createTimes(){

        Times obj = new Times(R.drawable.athletico,"Atlhetico","Curitiba - Paraná","- Campeão Copa do Brasil 1999 \n- Campeao da Liga 2002 \n- Campeao dos Campeos 2008");
        timesList.add(obj);
        obj = new Times(R.drawable.coritiba,"Coritiba FC","Curitiba - Paraná","- Campeao das Americas \n- Campeao dos Campeos 2002 \n- Campeao da esquina");
        timesList.add(obj);
        obj = new Times(R.drawable.parana,"Paraná","Curitiba - Paraná","- Campeao da Lagoa \n- Campeao dos Campeos 2007 \n- Campeao do Campeonato");
        timesList.add(obj);
        obj = new Times(R.drawable.trieste,"Trieste FC","Curitiba - Paraná","- Campeao Suburbana 2017\n- Campeao Suburbana 2018 \n- Campeao da pequena Liga");
        timesList.add(obj);


    }



}