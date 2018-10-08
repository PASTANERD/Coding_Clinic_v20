package com.example.a0xbistrot.coding_clinic_v20.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a0xbistrot.coding_clinic_v20.R;
import com.example.a0xbistrot.coding_clinic_v20.object.ViewItem;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        ImageView user_pic;
        ImageView content_pic;
        TextView user_id;
        TextView content_string;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            user_pic = itemView.findViewById(R.id.user_pic);
            content_pic = itemView.findViewById(R.id.content_pic);
            user_id = itemView.findViewById(R.id.user_id);
            content_string = itemView.findViewById(R.id.content_string);
        }
    }

    private ArrayList<ViewItem> viewItemArrayList;

    public RecyclerAdapter(ArrayList<ViewItem> foodInfoArrayList){
        this.viewItemArrayList = foodInfoArrayList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_recycler_board, viewGroup, false);

        return new RecyclerViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        RecyclerViewHolder myViewHolder = (RecyclerViewHolder) viewHolder;

        myViewHolder.user_pic.setImageResource(viewItemArrayList.get(i).drawable_user_pic);
        myViewHolder.user_id.setText(viewItemArrayList.get(i).user_name);
        myViewHolder.content_pic.setImageResource(viewItemArrayList.get(i).drawable_content_pic);
        myViewHolder.content_string.setText(viewItemArrayList.get(i).content_string);
    }

    @Override
    public int getItemCount() {
        return viewItemArrayList.size();
    }
}
