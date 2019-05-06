package com.example.minhtantt7;

import android.app.Dialog;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;



/*  */

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {
   //Khai Báo

    private Button btnBatDau;
    private Button btnSetTime;
    private Button btnOOF;
    private TextView txtTime;
    CountDownTimer countDownTimer;
    private int hour = 0;
    private int minute = 0;
    private int seconds = 0;
    private boolean timerRuning;
    private boolean play;
    private long time = 0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh Xạ

        btnBatDau = (Button)findViewById(R.id.btnBatDau);
        btnSetTime= (Button)findViewById(R.id.btnSetTime);
        btnOOF = (Button)findViewById(R.id.btnOOF);
        txtTime = (TextView) findViewById(R.id.txtTime);




       // Hoạt Động sau khi nhấn  Đặt Thời Gian
    btnSetTime.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            show(); // Gọi Hàm Show()
        }
    });

    // // Hoạt Động sau khi nhấn  Bắt Đầu
    btnBatDau.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startStop(); // Gọi Hàm startStop()
        }
    });


    }


    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        Log.i("value is",""+newVal); // xem chỉ số thay đổi trong Logcat
    }

    // Hàm Show() khởi động dialog
    public void show()
    {

        final Dialog d = new Dialog(MainActivity.this); // khai báo và tạo mới dialog
        d.setTitle("NumberPicker"); // đặt tiêu đề dialog
        d.setContentView(R.layout.my_time_picker);  // gọi UI dialog  giao diện my_time_picker.xml
        Button set = (Button) d.findViewById(R.id.set); // ánh xạ Button set
        Button cancel = (Button) d.findViewById(R.id.cancel); // ''''''' cancel
        final NumberPicker npHour = (NumberPicker) d.findViewById(R.id.npHour); // ánh xạ NumperPicker
        final NumberPicker npMinute = (NumberPicker) d.findViewById(R.id.npMinute);
        final NumberPicker npSeconds = (NumberPicker) d.findViewById(R.id.npSeconds);
        npHour.setMaxValue(23); // set giá trị tối đa cua npHour là 23
        npHour.setMinValue(00);//set giá trị tối thiểu là 00
        npHour.setWrapSelectorWheel(false); //Nhận được liệu wheel chọn có kết thúc tốt đẹp khi đạt giá trị tối thiểu / tối đa hay không.
        npHour.setOnValueChangedListener(this);// Dùng màn hình hiện tại nhận  những thay đổi của giá trị hiện tại
        npMinute.setMaxValue(59);
        npMinute.setMinValue(00);
        npMinute.setWrapSelectorWheel(false);
        npMinute.setOnValueChangedListener(this);
        npSeconds.setMaxValue(59);
        npSeconds.setMinValue(00);
        npSeconds.setWrapSelectorWheel(false);
        npSeconds.setOnValueChangedListener(this);
        set.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                hour = npHour.getValue(); // biến hour bằng giá trị của numper picker nphour sau khi pick
                minute = npMinute.getValue();
                seconds =npSeconds.getValue();
                time = ((seconds%60)*1000) + ((minute%60)*(1000*60)) + ((hour%24)*(1000*60*60)) ; // Biến time  = tổng số hour minute và secon quy đổi sang millisecond
                updateTime(); // khởi động hàm update();
                btnBatDau.setEnabled(true); // cho phép nhấn button Bắt đầu
                d.dismiss(); // Tắt dialog sau khi chọn xopng giá trị
            }
        });
        cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        }); // bấm cacel sec tắt dialog và không có giá trị được nhận
        d.show(); // hiện dialog


    }
    // hàm satrtStop diều chỉnh quá trình chạy
    public void startStop(){
        if(timerRuning) {
            stopTimer(); // nếu biến timeruning TRUE  khởi chạy hàm stopTimer();
        }
        else{
            startTimer();// ngược lại khởi chạy hàm startTimer();
        }


    }
    // hàm chuyển 2 chữ số
    private String twoDigitString(long number) {

        if (number == 0) {
            return "00"; // số cho vào = 0 chuyển thành 00
        }

        if (number / 10 == 0) {
            return "0" + number; // số cho vào chia 10 = 0 (Nhỏ hơn 10) thêm 0 trước số đó
        }

        return String.valueOf(number);
    }

    // Hàm chuyển đổi thời gian sang chuỗi ....
    //Đưa vào số millisecond và trả về chuỗi Giờ : Phút : giây tương ứng sau khi đã được chuyển 2 chữ số
    private String formatMilliSecondsToTime(long milliseconds) {

        int seconds = (int) (milliseconds / 1000) % 60;
        int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
        int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
        return twoDigitString(hours) + " : " + twoDigitString(minutes) + " : "
                + twoDigitString(seconds);
    }
    // Hàm Đếm Ngược coundown
    public void startTimer(){
        countDownTimer = new CountDownTimer(time,1000) { // cho vào giá trị millisecon và đếm mỗi 1000 milliseond
            @Override
            public void onTick(long millisUntilFinished) {
                time = millisUntilFinished; // kết Thúc sau khi số lượng đếm được bằng số đưa vào
                updateTime();


            }

            /************************* SAU KHI ĐẾM XONG THÌ THỰC HIỆN : ********************************************/
            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"HẾT GIỜ !!!" ,Toast.LENGTH_LONG).show(); // Thông Báo Hết Giờ
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);     // Phát Âm Thanh Thông Báo
                final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                r.play();

                txtTime.setTextColor(getColor(R.color.RedAlert)); // Đổi  Màu chữ Text View
                btnBatDau.setVisibility(View.GONE); // Ân Buuton Bắt Đầu, Chọn Tg
                btnSetTime.setVisibility(View.GONE);
                btnOOF.setVisibility(View.VISIBLE); // Hiện Button Ngừng

// Hiệu Ung Blink cho TextView
                final Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(100); //You can manage the blinking time with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                txtTime.startAnimation(anim);

                btnOOF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r.stop(); // Tắt Âm
                        btnBatDau.setVisibility(View.VISIBLE); //Hiện Buuton Bắt Đầu, Chọn Tg
                        btnSetTime.setVisibility(View.VISIBLE);
                        btnOOF.setVisibility(View.GONE);  // ẩn Button Ngừng
                        txtTime.setTextColor(getColor(R.color.Black)); // Đổi màu TextView
                        stopTimer(); // Tắt Đếm Ngược
                        anim.setRepeatCount(0); // Tắt Blink



                    }
                });



            }
        }.start();
        btnBatDau.setText("Tạm Dừng"); // đổi nút bắt đầu thành tạm dừng
        btnBatDau.setBackgroundColor(getColor(R.color.colorAccent)); // đổi màu nút bắt đầu
        btnSetTime.setEnabled(false); // tắt nút Chọn giờ
        timerRuning = true; // Biến Timeruning = TRUE

    }

    public void stopTimer(){
        countDownTimer.cancel(); // Dừng Bộ Đếm
        btnBatDau.setText("Bắt Đầu");// đổi lại Nút Bắt Đầu
        btnBatDau.setBackgroundColor(getColor(R.color.colorDefaul)); // Đổi Lại Màu Nút
        btnSetTime.setEnabled(true); //cho phép Chọn thời Gian
        timerRuning = false; // Biến TimeRunning FALSE
    }
    public void updateTime(){
         txtTime.setText(formatMilliSecondsToTime(time)); // Sửa Gía Trị TextView =  Chuỗi Thời gian đã được chuyển


    }
}
