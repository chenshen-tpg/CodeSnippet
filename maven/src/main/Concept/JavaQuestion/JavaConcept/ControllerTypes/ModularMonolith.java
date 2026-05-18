package main.Concept.JavaQuestion.JavaConcept.ControllerTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/***
 *
 *All modules are in one codebase, but separated by package and clear boundaries.
 *
 */
public class ModularMonolith {
    class User {

    }

    class Order {

    }

    @Service
    public class UserService {
        public User getUser(Long id) {
            return null;
        }
    }

    @Service
    public class OrderService {
        @Autowired
        private UserService userService;

        public Order getOrder(Long id) {
            return null;
        }

        public List<Order> getOrdersByUser(Long userId) {
            User user = userService.getUser(userId);
            return null;
        }
    }
}
