package cn.flyexp.douban_movie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static android.R.attr.id;

/**
 * Created by Won on 2017/4/9.
 */

public class CelebrityDetailModel {

    /**
     * mobile_url : https://movie.douban.com/celebrity/1025146/mobile
     * aka_en : ["Li Lian Jie (本名)"]
     * name : 李连杰
     * works : [{"roles":["演员"],"subject":{"rating":{"max":10,"average":8.4,"stars":"45","min":0},"genres":["短片","脱口秀"],"title":"青年电影馆 第一季","casts":[{"alt":null,"avatars":null,"name":"周星驰 Stephen Chow","id":null},{"alt":null,"avatars":null,"name":"周润发 Yun-Fat Chow","id":null},{"alt":null,"avatars":null,"name":"李连杰 Jet Li","id":null}],"collect_count":204,"original_title":"青年电影馆 第一季","subtype":"tv","directors":[{"alt":null,"avatars":null,"name":"王先华","id":null}],"year":"2013","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2227932525.webp","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2227932525.webp","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2227932525.webp"},"alt":"https://movie.douban.com/subject/26292697/","id":"26292697"}},{"roles":["演员"],"subject":{"rating":{"max":10,"average":8.3,"stars":"45","min":0},"genres":["动作","武侠","古装"],"title":"笑傲江湖2：东方不败","casts":[{"alt":"https://movie.douban.com/celebrity/1025146/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1369201135.38.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1369201135.38.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1369201135.38.jpg"},"name":"李连杰","id":"1025146"},{"alt":"https://movie.douban.com/celebrity/1044746/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/11228.jpg","large":"https://img1.doubanio.com/img/celebrity/large/11228.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/11228.jpg"},"name":"林青霞","id":"1044746"},{"alt":"https://movie.douban.com/celebrity/1028064/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/47411.jpg","large":"https://img3.doubanio.com/img/celebrity/large/47411.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/47411.jpg"},"name":"关之琳","id":"1028064"}],"collect_count":110374,"original_title":"笑傲江湖II東方不敗","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1280664/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/17793.jpg","large":"https://img3.doubanio.com/img/celebrity/large/17793.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/17793.jpg"},"name":"程小东","id":"1280664"}],"year":"1992","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p838966341.webp","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p838966341.webp","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p838966341.webp"},"alt":"https://movie.douban.com/subject/1294417/","id":"1294417"}},{"roles":["演员"],"subject":{"rating":{"max":10,"average":8.1,"stars":"40","min":0},"genres":["动作","剧情"],"title":"精武英雄","casts":[{"alt":"https://movie.douban.com/celebrity/1025146/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1369201135.38.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1369201135.38.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1369201135.38.jpg"},"name":"李连杰","id":"1025146"},{"alt":"https://movie.douban.com/celebrity/1017839/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/35371.jpg","large":"https://img3.doubanio.com/img/celebrity/large/35371.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/35371.jpg"},"name":"中山忍","id":"1017839"},{"alt":"https://movie.douban.com/celebrity/1005415/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1390971515.93.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1390971515.93.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1390971515.93.jpg"},"name":"钱小豪","id":"1005415"}],"collect_count":65627,"original_title":"精武英雄","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1274245/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/41709.jpg","large":"https://img1.doubanio.com/img/celebrity/large/41709.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/41709.jpg"},"name":"陈嘉上","id":"1274245"}],"year":"1994","images":{"small":"https://img5.doubanio.com/view/movie_poster_cover/ipst/public/p1482337156.webp","large":"https://img5.doubanio.com/view/movie_poster_cover/lpst/public/p1482337156.webp","medium":"https://img5.doubanio.com/view/movie_poster_cover/spst/public/p1482337156.webp"},"alt":"https://movie.douban.com/subject/1292895/","id":"1292895"}},{"roles":["演员"],"subject":{"rating":{"max":10,"average":7.9,"stars":"40","min":0},"genres":["动作","武侠","古装"],"title":"少林寺","casts":[{"alt":"https://movie.douban.com/celebrity/1025146/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1369201135.38.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1369201135.38.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1369201135.38.jpg"},"name":"李连杰","id":"1025146"},{"alt":"https://movie.douban.com/celebrity/1312752/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1369884550.09.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1369884550.09.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1369884550.09.jpg"},"name":"于海","id":"1312752"},{"alt":"https://movie.douban.com/celebrity/1274837/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1393514392.38.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1393514392.38.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1393514392.38.jpg"},"name":"丁岚","id":"1274837"}],"collect_count":47640,"original_title":"少林寺","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1274841/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/6613.jpg","large":"https://img3.doubanio.com/img/celebrity/large/6613.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/6613.jpg"},"name":"张鑫炎","id":"1274841"}],"year":"1982","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2379307962.webp","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2379307962.webp","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2379307962.webp"},"alt":"https://movie.douban.com/subject/1301198/","id":"1301198"}},{"roles":["演员"],"subject":{"rating":{"max":10,"average":7.9,"stars":"40","min":0},"genres":["剧情"],"title":"海洋天堂","casts":[{"alt":"https://movie.douban.com/celebrity/1025146/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1369201135.38.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1369201135.38.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1369201135.38.jpg"},"name":"李连杰","id":"1025146"},{"alt":"https://movie.douban.com/celebrity/1011513/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1218.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1218.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1218.jpg"},"name":"文章","id":"1011513"},{"alt":"https://movie.douban.com/celebrity/1215287/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/50270.jpg","large":"https://img3.doubanio.com/img/celebrity/large/50270.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/50270.jpg"},"name":"桂纶镁","id":"1215287"}],"collect_count":118856,"original_title":"海洋天堂","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1275139/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1367827663.92.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1367827663.92.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1367827663.92.jpg"},"name":"薛晓路","id":"1275139"}],"year":"2010","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p504314075.webp","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p504314075.webp","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p504314075.webp"},"alt":"https://movie.douban.com/subject/4004731/","id":"4004731"}}]
     * gender : 男
     * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/1369201135.38.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1369201135.38.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1369201135.38.jpg"}
     * id : 1025146
     * aka : ["李阳中（监制身份名 金庸取）"]
     * name_en : Jet Li
     * born_place : 中国,北京
     * alt : https://movie.douban.com/celebrity/1025146/
     */

    private String mobile_url;
    private String name;
    private String gender;
    private AvatarsBean avatars;
    @SerializedName("id")
    private String celebrity_id;
    private String name_en;
    private String born_place;
    private String alt;
    private List<String> aka_en;
    private List<WorksBean> works;
    private List<String> aka;

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AvatarsBean getAvatars() {
        return avatars;
    }

    public void setAvatars(AvatarsBean avatars) {
        this.avatars = avatars;
    }

    public String getId() {
        return celebrity_id;
    }

    public void setId(String celebrity_id) {
        this.celebrity_id = celebrity_id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getBorn_place() {
        return born_place;
    }

    public void setBorn_place(String born_place) {
        this.born_place = born_place;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public List<String> getAka_en() {
        return aka_en;
    }

    public void setAka_en(List<String> aka_en) {
        this.aka_en = aka_en;
    }

    public List<WorksBean> getWorks() {
        return works;
    }

    public void setWorks(List<WorksBean> works) {
        this.works = works;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class AvatarsBean {
        /**
         * small : https://img1.doubanio.com/img/celebrity/small/1369201135.38.jpg
         * large : https://img1.doubanio.com/img/celebrity/large/1369201135.38.jpg
         * medium : https://img1.doubanio.com/img/celebrity/medium/1369201135.38.jpg
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class WorksBean {
        /**
         * roles : ["演员"]
         * subject : {"rating":{"max":10,"average":8.4,"stars":"45","min":0},"genres":["短片","脱口秀"],"title":"青年电影馆 第一季","casts":[{"alt":null,"avatars":null,"name":"周星驰 Stephen Chow","id":null},{"alt":null,"avatars":null,"name":"周润发 Yun-Fat Chow","id":null},{"alt":null,"avatars":null,"name":"李连杰 Jet Li","id":null}],"collect_count":204,"original_title":"青年电影馆 第一季","subtype":"tv","directors":[{"alt":null,"avatars":null,"name":"王先华","id":null}],"year":"2013","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2227932525.webp","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2227932525.webp","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2227932525.webp"},"alt":"https://movie.douban.com/subject/26292697/","id":"26292697"}
         */

        private MovieSubjectsModel subject;
        private List<String> roles;

        public MovieSubjectsModel getSubject() {
            return subject;
        }

        public void setSubject(MovieSubjectsModel subject) {
            this.subject = subject;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

    }
}
