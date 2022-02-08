package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (users.putIfAbsent(user, new ArrayList<Account>()) == null) {
            System.out.println("Новый пользователь добавлен");
        }
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccounts = users.get(user.get());
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
                System.out.println("Новый счет пользователь добавлен");
            }

        }
    }

    public Optional<User> findByPassport(String passport) {
//        for (User user : users.keySet()) {
//            if (passport.equals(user.getPassport())) {
//                return user;
//            }
//        }
//        return null;
        return users.keySet()
                .stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
//        if (user != null) {
//            List<Account> userAccounts = users.get(user);
//            for (Account account : userAccounts) {
//                if (requisite.equals(account.getRequisite())) {
//                    return account;
//                }
//            }
//        }

        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(acc -> requisite.equals(acc.getRequisite()))
                    .findFirst();
        }
        return Optional.empty();
    }

    public boolean transferMoney(String scrPassport, String scrRequisite,
                                 String destPassport, String destRequisite, double amount) {

        Optional<Account> scrAccount = findByRequisite(scrPassport, scrRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);

        if (scrAccount.isEmpty()) {
            System.out.println("Не найдет счет-отправитель");
            return false;
        }

        if (destAccount.isEmpty()) {
            System.out.println("Не найдет счет-получатель");
            return false;
        }

        if (scrAccount.get().getBalance() < amount) {
            System.out.println("На счете-отправителе недостаточно средств");
            return false;
        }

        scrAccount.get().setBalance(scrAccount.get().getBalance() - amount);
        destAccount.get().setBalance(destAccount.get().getBalance() + amount);

        return true;
    }
}
