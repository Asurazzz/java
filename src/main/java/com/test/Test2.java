package com.test;

import java.util.*;

/**
 * @author yemingjie.
 * @date 2022/3/1.
 * @time 10:17.
 */
public class Test2 {


    public static void main(String[] args) {
        test1();
    }

    /**
     * 对应toTradeExportBean中520行
     * @param
     */
    public static void test1() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("1111", new ArrayList<>());
        map.get("1111").add("aaaa");
        map.get("1111").add("bbbb");
        map.put("2222", new ArrayList<>());
        map.get("2222").add("cccc");
        map.put("3333", new ArrayList<>());
        map.get("3333").add("dddd");
        map.put("4444", new ArrayList<>());
        map.get("4444").add("eeee");
        map.get("4444").add("ffff");
        map.get("4444").add("gggg");
        map.put("6666", new ArrayList<>());
        map.get("6666").add("hhhh");
        String tids = "1111|2222|3333|4444|5555|6666";
        String[] tidsArr = tids.split("\\|");
        StringBuilder tidTemps = new StringBuilder();
        for (String tid : tidsArr) {
            List<String> strings = map.get(tid);
            tidTemps.append(tid);
            if (strings != null) {
                for (String oid : strings) {
                    if (tidTemps.lastIndexOf(",") + 1 == tidTemps.length()) {
                        tidTemps.append(oid).append(",");
                    }
                    if (tidTemps.lastIndexOf(",") + 1 != tidTemps.length()) {

                        tidTemps.append(":").append(oid).append(",");
                    }

                }

            }
            if (tidTemps.lastIndexOf(",") + 1 == tidTemps.length()) {
                tidTemps = new StringBuilder(tidTemps.substring(0, tidTemps.length() - 1));
            }
            tidTemps.append("|");
        }
        System.out.println(tidTemps.toString());
    }

    /**
     * 对应DownLoadTaskService.getPrintBgKddMap的268行
     * @param
     */
    public static void test2() {
        Map<String, Set<String>> map = new HashMap();
        map.put("1", new HashSet<>());
        map.get("1").add("2222:23233,11111");
        map.get("1").add("3333");
        map.put("2", new HashSet<>());
        map.get("2").add("aaaa");
        map.get("2").add("bbbb:cccc,dddd");
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
//            String[] strs = ItemProsetSearchUtils.collectionToString(entry.getValue(), 200, ";");
//            for (String s : strs) {
//                System.out.println(s);
//            }
        }

    }


    /**
     * 对应排序
     * @param args
     */
    public static void main4(String[] args) {
        String s = tidsSort("1111:aaaa,bbbb|2222:cccc|3333:dddd|4444:eeee,ffff,gggg|5555:hhhh|");
        System.out.println(s);

    }

    public static String tidsSort(String tids){
        String[] tidArr = tids.split("\\|");
        String[] tidLists = new String[tidArr.length];
        Map<String, String> oidMap = new HashMap<>();
        for (int i = 0; i < tidArr.length; i++) {
            String str = tidArr[i];
            String tid = String.valueOf(str.split(":")[0]);
            if (str.split(":").length > 1) {
                String oids = str.split(":")[1];
                oidMap.put(tid, oids);
            }
            tidLists[i] = tid;
        }

        Arrays.sort(tidLists);

        StringBuilder newTids = new StringBuilder();

        for (int i = 0; i < tidLists.length; i++) {
            newTids.append(tidLists[i]);
            String oidStr = oidMap.get(tidLists[i]);
            if (oidStr != null && !"".equals(oidStr)) {
                String[] oidArr = oidStr.split(",");
                Arrays.sort(oidArr);
                newTids.append(":");
                for (int j = 0; j < oidArr.length; j++) {
                    newTids.append(oidArr[j]);

                    if (j < oidArr.length - 1) {
                        newTids.append(",");
                    }
                }
            }
            if (i < tidLists.length - 1) {
                newTids.append("|");
            }
        }

        return newTids.toString();
    }
}
