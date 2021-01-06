package com.medanis.bnbrvr.MyFragments;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.medanis.bnbrvr.models.StoreW;

import java.util.List;




public class AdapterFragmentA extends RecyclerView.Adapter<AdapterFragmentA.MovieViewHolder> {

    private List<StoreW> STOREW;
    private int rowLayout;
    private Context context;
    public TextView confirmer;


    public  class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout Le_layout;
        TextView Logo;
        TextView ID;
        TextView INFO;
        TextView QNT;
        TextView PRIX;


        public MovieViewHolder(View v) {
            super(v);
            Le_layout= (LinearLayout) v.findViewById(R.id.principal);
            Logo= (TextView) v.findViewById(R.id.logo);
            ID= (TextView) v.findViewById(R.id.nom);
            INFO= (TextView) v.findViewById(R.id.information);
            QNT= (TextView) v.findViewById(R.id.qnt);
            PRIX= (TextView) v.findViewById(R.id.prix);

        }
    }





    public AdapterFragmentA(List<LISTE_RAMASSAGE> lramassage, int rowLayout, Context context) {
        this.ramassages= lramassage;
        this.rowLayout = rowLayout;
        this.context = context;

    }

    @Override
    public CRamassageAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        String dtj= Tool.GetOnlyDate();

        holder.ID.setText(ramassages.get(position).getId()+"");
        holder.INFO.setText(ramassages.get(position).getLabel());
        holder.PRIX.setText(Constantes.Dformat.format(ramassages.get(position).getPrix())+" Da");
        holder.QNT.setText("x"+ramassages.get(position).getQnt()+"");

        holder.Le_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                int etat = ramassages.get(position).getDone();

                if(etat==0) {
                    ramassages.get(position).setDone(1);
                }else{
                    ramassages.get(position).setDone(0);
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    CalculateSum(2);
                }
                notifyDataSetChanged();// does not work
            }
        });


        if(ramassages.get(position).getDone()==0){
            holder.Logo.setBackgroundResource(R.drawable.ic_circle_vide);
        }else{
            holder.Logo.setBackgroundResource(R.drawable.ic_36px_circle_checked);
        }

    }

    @Override
    public int getItemCount() {
        return ramassages.size();
    }
}

