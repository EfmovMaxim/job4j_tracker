package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (users.putIfAbsent(user, new ArrayList<Account>()) == null) {
            System.out.println("Новый пользователь добавлен");
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
                System.out.println("Новый счет пользователь добавлен");
            }

        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            for (Account account : userAccounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String scrPassport, String scrRequisite,
                                 String destPassport, String destRequisite, double amount) {

        Account scrAccount = findByRequisite(scrPassport, scrRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        if (scrAccount == null) {
            System.out.println("Не найдет счет-отправитель");
            return false;
        }

        if (destAccount == null) {
            System.out.println("Не найдет счет-получатель");
            return false;
        }

        if (scrAccount.getBalance() < amount) {
            System.out.println("На счете-отправителе недостаточно средств");
            return false;
        }

        scrAccount.setBalance(scrAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);

        return true;
    }
}
