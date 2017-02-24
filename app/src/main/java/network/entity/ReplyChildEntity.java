package network.entity;

import java.util.List;

/**
 * Created by ly on 2017/2/25.
 */

public class ReplyChildEntity {

    /**
     * action : 0
     * attr : 0
     * content : {"device":"","members":[],"message":"up up 能不能把截取后的星空图发给我(｀?ω?\u2032)","plat":2}
     * count : 1
     * ctime : 1487948599
     * floor : 88
     * like : 1
     * member : {"DisplayRank":"0","avatar":"http://i0.hdslb.com/bfs/face/bfe888e0e1ddca1dc62059c3c7356eba9cb45486.jpg","level_info":{"current_exp":1419,"current_level":2,"current_min":200,"next_exp":1500},"mid":"30486073","nameplate":{"condition":"","image":"","image_small":"","level":"","name":"","nid":0},"official_verify":{"desc":"","type":-1},"pendant":{"expire":0,"image":"","name":"","pid":0},"rank":"10000","sex":"保密","sign":"","uname":"TheRutan","vip":{"accessStatus":1,"dueRemark":"","vipDueDate":0,"vipStatus":0,"vipStatusWarn":"","vipType":0}}
     * mid : 30486073
     * oid : 8694230
     * parent : 0
     * parent_str : 0
     * rcount : 1
     * replies : [{"action":0,"attr":0,"content":{"device":"","members":[],"message":"截取后的删掉啦，等我改天重新截取一份给你哦！","plat":3},"count":0,"ctime":1487948908,"floor":1,"like":0,"member":{"DisplayRank":"0","avatar":"http://i0.hdslb.com/bfs/face/6104ed556e15cac5ff82d8b5a3898b8b0e688164.jpg","level_info":{"current_exp":3257,"current_level":3,"current_min":1500,"next_exp":4500},"mid":"2446923","nameplate":{"condition":"","image":"","image_small":"","level":"","name":"","nid":0},"official_verify":{"desc":"","type":-1},"pendant":{"expire":0,"image":"","name":"","pid":0},"rank":"10000","sex":"男","sign":"尽情投币","uname":"米若吉姆","vip":{"accessStatus":1,"dueRemark":"","vipDueDate":0,"vipStatus":0,"vipStatusWarn":"","vipType":0}},"mid":2446923,"oid":8694230,"parent":209020072,"parent_str":"209020072","rcount":0,"replies":null,"root":209020072,"root_str":"209020072","rpid":209023936,"rpid_str":"209023936","state":0,"type":1}]
     * root : 0
     * root_str : 0
     * rpid : 209020072
     * rpid_str : 209020072
     * state : 0
     * type : 1
     */

    private int action;
    private int attr;
    private ContentBean content;
    private int count;
    private int ctime;
    private int floor;
    private int like;
    private MemberBean member;
    private int mid;
    private int oid;
    private int parent;
    private String parent_str;
    private int rcount;
    private int root;
    private String root_str;
    private int rpid;
    private String rpid_str;
    private int state;
    private int type;
    private List<RepliesBean> replies;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getAttr() {
        return attr;
    }

    public void setAttr(int attr) {
        this.attr = attr;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCtime() {
        return ctime;
    }

    public void setCtime(int ctime) {
        this.ctime = ctime;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public MemberBean getMember() {
        return member;
    }

    public void setMember(MemberBean member) {
        this.member = member;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getParent_str() {
        return parent_str;
    }

    public void setParent_str(String parent_str) {
        this.parent_str = parent_str;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public String getRoot_str() {
        return root_str;
    }

    public void setRoot_str(String root_str) {
        this.root_str = root_str;
    }

    public int getRpid() {
        return rpid;
    }

    public void setRpid(int rpid) {
        this.rpid = rpid;
    }

    public String getRpid_str() {
        return rpid_str;
    }

    public void setRpid_str(String rpid_str) {
        this.rpid_str = rpid_str;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<RepliesBean> getReplies() {
        return replies;
    }

    public void setReplies(List<RepliesBean> replies) {
        this.replies = replies;
    }

    public static class ContentBean {
        /**
         * device :
         * members : []
         * message : up up 能不能把截取后的星空图发给我(｀?ω?′)
         * plat : 2
         */

        private String device;
        private String message;
        private int plat;
        private List<?> members;

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getPlat() {
            return plat;
        }

        public void setPlat(int plat) {
            this.plat = plat;
        }

        public List<?> getMembers() {
            return members;
        }

        public void setMembers(List<?> members) {
            this.members = members;
        }
    }

    public static class MemberBean {
        /**
         * DisplayRank : 0
         * avatar : http://i0.hdslb.com/bfs/face/bfe888e0e1ddca1dc62059c3c7356eba9cb45486.jpg
         * level_info : {"current_exp":1419,"current_level":2,"current_min":200,"next_exp":1500}
         * mid : 30486073
         * nameplate : {"condition":"","image":"","image_small":"","level":"","name":"","nid":0}
         * official_verify : {"desc":"","type":-1}
         * pendant : {"expire":0,"image":"","name":"","pid":0}
         * rank : 10000
         * sex : 保密
         * sign :
         * uname : TheRutan
         * vip : {"accessStatus":1,"dueRemark":"","vipDueDate":0,"vipStatus":0,"vipStatusWarn":"","vipType":0}
         */

        private String DisplayRank;
        private String avatar;
        private LevelInfoBean level_info;
        private String mid;
        private NameplateBean nameplate;
        private OfficialVerifyBean official_verify;
        private PendantBean pendant;
        private String rank;
        private String sex;
        private String sign;
        private String uname;
        private VipBean vip;

        public String getDisplayRank() {
            return DisplayRank;
        }

        public void setDisplayRank(String DisplayRank) {
            this.DisplayRank = DisplayRank;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public LevelInfoBean getLevel_info() {
            return level_info;
        }

        public void setLevel_info(LevelInfoBean level_info) {
            this.level_info = level_info;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public NameplateBean getNameplate() {
            return nameplate;
        }

        public void setNameplate(NameplateBean nameplate) {
            this.nameplate = nameplate;
        }

        public OfficialVerifyBean getOfficial_verify() {
            return official_verify;
        }

        public void setOfficial_verify(OfficialVerifyBean official_verify) {
            this.official_verify = official_verify;
        }

        public PendantBean getPendant() {
            return pendant;
        }

        public void setPendant(PendantBean pendant) {
            this.pendant = pendant;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public VipBean getVip() {
            return vip;
        }

        public void setVip(VipBean vip) {
            this.vip = vip;
        }

        public static class LevelInfoBean {
            /**
             * current_exp : 1419
             * current_level : 2
             * current_min : 200
             * next_exp : 1500
             */

            private int current_exp;
            private int current_level;
            private int current_min;
            private String  next_exp;

            public int getCurrent_exp() {
                return current_exp;
            }

            public void setCurrent_exp(int current_exp) {
                this.current_exp = current_exp;
            }

            public int getCurrent_level() {
                return current_level;
            }

            public void setCurrent_level(int current_level) {
                this.current_level = current_level;
            }

            public int getCurrent_min() {
                return current_min;
            }

            public void setCurrent_min(int current_min) {
                this.current_min = current_min;
            }

            public String getNext_exp() {
                return next_exp;
            }

            public void setNext_exp(String next_exp) {
                this.next_exp = next_exp;
            }
        }

        public static class NameplateBean {
            /**
             * condition :
             * image :
             * image_small :
             * level :
             * name :
             * nid : 0
             */

            private String condition;
            private String image;
            private String image_small;
            private String level;
            private String name;
            private int nid;

            public String getCondition() {
                return condition;
            }

            public void setCondition(String condition) {
                this.condition = condition;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getImage_small() {
                return image_small;
            }

            public void setImage_small(String image_small) {
                this.image_small = image_small;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNid() {
                return nid;
            }

            public void setNid(int nid) {
                this.nid = nid;
            }
        }

        public static class OfficialVerifyBean {
            /**
             * desc :
             * type : -1
             */

            private String desc;
            private int type;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class PendantBean {
            /**
             * expire : 0
             * image :
             * name :
             * pid : 0
             */

            private int expire;
            private String image;
            private String name;
            private int pid;

            public int getExpire() {
                return expire;
            }

            public void setExpire(int expire) {
                this.expire = expire;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }
        }

        public static class VipBean {
            /**
             * accessStatus : 1
             * dueRemark :
             * vipDueDate : 0
             * vipStatus : 0
             * vipStatusWarn :
             * vipType : 0
             */

            private int accessStatus;
            private String dueRemark;
            private long vipDueDate;
            private int vipStatus;
            private String vipStatusWarn;
            private int vipType;

            public int getAccessStatus() {
                return accessStatus;
            }

            public void setAccessStatus(int accessStatus) {
                this.accessStatus = accessStatus;
            }

            public String getDueRemark() {
                return dueRemark;
            }

            public void setDueRemark(String dueRemark) {
                this.dueRemark = dueRemark;
            }

            public long getVipDueDate() {
                return vipDueDate;
            }

            public void setVipDueDate(long vipDueDate) {
                this.vipDueDate = vipDueDate;
            }

            public int getVipStatus() {
                return vipStatus;
            }

            public void setVipStatus(int vipStatus) {
                this.vipStatus = vipStatus;
            }

            public String getVipStatusWarn() {
                return vipStatusWarn;
            }

            public void setVipStatusWarn(String vipStatusWarn) {
                this.vipStatusWarn = vipStatusWarn;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }
        }
    }

    public static class RepliesBean {
        /**
         * action : 0
         * attr : 0
         * content : {"device":"","members":[],"message":"截取后的删掉啦，等我改天重新截取一份给你哦！","plat":3}
         * count : 0
         * ctime : 1487948908
         * floor : 1
         * like : 0
         * member : {"DisplayRank":"0","avatar":"http://i0.hdslb.com/bfs/face/6104ed556e15cac5ff82d8b5a3898b8b0e688164.jpg","level_info":{"current_exp":3257,"current_level":3,"current_min":1500,"next_exp":4500},"mid":"2446923","nameplate":{"condition":"","image":"","image_small":"","level":"","name":"","nid":0},"official_verify":{"desc":"","type":-1},"pendant":{"expire":0,"image":"","name":"","pid":0},"rank":"10000","sex":"男","sign":"尽情投币","uname":"米若吉姆","vip":{"accessStatus":1,"dueRemark":"","vipDueDate":0,"vipStatus":0,"vipStatusWarn":"","vipType":0}}
         * mid : 2446923
         * oid : 8694230
         * parent : 209020072
         * parent_str : 209020072
         * rcount : 0
         * replies : null
         * root : 209020072
         * root_str : 209020072
         * rpid : 209023936
         * rpid_str : 209023936
         * state : 0
         * type : 1
         */

        private int action;
        private int attr;
        private ContentBeanX content;
        private int count;
        private int ctime;
        private int floor;
        private int like;
        private MemberBeanX member;
        private int mid;
        private int oid;
        private int parent;
        private String parent_str;
        private int rcount;
        private Object replies;
        private int root;
        private String root_str;
        private int rpid;
        private String rpid_str;
        private int state;
        private int type;

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public int getAttr() {
            return attr;
        }

        public void setAttr(int attr) {
            this.attr = attr;
        }

        public ContentBeanX getContent() {
            return content;
        }

        public void setContent(ContentBeanX content) {
            this.content = content;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCtime() {
            return ctime;
        }

        public void setCtime(int ctime) {
            this.ctime = ctime;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public MemberBeanX getMember() {
            return member;
        }

        public void setMember(MemberBeanX member) {
            this.member = member;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public int getOid() {
            return oid;
        }

        public void setOid(int oid) {
            this.oid = oid;
        }

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public String getParent_str() {
            return parent_str;
        }

        public void setParent_str(String parent_str) {
            this.parent_str = parent_str;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public Object getReplies() {
            return replies;
        }

        public void setReplies(Object replies) {
            this.replies = replies;
        }

        public int getRoot() {
            return root;
        }

        public void setRoot(int root) {
            this.root = root;
        }

        public String getRoot_str() {
            return root_str;
        }

        public void setRoot_str(String root_str) {
            this.root_str = root_str;
        }

        public int getRpid() {
            return rpid;
        }

        public void setRpid(int rpid) {
            this.rpid = rpid;
        }

        public String getRpid_str() {
            return rpid_str;
        }

        public void setRpid_str(String rpid_str) {
            this.rpid_str = rpid_str;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public static class ContentBeanX {
            /**
             * device :
             * members : []
             * message : 截取后的删掉啦，等我改天重新截取一份给你哦！
             * plat : 3
             */

            private String device;
            private String message;
            private int plat;
            private List<?> members;

            public String getDevice() {
                return device;
            }

            public void setDevice(String device) {
                this.device = device;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public int getPlat() {
                return plat;
            }

            public void setPlat(int plat) {
                this.plat = plat;
            }

            public List<?> getMembers() {
                return members;
            }

            public void setMembers(List<?> members) {
                this.members = members;
            }
        }

        public static class MemberBeanX {
            /**
             * DisplayRank : 0
             * avatar : http://i0.hdslb.com/bfs/face/6104ed556e15cac5ff82d8b5a3898b8b0e688164.jpg
             * level_info : {"current_exp":3257,"current_level":3,"current_min":1500,"next_exp":4500}
             * mid : 2446923
             * nameplate : {"condition":"","image":"","image_small":"","level":"","name":"","nid":0}
             * official_verify : {"desc":"","type":-1}
             * pendant : {"expire":0,"image":"","name":"","pid":0}
             * rank : 10000
             * sex : 男
             * sign : 尽情投币
             * uname : 米若吉姆
             * vip : {"accessStatus":1,"dueRemark":"","vipDueDate":0,"vipStatus":0,"vipStatusWarn":"","vipType":0}
             */

            private String DisplayRank;
            private String avatar;
            private LevelInfoBeanX level_info;
            private String mid;
            private NameplateBeanX nameplate;
            private OfficialVerifyBeanX official_verify;
            private PendantBeanX pendant;
            private String rank;
            private String sex;
            private String sign;
            private String uname;
            private VipBeanX vip;

            public String getDisplayRank() {
                return DisplayRank;
            }

            public void setDisplayRank(String DisplayRank) {
                this.DisplayRank = DisplayRank;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public LevelInfoBeanX getLevel_info() {
                return level_info;
            }

            public void setLevel_info(LevelInfoBeanX level_info) {
                this.level_info = level_info;
            }

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public NameplateBeanX getNameplate() {
                return nameplate;
            }

            public void setNameplate(NameplateBeanX nameplate) {
                this.nameplate = nameplate;
            }

            public OfficialVerifyBeanX getOfficial_verify() {
                return official_verify;
            }

            public void setOfficial_verify(OfficialVerifyBeanX official_verify) {
                this.official_verify = official_verify;
            }

            public PendantBeanX getPendant() {
                return pendant;
            }

            public void setPendant(PendantBeanX pendant) {
                this.pendant = pendant;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public VipBeanX getVip() {
                return vip;
            }

            public void setVip(VipBeanX vip) {
                this.vip = vip;
            }

            public static class LevelInfoBeanX {
                /**
                 * current_exp : 3257
                 * current_level : 3
                 * current_min : 1500
                 * next_exp : 4500
                 */

                private int current_exp;
                private int current_level;
                private int current_min;
                private String next_exp;

                public int getCurrent_exp() {
                    return current_exp;
                }

                public void setCurrent_exp(int current_exp) {
                    this.current_exp = current_exp;
                }

                public int getCurrent_level() {
                    return current_level;
                }

                public void setCurrent_level(int current_level) {
                    this.current_level = current_level;
                }

                public int getCurrent_min() {
                    return current_min;
                }

                public void setCurrent_min(int current_min) {
                    this.current_min = current_min;
                }

                public String getNext_exp() {
                    return next_exp;
                }

                public void setNext_exp(String next_exp) {
                    this.next_exp = next_exp;
                }
            }

            public static class NameplateBeanX {
                /**
                 * condition :
                 * image :
                 * image_small :
                 * level :
                 * name :
                 * nid : 0
                 */

                private String condition;
                private String image;
                private String image_small;
                private String level;
                private String name;
                private int nid;

                public String getCondition() {
                    return condition;
                }

                public void setCondition(String condition) {
                    this.condition = condition;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getImage_small() {
                    return image_small;
                }

                public void setImage_small(String image_small) {
                    this.image_small = image_small;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getNid() {
                    return nid;
                }

                public void setNid(int nid) {
                    this.nid = nid;
                }
            }

            public static class OfficialVerifyBeanX {
                /**
                 * desc :
                 * type : -1
                 */

                private String desc;
                private int type;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }

            public static class PendantBeanX {
                /**
                 * expire : 0
                 * image :
                 * name :
                 * pid : 0
                 */

                private int expire;
                private String image;
                private String name;
                private int pid;

                public int getExpire() {
                    return expire;
                }

                public void setExpire(int expire) {
                    this.expire = expire;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }
            }

            public static class VipBeanX {
                /**
                 * accessStatus : 1
                 * dueRemark :
                 * vipDueDate : 0
                 * vipStatus : 0
                 * vipStatusWarn :
                 * vipType : 0
                 */

                private int accessStatus;
                private String dueRemark;
                private long vipDueDate;
                private int vipStatus;
                private String vipStatusWarn;
                private int vipType;

                public int getAccessStatus() {
                    return accessStatus;
                }

                public void setAccessStatus(int accessStatus) {
                    this.accessStatus = accessStatus;
                }

                public String getDueRemark() {
                    return dueRemark;
                }

                public void setDueRemark(String dueRemark) {
                    this.dueRemark = dueRemark;
                }

                public long getVipDueDate() {
                    return vipDueDate;
                }

                public void setVipDueDate(long vipDueDate) {
                    this.vipDueDate = vipDueDate;
                }

                public int getVipStatus() {
                    return vipStatus;
                }

                public void setVipStatus(int vipStatus) {
                    this.vipStatus = vipStatus;
                }

                public String getVipStatusWarn() {
                    return vipStatusWarn;
                }

                public void setVipStatusWarn(String vipStatusWarn) {
                    this.vipStatusWarn = vipStatusWarn;
                }

                public int getVipType() {
                    return vipType;
                }

                public void setVipType(int vipType) {
                    this.vipType = vipType;
                }
            }
        }
    }
}
