package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Service;


@Controller
public class CarController {
    private Service service;

    @Autowired
    public CarController(Service service) {
        this.service = service;
    }

    @GetMapping(value = "/cars")
    public String createCarTable(ModelMap model,
                                 @RequestParam(value = "count", defaultValue = "5") long count) {

        model.addAttribute("car", service.createCarList(count));
        return "cars";
    }
}
