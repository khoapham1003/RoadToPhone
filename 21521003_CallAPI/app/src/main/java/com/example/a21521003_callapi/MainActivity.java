package com.example.a21521003_callapi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.moshi.Moshi;

import org.w3c.dom.Text;

import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Moshi moshi;
    private TextView name,temperature,more;
    private ImageView backImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.name);
        temperature = (TextView) findViewById(R.id.temperature);
        more = (TextView) findViewById(R.id.more);
        backImg = (ImageView) findViewById(R.id.backImg);
        callApi();
    }
    private void callApi(){
        Toast.makeText(MainActivity.this,"abc",Toast.LENGTH_SHORT);
        moshi = new Moshi.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://3bro.hoanghy.tech/api/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();
        PlaceHolderAPI placeHolderAPI= retrofit.create(PlaceHolderAPI.class);
        placeHolderAPI.getForecast("ho chi minh city").enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                if(response.isSuccessful() && response.code()==200)
                {
                    Forecast forecast = response.body();
                    name.setText(forecast.getCity());
                    temperature.setText(String.valueOf(forecast.getTemperature())+" degree C");
                    more.setText("Wind:"+forecast.getWind()+"\nHumidity:"+forecast.getHumidity()+"\nVisibility:"+forecast.getVisibility());
                    new DownloadImageFromInternet((ImageView) findViewById(R.id.backImg)).execute(forecast.getPhoto());
                }
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Fail",Toast.LENGTH_SHORT).show();
            }
        });
    }
    static class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
//            Toast.makeText(getApplicationContext(), "Please wait, it may take a few minute...",Toast.LENGTH_SHORT).show();
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}