package com.github.bash.trycassandra.trycassandra.fw;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionConfig {
    private static CqlSession get() {
        return CqlSession.builder().withAuthCredentials("user", "pass").build();
    }
    public CqlSession getSession() {
        return ConnectionConfig.get();
    }
}
