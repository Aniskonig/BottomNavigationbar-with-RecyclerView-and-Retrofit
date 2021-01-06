package com.medanis.bnbrvr.MyFragments;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.medanis.bnbrvr.R;
import com.medanis.bnbrvr.models.StoreW;

import java.util.List;




public class AdapterFragmentA extends RecyclerView.Adapter<AdapterFragmentA.MovieViewHolder> {

    private List<StoreW> STOREW;
    private int rowLayout;
    private Context context;
    public TextView confirmer;


    public  class MovieViewHolder extends RecyclerView.ViewHolder {
        //LinearLayout Le_layout;
        TextView StoreName;
        TextView categorieStore;
        ImageView icone;
        ImageView storeImg;

        public MovieViewHolder(View v) {
            super(v);
          //  Le_layout= (LinearLayout) v.findViewById(R.id.principal);
            StoreName= (TextView) v.findViewById(R.id.storeName);
            categorieStore= (TextView) v.findViewById(R.id.categoryTV);
            icone= (ImageView) v.findViewById(R.id.itemDetailsIcon);
            storeImg= (ImageView) v.findViewById(R.id.storeImg);

        }
    }





    public AdapterFragmentA(List<StoreW> lramassage, int rowLayout, Context context) {
        this.STOREW= lramassage;
        this.rowLayout = rowLayout;
        this.context = context;

    }

    @Override
    public AdapterFragmentA.MovieViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {

        holder.StoreName.setText(STOREW.get(position).getName()+"");
        holder.categorieStore.setText(STOREW.get(position).getType());
        Glide.with(context).load(STOREW.get(position).getLien_image()).into(holder.storeImg);

       /* holder.PRIX.setText(Constantes.Dformat.format(ramassages.get(position).getPrix())+" Da");
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

        */

    }

    @Override
    public int getItemCount() {
        return STOREW.size();
    }
}

