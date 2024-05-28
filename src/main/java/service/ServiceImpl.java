package service;

import model.Car;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ServiceImpl implements Service {
    @Override
    public List<Car> createCarList(long count) {
        ArrayList<Car> list = new ArrayList<>();
        Car bmw = new Car("BMW", "black", 100);
        Car jeep = new Car("Jeep", "white", 101);
        Car uaz = new Car("UAZ", "green", 102);
        Car ferrari = new Car("Ferrari", "red", 103);
        Car tesla = new Car("Tesla", "silver", 104);

        list.add(jeep);
        list.add(bmw);
        list.add(uaz);
        list.add(tesla);
        list.add(ferrari);
        return list.stream().limit(count).collect(Collectors.toList());
    }
}
