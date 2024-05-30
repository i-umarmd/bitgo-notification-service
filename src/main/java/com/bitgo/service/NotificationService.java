package com.bitgo.service;

import com.bitgo.data.Notification;
import com.bitgo.data.NotificationStatus;
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
        notification.setCreatedBy((long) -90);
        notification.setUpdatedBy((long) -90);
        notification.setCreatedTimeStamp(LocalDateTime.now());
        notification.setUpdatedTimeStamp(LocalDateTime.now());
        notification.setStatus(NotificationStatus.PENDING);
        return  repository.save(notification);
    }

    public Notification updateNotification(Notification notification) throws Exception {
        var dbNotificationOpt = repository.findById(notification.getNotificationId());
        if(dbNotificationOpt.isEmpty()){
            throw new Exception("Record not found");
        }
        var dbNotification = dbNotificationOpt.get();
        // this can be optimised using mapstruct dependency
        dbNotification.setCurrentPriceOfBitCoin(notification.getCurrentPriceOfBitCoin());
        dbNotification.setDailyPercentageChange(notification.getDailyPercentageChange());
        dbNotification.setTradingVolume(notification.getTradingVolume());
        dbNotification.setUpdatedBy((long) -90);
        dbNotification.setUpdatedTimeStamp(LocalDateTime.now());
        return  repository.save(dbNotification);
    }

    public void deleteNotification(Long id) throws Exception {
        var dbNotificationOpt = repository.findById(id);
        if(dbNotificationOpt.isEmpty()){
            throw new Exception("Record not found");
        }
        repository.delete(dbNotificationOpt.get());
    }



    public void sendNotification(List<String> emailIds){
        var notifications = repository.findByStatus(NotificationStatus.PENDING);
        notifications.forEach(notification -> notification.setStatus(NotificationStatus.SENT));
        log.info("Sent Notifications for emailIds: {}",emailIds);
    }

    public List<Notification> getNotifications(){
        return repository.findAll();
    }
}
