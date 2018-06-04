package com.gem.demo.service;

import com.gem.demo.dao.MessageCatoryMapper;
import com.gem.demo.dao.MessageMapper;
import com.gem.demo.entity.Message;
import com.gem.demo.entity.MessageCatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements  MessageService {
    @Autowired//注入
    private MessageCatoryMapper messageCatoryMapper;
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<MessageCatory> getAllMessageCatory() {
        return messageCatoryMapper.getAllMessageCatory();
    }

    @Override
    public List<Message> getMessageByCatory(int catoryId) {
        return messageMapper.getMessageByCatory(catoryId);
    }

    @Override
    public String getAnswerById(int messageId) {
        return messageMapper.getAnswerById(messageId);
    }
}
