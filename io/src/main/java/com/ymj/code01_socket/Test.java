package com.ymj.code01_socket;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.6 + 1.5 + 1.0 + 0.9
 * @Classname Test
 * @Description TODO
 * 3 = 1.8    11 = 0.9      1.2
 *  1981 辛酉:1.6=========未时:0.8  13时至15时
 *  1981 辛酉:1.6=========申时:0.8  15时正至17时正
 *  1980 庚申:0.8=========巳时:1.6  上午9时至中午11时
 *  1980 庚申:0.8=========子时:1.6  23时至1时
 * 2.4
 * 戊子 1948
 * 甲戌 1994
 * 乙酉 1945
 * 辛酉 1981
 * 甲辰 1964
 * 丁丑 1997
 * 丙辰 1976
 * 乙卯 1975
 * 丁亥 1947
 * 戊戌 1958
 * 庚申 1980
 * 壬午 1942
 * 甲午 1954
 * 丙子 1996
 * 癸酉 1993
 * 丁酉 1957
 * 戊申 1968
 * 戊寅 1998
 * 辛亥 1971
 * 辛未 1931
 * @Date 2021/7/29 16:16
 * @Created by yemingjie
 */
public class Test {

    public static void main(String[] args) {
        Map<String, Float> years = getYears();
        Map<String, Float> times = getTimes();

        for (Map.Entry<String,Float> year : years.entrySet()) {
            for (Map.Entry<String,Float> time : times.entrySet()) {
                if (year.getValue() + time.getValue() == 2.4f) {
                    System.out.println(year.getKey() + ":" + year.getValue() + "=========" + time.getKey() + ":" + time.getValue());
                }
            }
        }
    }

    public static Map<String,Float> getTimes() {
        Map<String,Float> times = new HashMap<>();
        times.put("子时", 1.6f);times.put("丑时", 0.6f);times.put("寅时", 0.7f);times.put("卯时", 1.0f);
        times.put("辰时", 0.9f);times.put("巳时", 1.6f);times.put("午时", 1.0f);times.put("未时", 0.8f);
        times.put("申时", 0.8f);times.put("酉时", 0.9f);times.put("戌时", 0.6f);times.put("亥时", 0.6f);

        /**
         * 子时 一两六钱 丑时 六钱 寅时 七钱 卯时 一两 辰时 九钱 巳时 一两六钱
         * 午时 一两 未时八钱 申时 八钱 酉时 九钱 戌时 六钱 亥时 六钱
         */
        return times;

    }

    public static Map<String,Float> getYears() {
        Map<String,Float> years = new HashMap<>();
        years.put("甲子", 1.2f);years.put("丙子", 1.6f);years.put("戊子", 1.5f);years.put("庚子", 0.7f);years.put("壬子", 0.5f);
        years.put("乙丑", 0.9f);years.put("丁丑", 0.8f);years.put("己丑", 0.7f);years.put("辛丑", 0.7f);years.put("癸丑", 0.7f);
        years.put("丙寅", 0.6f);years.put("戊寅", 0.8f);years.put("庚寅", 0.9f);years.put("壬寅", 0.9f);years.put("甲寅", 1.2f);
        years.put("丁卯", 0.7f);years.put("己卯", 1.9f);years.put("辛卯", 1.2f);years.put("癸卯", 1.2f);years.put("乙卯", 0.8f);
        years.put("戊辰", 1.2f);years.put("庚辰", 1.2f);years.put("壬辰", 1.0f);years.put("甲辰", 0.8f);years.put("丙辰", 0.8f);
        years.put("己巳", 0.5f);years.put("辛巳", 0.6f);years.put("癸巳", 0.7f);years.put("乙巳", 0.7f);years.put("丁巳", 0.6f);
        years.put("庚午", 0.9f);years.put("壬午", 0.8f);years.put("甲午", 1.5f);years.put("丙午", 1.3f);years.put("戊午", 1.9f);
        years.put("辛未", 0.8f);years.put("癸未", 0.7f);years.put("乙未", 0.6f);years.put("丁未", 0.5f);years.put("己未", 0.6f);
        years.put("壬申", 0.7f);years.put("甲申", 0.5f);years.put("丙申", 0.5f);years.put("戊申", 1.4f);years.put("庚申", 0.8f);
        years.put("癸酉", 0.8f);years.put("乙酉", 1.5f);years.put("丁酉", 1.4f);years.put("己酉", 0.5f);years.put("辛酉", 1.6f);
        years.put("甲戌", 1.5f);years.put("丙戌", 0.6f);years.put("戊戌", 1.4f);years.put("庚戌", 0.9f);years.put("壬戌", 1.0f);
        years.put("乙亥", 0.9f);years.put("丁亥", 1.6f);years.put("己亥", 0.9f);years.put("辛亥", 1.7f);years.put("癸亥", 0.7f);
        return years;
        /**
         *  * 甲子 一两二钱 丙子 一两六钱 戊子 一两五钱 庚子 七钱 壬子 五钱
         *  * 乙丑 九钱 丁丑 八钱 己丑 七钱 辛丑 七钱 癸丑 七钱
         *  * 丙寅 六钱 戊寅 八钱 庚寅九钱 壬寅 九钱 甲寅 一两二钱
         *  * 丁卯七钱 己卯 一两九钱 辛卯 一两二钱 癸卯 一两二钱 乙卯八钱
         *  * 戊辰 一两二钱 庚辰一两二钱 壬辰 一两 甲辰 八钱 丙辰 八钱
         *  * 己巳 五钱 辛巳 六钱 癸巳 七钱 乙巳 七钱 丁巳 六钱
         *  * 庚午 九钱 壬午 八钱 甲午一两五钱 丙午 一两三钱 戊午 一两九钱
         *  * 辛未 八钱 癸未 七钱 乙未 六钱 丁未 五钱 己未 六钱
         *  * 壬申 七钱 甲申 五钱 丙申 五钱 戊申 一两四钱 庚申 八钱
         *  * 癸酉 八钱 乙酉 一两五钱 丁酉 一两四钱 己酉 五钱 辛酉 一两六钱
         *  * 甲戌 一两五钱 丙戌 六钱 戊戌 一两四钱 庚戌 九钱 壬戌 一两
         *  * 乙亥 九钱 丁亥 一两六钱 己亥 九钱 辛亥 一两七钱 癸亥 七钱
         */
    }
}
