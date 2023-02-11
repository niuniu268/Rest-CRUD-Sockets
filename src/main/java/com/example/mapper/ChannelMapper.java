package com.example.mapper;

import com.example.pojo.Channels;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChannelMapper {

    @Results(
            {
                    @Result(property =  "id", column = "id"),
                    @Result(property = "channelName", column = "name")
            }

    )
    @Select( "select * from channel;" )
    List <Channels> selectAll();
    @Update( "update channel set name=#{channelName} where id = #{id}" )
    void update( Channels channels);
    @Insert("insert into channel values ( null, #{channelName}) ")
    void insert (Channels channels);
    @Delete( "delete from channel where id = #{id}" )
    void delete(Integer id);
}
