package com.bitgo.controller;

import com.bitgo.data.Notification;
import com.bitgo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService service;


    @PostMapping("create")
    public ResponseEntity<?> createNotification(@RequestBody Notification notification){
        try{
            var response = service.createNotification(notification);
            return ResponseEntity.ok(response);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("send")
    public ResponseEntity<?> sendNotification(@RequestParam List<String> emailIds){
        try{
            service.sendNotification(emailIds);
            return ResponseEntity.ok("Successfully sent Email ");
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> getNotifications(){
        try{
            var response = service.getNotifications();
            return ResponseEntity.ok(response);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("update")
    public ResponseEntity<?>  updateNotification(@RequestBody Notification notification) {
        try {
            var response = service.updateNotification(notification);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?>  deleteNotification(@PathVariable Long id) {
        try {
            service.deleteNotification(id);
            return ResponseEntity.ok("Successfully deleted notification");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
