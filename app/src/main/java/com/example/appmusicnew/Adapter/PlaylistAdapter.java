package com.example.appmusicnew.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appmusicnew.Model.Playlist;
import com.example.appmusicnew.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }
    class  ViewHolder{
        TextView txttenplaylist;
        ImageView imgbackground, imgplaylist;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dongplaylist,null);
            viewHolder = new ViewHolder();
            viewHolder.txttenplaylist = convertView.findViewById(R.id.textviewtenplaylist);
            viewHolder.imgplaylist = convertView.findViewById(R.id.imageviewplaylist);
            viewHolder.imgbackground = convertView.findViewById(R.id.imageviewbackgroundplaylist);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhNen()).into(viewHolder.imgbackground);
        Picasso.with(getContext()).load(playlist.getHinhIcon()).into(viewHolder.imgplaylist);
        viewHolder.txttenplaylist.setText(playlist.getTen());
        return convertView;
    }
}
