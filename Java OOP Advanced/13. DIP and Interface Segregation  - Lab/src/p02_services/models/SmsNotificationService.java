package p02_services.models;

import p02_services.contracts.NotificationService;

public class SmsNotificationService implements NotificationService {

    @Override
    public void sendNotification() {
        System.out.println("sms notification test");
    }

    @Override
    public boolean isActive() {
        return false;
    }
}
