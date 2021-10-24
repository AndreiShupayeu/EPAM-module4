package by.epam.module4.simple.classes.objects.task8;
//Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
//и методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
//Найти и вывести:
//a) список покупателей в алфавитном порядке;
//b) список покупателей, у которых номер кредитной карточки находится в заданном интервале

import java.util.Arrays;

public class Task8 {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Mozalev", "Nikolay", "Semenovich", "Minsk,Lermontova,15-15", 1234, 2536);
        Customer customer2 = new Customer(1, "Mozalev", "Aleksandr", "Andreevich", "Minsk,Lermontova,15-15", 2356, 7777);
        Customer customer3 = new Customer(1, "Firsov", "Daniil", "Vladimirovich", "Minsk,Lermontova,15-15", 3561, 5555);
        Customer customer4 = new Customer(1, "Firsov", "Daniil", "Alekseevich", "Minsk,Lermontova,15-15", 4828, 2533);
        Customer customer5 = new Customer(1, "Shendik", "Aleksei", "Ivanovich", "Minsk,Lermontova,15-15", 2457, 2511);

        Customer[] customerArray = new Customer[5];
        customerArray[0] = customer1;
        customerArray[1] = customer2;
        customerArray[2] = customer3;
        customerArray[3] = customer4;
        customerArray[4] = customer5;
        CustomerArray customerArray1 = new CustomerArray(customerArray);

        customerArray1.sortCustomersInAlphabeticalOrder();
        System.out.println("Customers in alphabetical order:");
        customerArray1.printInfo();

        System.out.println();

        System.out.println("Customers with a cards within range: 3561 - 4828" + "\n" +
                Arrays.toString(customerArray1.printCustomersWithCardInRange(3561, 4828)));

    }
}

class Customer {
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String address;
    private int card;
    private int account;

    public Customer(int id, String surname, String name, String middleName, String address, int card, int account) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.card = card;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", address='" + address + '\'' +
                ", card=" + card +
                ", Account=" + account +
                '}';
    }
}

class CustomerArray {
    private Customer[] list;

    public CustomerArray(Customer[] list) {
        this.list = list;
    }

    public Customer[] getList() {
        return list;
    }

    public void setList(Customer[] list) {
        this.list = list;
    }

    public void sortCustomersInAlphabeticalOrder() {
        for (int i = 0; i < list.length; i++) {
            for (int j = list.length - 1; j > i; j--) {
                if (list[j].getSurname().compareTo(list[j - 1].getSurname()) < 0) {
                    swap(list, j, j - 1);
                } else {
                    if (list[j].getSurname().compareTo(list[j - 1].getSurname()) == 0) {
                        if (list[j].getName().compareTo(list[j - 1].getName()) < 0) {
                            swap(list, j, j - 1);
                        } else {
                            if (list[j].getName().compareTo(list[j - 1].getName()) == 0) {
                                if (list[j].getMiddleName().compareTo(list[j - 1].getMiddleName()) < 0) {
                                    swap(list, j, j - 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Customer[] printCustomersWithCardInRange(int min, int max) {
        int length = 0;
        for (Customer customer : list) {
            if (min <= customer.getCard() && customer.getCard() <= max) {
                length++;
            }
        }
        Customer[] arrays = new Customer[length];
        int index = 0;
        for (Customer customer : list) {
            if (min <= customer.getCard() && customer.getCard() <= max) {
                arrays[index++] = customer;
            }
        }
        return arrays;
    }

    public void printInfo() {
        for (Customer customer : list) {
            System.out.println(customer.toString());
        }
    }

    public static void swap(Customer[] list, int i, int j) {
        Customer temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}

