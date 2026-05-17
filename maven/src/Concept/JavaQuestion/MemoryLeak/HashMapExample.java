package PlatformQA.MemoryLeak;

import org.springframework.web.bind.annotation.*;

import java.util.*;

public class HashMapExample {


    @RestController
    public class SessionController {
        // BAD: Static map causes memory leak if not managed properly
        private final Map<String, UserSession> sessionCache = new HashMap<>();

        @PostMapping("/login")
        public String login(@RequestParam String userId) {
            UserSession session = new UserSession(userId, new Date());
            sessionCache.put(userId, session);
            return "Logged in: " + userId;
        }

        @PostMapping("/logout")
        public String logout(@RequestParam String userId) {
            // If you forget to remove the session, memory leak occurs!
            sessionCache.remove(userId);
            return "Logged out: " + userId;
        }

        // Simulate session usage
        @GetMapping("/session")
        public UserSession getSession(@RequestParam String userId) {
            return sessionCache.get(userId);
        }
    }

    class UserSession {
        private String userId;
        private Date loginTime;
        // ... other fields

        public UserSession(String userId, Date loginTime) {
            this.userId = userId;
            this.loginTime = loginTime;
        }
        // getters/setters
    }
}
