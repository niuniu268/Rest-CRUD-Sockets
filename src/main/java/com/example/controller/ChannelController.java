package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.pojo.Channels;
import com.example.service.ChannelService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.WebSession;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.Session;
import javax.websocket.server.PathParam;
import java.nio.channels.Channel;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/channel")
public class ChannelController {
    @Autowired
    private BroadcastServer broadcastServer;
    @Autowired
    private ChannelService channelService;


    @GetMapping
    @ResponseBody
    public String selectAll(){

       return JSON.toJSONString(  channelService.selectAll());
    }


    @PostMapping
    public void save(@RequestBody Channels channels){

        broadcastServer.broadcast( JSON.toJSONString(channelService.insert( channels )) );

    }
    @DeleteMapping({"{id}"})
    public void deleteItem(@PathVariable Integer id){
        channelService.delete( id );
    }
}
