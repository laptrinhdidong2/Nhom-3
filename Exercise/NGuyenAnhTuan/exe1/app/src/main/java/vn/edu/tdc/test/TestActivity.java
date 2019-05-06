package vn.edu.tdc.test;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvView, tvNhap;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnCong, btnTru, btnNhan, btnChia, btnBang, btnXoa,btnxanh,btndo,btnblue;
    LinearLayout background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        // set control
        setControl();

        // set event
        setEvent();
    }

    // Phương thức set control
    public void setControl() {
        tvView = (TextView) findViewById(R.id.tvView);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        btnBang = (Button) findViewById(R.id.btnBang);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        tvView = (TextView) findViewById(R.id.tvView);
        tvNhap = (TextView) findViewById(R.id.tvNhap);
        btnxanh = (Button) findViewById(R.id.btnxanh);
        btndo = (Button) findViewById(R.id.btnDo);
        btnblue = (Button) findViewById(R.id.btnblue);
        background = (LinearLayout) findViewById(R.id.backgroud);

    }

    public void setEvent() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnXoa.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnBang.setOnClickListener(this);
        btnblue.setOnClickListener(this);
        btndo.setOnClickListener(this);
        btnxanh.setOnClickListener(this);


    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                //TO DO
                tvNhap.append("0");
                break;
            case R.id.btn1:
                //TO DO
                tvNhap.append("1");
                break;
            case R.id.btn2:
                //TO DO
                tvNhap.append("2");
                break;
            case R.id.btn3:
                tvNhap.append("3");
                //TO DO
                break;
            case R.id.btn4:
                //TO DO
                tvNhap.append("4");
                break;
            case R.id.btn5:
                //TO DO
                tvNhap.append("5");
                break;
            case R.id.btn6:
                //TO DO
                tvNhap.append("6");
                break;
            case R.id.btn7:
                //TO DO
                tvNhap.append("7");
                break;
            case R.id.btn8:
                //TO DO
                tvNhap.append("8");
                break;
            case R.id.btn9:
                //TO DO
                tvNhap.append("9");

            case R.id.btnCong:
                //TO DO
                tvNhap.append("+");
                break;
            case R.id.btnTru:
                //TO DO
                tvNhap.append("-");
                break;
            case R.id.btnNhan:
                //TO DO
                tvNhap.append("*");
                break;
            case R.id.btnChia:
                //TO DO
                tvNhap.append("/");
                break;


            case R.id.btnXoa:
                //TO DO
                tvNhap.setText("");
                tvView.setText("");
                break;
            case R.id.btnxanh:
                background.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnDo:
                background.setBackgroundColor(Color.RED);
                break;
            case R.id.btnblue:
                background.setBackgroundColor(Color.BLUE);
                break;

            case R.id.btnBang:


                addOperation(tvNhap.getText().toString());
                addNumber(tvNhap.getText().toString());
                double kq = 0;

                //tinh bieu thuc
                for (int i = 0; i<arrNumber.size()-1;i++){
                    switch (arrOperation.get(i)){
                        case "+":
                            if(i==0){
                                kq = arrNumber.get(i)+arrNumber.get(i+1);
                            }
                            else {
                                kq=kq + arrNumber.get(i+1);
                            }
                            break;
                        case "-":
                            if(i==0){
                                kq = arrNumber.get(i)-arrNumber.get(i+1);
                            }
                            else {
                                kq=kq - arrNumber.get(i+1);
                            }
                            break;
                        case "*":
                            if(i==0){
                                kq = arrNumber.get(i)*arrNumber.get(i+1);
                            }
                            else {
                                kq=kq * arrNumber.get(i+1);
                            }
                            break;
                        case "/":
                            if(i==0){
                                kq = arrNumber.get(i)/arrNumber.get(i+1);
                            }
                            else {
                                kq=kq / arrNumber.get(i+1);
                            }
                            break;
                        default:
                            break;
                    }

                    tvView.setText(kq+ "");
                }


                break;

            default:
                break;


        }

    }
    //Mảng chứa các phép tính +, - , x, /
    public ArrayList<String> arrOperation;
    //Mảng chứa các số
    public ArrayList<Double> arrNumber;

    //Lấy tất cả các phép tính lưu vào mảng arrOperation
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    //Lấy tất cả các số lưu vào mảng arrNumber
    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }

}
