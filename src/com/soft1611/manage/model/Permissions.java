package com.soft1611.manage.model;

/**
 *  权限
 * @author sry
 * @date 2017/12/20
 */
public class Permissions {
    private String groupName;
    private String account;
    private String itemName;

    public Permissions() {
    }

    public Permissions(String groupName, String account, String itemID) {

        this.groupName = groupName;
        this.account = account;
        this.itemName = itemID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getItemID() {
        return itemName;
    }

    public void setItemID(String itemID) {
        this.itemName = itemID;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "groupName='" + groupName + '\'' +
                ", account='" + account + '\'' +
                ", itemID='" + itemName + '\'' +
                '}';
    }
}
