package com.github.wendao76.test;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className Index
 * @date 2020-6-5 15:40
 */
public class Index {
  public static void main(String[] args) {
    System.out.println(concat("a", "b", "c"));
  }

  static String concat(String... str2) {
    StringBuilder sb = new StringBuilder();
    for (String str : str2) {
      sb.append(str);
    }
    return sb.toString();
  }
}
