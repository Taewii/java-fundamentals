package p02_services;

import p02_services.models.EmailNotificationService;
import p02_services.models.OnlineStoreOrder;
import p02_services.models.SmsNotificationService;

public class Main {
    public static void main(String[] args) {

        OnlineStoreOrder store = new OnlineStoreOrder(new EmailNotificationService(), new SmsNotificationService());

        store.process();
    }
}
