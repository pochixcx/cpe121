package lectures.Midterm.Lecture8.examples.NotificationSystem.src;

import lectures.Midterm.Lecture8.examples.NotificationSystem.src.interfaces.Notification;
import lectures.Midterm.Lecture8.examples.NotificationSystem.src.notifications.EmailNotification;
import lectures.Midterm.Lecture8.examples.NotificationSystem.src.notifications.PushNotification;
import lectures.Midterm.Lecture8.examples.NotificationSystem.src.notifications.SMSNotification;

public class Main {
    public static void main(String[] args) {

        Notification n1 = new EmailNotification();
        Notification n2 = new SMSNotification();
        Notification n3 = new PushNotification();

        n1.send("Your order has been shipped");
        n2.send("Your OTP is 123456");
        n3.send("You have a new message");
    }
}