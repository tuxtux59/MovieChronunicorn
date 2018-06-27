package com.tiboreno.android.moviechronunicorn;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends Activity {

    private OmdbItemView mView;
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
        mView = findViewById(R.id.mOmdView);
        OmdbAPI.ServiceApi mclient = OmdbAPI.getDefault(getApplicationContext()).mClient;
        final String[] tests = new String[]{"Blade Runner", "Interstellar", "Blade Runner 2049", "Realive"};
        final ArrayList<OmdbItem> items = new ArrayList<>();
        mclient.getItemByTItle(tests[1], new Callback<OmdbItem>() {
            @Override
            public void success(OmdbItem omdbItem, Response response) {
                mView.setItem(omdbItem);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, error.getResponse().toString(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
