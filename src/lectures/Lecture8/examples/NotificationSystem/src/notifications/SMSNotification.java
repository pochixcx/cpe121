package lectures.Lecture8.examples.NotificationSystem.src.notifications;

import lectures.Lecture8.examples.NotificationSystem.src.interfaces.Notification;

public class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}