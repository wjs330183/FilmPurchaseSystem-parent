package com.ioe.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class CommonUtils {




        /*--------------------List转字符串---------------------*/
        public static String listToString(List<String> list, String separator, String open,
                                          String close) {
            if (list == null || list.size() < 1)
                return "";
            StringBuilder sb = new StringBuilder("");
            int index = 0;
            for (String str : list) {
                sb.append(open).append(str).append(close);
                if (index + 1 < list.size())
                    sb.append(separator);
                index++;
            }
            return sb.toString();
        }

        public static String listToString(List<String> list) {
            return listToString(list, ",", "", "");
        }

        public static String listToSqlString(List<String> list) {
            return listToString(list, ",", "'", "'");
        }




        /*---------------------非空判断-----------------------*/
        public static boolean isEmpty(String str) {
            return str == null || "".equals(str);
        }
    public static boolean isAnyEmpty(String str) {
        return str == null || "".equals(str);
    }
        public static boolean isNotEmpty(String str) {
            return str != null && !"".equals(str);
        }

        public static boolean isEmpty(Collection collection) {
            return collection == null || collection.isEmpty();
        }

        public static boolean isNotEmpty(Collection collection) {
            return collection != null && !collection.isEmpty();
        }

        public static <T> List<T> arrayListNullToEmpty(List<T> collection) {
            return isEmpty(collection) ? new ArrayList<T>() : collection;
        }

        /*---------------------方法内部性能调试----------------*/
        public static void methodCost(Long start, String methodName, StringBuilder sb) {
            Long tEnd = System.currentTimeMillis();
            sb.append(methodName + " execute cost time " + (tEnd - start) + " ms\n");
            start = tEnd;
        }

        public static void methodCost(Long start, String methodName) {
            Long tEnd = System.currentTimeMillis();
            System.out.println(methodName + " execute cost time " + (tEnd - start) + " ms\n");
            start = tEnd;
        }


        /**
         * json 转对象
         *
         * @return 对象数组
         */
        public static <T> List<T> parseObjects(String json, Class<T> clazz) {
            if (isEmpty(json)) {
                return Collections.emptyList();
            }
            List<T> list = new ArrayList<T>();
            if (json.charAt(0) == '[') {
                list = JSONArray.parseArray(json, clazz);
            } else {
                T entity = JSON.parseObject(json, clazz);
                list.add(entity);
            }
            return list;
        }

        /**
         * 向 value 为List<V> 的map中添加值
         */
        public static <K, V> void addMapList(Map<K, List<V>> map, K key, V value) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<V>());
            }
            map.get(key).add(value);
        }

        public static void main(String[] args) {
            List<String> metrics = new ArrayList<String>();
            metrics.add("02010100");
            metrics.add("02010200");
            metrics.add("02010300");
            metrics.add("02020100");
            System.out.println(listToString(metrics, "==", "<", ">"));
            System.out.println(listToString(metrics));
            System.out.println(listToSqlString(metrics));
        }

        public static <T> List<T> getListByJson(String json, Class<T> tClass) {

            List<T> list = new ArrayList<T>();
            if (json.charAt(0) == '[') {
                list = JSONArray.parseArray(json, tClass);
            } else {
                T rule = JSON.parseObject(json, tClass);
                list.add(rule);
            }

            return list;
        }

             /*  判断输入数据是否为NULL */
       /* public static boolean checkFieldValueNull(String string) {

            if (string == null) {
                return true;
            } else if (string.isEmpty()) {
                return true;
            }
            return false;
        }*/
    }


