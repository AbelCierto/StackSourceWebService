package com.example.stacksourcewebservices.service;

import com.example.stacksourcewebservices.entities.Message;

import java.util.List;

public interface IMessageService extends CrudService<Message>{
    List<Message> findLastMessageDeveloper(long id) throws Exception;
    List<Message> findLastMessageCompany(long id) throws Exception;
}
