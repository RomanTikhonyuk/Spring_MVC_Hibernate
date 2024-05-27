package service;

import dao.CarDao;
import dao.CarDaoImpl;
import model.Car;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

public class ServiceImpl implements Service {
    private CarDao carDao = new CarDaoImpl();

    @Override
    public ArrayList<Car> carCount() {
        return carDao.carCount();
    }
}