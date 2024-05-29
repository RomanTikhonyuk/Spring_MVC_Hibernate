package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import service.Service;


@Controller
@Validated
public class CarController {
    private Service service;

    @Autowired
    public CarController(Service service) {
        this.service = service;
    }

    @GetMapping(value = "/cars")
    public String createCarTable(ModelMap model,
                                 @RequestParam(value = "count", defaultValue = "5")
                                 long count) {

        try {
            model.addAttribute("car", service.createCarList(count));
            return "cars";
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Wrong request");
        }
    }
}
