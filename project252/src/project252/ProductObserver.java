package project252;

import java.util.ArrayList;
import java.util.List;

interface ProductObserver {
    void update(String message);
}

// Concrete observer classes
class EmailNotification implements ProductObserver {
    @Override
    public void update(String availability) {
        System.out.println("Email Notification: Product is now " + availability);
    }
}

class SMSNotification implements ProductObserver {
    @Override
    public void update(String availability) {
        System.out.println("SMS Notification: Product is now " + availability);
    }
}
