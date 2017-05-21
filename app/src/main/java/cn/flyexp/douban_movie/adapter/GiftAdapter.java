package cn.flyexp.douban_movie.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.model.GiftModel;

/**
 * Created by Won on 2017/5/13.
 */

public class GiftAdapter extends RecyclerView.Adapter<GiftAdapter.MyViewHolder> {
    private static final String TAG = "GiftAdapter";

    private List<GiftModel.ResultsBean> giftModels = new ArrayList<>();

    public GiftAdapter(List<GiftModel.ResultsBean> giftModels) {
        this.giftModels = giftModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gift_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).load(giftModels.get(position).getUrl()).
                diskCacheStrategy(DiskCacheStrategy.SOURCE).crossFade().into(holder.ivGift);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return giftModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_gift)
        ImageView ivGift;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private IOnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(IOnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface IOnItemClickListener {
        void onItemClick(int position);
    }

}
