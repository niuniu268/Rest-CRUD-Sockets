package com.example.service;

import com.example.mapper.ChannelMapper;
import com.example.pojo.Channels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ChannelService {

    List <Channels> selectAll();

    Boolean update(Channels channels);

    String insert (Channels channels);

    Boolean delete(Integer id);

}
