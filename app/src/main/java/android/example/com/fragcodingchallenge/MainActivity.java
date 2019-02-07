package android.example.com.fragcodingchallenge;

import android.example.com.fragcodingchallenge.controller.ZodiacAdapter;
import android.example.com.fragcodingchallenge.model.Zodiac;
import android.example.com.fragcodingchallenge.model.ZodiacApi;
import android.example.com.fragcodingchallenge.network.ZodiacRetro;
import android.example.com.fragcodingchallenge.network.Zservice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = findViewById(R.id.zodiac_recyclerview);

        //making the call
        //instantiate retro and service
        Retrofit retrofit = ZodiacRetro.getRetrofit();
        Zservice service = retrofit.create(Zservice.class);

        Call<ZodiacApi> zodiac = service.getZodiac();
        zodiac.enqueue(new Callback<ZodiacApi>() {
            @Override
            public void onResponse(Call<ZodiacApi> call, Response<ZodiacApi> response) {
                Log.d( "onResponse: ", response.body().getZodiac().get(0).getName());
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(new ZodiacAdapter(response.body().getZodiac()));

            }

            @Override
            public void onFailure(Call<ZodiacApi> call, Throwable t) {

            }
        });


    }
}
