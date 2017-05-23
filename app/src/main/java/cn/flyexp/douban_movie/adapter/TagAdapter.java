package cn.flyexp.douban_movie.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.flyexp.douban_movie.R;

/**
 * Created by Won on 2017/3/13.
 */

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.MyViewHolder> {

    private String[] tags = null;

    public TagAdapter(String[] tags) {
        this.tags = tags;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mian_tag_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.btMainTagItem.setText(tags[position]);
        holder.btMainTagItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(tags[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tags == null ? 0 : tags.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.bt_main_tag_item)
        TextView btMainTagItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private IOnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(IOnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface IOnItemClickListener{
        void onItemClick(String tag);
    }

}
