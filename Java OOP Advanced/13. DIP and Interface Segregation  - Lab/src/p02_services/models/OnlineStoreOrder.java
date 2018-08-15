package p02_services.models;

import p02_services.contracts.NotificationService;

public class OnlineStoreOrder {

    private NotificationService[] services;

    public OnlineStoreOrder(NotificationService... services) {
       this.services = services;
    }

    public void process() {
        for (NotificationService service : this.services) {
            if (service.isActive()) {
                service.sendNotification();
            }
        }
    }
}
