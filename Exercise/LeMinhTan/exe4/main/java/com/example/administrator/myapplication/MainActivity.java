package com.example.administrator.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private Button buttonImage;
    private Button buttonVideo;

    private VideoView videoView;
    private ImageView imageView;

    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 99;
    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private static final int REQUEST_ID_VIDEO_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonImage = (Button) this.findViewById(R.id.button_image);
        this.buttonVideo = (Button) this.findViewById(R.id.button_video);
        this.videoView = (VideoView) this.findViewById(R.id.videoView);
        this.imageView = (ImageView) this.findViewById(R.id.imageView);

        this.buttonImage.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage();
            }
        });

        this.buttonVideo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPermissionAndCaptureVideo();
            }
        });
    }

    private void captureImage(){
        //Tạo một Intent không tường minh
        //Để yêu cầu hệ thống mở Camera chuẩn bị hình.
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Start Activity chụp hình, chờ đợi kết quả trả về.
        this.startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);

    }

    private void askPermissionAndCaptureVideo(){

        //Với Android Level >= 23 bạn phải hỏi người dùng cho phép đọc/ghi dữ liệu vào thiết bị.
        if (Build.VERSION.SDK_INT >= 23){

            //Kiểm tra quyền đọc/ghi dữ liệu vào thiết bị lưu trữ ngoài.
            int readPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

            int writePermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED){

                // Nếu không có quyền cần nhắc người dùng cho phép
                this.requestPermissions(
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_ID_READ_WRITE_PERMISSION
                );
                return;
            }
        }
        this.captureVideo();
    }

    private void captureVideo(){

        // Tạo một Intent không tường minh
        // Để yêu cầu hệ thống mở camera chuẩn bị quay.

        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        // Thư mục lưu trữ ngoài
        File dir = Environment.getExternalStorageDirectory();
        if (!dir.exists()){
            dir.mkdirs();
        }

        //file:///storage/emulated/0/myvideo.mp4

        String savePath = dir.getAbsolutePath() + "/myvideo.mp4";
        File videoFile = new File(savePath);
        Uri videoUri = Uri.fromFile(videoFile);

        // Chỉ định vị trí lưu file Video khi quay.
        intent.putExtra(MediaStore.EXTRA_OUTPUT, videoUri);

        // Start Activity quay video và chờ kết quả trả về
        this.startActivityForResult(intent, REQUEST_ID_VIDEO_CAPTURE);


    }
    // Khi yêu cầu hỏi người dùng được trả về (Chấp nhận hoặc không chấp nhận)

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //
        switch (requestCode){
            case REQUEST_ID_READ_WRITE_PERMISSION:{
                // Chú ý: Nếu yêu cầu bị hủy, mảng kết quả trả về là rỗng
                // Người dùng đã cấp quyền (đọc/ghi)
                if (grantResults.length > 1
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission granted!", Toast.LENGTH_LONG).show();

                    this.captureVideo();
                }

                // Hủy bỏ và từ chối
                else {
                    Toast.makeText(this, "Permission denied!", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }

    // Khi activity chụp hình hoặc quay video hoàn thành, phương thức này sẽ gọi

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ID_IMAGE_CAPTURE){
            if (resultCode == RESULT_OK){
                Bitmap bp = (Bitmap) data.getExtras().get("data");

                Toast.makeText(this, "height: " + bp.getHeight(), Toast.LENGTH_LONG).show();

                this.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                this.imageView.setImageBitmap(bp);
            }
            else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Action Canceled", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this,"Action Failed", Toast.LENGTH_LONG).show();
            }
        }
        else if (requestCode == REQUEST_ID_VIDEO_CAPTURE){
            if (resultCode == RESULT_OK){
                Uri videoUri = data.getData();
                Log.i("MyLong", "Video saved to" + videoUri);
                Toast.makeText(this, "Video saved to:\n"+ videoUri, Toast.LENGTH_LONG).show();
                this.videoView.setVideoURI(videoUri);
                this.videoView.start();

            }
            else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Action Canceled", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();
            }
        }
    }
}
