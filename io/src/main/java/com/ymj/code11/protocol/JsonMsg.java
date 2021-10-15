package com.ymj.code11.protocol;

public class JsonMsg {
    //id Field(字段)
    private int id;
    //content Field(字段)
    private String content;

    //反序列化：在通用方法中，使用阿里FastJson转成Java对象
    public static JsonMsg parseFromJson(String json) {
        return JsonUtil.jsonToPojo(json, JsonMsg.class);
    }

    //序列化：在通用方法中，使用谷歌Gson转成字符串
    public String convertToJson() {
        return JsonUtil.pojoToJson(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
