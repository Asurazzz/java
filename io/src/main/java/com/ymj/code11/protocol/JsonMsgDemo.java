package com.ymj.code11.protocol;

public class JsonMsgDemo {
    // 构建json对象
    public static JsonMsg buildMsg() {
        JsonMsg user = new JsonMsg();
        user.setId(1000);
        user.setContent("疯狂创客圈:高性能学习社群");
        return user;
    }

    /**
     * 测试用例：序列化 serialization &反序列化 Deserialization
     * @param args
     */
    public static void main(String[] args) {
        JsonMsg msg = buildMsg();
        //将 POJO 对象，序列化成字符串
        String json = msg.convertToJson();
        //可以用于网络传输,保存到内存或外存
        System.out.println(json);

        //JSON 字符串,反序列化成 POJO 对象
        JsonMsg jsonMsg = JsonMsg.parseFromJson(json);
        System.out.println("id:=" + jsonMsg.getId());
        System.out.println("content:=" + jsonMsg.getContent());
    }

}
