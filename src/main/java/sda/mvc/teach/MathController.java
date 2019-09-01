package sda.mvc.teach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.mvc.teach.dto.ComplexMathDTO;
import sda.mvc.teach.dto.MathResultDTO;
import sda.mvc.teach.dto.SimpleMathDTO;
import sda.mvc.teach.dto.Value;

@RestController
public class MathController {

    @Autowired
    MathService mathService;

//    @GetMapping(value = "/add")
//    public Integer add(@RequestParam(value = "val1") Integer value1, @RequestParam(value = "val2") Integer value2) {
//        return value1 + value2;
//    }

    @PostMapping(value = "/add")
    public MathResultDTO add(@RequestBody SimpleMathDTO simpleMathDTO) {

        return mathService.performSimpleAdd(simpleMathDTO);
    }

    @PostMapping(value = "/subtract", produces = "application/json", consumes = "application/json")
    public MathResultDTO reduction(@RequestBody SimpleMathDTO simpleMathDTO) {

        Double result = simpleMathDTO.value1 - simpleMathDTO.value2;
        return new MathResultDTO(result, "reduction");
    }

    @PostMapping(value = "/pow2o3", produces = "application/json", consumes = "application/json")
    public MathResultDTO powerByTwoOrThree(@RequestBody SimpleMathDTO simpleMathDTO) {

        Double result = 0D;
        if (simpleMathDTO.value2 == null) {
            throw new IllegalArgumentException("Value 2 is null!!!");
        } else if (simpleMathDTO.value1 == null || simpleMathDTO.value1 < 0) {
            result = Math.pow(simpleMathDTO.value2, 3);
        }

        result = Math.pow(simpleMathDTO.value1, 2);

        return new MathResultDTO(result, "pow2o3");
    }

    @PostMapping(value = "/addThreeValues", produces = "application/json", consumes = "application/json")
    public MathResultDTO addThreeValues(@RequestBody SimpleMathDTO simpleMathDTO) {

        Double result = simpleMathDTO.value1 + simpleMathDTO.value2 + simpleMathDTO.value3;

        return new MathResultDTO(result, "addThreeValues");
    }

    @PostMapping(value = "/divide", produces = "application/json", consumes = "application/json")
    public ResponseEntity<MathResultDTO> subtract(@RequestBody SimpleMathDTO simpleMathDTO) {

        if(simpleMathDTO.isEmpty()) {
            return ResponseEntity.badRequest().body(new MathResultDTO("No content found!", "divide"));
        }
        if (simpleMathDTO.value2 == null || simpleMathDTO.value2 == 0) {
            return ResponseEntity.badRequest().body(new MathResultDTO("Division by zero", "divide"));
        }

        Double result = simpleMathDTO.value1/simpleMathDTO.value2;
        return ResponseEntity.ok().body(new MathResultDTO(result, "divide"));
    }

//    @PostMapping(value = "/complexAdd")
////    public Long addMore(@RequestBody ComplexMathDTO complexMathDTO) {
////
////        Long sum = 0L;
////        for(ComplexMathDTO.Value valueItem : complexMathDTO.values) {
////            sum += valueItem.value;
////        }
////
////        return sum;
////    }

    @PostMapping(value = "/complexAdd", produces = "application/json", consumes = "application/json")
    public MathResultDTO addMore(@RequestBody ComplexMathDTO complexMathDTO) {

        Double sum = 0D;
        for(Value valueItem : complexMathDTO.values) {
            sum += valueItem.value;
        }

        return new MathResultDTO(sum, "complexAdd");
    }

}
