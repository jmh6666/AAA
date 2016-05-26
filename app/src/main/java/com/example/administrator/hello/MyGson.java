package com.example.administrator.hello;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/5/22.
 */
public class MyGson {
    public static String str1="{\"i\":\"5410\",\"n\":\"777路\"}";
    public static String str2="{\"rn\":\"777路\",\"d\":\"0\",\"c\":\"07770\",\"ft\":\"0700\",\"lt\":\"2100\",\"l\":[{\"i\":\"154495\",\"n\":\"天河城总站\",\"sni\":\"2036\",\"si\":\"10007478\"},{\"i\":\"154486\",\"n\":\"体育西路南站\",\"sni\":\"749\",\"si\":\"10000243\"},{\"i\":\"176247\",\"n\":\"体育西横街路口站\",\"sni\":\"748\",\"si\":\"10009835\"},{\"i\":\"154497\",\"n\":\"天河站\",\"sni\":\"2043\",\"si\":\"10000319\"},{\"i\":\"154498\",\"n\":\"华夏路北站\",\"sni\":\"1117\",\"si\":\"10009712\"},{\"i\":\"154499\",\"n\":\"华成路口站\",\"sni\":\"1135\",\"si\":\"10005051\"},{\"i\":\"191227\",\"n\":\"花城广场（友谊国金店）站\",\"sni\":\"1325\",\"si\":\"10011123\"},{\"i\":\"154500\",\"n\":\"猎德站\",\"sni\":\"4044\",\"si\":\"10004731\"},{\"i\":\"236227\",\"n\":\"猎德东站\",\"sni\":\"4041\",\"si\":\"10027754\"},{\"i\":\"154501\",\"n\":\"猎德码头站\",\"sni\":\"4043\",\"si\":\"10004727\"},{\"i\":\"154502\",\"n\":\"临江大道东站\",\"sni\":\"465\",\"si\":\"10004748\"},{\"i\":\"154507\",\"n\":\"马场路南（南国花园）站\",\"sni\":\"2307\",\"si\":\"10003459\"},{\"i\":\"154503\",\"n\":\"珠江新城总站\",\"sni\":\"4136\",\"si\":\"10000212\"}]}\n";

    public static C c;
    public List<B> b;


    public static void main(String[] args){
        Gson gson=new Gson();
//        Type type = new TypeToken<MyGson>(){}.getType();
//        MyGson mGson=gson.fromJson(str2,type);
//        System.out.print(c.getC());
        String str1 = "{\"i\":\"5410\",\"n\":\"777路\",\"list\":[1,2,3,4]}";
        Test1 test1 = gson.fromJson(str1, Test1.class);
//        System.out.println(test1);

        //String str2 = "{\"i\":\"5410\",\"n\":\"777路\",\"list\":[{\"name\":\"hello\"},{\"name\":\"world\"},{\"name\":\"aaaaa\"}]}";
       // Test2 test2 = gson.fromJson(str2, Test2.class);
//        System.out.println(test2);

        String str3 = "[{\"i\":\"5410\",\"n\":\"777路\",\"list\":[{\"name\":\"hello\"},{\"name\":\"world\"},{\"name\":\"aaaaa\"}]}, {\"i\":\"5410\",\"n\":\"777路\",\"list\":[{\"name\":\"hello\"},{\"name\":\"world\"},{\"name\":\"aaaaa\"}]}]";
        List<Test2> listt = gson.fromJson(str3, new TypeToken<List<Test2>>(){}.getType());
//        System.out.println(listt);
        C c=gson.fromJson(str2,C.class);

        System.out.println(c);
    }

    class Test2 {
        private String i;
        private String n;
        private List<Test2Item> list;

        @Override
        public String toString() {
            return "Test2{" +
                    "i='" + i + '\'' +
                    ", n='" + n + '\'' +
                    ", list=" + list +
                    '}';
        }
    }

    class Test2Item{
        private String name;

        @Override
        public String toString() {
            return "Test2Item{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    class Test1 {
        private String i;
        private String n;
        private List<Integer> list;

        @Override
        public String toString() {
            return "Test1{" +
                    "i='" + i + '\'' +
                    ", n='" + n + '\'' +
                    ", list=" + list +
                    '}';
        }
    }

//
//    class A {
//        private String i;
//        private String n;
//
//        public String getI() {
//            return i;
//        }
//
//        public String getN() {
//            return n;
//        }
//
//        @Override
//        public String toString() {
//            return "A{" +
//                    "i='" + i + '\'' +
//                    ", n='" + n + '\'' +
//                    '}';
//        }
//    }
//
//    public static void main(String[] args){
//        Gson gson = new Gson();
//        A s = gson.fromJson(str1,A.class);
//        System.out.println(s.getI());
//        System.out.println(s.getN());
//    }

    static class B{
        private  String i;
        private String n;
        private String sni;
        private String si;

        @Override
        public String toString() {
            return "B{" +
                    "i='" + i + '\'' +
                    ", n='" + n + '\'' +
                    ", sni='" + sni + '\'' +
                    ", si='" + si + '\'' +
                    '}';
        }

        public String getI() {
            return i;
        }

        public String getN() {
            return n;
        }

        public String getSni() {
            return sni;
        }

        public String getSi() {
            return si;
        }
    }
   static class C{
       @SerializedName("rn")
        private String name;
        private String d;
        private String c;
        private String ft;
        private List<B> l;

       @Override
       public String toString() {
           
           return "C{" +
                   "rn='" + name + '\'' +
                   ", d='" + d + '\'' +
                   ", c='" + c + '\'' +
                   ", ft='" + ft + '\'' +
                   ", l=" + l +
                   ", lt='" + lt + '\'' +
                   '}';
       }

        public String getD() {
            return d;
        }

        public String getC() {
            return c;
        }

        public String getFt() {
            return ft;
        }

        public String getLt() {
            return lt;
        }

        private String lt;
    }

}
