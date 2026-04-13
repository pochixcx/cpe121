package lectures.Midterm.Lecture8.examples.NotificationSystem.src.notifications;

import lectures.Midterm.Lecture8.examples.NotificationSystem.src.interfaces.Notification;

public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}