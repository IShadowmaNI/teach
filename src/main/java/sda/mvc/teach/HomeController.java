package sda.mvc.teach;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sda.mvc.teach.dto.MathResultDTO;
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

//    @PostMapping("/simpleAdd") - asta a ramas de la prof
    @RequestMapping(value = "/action", method = RequestMethod.POST, params = "action=simpleAdd") // am folosit linia asta pentru a face mai multe butoane cu diverse operatii matematice definite mai jos
    public String computeMathThing(@ModelAttribute(value = "mathDTO") SimpleMathDTO simpleMathDTO, Model model) {
        Double sum = simpleMathDTO.value1 + simpleMathDTO.value2;

        model.addAttribute("result", sum);
        return "result";
    }

    @RequestMapping(value = "/action", method = RequestMethod.POST, params = "action=simpleReduction")
    public String reduction(@ModelAttribute(value = "mathDTO") SimpleMathDTO simpleMathDTO, Model model) {
        Double dif = simpleMathDTO.value1 - simpleMathDTO.value2;

        model.addAttribute("result", dif);
        return "result";
    }

    @RequestMapping(value = "/action", method = RequestMethod.POST, params = "action=pow2o3")
    public String powerByTwoOrThree(@ModelAttribute(value = "mathDTO") SimpleMathDTO simpleMathDTO, Model model) {

        Double result = 0D;
        if (simpleMathDTO.value2 == null) {
            throw new IllegalArgumentException("Value 2 is null!!!");
        } else if (simpleMathDTO.value1 == null || simpleMathDTO.value1 < 0) {
            result = Math.pow(simpleMathDTO.value2, 3);
            model.addAttribute("result", result);
            return "result";
        }

        result = Math.pow(simpleMathDTO.value1, 2);
        model.addAttribute("result", result);
        return "result";
    }
}
