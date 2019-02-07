package android.example.com.fragcodingchallenge.network;

import android.example.com.fragcodingchallenge.model.Zodiac;
import android.example.com.fragcodingchallenge.model.ZodiacApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Zservice {
    @GET("JDVila/storybook/master/zodiac.json")
    Call<ZodiacApi> getZodiac();
    //getting the whole list not the individual signs


}
