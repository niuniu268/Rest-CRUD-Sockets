package com.example;

import com.example.controller.BroadcastServer;
import com.example.mapper.ChannelMapper;
import com.example.service.ChannelService;
import com.example.service.ChannelServicesimpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.example.mapper")
class Demo3ApplicationTests {

    @Autowired
    private BroadcastServer broadcastServer;
    @Autowired
    private ChannelMapper channelMapper;
    @Autowired
    private ChannelService channelService;

    @Test
    void contextLoads() {
        channelMapper.selectAll();
    }

    @Test
    void testSelectall(){
        channelService.selectAll();

    }

}
