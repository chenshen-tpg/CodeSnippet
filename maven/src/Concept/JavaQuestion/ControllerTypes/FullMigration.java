package ControllerTypes;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 *
 *This is an example of Full MicroService Migration in SpringBoot
 * Each service is the separate Spring Boot Application
 *
 */
public class FullMigration {
    class User {

    }

    class Order {

    }

    @RestController
    @RequestMapping("/users")
    public class UserController {

        @GetMapping("/{id}")
        public User getUser(@PathVariable Long id) {
            return null;
        }
    }

    @RequestMapping("/orders")
    public class OrderController {

        @GetMapping("/{id}")
        public Order getOrder(@PathVariable Long id) {
            return null;
        }

        @GetMapping("/user/{userId}")
        public List<Order> getOrdersByUser(@PathVariable Long userId) {
            return null;
        }
    }
}
