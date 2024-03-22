package com.example.webviewapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webviewapp.CateModal;
import com.example.webviewapp.MainActivity;
import com.example.webviewapp.R;
import com.example.webviewapp.WebViewActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdatpter extends RecyclerView.Adapter<CategoryAdatpter.myViewHolder> {
    Context context;
    ArrayList<CateModal> cateList;

    public CategoryAdatpter(Context context, ArrayList<CateModal> cateList) {
        this.cateList = cateList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View photoView = inflater.inflate(R.layout.layout_cate, parent, false);
        myViewHolder viewHolder = new myViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.tvCate.setText(cateList.get(position).getName());
        Picasso.get().load(cateList.get(position).getImg()).into(holder.ivImage);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, WebViewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("name", cateList.get(position).getName());
            bundle.putString("url", cateList.get(position).getUrl());
            intent.putExtras(bundle);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return cateList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvCate;
        ImageView ivImage;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCate = (TextView) itemView.findViewById(R.id.tvCate);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
        }
    }
}
