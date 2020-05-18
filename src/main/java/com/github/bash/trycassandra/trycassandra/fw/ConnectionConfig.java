package com.github.bash.trycassandra.trycassandra.fw;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionConfig {
    public static CqlSession getSession() {
        return CqlSession.builder().withAuthCredentials("user", "pass").build();
    }
}
