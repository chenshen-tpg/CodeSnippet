package Concept.Platform.DecoratorNInterceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class Example {

    // Component interface
    public interface Notifier {
        void send(String message);
    }

    // Concrete component
    public class EmailNotifier implements Notifier {
        public void send(String message) {
            System.out.println("Sending email: " + message);
        }
    }

    // Decorator
    public class NotifierDecorator implements Notifier {
        protected Notifier notifier;
        public NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }
        public void send(String message) {
            notifier.send(message);
        }
    }

    // Concrete decorator
    public class SMSDecorator extends NotifierDecorator {
        public SMSDecorator(Notifier notifier) {
            super(notifier);
        }
        public void send(String message) {
            super.send(message);
            System.out.println("Sending SMS: " + message);
        }
    }

    // Usage
    public class Main {
        public void main(String[] args) {
//            Notifier notifier = new SMSDecorator(new EmailNotifier());
//            notifier.send("Hello!");
            // Output:
            // Sending email: Hello!
            // Sending SMS: Hello!
        }
    }



    // Spring Web Interceptor Example


    public class LoggingInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
            System.out.println("Request URL: " + request.getRequestURL());
            return true; // Continue to the next interceptor or controller
        }
        // postHandle and afterCompletion can also be overridden
    }
}
