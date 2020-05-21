package com.github.bash.trycassandra.trycassandra.fw;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionConfig {
  private static CqlSession get(String keyspace) {
    return CqlSession.builder()
      .withAuthCredentials("user", "pass").withKeyspace(keyspace).build();
  }

  public CqlSession getCqlSession() {
    return ConnectionConfig.get("cqldemo");
  }
}
