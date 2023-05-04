package com.example.stacksourcewebservices.service.impl;

import com.example.stacksourcewebservices.entities.Notification;
import com.example.stacksourcewebservices.repository.INotificationRepository;
import com.example.stacksourcewebservices.service.INotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class NotificationServiceImpl implements INotificationService {

    private final INotificationRepository notificationRepository;

    public NotificationServiceImpl(INotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    @Transactional
    public Notification save(Notification notification) throws Exception {
        return notificationRepository.save(notification);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        notificationRepository.deleteById(id);
    }

    @Override
    public List<Notification> getAll() throws Exception {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> getById(Long id) throws Exception {
        return notificationRepository.findById(id);
    }

    @Override
    public List<Notification> findLastNotificationDeveloper(long id) throws Exception {
        return notificationRepository.findLastNotificationDeveloper(id);
    }

    @Override
    public List<Notification> findLastNotificationCompany(long id) throws Exception {
        return notificationRepository.findLastNotificationCompany(id);
    }
}
