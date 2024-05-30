package com.bitgo.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long notificationId;

    @Column(name = "current_price_of_bitcoin")
    private Double currentPriceOfBitCoin;

    @Column(name = "daily_percentage_change")
    private Double dailyPercentageChange;

    @Column(name = "trading_volume")
    private Long tradingVolume;

    @Column(name ="status")
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

}
