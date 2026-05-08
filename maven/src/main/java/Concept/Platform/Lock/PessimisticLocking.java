package Concept.Platform.Lock;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;

import java.math.BigDecimal;

public class PessimisticLocking {

    @PersistenceContext
    EntityManager em;
    class Account{
        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        String balance;
        public void add(BigDecimal bigD){

        }

    }
    public void updateAccount(Long id, BigDecimal amount) {
        Account acc = em.find(Account.class, id, LockModeType.PESSIMISTIC_WRITE);
        acc.setBalance(acc.getBalance());
    }
}
