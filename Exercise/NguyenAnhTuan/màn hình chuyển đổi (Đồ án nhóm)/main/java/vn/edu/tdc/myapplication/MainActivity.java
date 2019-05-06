package vn.edu.tdc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText edtChieuCao;
    EditText edtCanNang;
    Button btnTinh;
    Button btnReset;
    TextView tvChiSo;
    TextView tvDanhGia;
    EditText edtNhietDo;
    RadioButton rdoDoC ;
    RadioButton rdoDoF ;
    Button btnChuyen ;
    TextView tvNhietDo;
    Button btnThoat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         edtChieuCao = (EditText) findViewById(R.id.edtChieuCao);
        edtCanNang = (EditText) findViewById(R.id.edtCanNang);
        btnTinh = (Button) findViewById(R.id.btnTinh);
        btnReset = (Button) findViewById(R.id.btnReset);
        tvDanhGia = (TextView) findViewById(R.id.txtDanhGia);
        edtNhietDo = (EditText) findViewById(R.id.edtNhietDo);
        rdoDoC = (RadioButton) findViewById(R.id.rdoBtC);
        rdoDoF = (RadioButton) findViewById(R.id.radioButton_DoF);
        btnChuyen = (Button) findViewById(R.id.btnChuyen);
        tvNhietDo = (TextView) findViewById(R.id.txtNhietDo);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        tvChiSo = (TextView) findViewById(R.id.txtChiSo) ;

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float chieuCao = Float.parseFloat(edtChieuCao.getText().toString());
                float canNang = Float.parseFloat(edtCanNang.getText().toString());;

                tvChiSo.setText(String.valueOf(canNang / (chieuCao * chieuCao)));

                if (Float.parseFloat(tvChiSo.getText().toString()) < 18) {
                    tvDanhGia.setText("Bạn hơi gầy");
                }

                if (Float.parseFloat(tvChiSo.getText().toString()) < 25) {
                    tvDanhGia.setText("Bạn bình thường");
                }

                if (Float.parseFloat(tvChiSo.getText().toString()) >25 || (Float.parseFloat(tvChiSo.getText().toString()) < 30)) {
                    tvDanhGia.setText("Bạn béo phì cấp độ 1");
                }

                if (Float.parseFloat(tvChiSo.getText().toString()) > 30 || (Float.parseFloat(tvChiSo.getText().toString()) < 35)) {
                    tvDanhGia.setText("Bạn béo phì cấp độ 2");
                }

                if (Float.parseFloat(tvChiSo.getText().toString()) > 35) {
                    tvDanhGia.setText("Bạn béo phì cấp độ 3");
                }



            }
        });


        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float nhietDo = Float.parseFloat(edtNhietDo.getText().toString());


                if (rdoDoC.isChecked() == true) {

                    double tinh = (nhietDo - 32) / 1.8;
                    tvNhietDo.setText(tinh + "");

                }

                if (rdoDoF.isChecked() == true) {

                    double tinh = (nhietDo * 1.8) + 32;
                    tvNhietDo.setText(tinh + "");

                }



            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setText("");
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


}
