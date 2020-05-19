package com.github.bash.trycassandra.trycassandra.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
  @Test
  public void testGetStringDigest_isNull() {
    var result = StringUtils.getStringDigest(null);
    Assertions.assertNull(result);
  }

  @Test
  public void testGetStringDigest_isEmpty() {
    var result = StringUtils.getStringDigest("");
    Assertions.assertEquals("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", result);
  }

  @Test
  public void testGetStringDigest_isString() {
    var password = "P@s5w0rd";
    var digest = StringUtils.getStringDigest(password);
    Assertions.assertEquals("181bd50ae63d9821d57cedbe4f1924a7cfe17a377b4e442c1cec30682e2934c9", digest);
    Assertions.assertEquals(digest.length(), 64);
  }
}
