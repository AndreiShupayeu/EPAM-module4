package by.epam.module4.aggregation_composition.task3;
//Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
//столицу, количество областей, площадь, областные центры.

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        City city = new City("Minsk", 350);
        City city1 = new City("Gomel", 140);
        City city2 = new City("Vitebsk", 125);
        City city3 = new City("Grodno", 142);
        City city4 = new City("Brest", 146);
        City city5 = new City("Mogilev", 120);

        District district = new District("Minski", new City[]{city}, 1900);
        District district1 = new District("Gomelski", new City[]{city1}, 1800);
        District district2 = new District("Vitebski", new City[]{city2}, 1600);
        District district3 = new District("Grodnenski", new City[]{city3}, 1750);
        District district4 = new District("Brestski", new City[]{city4}, 1800);
        District district5 = new District("Mogilevski", new City[]{city5}, 1600);

        Oblast oblast = new Oblast("Minskaya", new District[]{district}, city, 40000);
        Oblast oblast1 = new Oblast("Gomelskaya", new District[]{district1}, city1, 36000);
        Oblast oblast2 = new Oblast("Vitebskaya", new District[]{district2}, city2, 38000);
        Oblast oblast3 = new Oblast("Grodnenskaya", new District[]{district3}, city3, 30600);
        Oblast oblast4 = new Oblast("Brestskaya", new District[]{district4}, city4, 31000);
        Oblast oblast5 = new Oblast("Mogilevskaya", new District[]{district5}, city5, 32000);

        State state = new State("Belarus", new Oblast[]{oblast, oblast1, oblast2, oblast3, oblast4, oblast5}, city);

        System.out.println("The capital of Belarus is: " + state.getCapital().getName() + "\n");

        System.out.println("Belarus is consist of " + state.getOblasts().length + " oblasts" + "\n");

        System.out.println("The square of Belarus is " + state.getSquare() + "\n");

        System.out.println("The centers of oblasts: ");
        for (Oblast oblast6 : state.getOblasts()) {
            System.out.println(oblast6.getCenterOfOblast().getName());
        }
    }
}

class State {
    private final String name;
    private final Oblast[] oblasts;
    private final City capital;
    private double square;

    public State(String name, Oblast[] oblasts, City capital) {
        this.name = name;
        this.oblasts = oblasts;
        this.capital = capital;
        this.square = getSquareOfState();
    }

    public String getName() {
        return name;
    }

    public Oblast[] getOblasts() {
        return oblasts;
    }

    public City getCapital() {
        return capital;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", oblasts=" + Arrays.toString(oblasts) +
                ", capital=" + capital +
                ", square=" + square +
                '}';
    }

    private double getSquareOfState() {
        for (Oblast oblast : oblasts) {
            square += oblast.getSquare();
        }
        return square;
    }
}

class Oblast {
    private final String name;
    private final District[] districts;
    private final City centerOfOblast;
    private final double square;

    public Oblast(String name, District[] districts, City centerOfOblast, double square) {
        this.name = name;
        this.districts = districts;
        this.centerOfOblast = centerOfOblast;
        this.square = square;
    }

    public String getName() {
        return name;
    }

    public District[] getDistricts() {
        return districts;
    }

    public City getCenterOfOblast() {
        return centerOfOblast;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return "Oblast{" +
                "name='" + name + '\'' +
                ", districts=" + Arrays.toString(districts) +
                ", centerOfOblast=" + centerOfOblast +
                ", square=" + square +
                '}';
    }
}

class District {
    private final String name;
    private final City[] cities;
    private final double square;

    public District(String name, City[] cities, double square) {
        this.name = name;
        this.cities = cities;
        this.square = square;
    }

    public String getName() {
        return name;
    }


    public City[] getCities() {
        return cities;
    }


    public double getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", cities=" + Arrays.toString(cities) +
                ", square=" + square +
                '}';
    }
}

class City {
    private final String name;
    private final int square;

    public City(String name, int square) {
        this.name = name;
        this.square = square;
    }

    public String getName() {
        return name;
    }

    public int getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", square=" + square +
                '}';
    }
}

