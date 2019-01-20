package com.widiyanto.user.majalahberita.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.widiyanto.user.majalahberita.Entity.BeritaArtikelData;
import com.widiyanto.user.majalahberita.Entity.BeritaEntity;
import com.widiyanto.user.majalahberita.R;
import com.widiyanto.user.majalahberita.detail;

import java.util.Date;
import java.util.List;

public class CardViewBerita extends RecyclerView.Adapter<CardViewBerita.CardViewHolder> {
    private List<BeritaArtikelData> listberita;
    private Context context;

    public CardViewBerita(List<BeritaArtikelData> listberita, Context context) {
        this.listberita = listberita;
        this.context = context;
    }

    public void addItem(int position){
        notifyItemInserted(position);
    }


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_berita, parent, false);
        return new CardViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int i) {
        BeritaArtikelData beritaEntity = listberita.get(i);

        Glide.with(context)
                .load(beritaEntity.getUrlImage())
                .into(holder.image_berita);

        Log.i("xxxx", "author : " + beritaEntity.getAuthor());

        if (beritaEntity.getAuthor() != null) {
            holder.mTextJudul.setText(beritaEntity.getAuthor());
        }
        if (beritaEntity.getDescription() != null) {
            holder.mTextDeskripsi.setText(beritaEntity.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return listberita.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private ImageView image_berita;  // image awal di item
        private ImageView image_deskripsi; // image crc di detail
        private ImageView image_detail;      //image detail
        private TextView mTextJudul;        //text title awal
        private TextView mTextJudul1;       // text judul di detai;
        private TextView mTextDeskripsi;    //text deskrpsi di awal/item
        private TextView mTextDeskripsi1;   //text deskripsi buat halaman detail
        private TextView mDate;             //text taggal
        private Button btn;                 //button detail
        private ImageView btn1;             //button favorite

        public CardViewHolder(@NonNull final View itemview) {
            super(itemview);
            //Tampilan awal item
            image_berita = (ImageView) itemview.findViewById(R.id.img_berita);
            mTextJudul = (TextView) itemview.findViewById(R.id.tv_title);
            mTextDeskripsi = (TextView) itemview.findViewById(R.id.tv_desk_awal);
            btn = (Button) itemview.findViewById(R.id.btn_detail);


//
//
//            tampilan isi detail
//            mTextJudul = (TextView) itemview.findViewById(R.id.judul_atas);
//            image_deskripsi = (ImageView) itemview.findViewById(R.id.crc_img);
//            mTextJudul1 = (TextView) itemview.findViewById(R.id.tv_judul1);
//            mDate = (TextView) itemview.findViewById(R.id.tv_tanggal);
//            btn1 = (ImageView) itemview.findViewById(R.id.bookmark);
//            image_detail = (ImageView) itemview.findViewById(R.id.img_deskripsi);
//            mTextDeskripsi1 = (TextView) itemview.findViewById(R.id.tv_deskripsi1);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BeritaArtikelData data = listberita.get(getLayoutPosition());
                    Intent intent = new Intent(context, detail.class);
                    intent.putExtra("Judul",data.getTitle());
                    intent.putExtra("Judul1",data.getTitle());
                    intent.putExtra("Tanggal",data.getPublishedAt());
                    intent.putExtra("ImageDeskripsi",data.getUrlImage());
                    intent.putExtra("TextDeskripsi",data.getContent());
                    context.startActivity(intent);

                }
            });


        }
    }
}
