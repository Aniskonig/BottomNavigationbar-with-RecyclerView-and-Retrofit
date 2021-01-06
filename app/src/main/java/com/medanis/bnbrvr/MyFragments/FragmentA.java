package com.medanis.bnbrvr.MyFragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.medanis.bnbrvr.R;
import com.medanis.bnbrvr.models.CallStoresModelW;
import com.medanis.bnbrvr.retrofit.ApiClient;
import com.medanis.bnbrvr.retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentA extends Fragment {

    private ApiInterface apiService;
    private RecyclerView recycle ;
    Context context ;

    OnMessageReadListner messageR;
    public interface  OnMessageReadListner{
        public void OnMessageRead(String r);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_a, container, false);

        recycle = (RecyclerView) view.findViewById(R.id.recycler);
        recycle.setLayoutManager(new LinearLayoutManager(context));
        ApiGetUser(27);

        /*
        bt = (Button) view.findViewById(R.id.operation);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageR.OnMessageRead("waliiiid");
            }
        });
*/
    return view ;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
         Activity activity = (Activity) context;
         context = context;
    try {
        messageR = (OnMessageReadListner) activity;
    }catch (ClassCastException e){
        throw new ClassCastException(activity.toString()+" must be declared on The activity");
    }
    }


    private void ApiGetUser(int id ) {

        apiService = ApiClient.getApiClient().create(ApiInterface.class);
        Call<CallStoresModelW> call = apiService.getStoresDataWalid(id);
        call.enqueue(new Callback<CallStoresModelW>() {
            @Override
            public void onResponse(Call<CallStoresModelW> call, Response<CallStoresModelW> response) {
                int statusCode = response.code();

                if (!response.isSuccessful()) {
                    Log.i("ReponseWalid", "ERROR RECEIVING API");
                    return;
                }

                CallStoresModelW user = response.body();

                if (user.isSuccess() == true) {

                    Log.i("ReponseWalid", " true is true reponse true ");

                    for(int i=0; i<user.getRestaurant_array().size();i++){
                        Log.i("ReponseWalid", " restaurant  "+user.getRestaurant_array().get(i).getName());
                    }


                    AdapterFragmentA MyAdapter = new AdapterFragmentA(user.getRestaurant_array(),
                            R.layout.store_cv,getContext());
                    recycle.setAdapter(MyAdapter);

                } else {
                    Log.i("ReponseWalid", " false is false reponse false ");
                }


            }

            @Override
            public void onFailure(Call<CallStoresModelW> call, Throwable t) {
                // Log error here since request failed

                Log.e("API ERROR", t.toString());
                //FadingTextProcess(1);

            }
        });


    }
}
