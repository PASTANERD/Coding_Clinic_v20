package com.example.a0xbistrot.codingcleanic_v20.ui.feed;

import android.view.ViewGroup;

import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseRecyclerViewAdapter;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseViewHolder;

public class FeedAdapter extends BaseRecyclerViewAdapter{

//public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final String TAG = getClass().getSimpleName();

    @Override
    protected BaseViewHolder getViewHolder(int viewType, ViewGroup parent) {
        return new FeedViewHolder(parent);
    }


    /*
    private List<FeedItem> feedItems = new ArrayList<>();
    //private List<Integer> imageIds = new ArrayList<>();
    //private List<String> dateList = new ArrayList<>();


    public void addAll(List<FeedItem> items){
        feedItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed,parent,false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder");
        FeedViewHolder feedViewHolder = (FeedViewHolder) holder;
        feedViewHolder.bind((feedItems.get(position)));

        //feedViewHolder.bind(imageIds.get(position), dateList.get(position));
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    */
}
