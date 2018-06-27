package com.tiboreno.android.moviechronunicorn;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    /*private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
        R.id.navigation_home -> {
            message.setText(R.string.title_home)
            return@OnNavigationItemSelectedListener true
        }
        R.id.navigation_dashboard -> {
            message.setText(R.string.title_dashboard)
            return@OnNavigationItemSelectedListener true
        }
        R.id.navigation_notifications -> {
            message.setText(R.string.title_notifications)
            return@OnNavigationItemSelectedListener true
        }
    }
        falseMa
    }*/

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        OmdbAPI.ServiceApi mclient = OmdbAPI.getDefault(getApplicationContext()).mClient;
        String[] tests = new String[]{"Blade Runner", "Interstellar", "Blade Runner 2049"};
        for(String title : tests){
            mclient.getItemByTItle(title, new Callback<OmdbItem>() {
                @Override
                public void success(OmdbItem omdbItem, Response response) {
                    String msg = omdbItem.toString().concat(omdbItem.getFormattedReleased().toString());
                            Log.d("full", msg);
                            Log.d("date", omdbItem.getFormattedReleased().toString());
                    Toast.makeText(MainActivity.this, omdbItem.getTitle(), Toast.LENGTH_SHORT).show();
                    OmdbItemView view = new OmdbItemView(getApplicationContext());
                    view.setItem(omdbItem);
                    recyclerView.addView(view);
                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(MainActivity.this, error.getResponse().toString(), Toast.LENGTH_SHORT).show();

                }
            });
        }

    }
}
