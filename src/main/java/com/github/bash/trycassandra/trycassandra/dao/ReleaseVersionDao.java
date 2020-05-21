package com.github.bash.trycassandra.trycassandra.dao;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.github.bash.trycassandra.trycassandra.fw.CassandraDao;
import com.github.bash.trycassandra.trycassandra.fw.ConnectionConfig;
import org.springframework.stereotype.Component;

@Component
public class ReleaseVersionDao extends CassandraDao {
  public ReleaseVersionDao(final ConnectionConfig connectionConfig) {
    super(connectionConfig.getCqlSession());
  }

  public String getReleaseVersion() {
    ResultSet rs = session.execute("select release_version from system.local");
    var row = rs.one();
    return row.getString("release_version");
  }
}
