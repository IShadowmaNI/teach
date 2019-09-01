package sda.mvc.teach;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sda.mvc.teach.dto.SimpleMathDTO;
import sda.mvc.teach.dto.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

//    @GetMapping("/homePage")
//    public String homeMethod(Model model) {
//        List<Value> values = new ArrayList<>();
//        values.add(new Value(5d));
//        values.add(new Value(2d));
//        values.add(new Value(1d));
//
//        model.addAttribute("values", values);
//
//        model.addAttribute("myRandomNumber", new Random().nextInt(99999));
//        return "home"; //numele paginii html din packetul templates
//    }

    @GetMapping("/homePage")
    public String homeMethod(Model model) {
        SimpleMathDTO mathDTO = new SimpleMathDTO();
        mathDTO.setValue1(1.9d);
        mathDTO.setValue2(0.1d);

        model.addAttribute("mathDTO", mathDTO);
        return "home"; //numele paginii html din packetul templates
    }

    @PostMapping("/simpleAdd")
    public String computeMathThing(@ModelAttribute(value = "mathDTO") SimpleMathDTO simpleMathDTO, Model model) {
        Double sum = simpleMathDTO.value1 + simpleMathDTO.value2;
        model.addAttribute("result", sum);

        return "result";
    }


}
