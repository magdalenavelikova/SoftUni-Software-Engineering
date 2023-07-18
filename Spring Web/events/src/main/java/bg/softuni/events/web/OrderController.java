package bg.softuni.events.web;

import bg.softuni.events.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

  private OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/dummy/order/create")
  public String createOrder() {
    orderService.createOrder("3", 33);
    return "Hello!";
  }
}
