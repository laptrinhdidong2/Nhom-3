package com.example.administrator.doan_application.baothuc;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.doan_application.R;

import java.util.ArrayList;

public class ChuongBaoAdapter extends ArrayAdapter <ChuongBao> {

    private static final String TAG="ChuongBaoAdapter";

    private Context mContext;
    private int mResource;

    private static class ViewHolder{
        TextView txt_tenchuong;
        LinearLayout parentLayout;
    }

    public ChuongBaoAdapter(@NonNull Context context, int resource, ArrayList<ChuongBao> objects) {
        super(context, resource, objects);

        mContext = context;
        mResource = resource;
    }


    public View getView(final int position, View convertView, ViewGroup parent){
        // get chuong bao thuc
        String txt_tenchuong = getItem(position).getsTenChuong();
        String txt_duongdan = getItem(position).getsDuongDan();

        boolean checked = getItem(position).isCkecked();

        // create chuong bao thuc objects
        ChuongBao chuongBao = new ChuongBao(txt_tenchuong, txt_duongdan, checked);

        // create view result
        final View result;

        // View holder objects
        final ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            holder.txt_tenchuong = (TextView) convertView.findViewById(R.id.txt_tenchuong);
            holder.parentLayout = (LinearLayout) convertView.findViewById(R.id.parentLayoutChuongBaoThucItem);

            result = convertView;
            convertView.setTag(holder);
        }
        else {
            holder = (ChuongBaoAdapter.ViewHolder) convertView.getTag();
            result = convertView;
        }
        holder.txt_tenchuong.setText(txt_tenchuong);

        // set màu khi click chọn item nhạc chuông
        if (checked)
        {
            holder.parentLayout.setBackgroundColor(Color.parseColor("#ff6347"));
        }
        else
        {
            holder.parentLayout.setBackgroundColor(Color.TRANSPARENT);
        }

        return convertView;
    }
    public ChuongBaoAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


}
