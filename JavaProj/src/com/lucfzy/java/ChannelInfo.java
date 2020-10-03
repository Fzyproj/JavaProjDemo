package com.lucfzy.java;

public class ChannelInfo {
    // 店铺id
    private String channelId;
    // 仓库id
    private String storeId;

    public ChannelInfo(String channelId, String storeId) {
        this.channelId = channelId;
        this.storeId = storeId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "ChannelInfo{" +
                "channelId='" + channelId + '\'' +
                ", storeId='" + storeId + '\'' +
                '}';
    }
}
