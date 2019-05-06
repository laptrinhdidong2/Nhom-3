package com.example.administrator.doan_application.baothuc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.administrator.doan_application.BaoThucFragment;
import com.example.administrator.doan_application.MainActivity;
import com.example.administrator.doan_application.R;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TaoBaoThucActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_CHONCHUONGBAO = 1002;
    public static final String EXTRA_SELECTED_CHUONGBAO = "EXTRA_SELECTED_CHUONGBAO";

    Button btn_giohen;
    EditText edt_mota;
    TextView txt_tenchuong;
    //CheckBox txt_checkrung;

    TextView txt_chunhat, txt_thuhai, txt_thuba, txt_thutu, txt_thunam, txt_thusau, txt_thubay;

    // button huy tao bao thuc => khi click vao day no se quay ve man hinh chinh bao thuc
    Button btnHuy;

    // button hoan tat luu vao listview
    Button btnAdd;

    //adapter
    ArrayAdapter<String> adapter;

    // linerLayout
    LinearLayout layoutNgayTrongTuan;
    TextView txtTime;

    // arraylist
    ArrayList<BaoThuc> lstBaoThuc;
    ChuongBao selectedChuongBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_bao_thuc);



        initial();
    }


//    @Override
//    protected void onStop() {
//        Log.e("tag: ", "Stop a");
//        finish();
//        super.onStop();
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        Log.e("Activity: ", "Result on TaoBaoThucActivity. Request code: " + requestCode);
        if (requestCode == REQUEST_CODE_CHONCHUONGBAO) {
            ChuongBao result = (ChuongBao) data.getSerializableExtra(EXTRA_SELECTED_CHUONGBAO);

            if (result != null)
            {
                selectedChuongBao = result;
                txt_tenchuong.setText(result.getsTenChuong());
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void setBaoThucSelected(BaoThuc baoThuc) {
       btn_giohen.setText(baoThuc.getsGioHen());
        edt_mota.setText(baoThuc.getsMoTa());

        txt_tenchuong.setText(baoThuc.getsChuongBao().getsTenChuong());

        if (baoThuc.isChuNhat())
        {
            txt_chunhat.setTypeface(Typeface.DEFAULT_BOLD);
        }
        else
        {
            txt_chunhat.setTypeface(Typeface.DEFAULT);
        }

        if (baoThuc.isThuHai())
        {
            txt_thuhai.setTypeface(Typeface.DEFAULT_BOLD);
        }
        else
        {
            txt_thuhai.setTypeface(Typeface.DEFAULT);
        }

        if (baoThuc.isThuBa())
        {
            txt_thuba.setTypeface(Typeface.DEFAULT_BOLD);
        }
        else
        {
            txt_thuba.setTypeface(Typeface.DEFAULT);
        }

        if (baoThuc.isThuTu())
        {
            txt_thutu.setTypeface(Typeface.DEFAULT_BOLD);
        }
        else
        {
            txt_thutu.setTypeface(Typeface.DEFAULT);
        }

        if (baoThuc.isThuNam())
        {
            txt_thunam.setTypeface(Typeface.DEFAULT_BOLD);
        }
        else
        {
            txt_thunam.setTypeface(Typeface.DEFAULT);
        }

        if (baoThuc.isThuSau())
        {
            txt_thusau.setTypeface(Typeface.DEFAULT_BOLD);
        }
        else
        {
            txt_thusau.setTypeface(Typeface.DEFAULT);
        }

        if (baoThuc.isThuBay())
        {
            txt_thubay.setTypeface(Typeface.DEFAULT_BOLD);
        }
        else
        {
            txt_thubay.setTypeface(Typeface.DEFAULT);
        }
    }

    public void initial() {
        layoutNgayTrongTuan = (LinearLayout) findViewById(R.id.layout_ngaytrongtuan);

        btn_giohen = (Button) findViewById(R.id.btn_giohen);
        edt_mota = (EditText) findViewById(R.id.edt_mota);
        txt_tenchuong = (TextView) findViewById(R.id.txt_tenchuong);

        txt_chunhat = (TextView) findViewById(R.id.txt_chunhat);
        txt_thuhai = (TextView) findViewById(R.id.txt_thuhai);
        txt_thuba = (TextView) findViewById(R.id.txt_thuba);
        txt_thutu = (TextView) findViewById(R.id.txt_thutu);
        txt_thunam = (TextView) findViewById(R.id.txt_thunam);
        txt_thusau = (TextView) findViewById(R.id.txt_thusau);
        txt_thubay = (TextView) findViewById(R.id.txt_thubay);

        btnHuy = (Button) findViewById(R.id.btn_huy);
        btnAdd = (Button) findViewById(R.id.btn_add);

        // khi click vao tạo chuông báo mới no hien ra activity ChuongBaoThuc
        final TextView txt_tenchuong = (TextView) findViewById(R.id.txt_tenchuong);

        txt_tenchuong.setOnClickListener(new View.OnClickListener(){

            // su kien click vao tao chuong moi
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TaoBaoThucActivity.this, ChuongBaoThucActivity.class);
                ChuongBaoThucActivity activity = new ChuongBaoThucActivity();

                startActivityForResult(intent, REQUEST_CODE_CHONCHUONGBAO);
            }
        });

        // sửa báo thức
        BaoThuc selectedBaoThuc = (BaoThuc)getIntent().getSerializableExtra(BaoThucFragment.EXTRA_SUABAOTHUC);

        if (selectedBaoThuc != null)
        {
            setBaoThucSelected(selectedBaoThuc);
        }

        // kiem ra ngay trong tuan -> chọn thứ báo thức
        for (int i = 0; i < ((ViewGroup)layoutNgayTrongTuan).getChildCount(); i++) {
            final View current = layoutNgayTrongTuan.getChildAt(i);

            if (current instanceof TextView) {
                current.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //.setTypeface(Typeface.DEFAULT_BOLD);
                        if (((TextView) current).getTypeface() == Typeface.DEFAULT_BOLD) {
                            ((TextView) current).setTypeface(Typeface.DEFAULT);
                        }
                        else
                        {
                            ((TextView) current).setTypeface(Typeface.DEFAULT_BOLD);
                        }
                    }
                });
            }
        }

        // khi click vào button huy tu giao dien man hinh taobaothucActivity => quay vê giao dien man hinh chinh bao thuc
        btnHuy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ActivityName", "BaoThuc");
                setResult(Activity.RESULT_CANCELED, intent);

                finish();
            }
        });

        // khi click vao button hoan tat man hinh taobaothcActivity => quay ve man hinh chinh bao thuc, đồng thời load dữ liệu vừa tạo lên listview
        btnAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // tạo biến
                String taoGioBT = btn_giohen.getText().toString();
                String ghiChu = edt_mota.getText().toString();
                //String chuongBao = txt_tenchuong.getText().toString();

                boolean isChuNhat = false;

                if (txt_chunhat.getTypeface() == Typeface.DEFAULT_BOLD)
                {
                    isChuNhat = true;
                }
                boolean isThuHai = false;

                if (txt_thuhai.getTypeface() == Typeface.DEFAULT_BOLD) {
                    isThuHai = true;
                }

                boolean isThuBa = false;

                if (txt_thuba.getTypeface() == Typeface.DEFAULT_BOLD) {
                    isThuBa = true;
                }

                boolean isThuTu = false;

                if (txt_thutu.getTypeface() == Typeface.DEFAULT_BOLD) {
                    isThuTu = true;
                }

                boolean isThuNam = false;

                if (txt_thunam.getTypeface() == Typeface.DEFAULT_BOLD) {
                    isThuNam = true;
                }

                boolean isThuSau = false;

                if (txt_thusau.getTypeface() == Typeface.DEFAULT_BOLD) {
                    isThuSau = true;
                }

                boolean isThuBay = false;

                if (txt_thubay.getTypeface() == Typeface.DEFAULT_BOLD) {
                    isThuBay = true;
                }

                //Boolean checkRung = txt_checkrung.isSelected();

                BaoThuc baoThuc = new BaoThuc (taoGioBT, ghiChu, null, isChuNhat, isThuHai, isThuBa, isThuTu, isThuNam, isThuSau, isThuBay);

                // kiểm tra điều kiện bắt buộc chọn lặp lại báo thức bằng cách xem nó có đc in đậm ko
                if (btn_giohen.getText().toString().equalsIgnoreCase("Click vào đây để chọn giờ!") ){
                    alertDialog_Gio(); // khi ko click vao button
                    return;
                }

                if(isChuNhat == false && isThuHai == false && isThuBa == false && isThuTu == false && isThuNam == false
                        && isThuSau == false && isThuBay == false)
                {
                    alertDialog_lichhen();
                    return;
                }

                // trở lại màn hình chính
                Intent intent = new Intent();
                intent.putExtra(BaoThucFragment.EXTRA_BAOTHUCMOI, baoThuc);
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });


    }

    // set time sau khi click vao button tạo ngay gio bao thuc
    public void setTime(View view){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        //int am_pm = calendar.get(Calendar.AM_PM);

        TimePickerDialog timePickerDialog;

        // ham xu ly sau khi chon gio
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                btn_giohen.setText(hourOfDay+":"+minute);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    // hàm cảnh báo dialog khi không chọn giờ
    public void alertDialog_Gio(){
        new AlertDialog.Builder(this)
        .setTitle("Cảnh báo!")
        .setMessage("Vui lòng Nhập vào Giờ báo thức!")
        .setNegativeButton("OK", null)
        .create().show();

    }

    // hàm cảnh báo dialog khi không chọn ngày lặp báo thức
    public void alertDialog_lichhen(){
        new AlertDialog.Builder(this)
                .setTitle("Cảnh báo!")
                .setMessage("Vui lòng nhập vào Ngày hẹn Báo Thức!")
                .setNegativeButton("OK", null)
                .create().show();

    }

    // phần xử lý button hoàn tất khi tiến hành sửa nội dung báo thức

}
