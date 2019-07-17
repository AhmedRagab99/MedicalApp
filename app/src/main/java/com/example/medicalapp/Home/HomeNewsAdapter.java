package com.example.medicalapp.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.medicalapp.API.NewsModel.ArticlesItem;
import com.example.medicalapp.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.List;

public class HomeNewsAdapter extends  RecyclerView.Adapter<HomeNewsAdapter.ViewHolder> {


    List<ArticlesItem> articlesItems = new ArrayList<>();
    FoldingCell fc;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        ArticlesItem item = articlesItems.get(position);
        holder.desc.setText(item.getDescription());
        holder.publishedAt.setText(item.getPublishedAt());
        holder.title.setText(item.getTitle());
        Glide.with(holder.itemView)
                .load(item.getUrlToImage())
                .into(holder.imageView1);
        Glide.with(holder.itemView)
                .load(item.getUrlToImage())
                .into(holder.imageView2);


        holder.view2.bringToFront();
        holder.view1.bringToFront();
        holder.view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fcc.toggle(false);
                holder.view2.bringToFront();

            }
        });
        holder.view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fcc.toggle(false);
                holder.view1.bringToFront();

            }
        });
    }

    @Override
    public int getItemCount() {
        if (articlesItems == null)
            return 0;
        else return articlesItems.size();
    }

    public void changeData(List<ArticlesItem> items) {
        articlesItems = items;
        notifyDataSetChanged();

    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView1, imageView2;
        private View view1, view2;
        FoldingCell fcc;
        private TextView title, desc, publishedAt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.news_imageView1);
            imageView2 = itemView.findViewById(R.id.news_imageView2);
            title = itemView.findViewById(R.id.news_titleView1);
            view1 = itemView.findViewById(R.id.view_title);
            view2 = itemView.findViewById(R.id.view_content);
            fcc = (FoldingCell) itemView.findViewById(R.id.folding_cell);
            desc = itemView.findViewById(R.id.news_description);
            publishedAt = itemView.findViewById(R.id.news_date);


        }
    }
}

