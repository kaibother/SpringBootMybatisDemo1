package com.gem.demo.service;

import com.gem.demo.entity.Message;
import com.gem.demo.entity.MessageCatory;

import java.util.List;

public interface MessageService {
    //获得所有的类别，在初始页面显示
    public List<MessageCatory> getAllMessageCatory();

    //根据类别号获得该类别下的所有问题
    public List<Message> getMessageByCatory(int catoryId);
    //根据问题号得到答案
    public String getAnswerById(int messageId);




}
