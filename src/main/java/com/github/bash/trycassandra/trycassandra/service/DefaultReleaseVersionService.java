package com.github.bash.trycassandra.trycassandra.service;

import com.github.bash.trycassandra.trycassandra.dao.ReleaseVersionDao;
import com.github.bash.trycassandra.trycassandra.fw.ConnectionConfig;
import org.springframework.stereotype.Component;

@Component
public class DefaultReleaseVersionService implements ReleaseVersionService {
    public DefaultReleaseVersionService() {

    }

    @Override
    public String getReleaseVersion() {
        try (ReleaseVersionDao dao = new ReleaseVersionDao(ConnectionConfig.getSession())) {
            return dao.getReleaseVersion();
        }
    }
}
