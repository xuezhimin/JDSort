package com.qh.xzm.jdsort.bean;

import java.util.List;

public class RightBeanOut {
    private String cid;

    private List<RightBeanInner> list ;

    private String name;

    private String pcid;

    public void setCid(String cid){
        this.cid = cid;
    }
    public String getCid(){
        return this.cid;
    }

    public List<RightBeanInner> getList() {
        return list;
    }

    public void setList(List<RightBeanInner> list) {
        this.list = list;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPcid(String pcid){
        this.pcid = pcid;
    }
    public String getPcid(){
        return this.pcid;
    }

}
