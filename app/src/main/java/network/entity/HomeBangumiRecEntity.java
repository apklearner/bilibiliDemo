package network.entity;

import java.util.List;

/**
 * Created by ly on 2017/2/21.
 */

public class HomeBangumiRecEntity {
    /**
     * code : 0
     * message : success
     * result : [{"cover":"http://i0.hdslb.com/bfs/bangumi/4dc65a7baed39a737d3f6d1d013a3b4b4bedb362.jpg","cursor":1487635200911,"desc":"大早上的看恐怖泡面是不是会特别爽？","id":3643,"is_new":1,"link":"http://bangumi.bilibili.com/anime/2795","onDt":"2017-02-21 08:00:00","title":"【泡面档】KOWABON"},{"cover":"http://i0.hdslb.com/bfs/bangumi/7a3a43959444ed1cf06dcc3b29a0675e22e05009.jpg","cursor":1487584800521,"desc":"需要表达意见的时候\n壁咚一下可以收到更好的效果","id":3642,"is_new":1,"link":"http://bangumi.bilibili.com/anime/5787","onDt":"2017-02-20 18:00:00","title":"偶像选举 07"},{"cover":"http://i0.hdslb.com/bfs/bangumi/f82a3650e1c8d0ace840bb9ba8b4616bd6833666.jpg","cursor":1487498400774,"desc":"番剧年终盘点来了\n是时候拿出数据去安利小伙伴啦","id":3640,"is_new":1,"link":"http://www.bilibili.com/blackboard/activity-rylsFtGte.html","onDt":"2017-02-19 18:00:00","title":"2016番剧年终盘点"},{"cover":"http://i0.hdslb.com/bfs/bangumi/7043dfca4cd6fa0ffcc4cda6e11f512fb83b2208.jpg","cursor":1487412000022,"desc":"梦境是现实，现实是梦境？\n每个人都能有自己的理解","id":3615,"is_new":1,"link":"http://bangumi.bilibili.com/anime/3673","onDt":"2017-02-18 18:00:00","title":"【周末剧场】阿茹茉妮"},{"cover":"http://i0.hdslb.com/bfs/bangumi/09b2846a0cbb3bc1d80351a9508051d269c2ce0b.jpg","cursor":1487325600332,"desc":"对这个四月充满了期待","id":3629,"link":"http://www.bilibili.com/blackboard/activity-SJu83ZmKg.html","onDt":"2017-02-17 18:00:00","title":"【资讯档】2017年第7周资讯pick up！"},{"author":"5798","cover":"http://i0.hdslb.com/bfs/bangumi/70c2865bbcf4fbfa20cc401b0e69e790eee7c664.jpg","cursor":1487239200584,"desc":"妹妹的生活指导第二条\n累了就要好好休息","id":3621,"link":"http://bangumi.bilibili.com/anime/5798","onDt":"2017-02-16 18:00:00","title":"One Room 06"},{"cover":"http://i0.hdslb.com/bfs/bangumi/790c62dc1d7752620e486480230bc01f4886cd46.jpg","cursor":1487156400759,"desc":"小哥哥们真是越来越会玩了\n后面还有喂食镜头哦！","id":3616,"link":"http://bangumi.bilibili.com/anime/5061","onDt":"2017-02-15 19:00:00","title":"梦之祭！研究室 16"},{"cover":"http://i0.hdslb.com/bfs/bangumi/1e16d5528b69463ffee69572b01ef5ad9405ce54.jpg","cursor":1487066400330,"desc":"听说学生会的新成员\n是\u201c美少女\u201d","id":3606,"link":"http://bangumi.bilibili.com/anime/3227","onDt":"2017-02-14 18:00:00","title":"【泡面档】搞姬日常"},{"cover":"http://i0.hdslb.com/bfs/bangumi/976b4fd8eab8219746303f451e1bf2f4fee24e87.jpg","cursor":1486958520308,"desc":"经验多了，大家都会一样熟练（不","id":3588,"link":"http://www.bilibili.com/blackboard/activity-S1lkwcYue.html","onDt":"2017-02-13 12:02:00","title":"【番箱子vol.05】白色相簿2"},{"cover":"http://i0.hdslb.com/bfs/bangumi/9a599e78f6b3d066e42358bca7b174581f3d4e8d.jpg","cursor":1486807200971,"desc":"洗桑拿也可以出冷汗，泡澡也能前往天堂\n佛祖和耶稣在现代的轻松生活","id":3570,"link":"http://bangumi.bilibili.com/anime/3230","onDt":"2017-02-11 18:00:00","title":"【周末剧场】圣哥传"}]
     */

    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * cover : http://i0.hdslb.com/bfs/bangumi/4dc65a7baed39a737d3f6d1d013a3b4b4bedb362.jpg
         * cursor : 1487635200911
         * desc : 大早上的看恐怖泡面是不是会特别爽？
         * id : 3643
         * is_new : 1
         * link : http://bangumi.bilibili.com/anime/2795
         * onDt : 2017-02-21 08:00:00
         * title : 【泡面档】KOWABON
         * author : 5798
         */

        private String cover;
        private long cursor;
        private String desc;
        private int id;
        private int is_new;
        private String link;
        private String onDt;
        private String title;
        private String author;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public long getCursor() {
            return cursor;
        }

        public void setCursor(long cursor) {
            this.cursor = cursor;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIs_new() {
            return is_new;
        }

        public void setIs_new(int is_new) {
            this.is_new = is_new;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getOnDt() {
            return onDt;
        }

        public void setOnDt(String onDt) {
            this.onDt = onDt;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
