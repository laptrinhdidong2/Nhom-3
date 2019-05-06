package com.example.administrator.doan_application;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChuyenDoiFragment extends Fragment {

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

    public ChuyenDoiFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        edtChieuCao = (EditText) getView().findViewById(R.id.edtChieuCao);
        edtCanNang = (EditText) getView().findViewById(R.id.edtCanNang);
        btnTinh = (Button) getView().findViewById(R.id.btnTinh);
        btnReset = (Button) getView().findViewById(R.id.btnReset);
        tvDanhGia = (TextView) getView().findViewById(R.id.txtDanhGia);
        edtNhietDo = (EditText) getView().findViewById(R.id.edtNhietDo);
        rdoDoC = (RadioButton) getView().findViewById(R.id.rdoBtC);
        rdoDoF = (RadioButton) getView().findViewById(R.id.radioButton_DoF);
        btnChuyen = (Button) getView().findViewById(R.id.btnChuyen);
        tvNhietDo = (TextView) getView().findViewById(R.id.txtNhietDo);
        btnThoat = (Button) getView().findViewById(R.id.btnThoat);
        tvChiSo = (TextView) getView().findViewById(R.id.txtChiSo) ;

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chuyen_doi, container, false);
    }

}
