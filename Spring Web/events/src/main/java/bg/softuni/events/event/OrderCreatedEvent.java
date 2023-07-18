package bg.softuni.events.event;

import org.springframework.context.ApplicationEvent;

public class OrderCreatedEvent extends ApplicationEvent {

  private final String orderId;

  public OrderCreatedEvent(Object source,
                           String orderId) {
    super(source);
    this.orderId = orderId;
  }

  public String getOrderId() {
    return orderId;
  }
}
