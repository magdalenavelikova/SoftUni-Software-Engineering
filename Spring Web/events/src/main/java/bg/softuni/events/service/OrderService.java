package bg.softuni.events.service;

import bg.softuni.events.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
  private final ApplicationEventPublisher eventPublisher;


  public OrderService(ApplicationEventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  public void createOrder(String productId, int quantity) {
    LOGGER.info("Creating order for product {} with quantity {}.",
        productId, quantity);

    // TODO: do some work

    OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(
        OrderService.class.getSimpleName(),
        productId
    );

    eventPublisher.publishEvent(orderCreatedEvent);
  }

}
