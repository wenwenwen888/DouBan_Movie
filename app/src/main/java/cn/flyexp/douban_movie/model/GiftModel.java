package cn.flyexp.douban_movie.model;

import java.util.List;

/**
 * Created by Won on 2017/5/13.
 */

public class GiftModel {

    /**
     * error : false
     * results : [{"_id":"59154ae7421aa90c7a8b2b0d","createdAt":"2017-05-12T13:40:55.505Z","desc":"5-13","publishedAt":"2017-05-12T13:44:54.673Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-12-18380140_455327614813449_854681840315793408_n.jpg","used":true,"who":"daimajia"},{"_id":"5913d09d421aa90c7fefdd8e","createdAt":"2017-05-11T10:46:53.608Z","desc":"5-11","publishedAt":"2017-05-11T12:03:09.581Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-11-18380166_305443499890139_8426655762360565760_n.jpg","used":true,"who":"代码家"},{"_id":"591264ce421aa90c7a8b2aec","createdAt":"2017-05-10T08:54:38.531Z","desc":"5-10","publishedAt":"2017-05-10T11:56:10.18Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-10-18382517_1955528334668679_3605707761767153664_n.jpg","used":true,"who":"带马甲"},{"_id":"59110cff421aa90c83a513ff","createdAt":"2017-05-09T08:27:43.31Z","desc":"5-9","publishedAt":"2017-05-09T12:13:25.467Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-09-18443931_429618670743803_5734501112254300160_n.jpg","used":true,"who":"daimajia"},{"_id":"590fe059421aa90c83a513f2","createdAt":"2017-05-08T11:04:57.969Z","desc":"5-8","publishedAt":"2017-05-08T11:22:01.540Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-08-18252341_289400908178710_9137908350942445568_n.jpg","used":true,"who":"daimajia"},{"_id":"590bce25421aa90c7d49ad3c","createdAt":"2017-05-05T08:58:13.502Z","desc":"5-5","publishedAt":"2017-05-05T11:56:35.629Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-05-18251898_1013302395468665_8734429858911748096_n.jpg","used":true,"who":"daimajia"},{"_id":"590a791e421aa90c83a513d1","createdAt":"2017-05-04T08:43:10.164Z","desc":"5-4","publishedAt":"2017-05-04T11:43:26.66Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-04-18299181_1306649979420798_1108869403736276992_n.jpg","used":true,"who":"daimajia"},{"_id":"58fb32cb421aa9544b774054","createdAt":"2017-04-22T18:39:07.864Z","desc":"浅川梨奈","publishedAt":"2017-05-03T12:00:31.516Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/61e74233ly1feuogwvg27j20p00zkqe7.jpg","used":true,"who":"小萝莉快过来叔叔帮你检查身体"},{"_id":"5907cf57421aa90c7d49ad19","createdAt":"2017-05-02T08:14:15.561Z","desc":"5-2","publishedAt":"2017-05-02T12:00:17.802Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-02-926821_1453024764952889_775781470_n.jpg","used":true,"who":"daimajia"},{"_id":"59029242421aa9544ed889ff","createdAt":"2017-04-28T08:52:18.878Z","desc":"4-28","publishedAt":"2017-04-28T11:49:38.12Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-28-18094719_120129648541065_8356500748640452608_n.jpg","used":true,"who":"daimajia"},{"_id":"59013b1a421aa9544b774088","createdAt":"2017-04-27T08:28:10.755Z","desc":"4-27","publishedAt":"2017-04-27T13:16:46.955Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-27-17934080_117414798808566_8957027985114791936_n.jpg?imageslim","used":true,"who":"daimajia"},{"_id":"58ffe1b5421aa9544ed889e6","createdAt":"2017-04-26T07:54:29.874Z","desc":"4-26","publishedAt":"2017-04-26T11:30:43.767Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-25-13651793_897557617014845_571817176_n.jpg","used":true,"who":"daimajia"},{"_id":"58fe8e05421aa9544b77406d","createdAt":"2017-04-25T07:45:09.55Z","desc":"4-25","publishedAt":"2017-04-25T13:11:39.357Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-24-18013547_1532023163498554_215541963087151104_n.jpg","used":true,"who":"dmj"},{"_id":"58fd4b4a421aa9544825f8f7","createdAt":"2017-04-24T08:48:10.92Z","desc":"4-24","publishedAt":"2017-04-24T11:35:03.680Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-24-18094714_158946097967074_5909424912493182976_n.jpg","used":true,"who":"dmj"},{"_id":"58f95b74421aa954511ebedf","createdAt":"2017-04-21T09:08:04.293Z","desc":"4-21","publishedAt":"2017-04-21T11:30:29.323Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-21-18013964_1389732981073150_4044061109068496896_n.jpg","used":true,"who":"daimajia"},{"_id":"58f8043e421aa9544ed88993","createdAt":"2017-04-20T08:43:42.333Z","desc":"4-20","publishedAt":"2017-04-20T14:03:06.490Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-20-17932350_1238028809599424_2089669844847820800_n.jpg","used":true,"who":"daimajia"},{"_id":"58f6baad421aa954511ebec3","createdAt":"2017-04-19T09:17:33.987Z","desc":"4-19","publishedAt":"2017-04-19T11:44:51.925Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-19-17881407_1845958195665029_1132383288824954880_n.jpg","used":true,"who":"daimajia"},{"_id":"58f5649b421aa9544825f89f","createdAt":"2017-04-18T08:58:03.511Z","desc":"4-18","publishedAt":"2017-04-18T11:34:29.203Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-18-17882540_190116561497334_440657494176432128_n.jpg","used":true,"who":"带马甲"},{"_id":"58f3980c421aa9544b773ff1","createdAt":"2017-04-17T00:13:00.136Z","desc":"4-17","publishedAt":"2017-04-17T11:32:14.674Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-16-17934400_1738549946443321_2924146161843437568_n.jpg","used":true,"who":"daimajia"},{"_id":"58f0438f421aa9544825f873","createdAt":"2017-04-14T11:35:43.995Z","desc":"4-14","publishedAt":"2017-04-14T11:46:48.47Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-14-17881962_1329090457138411_8289893708619317248_n.jpg","used":true,"who":"代码家"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 59154ae7421aa90c7a8b2b0d
         * createdAt : 2017-05-12T13:40:55.505Z
         * desc : 5-13
         * publishedAt : 2017-05-12T13:44:54.673Z
         * source : chrome
         * type : 福利
         * url : http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-12-18380140_455327614813449_854681840315793408_n.jpg
         * used : true
         * who : daimajia
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
