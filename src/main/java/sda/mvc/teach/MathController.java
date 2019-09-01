package sda.mvc.teach;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class MathController {

//    @GetMapping(value = "/add")
//    public Integer add(@RequestParam(value = "val1") Integer value1, @RequestParam(value = "val2") Integer value2) {
//        return value1 + value2;
//    }

//    @PostMapping(value = "/add")
//    public Integer add(@RequestParam(value = "val1") Integer value1, @RequestParam(value = "val2") Integer value2) {
//        return value1 + value2;
//    }

    @PostMapping(value = "/add")
    public Integer add(@RequestBody SimpleMathDTO simpleMathDTO) {
        return simpleMathDTO.value1 + simpleMathDTO.value2;
    }

    @PostMapping(value = "/red")
    public Integer reduction(@RequestBody SimpleMathDTO simpleMathDTO) {
        return simpleMathDTO.value1 - simpleMathDTO.value2;
    }

    @PostMapping(value = "/pow2o3")
    public double powerByTwoOrThree(@RequestBody SimpleMathDTO simpleMathDTO) {

        if (simpleMathDTO.value2 == null) {
            throw new IllegalArgumentException("Value 2 is null!!!");
        } else if (simpleMathDTO.value1 == null || simpleMathDTO.value1 < 0) {
            return Math.pow(simpleMathDTO.value2, 3);
        }

        return Math.pow(simpleMathDTO.value1, 2);
    }

    @PostMapping(value = "/add3v")
    public Integer addThreeValues(@RequestBody SimpleMathDTO simpleMathDTO) {

        return simpleMathDTO.value1 + simpleMathDTO.value2 + simpleMathDTO.value3;
    }

    @PostMapping(value = "/sub")
    public Integer subtract(@RequestBody SimpleMathDTO simpleMathDTO) {

        return Math.subtractExact(simpleMathDTO.value1, simpleMathDTO.value2);
    }

    @PostMapping(value = "/complexAdd")
    public Long addMore(@RequestBody ComplexMathDTO complexMathDTO) {

        Long sum = 0L;
        for(ComplexMathDTO.Value valueItem : complexMathDTO.values) {
            sum += valueItem.value;
        }

        return sum;
    }




}
