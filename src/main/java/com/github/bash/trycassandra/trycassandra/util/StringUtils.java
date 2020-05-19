package com.github.bash.trycassandra.trycassandra.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {
  public static String getStringDigest(String data) {
    if (data == null){
      return null;
    }
    MessageDigest md;
    try {
      md = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException e) {
      return "";
    }
    md.update(data.getBytes());
    var digest = md.digest();
    StringBuilder sb = new StringBuilder();
    for (int b : digest) {
      int d = b;
      if (d < 0) {  // byte型では128～255が負値になっているので補正
        d += 256;
      }
      if (d < 16) {  // 0～15は16進数で1けたになるので、2けたになるよう頭に0を追加
        sb.append("0");
      }
      sb.append(Integer.toString(d, 16));  // ダイジェスト値の1バイトを16進数2けたで表示
    }
    return sb.toString();
  }
}
