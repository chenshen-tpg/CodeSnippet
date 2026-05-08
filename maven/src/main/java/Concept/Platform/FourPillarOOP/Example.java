package Concept.Platform.FourPillarOOP;

public class Example {

    //Encapsulation, having object class and getter&setter method
    public class User {
        private String name;
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    //Abstraction, having a interface that can be overridden.
    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    //Inheritance, get properties from other class.
    public class CreditCardPayment implements PaymentProcessor {
        public void processPayment(double amount) {
            // Implementation
        }
    }

    //Polymorphism same method name for different parameters taken
    public void makePayment(PaymentProcessor processor, double amount) {
        processor.processPayment(amount);
    }
}
