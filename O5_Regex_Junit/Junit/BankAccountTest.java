package org.rajesh;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(200.0);
        account.withdraw(80.0);
        assertEquals(120.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount(50.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.0));
    }

    @Test
    void testDepositNegativeAmount() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50.0));
    }
}
