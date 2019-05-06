package com.example.administrator.doan_application.baothuc;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.doan_application.BaoThucFragment;
import com.example.administrator.doan_application.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class XoaBaoThucActivity extends AppCompatActivity{
    private static final String TAG = "XoaBaoThucActivity";

    TextView txt_giohen, txt_tenchuong, txt_chunhat, txt_thuhai, txt_thuba, txt_thutu, txt_thunam, txt_thusau, txt_thubay;
    EditText edt_mota;
    //CheckBox txt_check;

    // khai báo các button
    Button btn_delete_bt, btn_huy_bt;

    // adapter
    BaoThucAdapter adapterBaoThuc;

    // arraylist
    ArrayList<BaoThuc> arrBaoThuc;

    // listview
    ListView mListView_xoa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xoa_bao_thuc);

        //Log.d(TAG, "onCreate: Started.");
        ;
        mListView_xoa = (ListView) findViewById(R.id.listView_bt_xoa);
        // xu ly passing data tu listview chinh sang activity khac
        Bundle bundle = getIntent().getExtras();
        arrBaoThuc = (ArrayList<BaoThuc>) bundle.getSerializable("BaoThuc");

        adapterBaoThuc = new BaoThucAdapter(this, R.layout.baothuc_item, arrBaoThuc);

        mListView_xoa.setAdapter(adapterBaoThuc);


        configure();
        initial();
    }

    private void configure() {

    }

    public void initial(){
         txt_giohen = (TextView)findViewById(R.id.txt_giohen);
         edt_mota = (EditText) findViewById(R.id.edt_mota);
         txt_tenchuong = (TextView) findViewById(R.id.txt_tenchuong);

         txt_chunhat = (TextView) findViewById(R.id.txt_chunhat);
         txt_thuhai = (TextView) findViewById(R.id.txt_thuhai);
         txt_thuba = (TextView) findViewById(R.id.txt_thuba);
         txt_thutu = (TextView) findViewById(R.id.txt_thutu);
         txt_thunam = (TextView) findViewById(R.id.txt_thunam);
         txt_thusau = (TextView) findViewById(R.id.txt_thusau);
         txt_thubay = (TextView) findViewById(R.id.txt_thubay);

         /*txt_check = (CheckBox) findViewById(R.id.txt_check);*/ // không xoá

        // khi click vào button huy tu giao dien man hinh taobaothucActivity => quay vê giao dien man hinh chinh bao thuc
        btn_huy_bt = (Button) findViewById(R.id.btn_huy_bt);
        btn_delete_bt = (Button)findViewById(R.id.btn_delete_bt);



        btn_huy_bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ActivityName", "BaoThuc");
                setResult(Activity.RESULT_CANCELED, intent);

                finish();
            }
        });

        // hàm kt xem item có được click chọn ko, đồng thời dưới btn xoá cập nhật số lượng item được click
        mListView_xoa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                boolean isChecked = arrBaoThuc.get(position).isChecked(); // lay ra trang thai hien tai
                arrBaoThuc.get(position).setChecked(!isChecked);

                adapterBaoThuc.notifyDataSetChanged(); // lưu thay đổi

                // XOA(xxx) -> xử lý phần button xoá, tăng số lượng item được chọn
                String strXoaBaoThuc = btn_delete_bt.getText().toString();
                String strCurrentBaoThuc = strXoaBaoThuc.substring(4, strXoaBaoThuc.length() - 1);

                int currentNumber = Integer.valueOf(strCurrentBaoThuc);

                if (isChecked)
                {
                    btn_delete_bt.setText("XOÁ(" + --currentNumber + ")");
                }
                else
                {
                    btn_delete_bt.setText("XOÁ(" + ++currentNumber + ")");
                }

                // lấy giá trị item được chọn
                //final BaoThuc selectedItem = (BaoThuc) mListView.getItemAtPosition(position);

//                // xoá sau khi đã get đc item đc chọn
//                if(isChecked == true){
//                    adapterBaoThuc.remove(adapterBaoThuc.getItem(position));
//                    adapterBaoThuc.notifyDataSetChanged();
//                }

                btn_delete_bt.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), BaoThucAdapter.class);

                        if (mListView_xoa != null){
                            for (int i=0; i < arrBaoThuc.size(); i++){
                                if (arrBaoThuc.get(i).isChecked()){
                                    Log.d("testingTAG", String.valueOf(i));
                                    arrBaoThuc.remove(i);
                                    adapterBaoThuc.notifyDataSetChanged();
                                    i--;

                                }
                            }

                        }
                        btn_delete_bt.setText("XOÁ(0)" );
                        return;
                    }
                });


            }
        });

        // xử lý sự kiện xoá iem báo thức

    }



}
