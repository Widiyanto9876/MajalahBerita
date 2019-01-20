package com.widiyanto.user.majalahberita;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import io.supercharge.shimmerlayout.ShimmerLayout;

public class detail extends AppCompatActivity {

    private TextView Judul;
    private CircleImageView image_deskripsi;
    private TextView mTextJudul1;
    private TextView mDate;
    private ImageView image_detail;
    private TextView mTextDeskripsi1;


//public detail (@NonNull final view item){}
//    mTextJudul = (TextView) itemview.findViewById(R.id.judul_atas);
//            image_deskripsi = (ImageView) itemview.findViewById(R.id.crc_img);
//            mTextJudul1 = (TextView) itemview.findViewById(R.id.tv_judul1);
//            mDate = (TextView) itemview.findViewById(R.id.tv_tanggal);
//            btn1 = (ImageView) itemview.findViewById(R.id.bookmark);
//            image_detail = (ImageView) itemview.findViewById(R.id.img_deskripsi);
//            mTextDeskripsi1 = (TextView) itemview.findViewById(R.id.tv_deskripsi1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Judul = (TextView) findViewById(R.id.judul_atas);
        image_deskripsi = (CircleImageView) findViewById(R.id.crc_img);
        mTextJudul1 = (TextView) findViewById(R.id.tv_judul1);
        mDate = (TextView) findViewById(R.id.tv_tanggal);
        image_detail = (ImageView) findViewById(R.id.img_deskripsi);
        mTextDeskripsi1  = (TextView) findViewById(R.id.tv_deskripsi1);

        ShimmerLayout shimmerText = (ShimmerLayout) findViewById(R.id.shimer);
        shimmerText.startShimmerAnimation();

        Intent intent = getIntent();
        Judul.setText(intent.getStringExtra("Judul"));
        mTextJudul1.setText(intent.getStringExtra("Judul1"));
        mDate.setText(intent.getStringExtra("Tanggal"));
        mTextDeskripsi1.setText(intent.getStringExtra("TextDeskripsi"));


        Glide.with(this)
                .load(intent.getStringExtra("ImageDeskripsi"))
                .into(image_detail);

        Glide.with(this)
                .load(intent.getStringExtra("ImageDeskripsi"))
                .into(image_deskripsi);


    }
}
