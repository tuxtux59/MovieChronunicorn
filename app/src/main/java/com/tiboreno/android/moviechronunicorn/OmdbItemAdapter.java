package com.tiboreno.android.moviechronunicorn;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

class OmdbItemAdapter extends ArrayAdapter<OmdbItem> {
    public OmdbItemAdapter(Context context, int resource, List<OmdbItem> objects) {
        super(context, R.layout.home_omdb_item_view, objects);
    }

    public OmdbItemAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return new OmdbItemView(getContext(), getItem(position));
    }
}
