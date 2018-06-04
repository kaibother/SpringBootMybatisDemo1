package com.gem.demo.dao;

import com.gem.demo.entity.Message;

import java.util.List;

public interface MessageMapper {
    //根据类别号获得该类别下的所有问题
    public List<Message> getMessageByCatory(int catory_Id);
    //根据问题号得到答案
    public String getAnswerById(int messageId);
}
