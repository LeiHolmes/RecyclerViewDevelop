package com.sherlockxu.recyclerviewdevelop;

/**
 * Description:
 * author         xulei
 * Date           2017/3/29
 */

public class DataBean {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    private String name;
    private String contentName;
    private int headColor;
    private int contentColor;
    private int type;

    public DataBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public int getHeadColor() {
        return headColor;
    }

    public void setHeadColor(int headColor) {
        this.headColor = headColor;
    }

    public int getContentColor() {
        return contentColor;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "name='" + name + '\'' +
                ", contentName='" + contentName + '\'' +
                ", headColor=" + headColor +
                ", contentColor=" + contentColor +
                ", type=" + type +
                '}';
    }
}
