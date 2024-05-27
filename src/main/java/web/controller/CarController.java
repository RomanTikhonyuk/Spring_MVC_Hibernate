package web.controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ServiceImpl;

import java.util.ArrayList;

@Controller
public class CarController {
    private ServiceImpl service = new ServiceImpl();
    private ArrayList<Car> resultList = new ArrayList<>();

    @GetMapping(value = "/cars")
    public String someMethod(ModelMap model,
                             @RequestParam(value = "count", defaultValue = "5") int count) {

        switch (count) {
            case 1:
                resultList.clear();
                resultList.add(0, service.carCount().get(0));
                System.out.println(resultList);
                break;
            case 2:
                resultList.clear();
                resultList.add(0, service.carCount().get(0));
                resultList.add(1, service.carCount().get(1));
                System.out.println(resultList);
                break;
            case 3:
                resultList.clear();
                resultList.add(0, service.carCount().get(0));
                resultList.add(1, service.carCount().get(1));
                resultList.add(2, service.carCount().get(2));
                System.out.println(resultList);
                break;
            case 4:
                resultList.clear();
                resultList.addAll(service.carCount());
                resultList.remove(resultList.size() - 1);
                System.out.println(resultList);
                break;
            case 5:
                resultList.clear();
                resultList.addAll(service.carCount());
                System.out.println(resultList);
                break;
            default:
                resultList.clear();
                resultList.addAll(service.carCount());
                System.out.println(resultList);
                break;
        }
        model.addAttribute("resultList", resultList);
        return "cars";
    }
}
