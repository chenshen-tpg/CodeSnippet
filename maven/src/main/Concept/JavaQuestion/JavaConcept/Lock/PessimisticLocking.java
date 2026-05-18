package main.Concept.JavaQuestion.JavaConcept.Lock;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;

import java.math.BigDecimal;

public class PessimisticLocking {

    @PersistenceContext
    EntityManager em;

    public void updateAccount(Long id, BigDecimal amount) {
        Account acc = em.find(Account.class, id, LockModeType.PESSIMISTIC_WRITE);
        acc.setBalance(acc.getBalance());
    }

    class Account {
        String balance;

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public void add(BigDecimal bigD) {

        }

    }
}
