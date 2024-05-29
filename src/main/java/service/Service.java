package service;

import model.Car;
import java.util.List;


public interface Service {
    List<Car> createCarList(long count);
}
