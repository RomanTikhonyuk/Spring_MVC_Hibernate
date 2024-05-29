package service;

import dao.DAOImpl;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceImpl implements Service {
    DAOImpl dao;

    @Autowired
    public ServiceImpl(DAOImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<Car> createCarList(long count) {
        return dao.createCarList(count);
    }
}
