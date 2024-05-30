package com.bitgo.respository;

import com.bitgo.data.Notification;
import com.bitgo.data.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {

    List<Notification> findByStatus(NotificationStatus status);

}
