package com.example.administrator.doan_application;


import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;

import com.example.administrator.doan_application.baothuc.BaoThuc;
import com.example.administrator.doan_application.baothuc.BaoThucAdapter;
import com.example.administrator.doan_application.baothuc.TaoBaoThucActivity;
import com.example.administrator.doan_application.baothuc.XoaBaoThucActivity;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaoThucFragment extends Fragment {

    public final static String EXTRA_BAOTHUCMOI = "BAOTHUCMOI";
    public final static String EXTRA_SUABAOTHUC = "SUABAOTHUC";

    // button hoan tat va luu bao thuc vao listview
    Button txt_giohen;

    // arraylist
    ArrayList<BaoThuc> arr_lstBaoThuc;

    // adapter
    BaoThucAdapter adapterBaoThuc;

    // listview
    private ListView mListView;

    // them bao thuc
    private FloatingActionButton btnThemBaoThuc;

    // xoa bao thuc
    private  FloatingActionButton btnXoaBaoThuc;

    public BaoThucFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("tag: ", "Trong onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bao_thuc, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.e("tag: ", "Sau onActivityCreated");
        mListView = (ListView) getView().findViewById(R.id.listView_bt);

//        // tạo thông tin báo thức (code cứng)
        BaoThuc baothuc1 = new BaoThuc("7:00", "Đi học", null, false, true, false, true, true, true, false);
        BaoThuc baothuc2 = new BaoThuc("8:00", "Đi làm", null, true, false, true, false, true, false, false);


        arr_lstBaoThuc = new ArrayList<BaoThuc>();

        arr_lstBaoThuc.add(baothuc1);
        arr_lstBaoThuc.add(baothuc2);

        adapterBaoThuc = new BaoThucAdapter(this.getActivity(), R.layout.baothuc_item, arr_lstBaoThuc);

        mListView.setAdapter(adapterBaoThuc);

        initial();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("tag: ", "Activity Result on fragment");

        if (resultCode == MainActivity.REQUEST_CODE_TAOBAOTHUC)
        {
            ((MainActivity)getActivity()).setSelectedItemMenu(R.id.menu_bao_thuc);

            BaoThuc result = (BaoThuc) data.getSerializableExtra(EXTRA_BAOTHUCMOI);

            if (result != null)
            {
                Log.e("tag: ", "Add new baothuc has been successful");
                arr_lstBaoThuc.add(result);
                adapterBaoThuc.notifyDataSetChanged();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void initial() {
        // xu ly phan them bao thuc click vao + -> hien thi activity TaoBaoThuc
        btnThemBaoThuc = (FloatingActionButton) getView().findViewById(R.id.btnThemBaoThuc);

        // khi click vao icon + -> load trag them bao thuc
        btnThemBaoThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TaoBaoThucActivity.class);
                TaoBaoThucActivity activity = new TaoBaoThucActivity();

                startActivityForResult(intent, MainActivity.REQUEST_CODE_TAOBAOTHUC);
            }
        });

        // xu ly phan xoa bao thuc -> click vao X -> hien thi activity XoaBaoThuc
        btnXoaBaoThuc = (FloatingActionButton) getView().findViewById(R.id.btnXoaBaoThuc);

        // khi click vao icon + -> load trag xoa bao thuc
        btnXoaBaoThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), XoaBaoThucActivity.class);
                XoaBaoThucActivity activity = new XoaBaoThucActivity();

                 //thực hiện chuyển list bao thuc sang activity XaoBaoThuc bằng cách passing dữ liệu dùng putExtras
                Bundle bundle = new Bundle();
                bundle.putSerializable("BaoThuc", arr_lstBaoThuc);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        // xử lý phần click vào listview nó hiện ra activity tạo báo thức
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("tag: ", "onItemSelected");
                Intent i = new Intent(BaoThucFragment.this.getContext(), TaoBaoThucActivity.class);
                i.putExtra(EXTRA_SUABAOTHUC, (BaoThuc)mListView.getAdapter().getItem(position));
                startActivity(i);
            }
        });

        // xử lý sự kiện click vào button áp dụng khi sửa đổi nội dung báo thức và lưu vào listview màn hình chính

    }

    // set time sau khi click vao button click vào đây để chọn giờ
    public void setTime(View view){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int am_pm = calendar.get(Calendar.AM_PM);

        TimePickerDialog timePickerDialog;

        // ham xu ly sau khi chon gio
        timePickerDialog = new TimePickerDialog(BaoThucFragment.this.getActivity(),     new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                txt_giohen.setText(hourOfDay+":"+minute);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }


}
