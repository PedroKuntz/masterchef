package com.ello.masterchef.sales.controller;

import com.ello.masterchef.sales.model.SalesChannel;
import com.ello.masterchef.sales.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @PutMapping(value = "/table/{tableId}/select")
  public ResponseEntity<?> selectTable(@PathVariable("tableId") String tableId,
                                       @RequestBody SalesChannel salesChannel) {
    channelService.selectTable(tableId, salesChannel);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PutMapping(value = "/card/{tableId}/select")
  public ResponseEntity<?> selectCard(@PathVariable("tableId") String tableId,
                                       @RequestBody SalesChannel salesChannel) {
    channelService.selectCard(tableId, salesChannel);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PutMapping(value = "/table/{tableId}/clear")
  public ResponseEntity<?> clearTable(@PathVariable("tableId") String tableId,
                                      @RequestBody SalesChannel salesChannel) {
    channelService.clearTable(tableId, salesChannel);
    return new ResponseEntity(HttpStatus.OK);
  }

  @GetMapping(value = "/tables")
  public ResponseEntity<?> findAllTables() {
    return new ResponseEntity(channelService.findAllTables(), HttpStatus.OK);
  }

  @GetMapping(value = "/cards")
  public ResponseEntity<?> findAllCards() {
    return new ResponseEntity(channelService.findAllCards(), HttpStatus.OK);
  }

}
