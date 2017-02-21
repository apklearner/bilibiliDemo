package network.entity;

import java.util.List;

/**
 * Created by ly on 2017/2/22.
 */

public class HomeRecBannerEntity {
    /**
     * code : 0
     * data : [{"title":"时尚0222","value":"http://www.bilibili.com/blackboard/activity-HyvNYstKe.html","image":"http://i0.hdslb.com/bfs/archive/134a1dc059f496a7a4021a0ef87a724c97c5d12a.jpg","type":2,"weight":1,"remark":"","hash":"d290d8d9dd62ed88e2d7c7a882af09aa"},{"title":"舞蹈46期","value":"http://www.bilibili.com/blackboard/activity-BkKRNcKFg.html","image":"http://i0.hdslb.com/bfs/archive/1cf89c323251ac256d45271d0ae8c9b7c56ba226.png","type":2,"weight":2,"remark":"","hash":"5a531544775bd19fd9a82c8aff3a612a"},{"title":"鬼畜0221","value":"http://www.bilibili.com/blackboard/activity-SykvysbYg.html","image":"http://i0.hdslb.com/bfs/archive/3873e99c30e77546d2637e531aa13d17c34436bd.jpg","type":2,"weight":3,"remark":"","hash":"7a3954660236a823b297b89c5993145e"}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 时尚0222
         * value : http://www.bilibili.com/blackboard/activity-HyvNYstKe.html
         * image : http://i0.hdslb.com/bfs/archive/134a1dc059f496a7a4021a0ef87a724c97c5d12a.jpg
         * type : 2
         * weight : 1
         * remark :
         * hash : d290d8d9dd62ed88e2d7c7a882af09aa
         */

        private String title;
        private String value;
        private String image;
        private int type;
        private int weight;
        private String remark;
        private String hash;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }
    }
}
