create table notification(
	notification_id bigint primary key AUTO_INCREMENT,
   current_price_of_bitcoin double,
   daily_percentage_change double,
   trading_volume bigint,
   created_by bigint,
   created_timeStamp timestamp,
   updated_by bigint,
   updated_timeStamp timestamp
);