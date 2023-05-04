package com.example.stacksourcewebservice.service.impl;

import com.example.stacksourcewebservice.entities.Message;
import com.example.stacksourcewebservice.repository.IMessageRepository;
import com.example.stacksourcewebservice.service.IMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MessageServiceImpl implements IMessageService {

    private final IMessageRepository messageRepository;

    public MessageServiceImpl(IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    @Transactional
    public Message save(Message message) throws Exception {
        return messageRepository.save(message);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        messageRepository.deleteById(id);
    }

    @Override
    public List<Message> getAll() throws Exception {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> getById(Long id) throws Exception {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> findLastMessageDeveloper(long id) throws Exception {
        return messageRepository.findLastMessageDeveloper(id);
    }

    @Override
    public List<Message> findLastMessageCompany(long id) throws Exception {
        return messageRepository.findLastMessageCompany(id);
    }
}
