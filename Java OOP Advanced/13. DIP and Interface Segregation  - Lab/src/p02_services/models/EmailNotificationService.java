package p02_services.models;

import p02_services.contracts.NotificationService;

public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification() {
        System.out.println("email notification test");
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
