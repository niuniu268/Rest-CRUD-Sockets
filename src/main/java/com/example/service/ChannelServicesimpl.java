package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.mapper.ChannelMapper;
import com.example.pojo.Channels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChannelServicesimpl implements ChannelService{
    @Autowired
    private ChannelMapper channelMapper;
    @Override
    public List <Channels> selectAll () {

        return channelMapper.selectAll();
    }

    @Override
    public Boolean update (Channels channels) {
        channelMapper.update( channels );
        return null;
    }

    @Override
    public String insert (Channels channels) {

        channelMapper.insert( channels );



        return JSON.toJSONString( channels );
    }

    @Override
    public Boolean delete (Integer id) {
        channelMapper.delete( id );
        return null;
    }
}
