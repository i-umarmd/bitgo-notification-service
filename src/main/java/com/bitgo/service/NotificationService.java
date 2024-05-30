package com.bitgo.service;

import com.bitgo.data.Notification;
import com.bitgo.respository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public Notification createNotification(Notification notification){
        notification.setCreatedBy(Long.valueOf(-90));
        notification.setUpdatedBy(Long.valueOf(-90));
        notification.setCreatedTimeStamp(LocalDateTime.now());
        notification.setUpdatedTimeStamp(LocalDateTime.now());
        return  repository.save(notification);
    }

    public void sendNotification(List<String> emailIds){
        log.info("Sent Notifications for emailIds: {}",emailIds);
    }

    public List<Notification> getNotifications(){
        return repository.findAll();
    }
}
