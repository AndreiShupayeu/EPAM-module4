package by.epam.module4.simple.classes.objects.task1;
//Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
//переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
//наибольшее значение из этих двух переменных.

public class Task1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1(10, 20);
        test1.print();
        test1.setA(2);
        test1.setB(5);
        System.out.println(test1.maxVariable());
        System.out.println(test1.sumVariables());
    }
}

class Test1 {
    private int a;
    private int b;

    public Test1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void print() {
        System.out.println(a + " " + b);
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    int sumVariables() {
        return a + b;
    }

    int maxVariable() {
        return Math.max(a, b);
    }
}
