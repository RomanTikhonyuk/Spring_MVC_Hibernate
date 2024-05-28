package service;

import model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public interface Service {
    List<Car> createCarList(long count);
}
