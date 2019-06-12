package com.sherlockxu.recyclerviewdevelop.linkplus;

/**
 * Description:   顾客需求Model
 * author         xulei
 * Date           2019/6/12
 */
public class DemandModel {
    private String mealTime;
    private String tableName;
    private String peopleNum;
    private String operate;

    public DemandModel() {
    }

    public DemandModel(String mealTime, String tableName, String peopleNum, String operate) {
        this.mealTime = mealTime;
        this.tableName = tableName;
        this.peopleNum = peopleNum;
        this.operate = operate;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    @Override
    public String toString() {
        return "DemandModel{" +
                "mealTime='" + mealTime + '\'' +
                ", tableName='" + tableName + '\'' +
                ", peopleNum=" + peopleNum +
                ", operate='" + operate + '\'' +
                '}';
    }
}
