package com.github.bash.trycassandra.trycassandra.fw;

import com.datastax.oss.driver.api.core.CqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.util.Objects;

public abstract class CassandraDao implements Closeable {
    private final Logger logger = LoggerFactory.getLogger(CassandraDao.class);
    protected final CqlSession session;

    public CassandraDao(CqlSession session) {
        this.logger.debug("initialize cassandra dao.");
        this.session = session;
    }

    public void close() {
        this.logger.debug("close cassandra dao.");
        if (Objects.nonNull(this.session)) {
            if (this.session.isClosed()) {
                this.logger.debug("already closed cassandra dao.");
            }
            try {
                this.session.close();
                this.logger.debug("successfully closed the cassandra session.");
            } catch (Exception e) {
                this.logger.error("cassandra session close error.", e);
            }
        } else {
            this.logger.debug("cassandra dao is null.");
        }
    }
}
