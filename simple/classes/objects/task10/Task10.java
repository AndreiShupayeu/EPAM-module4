package by.epam.module4.simple.classes.objects.task10;

import java.util.Arrays;

//Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
//Найти и вывести:
//a) список рейсов для заданного пункта назначения;
//b) список рейсов для заданного дня недели;
//c) список рейсов для заданного дня недели, время вылета для которых больше заданного.

public class Task10 {
    public static void main(String[] args) {
        Airline airline = new Airline("Minsk", 1, "Boeing-747", new DepartureTime(10, 30), "sunday");
        Airline airline1 = new Airline("Mosсow", 5, "Boeing-737", new DepartureTime(11, 30), "monday");
        Airline airline2 = new Airline("Minsk", 5, "Boeing-737", new DepartureTime(11, 30), "sunday");
        Airline airline3 = new Airline("Gomel", 3, "Boeing-747", new DepartureTime(12, 30), "monday");
        Airline airline4 = new Airline("Gomel", 2, "Boeing-777", new DepartureTime(12, 30), "friday");
        Airline airline5 = new Airline("Vitebsk", 6, "Boeing-797", new DepartureTime(20, 40), "friday");
        Airline airline6 = new Airline("Brest", 4, "Boeing-700", new DepartureTime(9, 50), "tuesday");

        Airline[] airlines = new Airline[7];
        airlines[0] = airline;
        airlines[1] = airline1;
        airlines[2] = airline2;
        airlines[3] = airline3;
        airlines[4] = airline4;
        airlines[5] = airline5;
        airlines[6] = airline6;

        AirLineArray airLineArray = new AirLineArray(airlines);

        System.out.println("Airlines with defined destination: Minsk " + "\n" +
                airLineArray.findAirlinesWithDefinedDestination("Minsk"));

        System.out.println();

        System.out.println("Airlines for weekday: sunday" + "\n" + airLineArray.findAirlinesForWeekday("sunday"));

        System.out.println();

        System.out.println("Airlines for weekday: friday after: 15:15" + "\n" +
                airLineArray.findAirlinesForWeekdayAfterDefinedTime("friday", new DepartureTime(15, 15)));

    }
}

class Airline {
    private String destination;
    private int flightNumber;
    private String typeOfAircraft;
    private DepartureTime departureTime;
    private String weekday;

    public Airline(String destination, int flightNumber, String typeOfAircraft, DepartureTime departureTime, String weekday) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.typeOfAircraft = typeOfAircraft;
        this.departureTime = departureTime;
        this.weekday = weekday;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getTypeOfAircraft() {
        return typeOfAircraft;
    }

    public void setTypeOfAircraft(String typeOfAircraft) {
        this.typeOfAircraft = typeOfAircraft;
    }

    public DepartureTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(DepartureTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    @Override
    public String toString() {
        return "destination='" + destination + '\'' +
                ", flightNumber=" + flightNumber +
                ", typeOfAircraft='" + typeOfAircraft + '\'' +
                ", departureTime=" + departureTime +
                ", weekday='" + weekday + '\'' +
                '}';
    }

}

class AirLineArray {
    private final Airline[] airlines;

    public AirLineArray(Airline[] airlines) {
        this.airlines = airlines;
    }

    @Override
    public String toString() {
        return Arrays.toString(airlines);
    }

    public AirLineArray findAirlinesWithDefinedDestination(String destination) {
        int length = 0;
        for (Airline airline : airlines) {
            if (airline.getDestination().equals(destination)) {
                length++;
            }
        }
        Airline[] airlines1 = new Airline[length];
        int index = 0;
        for (Airline airline : airlines) {
            if (airline.getDestination().equals(destination)) {
                airlines1[index++] = airline;
            }
        }
        return new AirLineArray(airlines1);
    }

    public AirLineArray findAirlinesForWeekday(String weekday) {
        int length = 0;
        for (Airline airline : airlines) {
            if (airline.getWeekday().equals(weekday)) {
                length++;
            }
        }
        Airline[] airlines1 = new Airline[length];
        int index = 0;
        for (Airline airline : airlines) {
            if (airline.getWeekday().equals(weekday)) {
                airlines1[index++] = airline;
            }
        }
        return new AirLineArray(airlines1);
    }

    public AirLineArray findAirlinesForWeekdayAfterDefinedTime(String weekday, DepartureTime time) {
        int length = 0;
        for (Airline airline : airlines) {
            if (airline.getWeekday().equals(weekday) && airline.getDepartureTime().compareTo(time) == 1) {
                length++;
            }
        }
        Airline[] airlines1 = new Airline[length];
        int index = 0;
        for (Airline airline : airlines) {
            if (airline.getWeekday().equals(weekday) && airline.getDepartureTime().compareTo(time) == 1) {
                airlines1[index++] = airline;
            }
        }
        return new AirLineArray(airlines1);
    }
}

class DepartureTime {
    private final int hours;
    private final int minutes;

    public DepartureTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }


    @Override
    public String toString() {
        return hours + ":" + minutes;
    }

    public int compareTo(DepartureTime y) {
        if (hours > y.getHours()) {
            return 1;
        } else {
            if (hours < y.getHours()) {
                return -1;
            } else {
                if (minutes > y.getMinutes()) {
                    return 1;
                } else {
                    if (minutes < y.getMinutes()) {
                        return -1;
                    }
                }
            }
        }
        return 0;
    }
}