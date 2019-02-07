package android.example.com.fragcodingchallenge.controller;

import android.example.com.fragcodingchallenge.R;
import android.example.com.fragcodingchallenge.model.Zodiac;
import android.example.com.fragcodingchallenge.view.ZodiacViewHolder;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacViewHolder> {
    private List<Zodiac> zodiac;

    public ZodiacAdapter(List<Zodiac> zodiac) {
        this.zodiac = zodiac;
    }

    @NonNull
    @Override
    public ZodiacViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zodiac_item_view, viewGroup, false);
        return new ZodiacViewHolder(childView);
    }


    @Override
    public void onBindViewHolder(@NonNull ZodiacViewHolder zodiacViewHolder, int i) {
        zodiacViewHolder.onBind(zodiac.get(i));
    }

    @Override
    public int getItemCount() {
        return zodiac.size();
    }
}

