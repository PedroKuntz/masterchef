package com.ello.masterchef.sales.controller;

import com.ello.masterchef.sales.model.SalesChannel;
import com.ello.masterchef.sales.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/channel")
public class ChannelController {

  @Autowired
  private ChannelService channelService;

  @PostMapping
  public ResponseEntity<?> createChannel(@RequestBody SalesChannel salesChannel) {
    channelService.create(salesChannel);
    return new ResponseEntity(HttpStatus.CREATED);
  }

}
