package cn.flyexp.douban_movie.model;

import java.util.List;

/**
 * Created by Won on 2017/3/13.
 */

public class MovieModel {

    /**
     * count : 20
     * start : 0
     * total : 19947
     * title : 搜索 "喜剧" 的结果
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<MovieSubjectsModel> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieSubjectsModel> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MovieSubjectsModel> subjects) {
        this.subjects = subjects;
    }

}
