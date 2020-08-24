package com.luanelioliveira.gobarber.ui.rest.status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
  private static final String STATUS_OK = "OK";

  @GetMapping
  public String status() {
    return STATUS_OK;
  }
}
