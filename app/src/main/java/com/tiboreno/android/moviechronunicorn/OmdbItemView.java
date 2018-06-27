package com.tiboreno.android.moviechronunicorn;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OmdbItemView extends RelativeLayout {
    private AttributeSet mAttrs;
    private final Context mContext;
    private ImageView omdbPosterImv;
    private TextView omdbTitleTv;
    private TextView omdbDescTv;

    public OmdbItemView(Context context) {
        super(context);
        mContext = context;
        initializeView();
    }


    public OmdbItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mAttrs = attrs;
        initializeView();
    }

    public OmdbItemView(Context context, OmdbItem item) {
        super(context);
        mContext = context;
        initializeView();
        setItem(item);
    }

    public OmdbItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mAttrs = attrs;
        initializeView();
        invalidate();
        requestLayout();
    }
    private void initializeView() {
        if (mContext == null) {
            return;
        }
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.home_omdb_item_view, this, true);

        omdbPosterImv= findViewById(R.id.poster_imv);
        omdbTitleTv = findViewById(R.id.omdb_title_tv);
        omdbDescTv = findViewById(R.id.omdb_desc_tv);
    }


    public void setItem(OmdbItem omdbItem){
        initializeView();
        String title = omdbItem.getTitle();
        Log.d("titletv", String.valueOf(omdbTitleTv == null));
        Log.d("title tv", omdbTitleTv.getText().toString());
        omdbTitleTv.setText(title);
        Log.d("title tv", omdbTitleTv.getText().toString());
        Date releaseDate = omdbItem.getFormattedReleased();
        Calendar c = Calendar.getInstance();
        c.setTime(releaseDate);
        c.add(Calendar.YEAR, 2);
        Date availableDate = c.getTime();
        String desc = String.format("%s > %s", omdbItem.getReleased(), new SimpleDateFormat(OmdbItem.date_format).format(availableDate));
        Log.d("desctv", String.valueOf(omdbDescTv == null));
        omdbDescTv.setText(desc);
        Picasso.with(mContext)
                .load(omdbItem.getPoster())
                .placeholder(R.drawable.ic_home_black_24dp)
                .error(R.drawable.ic_home_black_24dp)
                .into(omdbPosterImv);

        Toast.makeText(mContext, omdbItem.getTitle(), Toast.LENGTH_SHORT).show();
        this.invalidate();
        this.requestLayout();
    }

}
