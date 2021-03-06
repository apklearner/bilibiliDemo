package network.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ly on 2017/2/23.
 */

public class HotTagEntity {
    /**
     * code : 0
     * seid : 16031953389993258972
     * message : success
     * timestamp : 1485923084
     * list : [{"keyword":"人渣的本愿","status":"keep"},{"keyword":"极乐净土","status":"keep"},{"keyword":"吃货木下","status":"up"},{"keyword":"暴走大事件","status":"up"},{"keyword":"阴阳师","status":"down"},{"keyword":"三生三世十里桃花","status":"up"},{"keyword":"主播炸了","status":"up"},{"keyword":"主播真会玩","status":"down"},{"keyword":"敖厂长","status":"up"},{"keyword":"鬼怪","status":"up"},{"keyword":"斗破苍穹","status":"up"},{"keyword":"nct","status":"up"},{"keyword":"大胃王密子君","status":"up"},{"keyword":"一年生","status":"keep"},{"keyword":"red+velvet","status":"up"},{"keyword":"谷阿莫","status":"down"},{"keyword":"四重奏","status":"up"},{"keyword":"fate","status":"up"},{"keyword":"pdd","status":"down"},{"keyword":"中国boy大基佬","status":"up"},{"keyword":"纯黑","status":"up"},{"keyword":"嗨氏","status":"up"},{"keyword":"王者荣耀","status":"up"},{"keyword":"老e","status":"up"},{"keyword":"起小点","status":"down"},{"keyword":"守望先锋","status":"down"},{"keyword":"生化危机7","status":"down"},{"keyword":"逆风笑","status":"up"},{"keyword":"你的名字","status":"up"},{"keyword":"徐老师来巡山","status":"up"},{"keyword":"程潇","status":"up"},{"keyword":"迪玛希","status":"up"},{"keyword":"逗鱼时刻","status":"up"},{"keyword":"法医秦明","status":"up"},{"keyword":"h1z1","status":"down"},{"keyword":"大唐荣耀","status":"up"},{"keyword":"日剧","status":"up"},{"keyword":"火影忍者","status":"up"},{"keyword":"海贼王","status":"up"},{"keyword":"狐妖小红娘","status":"up"},{"keyword":"吻戏","status":"down"},{"keyword":"papi酱","status":"up"},{"keyword":"渗透之c君","status":"up"},{"keyword":"孤独的美食家","status":"up"},{"keyword":"挠脚心","status":"up"},{"keyword":"拜年祭","status":"up"},{"keyword":"seventeen","status":"up"},{"keyword":"我的世界","status":"up"},{"keyword":"周星驰","status":"down"},{"keyword":"宇宙少女","status":"up"}]
     * cost : {"timer":"hotword","total":"0.000190","read file":"0.000115"}
     */

    private int code;
    private String seid;
    private String message;
    private int timestamp;
    private CostBean cost;
    private List<ListBean> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public CostBean getCost() {
        return cost;
    }

    public void setCost(CostBean cost) {
        this.cost = cost;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class CostBean {
        /**
         * timer : hotword
         * total : 0.000190
         * read file : 0.000115
         */

        private String timer;
        private String total;
        @SerializedName("read file")
        private String _$ReadFile284; // FIXME check this code

        public String getTimer() {
            return timer;
        }

        public void setTimer(String timer) {
            this.timer = timer;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String get_$ReadFile284() {
            return _$ReadFile284;
        }

        public void set_$ReadFile284(String _$ReadFile284) {
            this._$ReadFile284 = _$ReadFile284;
        }
    }

    public static class ListBean {
        /**
         * keyword : 人渣的本愿
         * status : keep
         */

        private String keyword;
        private String status;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
