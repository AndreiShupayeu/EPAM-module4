package by.epam.module4.simple.classes.objects.task4;
//Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
//Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
//номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
//Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
//назначения должны быть упорядочены по времени отправления.

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Train[] trains = new Train[5];
        trains[0] = new Train("Gomel", 5, new Time(15, 20));
        trains[1] = new Train("Vitebsk", 4, new Time(11, 40));
        trains[2] = new Train("Brest", 3, new Time(12, 15));
        trains[3] = new Train("Minsk", 9, new Time(14, 55));
        trains[4] = new Train("Gomel", 1, new Time(15, 10));

        sortingNumbers(trains, true);
        print(trains);

        System.out.println();

        sortingNumbers(trains, false);
        print(trains);

        System.out.println();

        Scanner in = new Scanner(System.in);
        System.out.println("Input number train:");
        int number = in.nextInt();

        infoByNumber(trains, number);

        System.out.println();

        infoByDestination(trains);
        print(trains);
    }

    private static void print(Train[] trains) {
        for (Train train : trains) {
            System.out.println("Number train: " + train.getNumberTrain() + " destination: " +
                    train.getDestination() + " departure time: " + train.getTime().getHours() +
                    ":" + train.getTime().getMinutes());
        }
    }

    private static void sortingNumbers(Train[] trains, boolean asc) {
        for (int i = 0; i < trains.length; i++) {
            for (int j = trains.length - 1; j > i; j--) {
                if (trains[j - 1].getNumberTrain() > trains[j].getNumberTrain() == asc) {
                    swap(trains, j, j - 1);
                }
            }
        }
    }

    private static void swap(Train[] trains, int i, int j) {
        Train temp = trains[i];
        trains[i] = trains[j];
        trains[j] = temp;
    }

    private static void infoByNumber(Train[] trains, int numberTrain) {
        for (Train train : trains) {
            if (train.getNumberTrain() == numberTrain) {
                System.out.println("Number train: " + train.getNumberTrain() + " destination: " +
                        train.getDestination() + " departure time: " + train.getTime().getHours() +
                        ":" + train.getTime().getMinutes());
            }
        }
    }

    private static void infoByDestination(Train[] trains) {
        for (int i = 0; i < trains.length; i++) {
            for (int j = trains.length - 1; j > i; j--) {
                if (trains[j].getDestination().compareTo(trains[j - 1].getDestination()) < 0) {
                    swap(trains, j, j - 1);
                } else if (trains[j].getDestination().compareTo(trains[j - 1].getDestination()) == 0) {
                    if (trains[j].getTime().getHours() < trains[j - 1].getTime().getHours()) {
                        swap(trains, j, j - 1);
                    } else if (trains[j].getTime().getHours() == trains[j - 1].getTime().getHours()) {
                        if (trains[j].getTime().getMinutes() < trains[j - 1].getTime().getMinutes()) {
                            swap(trains, j, j - 1);
                        }
                    }
                }
            }
        }
    }
}

class Train {
    private final String destination;
    private final int numberTrain;
    private final Time time;

    public Train(String destination, int numberTrain, Time time) {
        this.destination = destination;
        this.numberTrain = numberTrain;
        this.time = time;
    }

    public String getDestination() {
        return destination;
    }

    public int getNumberTrain() {
        return numberTrain;
    }

    public Time getTime() {
        return time;
    }
}

class Time {
    private final int hours;
    private final int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}