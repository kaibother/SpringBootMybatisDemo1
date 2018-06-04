package com.gem.demo.dao;

import com.gem.demo.entity.MessageCatory;

import java.util.List;

public interface MessageCatoryMapper {
    //获得所有的类别，在初始页面显示
    public List<MessageCatory> getAllMessageCatory();

}
