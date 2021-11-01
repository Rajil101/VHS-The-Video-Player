package com.example.videoplayerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoRVAdapter extends RecyclerView.Adapter<VideoRVAdapter.ViewHolder> {

    private ArrayList<VideoRVModal> videoRVModalArrayList;
    private Context context;
    private VideoClickInterface videoClickInterface;

    public VideoRVAdapter(ArrayList<VideoRVModal> videoRVModalArrayList, Context context, VideoClickInterface videoClickInterface) {
        this.videoRVModalArrayList = videoRVModalArrayList;
        this.context = context;
        this.videoClickInterface = videoClickInterface;
    }

    @NonNull
    @Override
    public VideoRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoRVAdapter.ViewHolder holder,int position) {
        VideoRVModal videoRVModal = videoRVModalArrayList.get(position);
        holder.thumbnailIV.setImageBitmap(videoRVModal.getThumbNail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoClickInterface.onVideoClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoRVModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView thumbnailIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnailIV = itemView.findViewById(R.id.idIVThumbNail);
        }
    }

    public interface VideoClickInterface{
        void onVideoClick(int position);
    }
}
