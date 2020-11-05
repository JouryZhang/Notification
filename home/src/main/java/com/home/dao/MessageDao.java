package com.home.dao;

import com.home.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageDao {
    int deleteByPrimaryKey(String messageid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String messageid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> selectByPage(int from, int to);
}