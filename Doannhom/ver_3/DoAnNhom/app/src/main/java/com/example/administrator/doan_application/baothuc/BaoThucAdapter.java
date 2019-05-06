package com.example.administrator.doan_application.baothuc;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.doan_application.BaoThucFragment;
import com.example.administrator.doan_application.R;

import java.util.ArrayList;

public class BaoThucAdapter extends ArrayAdapter <BaoThuc>{

    private static final String TAG = "BaoThucAdapter";

    private Context mContext;
    private int mResource;

    private ListView mListView;

    ArrayList<BaoThuc> lstBaoThuc;

    private static class ViewHolder{
        TextView txtgiohen, txtmota, txt_chuongbao, txt_cn, txt_thu2, txt_thu3, txt_thu4, txt_thu5, txt_thu6, txt_thu7;
        CheckBox ckbCheck;
        LinearLayout parentLayout;
       // CheckBox txt_check;
    }

    public BaoThucAdapter (Context context, int resource, ArrayList<BaoThuc> objects){
        super(context, resource, objects);

        mContext = context;
        mResource = resource;

        initial();
    }

    public View getView(final int position, View convertView, ViewGroup parent){

        BaoThuc t = getItem(position);

        // get bao thuc
        String txt_giohen = getItem(position).getsGioHen();
        String txt_mota = getItem(position).getsMoTa();
        ChuongBao chuongBao = getItem(position).getsChuongBao();

        boolean txt_chunhat = getItem(position).isChuNhat();
        boolean txt_thuhai = getItem(position).isThuHai();
        boolean txt_thuba = getItem(position).isThuBa();
        boolean txt_thutu = getItem(position).isThuTu();
        boolean txt_thunam = getItem(position).isThuNam();
        boolean txt_thusau = getItem(position).isThuSau();
        boolean txt_thubay = getItem(position).isThuBay();
        boolean ckb_Checked = getItem(position).isChecked();

        //boolean txt_check = getItem(position).isCheck();

        // create bao thuc object
        BaoThuc baoThuc = new BaoThuc(txt_giohen, txt_mota, chuongBao, txt_chunhat, txt_thuhai, txt_thuba, txt_thutu, txt_thunam, txt_thusau, txt_thubay);

        // create the view result;
        final View result;

        // viewholder object
        final ViewHolder holder;

        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            holder.txtgiohen = (TextView) convertView.findViewById(R.id.txt_giohen);
            holder.txtmota = (TextView) convertView.findViewById(R.id.txt_mota);
            //holder.txt_chuongbao = (TextView) convertView.findViewById(R.id.txt_tenchuong);

            holder.txt_cn = (TextView) convertView.findViewById(R.id.txt_chunhat);
            holder.txt_thu2 = (TextView) convertView.findViewById(R.id.txt_thuhai);
            holder.txt_thu3 = (TextView) convertView.findViewById(R.id.txt_thuba);
            holder.txt_thu4 = (TextView) convertView.findViewById(R.id.txt_thutu);
            holder.txt_thu5 = (TextView) convertView.findViewById(R.id.txt_thunam);
            holder.txt_thu6 = (TextView) convertView.findViewById(R.id.txt_thusau);
            holder.txt_thu7 = (TextView) convertView.findViewById(R.id.txt_thubay);
            /*holder.ckbCheck = (CheckBox) convertView.findViewById(R.id.txt_check);*/ // không xoá
            holder.parentLayout = (LinearLayout) convertView.findViewById(R.id.parentLayoutBaoThucItem);
            //holder.txt_check = (CheckBox) convertView.findViewById(R.id.txt_check);

            result = convertView;
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        holder.txtgiohen.setText(txt_giohen);
        holder.txtmota.setText(txt_mota);
        //holder.txt_chuongbao.setText(txt_chuongBao);

        // set đậm nhạt
        if (txt_chunhat)
        {
            holder.txt_cn.setTypeface(Typeface.DEFAULT_BOLD);
        }

        if (txt_thuhai)
        {
            holder.txt_thu2.setTypeface(Typeface.DEFAULT_BOLD);
        }

        if (txt_thuba)
        {
            holder.txt_thu3.setTypeface(Typeface.DEFAULT_BOLD);
        }

        if (txt_thutu)
        {
            holder.txt_thu4.setTypeface(Typeface.DEFAULT_BOLD);
        }

        if (txt_thunam)
        {
            holder.txt_thu5.setTypeface(Typeface.DEFAULT_BOLD);
        }

        if (txt_thusau)
        {
            holder.txt_thu6.setTypeface(Typeface.DEFAULT_BOLD);
        }

        if (txt_thubay)
        {
            holder.txt_thu7.setTypeface(Typeface.DEFAULT_BOLD);
        }

        holder.txtgiohen.setText(txt_giohen);

        /* Log.e("tag: ", ckb_Checked + " checkbox: " + holder.ckbCheck.getId());
        holder.ckbCheck.setSelected(ckb_Checked); */ // không xoá

        // set màu khi click chọn báo thức để xoá
        if (ckb_Checked)
        {
            holder.parentLayout.setBackgroundColor(Color.parseColor("#ff6347"));
        }
        else
        {
            holder.parentLayout.setBackgroundColor(Color.TRANSPARENT);
        }

       /* holder.ckbCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView parent = (ListView)v.getParent().getParent().getParent();

                Log.e("perform: ", "Linear clicked");
                parent.performItemClick(v, position, 0);
            }
        }); */ // không xoá

        return convertView;
    }

    public void initial() {

    }

    public BaoThucAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        initial();
    }


}
