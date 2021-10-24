package by.epam.module4.simple.classes.objects.task2;
//Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте
//конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
//класса.

public class Task2 {
    public static void main(String[] args) {
        Test2 human = new Test2();
        System.out.println("Name: " + human.getName() + " age: " + human.getAge());
        human.setAge(35);
        human.setName("Aleksei");
        System.out.println("Name: " + human.getName() + " age: " + human.getAge());

        Test2 human1 = new Test2("Dima",30);
        System.out.println("Name: " + human1.getName() + " age: " + human1.getAge());
        human1.setName("Tanya");
        human1.setAge(25);
        System.out.println("Name: " + human1.getName() + " age: " + human1.getAge());
    }
}

class Test2 {
    private String name;
    private int age;

    public Test2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Test2() {
        name = "Ivan";
        age = 20;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}