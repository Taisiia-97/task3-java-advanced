package taskstreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AutoKomis {
    public static void main(String[] args) {
        Car auto1 = new Car("Ford",150,1500,Color.BLACK,5000,6);
        Car auto2 = new Car("Ford",118,1500,Color.RED,4900,2);
        Car auto3 = new Car("Mersedess",178,1500,Color.WHITE,7600,6);
        Car auto4 = new Car("BMW",160,1500,Color.RED,2500,6);
     List<Car> cars = new ArrayList<>(Arrays.asList(auto1,auto2,auto3,auto4));
//        //auto zawierajace wiecej niz 5 miejsc siedzacych
//        cars.stream().filter(car -> car.getSeatsPlaces()>5).forEach(System.out::println);
//        //auta ktore maja kolor czerwony i cene mniejsza niz 10 tys.
//        cars.stream().filter(car -> car.getColor()==Color.RED&&car.getPrise()<10_000).forEach(System.out::println);
       // liste aut posortowamej wedlug rosnanacej ceny
        //metoda z używaniem klasy anonimowej
       List<Car> sortedCars = cars.stream().sorted(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Double.compare(o1.getPrise(),o2.getPrise());
            }
        }).collect(Collectors.toList());



        //metoda z lambdą
       // cars.stream().sorted((a,b)->Double.compare(a.getPrise(),b.getPrise())).forEach(System.out::println);
//wartości min i max
        System.out.println(cars.stream().max((a,b)->Double.compare(a.getPrise(),b.getPrise())));
        System.out.println(cars.stream().min((a,b)->Double.compare(a.getPrise(),b.getPrise())));

//auto zawierajace wiecej niż  5 miejsc siedzacych
//        Predicate<Car> predicate = car -> car.getSeatsPlaces()>5;
//        cars.stream().filter(predicate).forEach(System.out::println);


    }
}
