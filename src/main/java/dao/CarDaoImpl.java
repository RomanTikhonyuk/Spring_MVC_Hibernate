package dao;

import model.Car;

import java.util.ArrayList;

public class CarDaoImpl implements CarDao {
    @Override
    public ArrayList<Car> carCount() {
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
        System.out.println("Размер списка: " + list.size());
        return list;
    }
}
