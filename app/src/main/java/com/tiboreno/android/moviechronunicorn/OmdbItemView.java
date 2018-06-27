package com.tiboreno.android.moviechronunicorn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


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

    public OmdbItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mAttrs = attrs;
        initializeView();
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
        omdbTitleTv.setText(omdbItem.getTitle());
        Date releaseDate = omdbItem.getFormattedReleased();
        Calendar c = Calendar.getInstance();
        c.setTime(releaseDate);
        c.add(Calendar.YEAR, 2);
        Date availableDate = c.getTime();
        omdbDescTv.setText(String.format("%s > %s", omdbItem.getReleased(), new SimpleDateFormat(OmdbItem.date_format).format(availableDate)));
        //Glide.with(mContext).load(omdbItem.getPoster()).into(omdbPosterImv);

    }

}
