package com.codedbyte.retrofitjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Model> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(RetrofitInterface.BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        Call<ArrayList<Model>>  call = retrofitInterface.getCountry();
        call.enqueue(new Callback<ArrayList<Model>>() {
            @Override
            public void onResponse(Call<ArrayList<Model>> call, Response<ArrayList<Model>> response) {
                arrayList = response.body();
                Log.i("GOAT", response.toString());
                RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), arrayList);
                recyclerView.setAdapter(customAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Model>> call, Throwable t) {
                Log.i("GOAT", t.toString());
            }
        });



    }
}
