package by.epam.module4.aggregation_composition.task5;

import java.util.Arrays;
import java.util.Scanner;

//Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
//различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
//возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.

public class Task5 {
    public static void main(String[] args) {

        TravelTour[] travelTours = createArrayTravelTours();

        TravelAgency travelAgency = new TravelAgency("Best Choice", "Minsk,Lenina,50", travelTours);

        AgencyUI agencyUI = new AgencyUI(travelAgency);

        agencyUI.start();

    }

    public static TravelTour[] createArrayTravelTours() {
        Food allInclusive = new Food(FoodType.ALL_INCLUSIVE, 5000);
        Food fullBoard = new Food(FoodType.FULL_BOARD, 4500);
        Food halfBoard = new Food(FoodType.HALF_BOARD, 2500);
        Food breakfast = new Food(FoodType.BREAKFAST, 1000);

        Transport plane = new Transport(TransportType.PLANE, 2000);
        Transport bus = new Transport(TransportType.BUS, 500);
        Transport train = new Transport(TransportType.TRAIN, 1000);
        Transport ship = new Transport(TransportType.SHIP, 1500);

        TravelTour travelTour = new TravelTour("Rest", plane, allInclusive, "Turkey", 2000);
        TravelTour travelTour1 = new TravelTour("Treatment", bus, fullBoard, "Belarus", 2000);
        TravelTour travelTour2 = new TravelTour("Shopping", bus, breakfast, "Ukraine", 500);
        TravelTour travelTour3 = new TravelTour("Rest", train, fullBoard, "Russia", 1500);
        TravelTour travelTour4 = new TravelTour("Rest", plane, allInclusive, "Egypt", 2000);
        TravelTour travelTour5 = new TravelTour("Rest", plane, halfBoard, "Egypt", 1000);
        TravelTour travelTour6 = new TravelTour("Treatment", bus, fullBoard, "Lithuania", 2000);
        TravelTour travelTour7 = new TravelTour("Treatment", bus, fullBoard, "Latvia", 2000);
        TravelTour travelTour8 = new TravelTour("Treatment", plane, fullBoard, "Montenegro", 2000);
        TravelTour travelTour9 = new TravelTour("Shopping", bus, breakfast, "Lithuania", 700);
        TravelTour travelTour10 = new TravelTour("Shopping", bus, breakfast, "Ukraine", 500);

        TravelTour[] travelTours = new TravelTour[11];
        travelTours[0] = travelTour;
        travelTours[1] = travelTour1;
        travelTours[2] = travelTour2;
        travelTours[3] = travelTour3;
        travelTours[4] = travelTour4;
        travelTours[5] = travelTour5;
        travelTours[6] = travelTour6;
        travelTours[7] = travelTour7;
        travelTours[8] = travelTour8;
        travelTours[9] = travelTour9;
        travelTours[10] = travelTour10;

        return travelTours;
    }
}

class AgencyUI {
    private final TravelAgency travelAgency;

    public AgencyUI(TravelAgency travelAgency) {
        this.travelAgency = travelAgency;
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        printMainMenu(in);
    }

    private void printMainMenu(Scanner in) {

        boolean running = true;

        while (running) {
            System.out.println("Indicate your choice");
            System.out.println("1) Search tours");
            System.out.println("2) Exit");

            int variant = in.nextInt();

            switch (variant) {
                case 1:
                    searchTours(in);
                    break;
                case 2:
                    running = false;
                    break;
            }
        }
    }

    private void searchTours(Scanner in) {
        SearchRequest searchRequest = getSearchRequest(in);

        TravelTour[] tours = travelAgency.findTravelTours(searchRequest);
        if (tours.length == 0) {
            System.out.println("We don't have any travel tours in this range!");
        } else {
            int choiceTypeOfSorting = getChoiceForSortTravelTours(in);

            switch (choiceTypeOfSorting) {
                case 1:
                    travelAgency.sortTravelTourByCost(true, tours);
                    printToursToUser(tours);
                    break;
                case 2:
                    travelAgency.sortTravelTourByCost(false, tours);
                    printToursToUser(tours);
                    break;
                case 3:
                    printToursToUser(tours);
                    break;
            }
        }
        System.out.println();
    }

    private int getChoiceForSortTravelTours(Scanner in) {

        int choiceTypeOfSorting = 0;

        while (choiceTypeOfSorting <= 0 || choiceTypeOfSorting > 3) {
            System.out.println("How to sort a list?");
            System.out.println("1) Ascending price");
            System.out.println("2) Descending price");
            System.out.println("3) It does not matter" + "\n");
            choiceTypeOfSorting = in.nextInt();

            if (choiceTypeOfSorting <= 0 || choiceTypeOfSorting > 3) {
                System.out.println("Digit should be from 1 to 3." + "\n");
            }
        }
        return choiceTypeOfSorting;
    }

    private void printToursToUser(TravelTour[] tours) {

        System.out.println("Information on your request: " + Arrays.toString(tours));
    }

    private SearchRequest getSearchRequest(Scanner in) {

        return new SearchRequest(getSearchRequestTypeOfTravel(in),
                getSearchRequestTransportType(in),
                getSearchRequestFoodType(in),
                getSearchRequestCountry(in));
    }

    private String getSearchRequestCountry(Scanner in) {

        int choiceCountry = 0;
        while (choiceCountry <= 0 || choiceCountry > 9) {
            System.out.println("Indicate country:");
            System.out.println("1) Belarus");
            System.out.println("2) Russia");
            System.out.println("3) Turkey");
            System.out.println("4) Egypt");
            System.out.println("5) Ukraine");
            System.out.println("6) Lithuania");
            System.out.println("7) Montenegro");
            System.out.println("8) Latvia");
            System.out.println("9) It does not matter");
            System.out.println();
            choiceCountry = in.nextInt();

            if (choiceCountry <= 0 || choiceCountry > 9) {
                System.out.println("Digit should be from 1 to 9" + "\n");
            }
        }

        String country = null;
        switch (choiceCountry) {
            case 1:
                country = "Belarus";
                break;
            case 2:
                country = "Russia";
                break;
            case 3:
                country = "Turkey";
                break;
            case 4:
                country = "Egypt";
                break;
            case 5:
                country = "Ukraine";
                break;
            case 6:
                country = "Lithuania";
                break;
            case 7:
                country = "Montenegro";
                break;
            case 8:
                country = "Latvia";
                break;
            case 9:
                country = null;
        }
        return country;
    }

    private FoodType getSearchRequestFoodType(Scanner in) {

        int choiceFood = 0;
        while (choiceFood <= 0 || choiceFood > 5) {
            System.out.println("Indicate type of food:");
            System.out.println("1) all inclusive");
            System.out.println("2) full board");
            System.out.println("3) half Board");
            System.out.println("4) breakfast");
            System.out.println("5) It does not matter");
            System.out.println();
            choiceFood = in.nextInt();

            if (choiceFood <= 0 || choiceFood > 5) {
                System.out.println("Digit should be from 1 to 5" + "\n");
            }
        }

        FoodType foodType = null;
        switch (choiceFood) {
            case 1:
                foodType = FoodType.ALL_INCLUSIVE;
                break;
            case 2:
                foodType = FoodType.FULL_BOARD;
                break;
            case 3:
                foodType = FoodType.HALF_BOARD;
                break;
            case 4:
                foodType = FoodType.BREAKFAST;
                break;
            case 5:
                foodType = null;
        }
        return foodType;
    }

    private TransportType getSearchRequestTransportType(Scanner in) {

        int choiceTransport = 0;
        while (choiceTransport <= 0 || choiceTransport > 5) {
            System.out.println("Indicate type of transport:");
            System.out.println("1) plane");
            System.out.println("2) bus");
            System.out.println("3) train");
            System.out.println("4) ship");
            System.out.println("5) It does not matter");
            System.out.println();
            choiceTransport = in.nextInt();

            if (choiceTransport <= 0 || choiceTransport > 5) {
                System.out.println("Digit should be from 1 to 5" + "\n");
            }
        }

        TransportType transportType = null;
        switch (choiceTransport) {
            case 1:
                transportType = TransportType.PLANE;
                break;
            case 2:
                transportType = TransportType.BUS;
                break;
            case 3:
                transportType = TransportType.TRAIN;
                break;
            case 4:
                transportType = TransportType.SHIP;
                break;
            case 5:
                transportType = null;
        }
        return transportType;
    }

    private String getSearchRequestTypeOfTravel(Scanner in) {

        int choiceTypeOfTravel = 0;
        while (choiceTypeOfTravel <= 0 || choiceTypeOfTravel > 5) {
            System.out.println("Indicate type of travel:");
            System.out.println("1) Rest");
            System.out.println("2) Treatment");
            System.out.println("3) Shopping");
            System.out.println("4) Cruise");
            System.out.println("5) It does not matter");
            System.out.println();
            choiceTypeOfTravel = in.nextInt();

            if (choiceTypeOfTravel <= 0 || choiceTypeOfTravel > 5) {
                System.out.println("Digit should be from 1 to 5" + "\n");
            }
        }

        String typeOfTravel = null;
        switch (choiceTypeOfTravel) {
            case 1:
                typeOfTravel = "Rest";
                break;
            case 2:
                typeOfTravel = "Treatment";
                break;
            case 3:
                typeOfTravel = "Shopping";
                break;
            case 4:
                typeOfTravel = "Cruise";
                break;
            case 5:
                typeOfTravel = null;
                break;
        }
        return typeOfTravel;
    }
}

class SearchRequest {
    private final String typeOfTravel;
    private final TransportType transportType;
    private final FoodType foodType;
    private final String country;

    public SearchRequest(String typeOfTravel, TransportType transportType, FoodType foodType, String country) {
        this.typeOfTravel = typeOfTravel;
        this.transportType = transportType;
        this.foodType = foodType;
        this.country = country;
    }

    public String getTypeOfTravel() {
        return typeOfTravel;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "SearchRequest{" +
                "typeOfTravel='" + typeOfTravel + '\'' +
                ", transportType=" + transportType +
                ", foodType=" + foodType +
                ", country='" + country + '\'' +
                '}';
    }
}

class TravelAgency {
    private final String name;
    private final String address;
    private final TravelTour[] travelTours;

    public TravelAgency(String name, String address, TravelTour[] travelTours) {
        this.name = name;
        this.address = address;
        this.travelTours = travelTours;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public TravelTour[] getTravelTours() {
        return travelTours;
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", travelTours=" + Arrays.toString(travelTours) +
                '}';
    }

    public TravelTour[] findTravelTours(SearchRequest searchRequest) {
        TravelTour[] resultTypeOfTravel = getTravelTourByType(searchRequest.getTypeOfTravel());
        TravelTour[] resultTransportType = getTravelTourByTransportType(searchRequest.getTransportType(), resultTypeOfTravel);
        TravelTour[] resultFoodType = getTravelTourByFood(searchRequest.getFoodType(), resultTransportType);
        return getTravelTourByCountry(searchRequest.getCountry(), resultFoodType);
    }

    public void sortTravelTourByCost(boolean asc, TravelTour[] input) {
        for (int i = 0; i < input.length; ++i) {
            for (int j = input.length - 1; j > i; j--) {
                if (input[j - 1].getCost() > input[j].getCost() == asc) {
                    swap(input, j - 1, j);
                }
            }
        }
    }

    public static void swap(TravelTour[] travelTours, int i, int j) {
        TravelTour temp = travelTours[i];
        travelTours[i] = travelTours[j];
        travelTours[j] = temp;
    }

    public TravelTour[] getTravelTourByType(String type) {
        if (type == null) {
            return travelTours;
        }

        int length = 0;
        for (TravelTour travelTour : travelTours) {
            if (travelTour.getTypeOfTravel().equals(type)) {
                length++;
            }
        }

        TravelTour[] result = new TravelTour[length];
        int index = 0;
        for (TravelTour travelTour : travelTours) {
            if (travelTour.getTypeOfTravel().equals(type)) {
                result[index++] = travelTour;
            }
        }
        return result;
    }

    public TravelTour[] getTravelTourByFood(FoodType foodType, TravelTour[] input) {
        if (foodType == null) {
            return input;

        }
        int length = 0;
        for (TravelTour travelTour : input) {
            if (travelTour.getFood().getType() == foodType) {
                length++;
            }
        }

        TravelTour[] result = new TravelTour[length];
        int index = 0;
        for (TravelTour travelTour : input) {
            if (travelTour.getFood().getType() == foodType) {
                result[index++] = travelTour;
            }
        }
        return result;
    }

    public TravelTour[] getTravelTourByCountry(String country, TravelTour[] input) {
        if (country == null) {
            return input;
        }

        int length = 0;
        for (TravelTour travelTour : input) {
            if (travelTour.getCountry().equals(country)) {
                length++;
            }
        }

        TravelTour[] result = new TravelTour[length];
        int index = 0;
        for (TravelTour travelTour : input) {
            if (travelTour.getCountry().equals(country)) {
                result[index++] = travelTour;
            }
        }
        return result;
    }

    public TravelTour[] getTravelTourByTransportType(TransportType transportType, TravelTour[] input) {
        if (transportType == null) {
            return input;

        }
        int length = 0;
        for (TravelTour travelTour : input) {
            if (travelTour.getTransport().getTransportType() == transportType) {
                length++;
            }
        }

        TravelTour[] result = new TravelTour[length];
        int index = 0;
        for (TravelTour travelTour : input) {
            if (travelTour.getTransport().getTransportType() == transportType) {
                result[index++] = travelTour;
            }
        }
        return result;
    }

}

class TravelTour {
    private final String typeOfTravel;
    private final Transport transport;
    private final Food food;
    private final String country;
    private final int fullCost;

    public TravelTour(String typeOfTravel, Transport transport, Food food, String country, int partCost) {
        this.typeOfTravel = typeOfTravel;
        this.transport = transport;
        this.food = food;
        this.country = country;
        this.fullCost = partCost + minCostOfTravelTour();

    }

    public int minCostOfTravelTour() {
        return transport.getTransportCost() + food.getFoodCost();

    }

    public String getTypeOfTravel() {
        return typeOfTravel;
    }

    public Transport getTransport() {
        return transport;
    }

    public Food getFood() {
        return food;
    }

    public String getCountry() {
        return country;
    }

    public int getCost() {
        return fullCost;
    }

    @Override
    public String toString() {
        return "TravelTour{" +
                "typeOfTravel='" + typeOfTravel + '\'' +
                ", transport=" + transport +
                ", food=" + food +
                ", country='" + country + '\'' +
                ", fullCost=" + fullCost +
                '}';
    }
}

enum TransportType {
    PLANE,
    BUS,
    TRAIN,
    SHIP;
}

class Transport {
    private final TransportType transportType;
    private final int transportCost;

    public Transport(TransportType transportType, int transportCost) {
        this.transportType = transportType;
        this.transportCost = transportCost;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public int getTransportCost() {
        return transportCost;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "transportType=" + transportType +
                ", transportCost=" + transportCost +
                '}';
    }
}

enum FoodType {
    ALL_INCLUSIVE,
    FULL_BOARD,
    HALF_BOARD,
    BREAKFAST;
}

class Food {
    FoodType type;
    private final int foodCost;

    public Food(FoodType type, int foodCost) {
        this.type = type;
        this.foodCost = foodCost;
    }

    public FoodType getType() {
        return type;
    }

    public int getFoodCost() {
        return foodCost;
    }

    @Override
    public String toString() {
        return "Food{" +
                "type=" + type +
                ", foodCost=" + foodCost +
                '}';
    }
}



