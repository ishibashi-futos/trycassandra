package com.github.bash.trycassandra.trycassandra.controller;

import com.github.bash.trycassandra.trycassandra.service.ReleaseVersionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versions")
public class ReleaseVersionController {
  ReleaseVersionService service;

  public ReleaseVersionController(final ReleaseVersionService service) {
    this.service = service;
  }

  @GetMapping(value = "cassandra")
  public String cassandraVersion() {
    return service.getReleaseVersion();
  }
}
