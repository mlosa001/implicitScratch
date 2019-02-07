package android.example.com.fragcodingchallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayActivity extends AppCompatActivity {
    private ImageView image;
    private TextView name;
    private TextView dateRange;
    private Button button;
    private static final String address = "https://www.astrology.com/horoscope/daily/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        Log.e("intent:", intent.toString());

        image = findViewById(R.id.zodiac_imageview);
        name = findViewById(R.id.zodiac_name_textview);
        dateRange = findViewById(R.id.zodiac_number_tview);
        button = findViewById(R.id.zodiac_button);


        String imageURL = intent.getStringExtra("image");
         final String zodiacName = intent.getStringExtra("zodiac_name");
        String dates = intent.getStringExtra("date");

//        Log.e("imageURL:", imageURL);

        name.setText(zodiacName);
        dateRange.setText(dates);
        Picasso.get()
                .load(imageURL)
                .into(image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(address + zodiacName + " .html");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent1);

            }
        });

    }
}
