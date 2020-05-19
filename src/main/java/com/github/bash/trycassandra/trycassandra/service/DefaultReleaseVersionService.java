package com.github.bash.trycassandra.trycassandra.service;

import com.github.bash.trycassandra.trycassandra.dao.ReleaseVersionDao;
import org.springframework.stereotype.Component;

@Component
public class DefaultReleaseVersionService implements ReleaseVersionService {
  private final ReleaseVersionDao dao;

  public DefaultReleaseVersionService(final ReleaseVersionDao dao) {
    this.dao = dao;
  }

  @Override
  public String getReleaseVersion() {
    var version = this.dao.getReleaseVersion();
    dao.close();
    return version;
  }
}
