package dao;

import model.Car;
import java.util.List;

public interface DAO {
    List<Car> createCarList(long count);
}
