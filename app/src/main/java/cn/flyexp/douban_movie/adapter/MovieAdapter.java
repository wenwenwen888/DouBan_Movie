package cn.flyexp.douban_movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.model.MovieModel;

import static cn.flyexp.douban_movie.R.string.director;

/**
 * Created by Won on 2017/3/11.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private ArrayList<MovieModel.SubjectsBean> movieModel = new ArrayList<>();

    public MovieAdapter(ArrayList<MovieModel.SubjectsBean> movieModel) {
        this.movieModel = movieModel;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        final MovieModel.SubjectsBean subjectsBean = movieModel.get(position);
        //加载图片
        Glide.with(context).load(subjectsBean.getImages().getMedium()).into(holder.imgMovie);
        //设置title
        holder.tvMovieTitle.setText(subjectsBean.getTitle());
        //设置导演
        String directors = "";
        for (int i = 0; i < subjectsBean.getDirectors().size(); i++) {
            MovieModel.SubjectsBean.DirectorsBean director = subjectsBean.getDirectors().get(i);
            if (i == subjectsBean.getDirectors().size() - 1) {
                directors = directors + director.getName();
            } else {
                directors = directors + director.getName() + "、";
            }
        }
        holder.tvMovieDirector.setText(String.format(context.getResources().getString(director), directors));
        //设置主演
        String casts = "";
        for (int i = 0; i < subjectsBean.getCasts().size(); i++) {
            MovieModel.SubjectsBean.CastsBean cats = subjectsBean.getCasts().get(i);
            if (i == subjectsBean.getCasts().size() - 1) {
                casts = casts + cats.getName();
            } else {
                casts = casts + cats.getName() + "、";
            }
        }
        holder.tvMovieCast.setText(String.format(context.getResources().getString(R.string.cast), casts));
        //设置分数
        holder.tvMovieAverage.setText(String.format(context.getResources().getString(R.string.average), "" + subjectsBean.getRating().getAverage()));
        //点击回调
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(subjectsBean.getId(), subjectsBean.getImages().getLarge(), subjectsBean.getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieModel.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_movie)
        ImageView imgMovie;
        @BindView(R.id.tv_movie_title)
        TextView tvMovieTitle;
        @BindView(R.id.tv_movie_director)
        TextView tvMovieDirector;
        @BindView(R.id.tv_movie_cast)
        TextView tvMovieCast;
        @BindView(R.id.tv_movie_average)
        TextView tvMovieAverage;

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
        void onItemClick(String id, String img_url, String title);
    }

}
