package android.example.com.fragcodingchallenge.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZodiacRetro {
 private static String BASE_URL = "https://raw.githubusercontent.com";
 private static Retrofit instance;

 public ZodiacRetro() {
 }

 public static Retrofit getRetrofit(){
  if(instance == null){
   instance =  new Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build();

  }
  return instance;
 }

}
