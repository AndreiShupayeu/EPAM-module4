package by.epam.module4.aggregation_composition.task4;
//Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
//счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
//всем счетам, имеющим положительный и отрицательный балансы отдельно.

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Account account = new Account(5, "Active", 100, -50);
        Account account1 = new Account(3, "Active", 500, -50);
        Account account2 = new Account(7, "Blocked", -200, -50);
        Account account3 = new Account(4, "Active", 1000, -50);
        Account account4 = new Account(9, "Blocked", -100, -50);

        Client client = new Client("Ivanov Ivan Ivanovich", new Account[]{account, account1, account2, account3, account4});

        client.sortByNumber(true);
        System.out.println(client + "\n");

        client.sortByNumber(false);
        System.out.println(client + "\n");

        Account account5 = client.getAccountByNumber(in);
        if (account5 != null) {
            System.out.println(account5 + "\n");
        }

        System.out.println("Total sum of your accounts: " + client.getTotalSumOfAccounts() + "\n");

        System.out.println("Total sum of your accounts with negative balance: " + client.getSumOfAccountsWithNegativeBalance() + "\n");

        System.out.println("Total sum of your accounts with positive balance: " + client.getSumOfAccountsWithPositiveBalance() + "\n");

        account4.refillAccount(1000);
        System.out.println(account4 + "\n");

        account4.doPayment(1500);
        System.out.println(account4 + "\n");
    }
}

class Client {
    private final String name;
    Account[] accounts;

    public Client(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }

    public int getTotalSumOfAccounts() {
        int totalSum = 0;
        for (Account value : accounts) {
            totalSum += value.getBalance();
        }
        return totalSum;
    }

    public int getSumOfAccountsWithNegativeBalance() {
        int totalSum = 0;
        for (Account value : accounts) {
            if (value.getBalance() >= 0) {
                totalSum += value.getBalance();
            }
        }
        return totalSum;
    }

    public int getSumOfAccountsWithPositiveBalance() {
        int totalSum = 0;
        for (Account value : accounts) {
            if (value.getBalance() < 0) {
                totalSum += value.getBalance();
            }
        }
        return totalSum;
    }

    public Account getAccountByNumber(Scanner in) {
        Account account = null;
        int number = 0;
        while (number <= 0) {
            System.out.println("Indicate number of your account, number can't negative:");
            number = in.nextInt();
        }
        for (Account value : accounts) {
            if (value.getNumber() == number) {
                account = value;
                break;
            }
        }
        if (account == null) {
            System.out.println("You don't have an account with the specified number!");
        }
        return account;
    }


    public void sortByNumber(boolean asc) {
        for (int i = 0; i < accounts.length; i++) {
            for (int j = accounts.length - 1; j > i; j--) {
                if (accounts[j].getNumber() < accounts[j - 1].getNumber() == asc) {
                    swap(accounts, j, j - 1);
                }
            }
        }
    }

    public static void swap(Account[] accounts, int i, int j) {
        Account temp = accounts[i];
        accounts[i] = accounts[j];
        accounts[j] = temp;
    }
}

class Account {
    private final int number;
    private String status;
    private int balance;
    private int limit;

    public Account(int number, String status, int balance, int limit) {
        this.number = number;
        this.status = status;
        this.balance = balance;
        this.limit = limit;
    }

    public int getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBalance() {
        return balance;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void doPayment(int sumOfPayment) {
        if (status.equals("Active")) {
            balance -= sumOfPayment;
            if (balance < limit) {
                status = "Blocked";
            }
        } else {
            System.out.println("Your card is blocked!!! Contact your bank!!!");
        }
    }

    public void refillAccount(int sumOfRefill) {
        balance += sumOfRefill;
        if (balance >= limit && status.equals("Blocked")) {
            status = "Active";
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", status='" + status + '\'' +
                ", balance=" + balance +
                ", limit=" + limit +
                '}';
    }
}
