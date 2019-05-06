package com.example.ngocdiem.listanimationapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class PokemonListAdapter extends ArrayAdapter<pokemon>{

    private static final String TAG = "PokemonListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;



    private static class ViewHolder{
        TextView name;
        ImageView img;
    }

    public PokemonListAdapter(Context context, int resource, ArrayList<pokemon> objects){
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        // get the pokemon
        String name = getItem(position).getName();
        int img = getItem(position).getImg();

        // create the pokemon object
        pokemon pokemons = new pokemon(name, img);

        // create the view result
        final View result;

        // viewholder object
        final ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            holder.name = (TextView) convertView.findViewById(R.id.txtName);
            holder.img = (ImageView) convertView.findViewById(R.id.ivImage);

            result = convertView;

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        holder.name.setText(name);

        // load hinh anh len list view --> cho bi roi
        holder.img.setImageResource(pokemons.getImg());
        holder.name.setText(pokemons.getName());

        // hieu ung animation
        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        // tao menu chua hieu ung
        switch (ListViewAnimationActivity.animationItem){
            case R.id.fade_in:
                animation = AnimationUtils.loadAnimation(mContext, R.anim.fade_in);
                convertView.startAnimation(animation);
                break;
            case R.id.slide_left:
                animation = AnimationUtils.loadAnimation(mContext, R.anim.slide_left);
                convertView.startAnimation(animation);
                break;
            case R.id.slide_up:
                animation = AnimationUtils.loadAnimation(mContext, R.anim.slide_up);
                convertView.startAnimation(animation);
                break;
            case R.id.shake:
                animation = AnimationUtils.loadAnimation(mContext, R.anim.shake);
                convertView.startAnimation(animation);
                break;
            case R.id.scale:
                animation = AnimationUtils.loadAnimation(mContext, R.anim.scale);
                convertView.startAnimation(animation);
                break;
        }
        return convertView;

    }

}
