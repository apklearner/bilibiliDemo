package network.entity;

import java.util.List;

/**
 * Created by ly on 2017/2/21.
 */

public class HomeBangumiMainEntity {
    /**
     * code : 0
     * message : success
     * result : {"banners":[{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/27eb75aaef49ff24fe3a4620be72aacfb16c7ee6.jpg","link":"http://bangumi.bilibili.com/anime/5794","pub_time":"2017-02-21 01:35:00","title":"飙速宅男 新世代"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/a5fd7006d3a30800bf2f251b8c9bbc290a545c2b.jpg","link":"http://bangumi.bilibili.com/anime/5792","pub_time":"2017-02-21 01:35:00","title":"鬼平"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/d3f1a286da362b803f6f32a1992ee1f0492d69fc.jpg","link":"http://bangumi.bilibili.com/anime/5789","pub_time":"2017-02-20 09:55:00","title":"热诚传说X"}],"ends":[{"cover":"http://i0.hdslb.com/bfs/bangumi/35d83fd717967df9807b1ef18d8649fc1362171b.jpg","last_time":"1403426923","newest_ep_id":"4094","newest_ep_index":"12","season_id":"170","title":"众神的恶作剧","total_count":"12","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/dfd40bb8ff7c096eb6789dd7548f418eec842fbf.jpg","last_time":"1481169806","newest_ep_id":"97871","newest_ep_index":"Maga进化3","season_id":"5762","title":"精灵宝可梦 XY","total_count":"92","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/2acfe88770f32598abd0f75e46cfb1eb9620caa7.jpg","last_time":"1381330291","newest_ep_id":"23160","newest_ep_index":"26","season_id":"1270","title":"濑户的花嫁","total_count":"26","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/0406cd1398ad8ae0e9623bed5544d6002d8d30be.jpg","last_time":"1429769614","newest_ep_id":"32254","newest_ep_index":"13","season_id":"1539","title":"我的青春恋爱物语果然有问题。","total_count":"13","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/0d0bc748203e5af67b136f04df6d294911eabb8f.jpg","last_time":"1459677697","newest_ep_id":"85775","newest_ep_index":"52","season_id":"2021","title":"寻找满月","total_count":"52","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/ef3fe6a621e72a19193f44874e3971ca4b7d0d99.jpg","last_time":"1364532833","newest_ep_id":"7864","newest_ep_index":"12","season_id":"417","title":"琴浦小姐","total_count":"12","watchingCount":"0"}],"latestUpdate":{"list":[{"cover":"http://i0.hdslb.com/bfs/archive/21bfa41c87e3a19da001b0399eab3cbbdc6e8487.jpg","last_time":"1487655358","newest_ep_id":"102048","newest_ep_index":"9","season_id":"5860","title":"枪灵计划","total_count":"12","watchingCount":"43"},{"cover":"http://i0.hdslb.com/bfs/archive/81144ca3e3b26dab187eda30e55c9cdf7edd397a.jpg","last_time":"1487630709","newest_ep_id":"100579","newest_ep_index":"21","season_id":"5504","title":"喵阿楞","total_count":"26","watchingCount":"62"},{"cover":"http://i1.hdslb.com/bfs/archive/9231c05cc3423edaeee160aa24fc34ef13f7f389.jpg","last_time":"1487612110","newest_ep_id":"100435","newest_ep_index":"7","season_id":"5794","title":"飙速宅男 新世代","total_count":"13","watchingCount":"750"},{"cover":"http://i2.hdslb.com/bfs/archive/2e9ce612a9278452573cfdcdf47a4c1ae1a5612a.jpg","last_time":"1487612110","newest_ep_id":"100460","newest_ep_index":"7","season_id":"5792","title":"鬼平","total_count":"13","watchingCount":"669"},{"cover":"http://i1.hdslb.com/bfs/archive/fa1cd63ede02ef7656fe5ebe1459332cacbb59bf.jpg","last_time":"1487610300","newest_ep_id":"100423","newest_ep_index":"19","season_id":"5542","title":"TRICKSTER","total_count":"24","watchingCount":"428"},{"cover":"http://i0.hdslb.com/bfs/archive/44a085a51d457095f91e36a6213f3c0f589ac3b4.jpg","last_time":"1487606410","newest_ep_id":"100411","newest_ep_index":"7","season_id":"5791","title":"新撰组镇魂歌 二分之一","total_count":"12","watchingCount":"32"},{"cover":"http://i0.hdslb.com/bfs/archive/3b79311ec4223717df9211379facd86ba2dfddde.jpg","last_time":"1487602809","newest_ep_id":"98621","newest_ep_index":"7","season_id":"5793","title":"珈百璃的堕落","total_count":"12","watchingCount":"7006"},{"cover":"http://i2.hdslb.com/bfs/archive/b42a7ce30ebe18a51f548261b19ffc427223db98.jpg","last_time":"1487586309","newest_ep_id":"91087","newest_ep_index":"33","season_id":"5025","title":"智龙迷城X","total_count":"50","watchingCount":"37"}],"updateCount":"6"}}
     */

    private int code;
    private String message;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * banners : [{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/27eb75aaef49ff24fe3a4620be72aacfb16c7ee6.jpg","link":"http://bangumi.bilibili.com/anime/5794","pub_time":"2017-02-21 01:35:00","title":"飙速宅男 新世代"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/a5fd7006d3a30800bf2f251b8c9bbc290a545c2b.jpg","link":"http://bangumi.bilibili.com/anime/5792","pub_time":"2017-02-21 01:35:00","title":"鬼平"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/d3f1a286da362b803f6f32a1992ee1f0492d69fc.jpg","link":"http://bangumi.bilibili.com/anime/5789","pub_time":"2017-02-20 09:55:00","title":"热诚传说X"}]
         * ends : [{"cover":"http://i0.hdslb.com/bfs/bangumi/35d83fd717967df9807b1ef18d8649fc1362171b.jpg","last_time":"1403426923","newest_ep_id":"4094","newest_ep_index":"12","season_id":"170","title":"众神的恶作剧","total_count":"12","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/dfd40bb8ff7c096eb6789dd7548f418eec842fbf.jpg","last_time":"1481169806","newest_ep_id":"97871","newest_ep_index":"Maga进化3","season_id":"5762","title":"精灵宝可梦 XY","total_count":"92","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/2acfe88770f32598abd0f75e46cfb1eb9620caa7.jpg","last_time":"1381330291","newest_ep_id":"23160","newest_ep_index":"26","season_id":"1270","title":"濑户的花嫁","total_count":"26","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/0406cd1398ad8ae0e9623bed5544d6002d8d30be.jpg","last_time":"1429769614","newest_ep_id":"32254","newest_ep_index":"13","season_id":"1539","title":"我的青春恋爱物语果然有问题。","total_count":"13","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/0d0bc748203e5af67b136f04df6d294911eabb8f.jpg","last_time":"1459677697","newest_ep_id":"85775","newest_ep_index":"52","season_id":"2021","title":"寻找满月","total_count":"52","watchingCount":"0"},{"cover":"http://i0.hdslb.com/bfs/bangumi/ef3fe6a621e72a19193f44874e3971ca4b7d0d99.jpg","last_time":"1364532833","newest_ep_id":"7864","newest_ep_index":"12","season_id":"417","title":"琴浦小姐","total_count":"12","watchingCount":"0"}]
         * latestUpdate : {"list":[{"cover":"http://i0.hdslb.com/bfs/archive/21bfa41c87e3a19da001b0399eab3cbbdc6e8487.jpg","last_time":"1487655358","newest_ep_id":"102048","newest_ep_index":"9","season_id":"5860","title":"枪灵计划","total_count":"12","watchingCount":"43"},{"cover":"http://i0.hdslb.com/bfs/archive/81144ca3e3b26dab187eda30e55c9cdf7edd397a.jpg","last_time":"1487630709","newest_ep_id":"100579","newest_ep_index":"21","season_id":"5504","title":"喵阿楞","total_count":"26","watchingCount":"62"},{"cover":"http://i1.hdslb.com/bfs/archive/9231c05cc3423edaeee160aa24fc34ef13f7f389.jpg","last_time":"1487612110","newest_ep_id":"100435","newest_ep_index":"7","season_id":"5794","title":"飙速宅男 新世代","total_count":"13","watchingCount":"750"},{"cover":"http://i2.hdslb.com/bfs/archive/2e9ce612a9278452573cfdcdf47a4c1ae1a5612a.jpg","last_time":"1487612110","newest_ep_id":"100460","newest_ep_index":"7","season_id":"5792","title":"鬼平","total_count":"13","watchingCount":"669"},{"cover":"http://i1.hdslb.com/bfs/archive/fa1cd63ede02ef7656fe5ebe1459332cacbb59bf.jpg","last_time":"1487610300","newest_ep_id":"100423","newest_ep_index":"19","season_id":"5542","title":"TRICKSTER","total_count":"24","watchingCount":"428"},{"cover":"http://i0.hdslb.com/bfs/archive/44a085a51d457095f91e36a6213f3c0f589ac3b4.jpg","last_time":"1487606410","newest_ep_id":"100411","newest_ep_index":"7","season_id":"5791","title":"新撰组镇魂歌 二分之一","total_count":"12","watchingCount":"32"},{"cover":"http://i0.hdslb.com/bfs/archive/3b79311ec4223717df9211379facd86ba2dfddde.jpg","last_time":"1487602809","newest_ep_id":"98621","newest_ep_index":"7","season_id":"5793","title":"珈百璃的堕落","total_count":"12","watchingCount":"7006"},{"cover":"http://i2.hdslb.com/bfs/archive/b42a7ce30ebe18a51f548261b19ffc427223db98.jpg","last_time":"1487586309","newest_ep_id":"91087","newest_ep_index":"33","season_id":"5025","title":"智龙迷城X","total_count":"50","watchingCount":"37"}],"updateCount":"6"}
         */

        private LatestUpdateBean latestUpdate;
        private List<BannersBean> banners;
        private List<EndsBean> ends;

        public LatestUpdateBean getLatestUpdate() {
            return latestUpdate;
        }

        public void setLatestUpdate(LatestUpdateBean latestUpdate) {
            this.latestUpdate = latestUpdate;
        }

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public List<EndsBean> getEnds() {
            return ends;
        }

        public void setEnds(List<EndsBean> ends) {
            this.ends = ends;
        }

        public static class LatestUpdateBean {
            /**
             * list : [{"cover":"http://i0.hdslb.com/bfs/archive/21bfa41c87e3a19da001b0399eab3cbbdc6e8487.jpg","last_time":"1487655358","newest_ep_id":"102048","newest_ep_index":"9","season_id":"5860","title":"枪灵计划","total_count":"12","watchingCount":"43"},{"cover":"http://i0.hdslb.com/bfs/archive/81144ca3e3b26dab187eda30e55c9cdf7edd397a.jpg","last_time":"1487630709","newest_ep_id":"100579","newest_ep_index":"21","season_id":"5504","title":"喵阿楞","total_count":"26","watchingCount":"62"},{"cover":"http://i1.hdslb.com/bfs/archive/9231c05cc3423edaeee160aa24fc34ef13f7f389.jpg","last_time":"1487612110","newest_ep_id":"100435","newest_ep_index":"7","season_id":"5794","title":"飙速宅男 新世代","total_count":"13","watchingCount":"750"},{"cover":"http://i2.hdslb.com/bfs/archive/2e9ce612a9278452573cfdcdf47a4c1ae1a5612a.jpg","last_time":"1487612110","newest_ep_id":"100460","newest_ep_index":"7","season_id":"5792","title":"鬼平","total_count":"13","watchingCount":"669"},{"cover":"http://i1.hdslb.com/bfs/archive/fa1cd63ede02ef7656fe5ebe1459332cacbb59bf.jpg","last_time":"1487610300","newest_ep_id":"100423","newest_ep_index":"19","season_id":"5542","title":"TRICKSTER","total_count":"24","watchingCount":"428"},{"cover":"http://i0.hdslb.com/bfs/archive/44a085a51d457095f91e36a6213f3c0f589ac3b4.jpg","last_time":"1487606410","newest_ep_id":"100411","newest_ep_index":"7","season_id":"5791","title":"新撰组镇魂歌 二分之一","total_count":"12","watchingCount":"32"},{"cover":"http://i0.hdslb.com/bfs/archive/3b79311ec4223717df9211379facd86ba2dfddde.jpg","last_time":"1487602809","newest_ep_id":"98621","newest_ep_index":"7","season_id":"5793","title":"珈百璃的堕落","total_count":"12","watchingCount":"7006"},{"cover":"http://i2.hdslb.com/bfs/archive/b42a7ce30ebe18a51f548261b19ffc427223db98.jpg","last_time":"1487586309","newest_ep_id":"91087","newest_ep_index":"33","season_id":"5025","title":"智龙迷城X","total_count":"50","watchingCount":"37"}]
             * updateCount : 6
             */

            private String updateCount;
            private List<ListBean> list;

            public String getUpdateCount() {
                return updateCount;
            }

            public void setUpdateCount(String updateCount) {
                this.updateCount = updateCount;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * cover : http://i0.hdslb.com/bfs/archive/21bfa41c87e3a19da001b0399eab3cbbdc6e8487.jpg
                 * last_time : 1487655358
                 * newest_ep_id : 102048
                 * newest_ep_index : 9
                 * season_id : 5860
                 * title : 枪灵计划
                 * total_count : 12
                 * watchingCount : 43
                 */

                private String cover;
                private String last_time;
                private String newest_ep_id;
                private String newest_ep_index;
                private String season_id;
                private String title;
                private String total_count;
                private String watchingCount;

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getLast_time() {
                    return last_time;
                }

                public void setLast_time(String last_time) {
                    this.last_time = last_time;
                }

                public String getNewest_ep_id() {
                    return newest_ep_id;
                }

                public void setNewest_ep_id(String newest_ep_id) {
                    this.newest_ep_id = newest_ep_id;
                }

                public String getNewest_ep_index() {
                    return newest_ep_index;
                }

                public void setNewest_ep_index(String newest_ep_index) {
                    this.newest_ep_index = newest_ep_index;
                }

                public String getSeason_id() {
                    return season_id;
                }

                public void setSeason_id(String season_id) {
                    this.season_id = season_id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTotal_count() {
                    return total_count;
                }

                public void setTotal_count(String total_count) {
                    this.total_count = total_count;
                }

                public String getWatchingCount() {
                    return watchingCount;
                }

                public void setWatchingCount(String watchingCount) {
                    this.watchingCount = watchingCount;
                }
            }
        }

        public static class BannersBean {
            /**
             * id : 0
             * img : http://i0.hdslb.com/bfs/bangumi/27eb75aaef49ff24fe3a4620be72aacfb16c7ee6.jpg
             * link : http://bangumi.bilibili.com/anime/5794
             * pub_time : 2017-02-21 01:35:00
             * title : 飙速宅男 新世代
             */

            private int id;
            private String img;
            private String link;
            private String pub_time;
            private String title;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getPub_time() {
                return pub_time;
            }

            public void setPub_time(String pub_time) {
                this.pub_time = pub_time;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class EndsBean {
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/35d83fd717967df9807b1ef18d8649fc1362171b.jpg
             * last_time : 1403426923
             * newest_ep_id : 4094
             * newest_ep_index : 12
             * season_id : 170
             * title : 众神的恶作剧
             * total_count : 12
             * watchingCount : 0
             */

            private String cover;
            private String last_time;
            private String newest_ep_id;
            private String newest_ep_index;
            private String season_id;
            private String title;
            private String total_count;
            private String watchingCount;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getLast_time() {
                return last_time;
            }

            public void setLast_time(String last_time) {
                this.last_time = last_time;
            }

            public String getNewest_ep_id() {
                return newest_ep_id;
            }

            public void setNewest_ep_id(String newest_ep_id) {
                this.newest_ep_id = newest_ep_id;
            }

            public String getNewest_ep_index() {
                return newest_ep_index;
            }

            public void setNewest_ep_index(String newest_ep_index) {
                this.newest_ep_index = newest_ep_index;
            }

            public String getSeason_id() {
                return season_id;
            }

            public void setSeason_id(String season_id) {
                this.season_id = season_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTotal_count() {
                return total_count;
            }

            public void setTotal_count(String total_count) {
                this.total_count = total_count;
            }

            public String getWatchingCount() {
                return watchingCount;
            }

            public void setWatchingCount(String watchingCount) {
                this.watchingCount = watchingCount;
            }
        }
    }
}
