package lectures.Lecture8.examples.NotificationSystem.src.notifications;

import lectures.Lecture8.examples.NotificationSystem.src.interfaces.Notification;

public class PushNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending PUSH notification: " + message);
    }
}