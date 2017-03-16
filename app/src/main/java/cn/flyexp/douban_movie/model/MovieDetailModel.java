package cn.flyexp.douban_movie.model;

import java.util.List;

/**
 * Created by Won on 2017/3/15.
 */

public class MovieDetailModel {


    /**
     * rating : {"max":10,"average":8.4,"stars":"45","min":0}
     * reviews_count : 730
     * wish_count : 16111
     * douban_site :
     * year : 1999
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p1043597424.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p1043597424.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p1043597424.jpg"}
     * alt : https://movie.douban.com/subject/1302425/
     * id : 1302425
     * mobile_url : https://movie.douban.com/subject/1302425/mobile
     * title : 喜剧之王
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/1302425
     * seasons_count : null
     * schedule_url :
     * episodes_count : null
     * countries : ["香港"]
     * genres : ["喜剧","剧情","爱情"]
     * collect_count : 361263
     * casts : [{"alt":"https://movie.douban.com/celebrity/1048026/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/47421.jpg","large":"https://img3.doubanio.com/img/celebrity/large/47421.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/47421.jpg"},"name":"周星驰","id":"1048026"},{"alt":"https://movie.douban.com/celebrity/1003495/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1394446025.33.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1394446025.33.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1394446025.33.jpg"},"name":"张柏芝","id":"1003495"},{"alt":"https://movie.douban.com/celebrity/1018248/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/27003.jpg","large":"https://img3.doubanio.com/img/celebrity/large/27003.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/27003.jpg"},"name":"莫文蔚","id":"1018248"},{"alt":"https://movie.douban.com/celebrity/1016771/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/45481.jpg","large":"https://img3.doubanio.com/img/celebrity/large/45481.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/45481.jpg"},"name":"吴孟达","id":"1016771"}]
     * current_season : null
     * original_title : 喜劇之王
     * summary : 尹天仇（周星驰 饰）一直醉心戏剧，想成为一名演员，平时除了做跑龙套以外，还会在街坊福利会里开设演员训练班。此时舞小姐柳飘飘在妈妈桑的带领下来到这里要求学做戏，原来柳飘飘有一段非常不愉快的经历，在尹天仇对她指导的过程中，柳飘飘对尹天仇渐生情愫，同时她也成为了夜总会里当红的小姐。尹天仇受到了极多白眼之后，终于得到了大明星鹃姐（莫文蔚 饰）的赏识，提携他担演新戏中的男主角，但没想到突然把他的角色换掉了，令他失望不已。在片场当场务的卧底警员（吴孟达 饰）身份被识穿，尹天仇阴差阳错的帮忙破了案。之后尹天仇继续活跃在街坊福利会的演员训练班里。©豆瓣
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1048026/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/47421.jpg","large":"https://img3.doubanio.com/img/celebrity/large/47421.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/47421.jpg"},"name":"周星驰","id":"1048026"},{"alt":"https://movie.douban.com/celebrity/1274246/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/51748.jpg","large":"https://img1.doubanio.com/img/celebrity/large/51748.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/51748.jpg"},"name":"李力持","id":"1274246"}]
     * comments_count : 43428
     * ratings_count : 269879
     * aka : ["King of Comedy"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private String share_url;
    private String schedule_url;
    private int collect_count;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 8.4
         * stars : 45
         * min : 0
         */

        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p1043597424.jpg
         * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p1043597424.jpg
         * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p1043597424.jpg
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

    public static class CastsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1048026/
         * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/47421.jpg","large":"https://img3.doubanio.com/img/celebrity/large/47421.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/47421.jpg"}
         * name : 周星驰
         * id : 1048026
         */

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : https://img3.doubanio.com/img/celebrity/small/47421.jpg
             * large : https://img3.doubanio.com/img/celebrity/large/47421.jpg
             * medium : https://img3.doubanio.com/img/celebrity/medium/47421.jpg
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
    }

    public static class DirectorsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1048026/
         * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/47421.jpg","large":"https://img3.doubanio.com/img/celebrity/large/47421.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/47421.jpg"}
         * name : 周星驰
         * id : 1048026
         */

        private String alt;
        private AvatarsBeanX avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : https://img3.doubanio.com/img/celebrity/small/47421.jpg
             * large : https://img3.doubanio.com/img/celebrity/large/47421.jpg
             * medium : https://img3.doubanio.com/img/celebrity/medium/47421.jpg
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
    }
}
