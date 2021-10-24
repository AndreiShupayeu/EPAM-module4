package by.epam.module4.simple.classes.objects.task5;
//Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
//на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
//произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
//позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.

public class Task5 {
    public static void main(String[] args) {
        Counter counter1=new Counter();
        Counter counter2=new Counter(5,50,60);
        counter2.increaseCounter();
        counter2.increaseCounter();
        counter2.info();
        counter2.decreaseCounter();
        counter2.decreaseCounter();
        counter2.info();
        counter1.info();
    }
}

class Counter {
    private final int min;
    private final int max;
    private int current;

    public Counter(int min, int max, int current) {
        this.min = min;
        this.max = max;
        this.current = current;
        if (current > max) {
            this.current = max;
        }
        else if (current < min) {
            this.current = min;
        }
    }

    public Counter() {
        min = 0;
        max = 20;
        current = 10;
    }

    public void increaseCounter() {
        current++;
        if (current > max) {
            current = max;
        }
    }

    public void decreaseCounter() {
        current--;
        if (current < min) {
            this.current = min;
        }
    }

    public void info() {
        System.out.println(current);
    }
}


