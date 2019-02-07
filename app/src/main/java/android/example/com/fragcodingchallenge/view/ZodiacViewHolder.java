package android.example.com.fragcodingchallenge.view;

import android.content.Intent;
import android.example.com.fragcodingchallenge.DisplayActivity;
import android.example.com.fragcodingchallenge.R;
import android.example.com.fragcodingchallenge.model.Zodiac;
import android.example.com.fragcodingchallenge.model.ZodiacApi;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ZodiacViewHolder extends RecyclerView.ViewHolder {


//
//    public static final String NAME_KEY = "name";
//    public static final String NUMBER_KEY = "number";
//    public static final String URL_KEY = "url";
//
     private TextView zodiacNameTextView;
     private TextView zodiacNumberTextView;

    public ZodiacViewHolder(@NonNull View itemView) {
        super(itemView);
        zodiacNameTextView = itemView.findViewById(R.id.zodiac_name_textview);
        zodiacNumberTextView = itemView.findViewById(R.id.zodiac_date_textview);
    }



    public void onBind(final Zodiac zodiac){


        zodiacNameTextView.setText(zodiac.getName());
        zodiacNumberTextView.setText(zodiac.getNumber());

//        itemView.setOnClickListener(new View.OnClickListener(){
//
//                                    }
//
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DisplayActivity.class);
                intent.putExtra("zodiac_name", zodiac.getName());
                intent.putExtra("date", zodiac.getNumber());
                intent.putExtra("image", zodiac.getImage());
                itemView.getContext().startActivity(intent);



            }
        });


//        Picasso.get()
//                .load(planetUrl)
//                .into(planetImageIv);
//
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(),DisplayActivity.class);
//                intent.putExtra(NAME_KEY,planetName);
//                intent.putExtra(NUMBER_KEY,planetNumber);
//                intent.putExtra(URL_KEY,planetUrl);
//                itemView.getContext().startActivity(intent);
//            }
//        });
    }
}
