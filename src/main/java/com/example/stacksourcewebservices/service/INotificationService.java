package com.example.stacksourcewebservices.service;
import com.example.stacksourcewebservices.entities.Notification;

import java.util.List;

public interface INotificationService extends CrudService<Notification>{
    List<Notification> findLastNotificationDeveloper(long id) throws Exception;
    List<Notification> findLastNotificationCompany(long id) throws Exception;
}
