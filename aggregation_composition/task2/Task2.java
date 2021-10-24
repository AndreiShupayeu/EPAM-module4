package by.epam.module4.aggregation_composition.task2;

//Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
//менять колесо, вывести на консоль марку автомобиля.

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Car car = Car.getFromScanner(in);

        car.printBrand();
        System.out.println(car.getPetrolTank());
        car.changeWheel(0, new Wheel("winter", 15));

        car.drive(2000);
        System.out.println(car.getPetrolTank());

        car.refuel(100);
        car.refuel(25);
        System.out.println(car.getPetrolTank());

    }
}

class Car {
    private final Engine engine;
    private final Wheel[] wheels;
    private final String carBrand;
    private int petrolTank;
    private static final int capacityOfPetrolTank = 55;
    private static final int fuelRate = 10;

    public Car(Engine engine, Wheel[] wheels, String carBrand, int petrolTank) {
        this.engine = engine;
        this.wheels = wheels;
        this.carBrand = carBrand;
        this.petrolTank = petrolTank;

    }

    public static Car getFromScanner(Scanner in) {
        return new Car(Engine.getEngineFromScanner(in), getWheelsFromScanner(in), getBrandCarFromScanner(in), 0);
    }

    public static String getBrandCarFromScanner(Scanner in) {
        String carBrand = null;
        while (carBrand == null) {
            System.out.println("Input car brand");
            if (in.hasNextLine()) {
                String input = in.nextLine();

                input = input.trim();
                if (input.isEmpty()) {
                    System.out.println("Car brand can't be blank");
                } else {
                    carBrand = input;
                }
            }
        }
        return carBrand;
    }

    public static Wheel[] getWheelsFromScanner(Scanner in) {
        Wheel[] wheels = new Wheel[4];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = Wheel.getWheelFromScanner(in);
        }
        return wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public int getPetrolTank() {
        return petrolTank;
    }

    public void drive(int distance) {
        if (distance > petrolTank * fuelRate) {
            System.out.println("You must refuel!");
        } else {
            petrolTank -= distance / fuelRate;
        }
    }

    public void refuel(int petrol) {
        if (petrol > capacityOfPetrolTank - petrolTank) {
            System.out.println("It is too much! The capacity of petrol tank is " + capacityOfPetrolTank);
        } else {
            petrolTank += petrol;
        }
    }

    public void printBrand() {
        System.out.println("Car brand: " + carBrand);
    }

    public void changeWheel(int index, Wheel wheel) {
        if (index < 0 || index > 3) {
            System.out.println("Index should be from 0 to 3. Current index = " + index);
            return;
        }

        Wheel wheelToChange = wheels[index];
        if (wheelToChange.getDiameter() != wheel.getDiameter()) {
            System.out.println("Diameter of wheel should be = " + wheelToChange.getDiameter() + ", but got " + wheel.getDiameter());
            return;
        }

        wheels[index] = wheel;
        System.out.println("The wheel has been replaced");
    }
}
class Wheel {
    private final String type;
    private final int diameter;
    private static final int maxDiameter = 25;

    public Wheel(String type, int diameter) {
        this.type = type;
        this.diameter = diameter;
    }

    public String getType() {
        return type;
    }

    public static int getMaxDiameter() {
        return maxDiameter;
    }

    public int getDiameter() {
        return diameter;
    }


    @Override
    public String toString() {
        return "Wheel{" +
                "type='" + type + '\'' +
                ", diameter=" + diameter +
                '}';
    }

    public static Wheel getWheelFromScanner(Scanner in) {
        return new Wheel(getTypeOfWheelFromScanner(in), getDiameterOfWheelFromScanner(in));
    }

    public static String getTypeOfWheelFromScanner(Scanner in) {
        String type = "";
        while (type.length() == 0) {
            System.out.println("Indicate type of wheel:");
            type = in.next();
        }
        return type;
    }

    public static int getDiameterOfWheelFromScanner(Scanner in) {
        int diameter = 0;
        while (diameter <= 0 || diameter > maxDiameter) {
            System.out.println("Indicate diameter of wheel:");
            diameter = in.nextInt();
        }
        return diameter;
    }
}

class Engine {

    private final int power;
    private final String model;
    private static final int maxPower = 300;

    public Engine(int power, String model) {
        this.power = power;
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public String getModel() {
        return model;
    }


    @Override
    public String toString() {
        return "Engine{" +
                "power=" + power +
                ", model='" + model + '\'' +
                '}';
    }

    public static Engine getEngineFromScanner(Scanner in) {
        return new Engine(getPowerEngineFromScanner(in), getModelEngineFromScanner(in));
    }

    public static int getPowerEngineFromScanner(Scanner in) {
        int power = 0;
        while (power <= 0 || power > maxPower) {
            System.out.println("Indicate power of engine:");
            power = in.nextInt();
        }
        return power;
    }

    public static String getModelEngineFromScanner(Scanner in) {
        String model = "";
        while (model.length() == 0) {
            System.out.println("Indicate model of engine:");
            model = in.next();
        }
        return model;
    }
}