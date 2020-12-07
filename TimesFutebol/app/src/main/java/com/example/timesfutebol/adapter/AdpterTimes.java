package com.example.timesfutebol.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timesfutebol.R;
import com.example.timesfutebol.model.Times;

import java.util.List;

public class AdpterTimes extends RecyclerView.Adapter<AdpterTimes.MyViewHolder> {


    private List<Times> listTimes;

    public AdpterTimes(List<Times> list){
        this.listTimes = list;
    }

    //Innerclass que contém as informações das células da lista
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, owner;
        ImageView img;

        public MyViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.textViewName);
            owner = view.findViewById(R.id.textViewOwner);
            img = view.findViewById(R.id.imageViewTimes);

        }


}

    //Métodos que precisam ser implementados para este tipo de adapter
    @NonNull
    @Override
    // Cria a lista em tempo real, retornando célula a célula
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adpter_list_times, parent, false);

        return new MyViewHolder(listItem);
    }

    @Override
    //Mostra os componentes de uma célula
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


      Times obj = listTimes.get(position);
      holder.name.setText(obj.getName());
      holder.owner.setText(obj.getOwner());
      holder.img.setImageResource(obj.getImg());

    //    holder.name.setText("Athletico");
    //    holder.owner.setText("Curitiba - Parana");
    //    holder.img.setImageResource(R.drawable.athletico);

    }

    @Override
    //Informa o tamanho da lista
    public int getItemCount() {
       return listTimes.size();
    }
    //Fim dos métodos que precisam ser implementados




}