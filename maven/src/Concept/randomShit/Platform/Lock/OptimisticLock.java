package Concept.randomShit.Platform.Lock;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.A;

import java.math.BigDecimal;

public class OptimisticLock {
    @Entity
    public class Account {
        @Id
        private Long id;

        @Version
        private int version;

        @Getter
        @Setter
        private BigDecimal balance;

    }

    // Usage
    public void updateAccount(Long id, BigDecimal amount) {
        Account acc = new Account();
        acc.setBalance(acc.getBalance().add(amount));
        // On commit, Hibernate checks the version field.
        // If another transaction updated it, an OptimisticLockException is thrown.
    }
}
