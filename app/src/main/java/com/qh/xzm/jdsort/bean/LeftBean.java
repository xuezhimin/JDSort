package com.qh.xzm.jdsort.bean;

public class LeftBean {


    private int cid;

    private String createtime;

    private String icon;

    private int ishome;

    private String name;

    private boolean isClick = false;

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public void setCid(int cid){
        this.cid = cid;
    }
    public int getCid(){
        return this.cid;
    }
    public void setCreatetime(String createtime){
        this.createtime = createtime;
    }
    public String getCreatetime(){
        return this.createtime;
    }
    public void setIcon(String icon){
        this.icon = icon;
    }
    public String getIcon(){
        return this.icon;
    }
    public void setIshome(int ishome){
        this.ishome = ishome;
    }
    public int getIshome(){
        return this.ishome;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
