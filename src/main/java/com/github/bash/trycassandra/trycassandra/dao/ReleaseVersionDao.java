package com.github.bash.trycassandra.trycassandra.dao;

import com.datastax.oss.driver.api.core.CqlSession;
import com.github.bash.trycassandra.trycassandra.fw.CassandraDao;

import com.datastax.oss.driver.api.core.cql.ResultSet;

public class ReleaseVersionDao extends CassandraDao {
    public ReleaseVersionDao(final CqlSession session) {
        super(session);
    }

    public String getReleaseVersion() {
        ResultSet rs = session.execute("select release_version from system.local");
        var row = rs.one();
        return row.getString("release_version");
    }
}
