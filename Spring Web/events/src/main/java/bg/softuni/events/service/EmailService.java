package bg.softuni.events.service;

import bg.softuni.events.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);


  @EventListener(OrderCreatedEvent.class)
  public void onOrderCreated(OrderCreatedEvent evt) {
    LOGGER.info("Sending email to user for order {}", evt.getOrderId());
  }
}
