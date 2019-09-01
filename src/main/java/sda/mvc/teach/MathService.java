package sda.mvc.teach;

import org.springframework.stereotype.Service;
import sda.mvc.teach.dto.MathResultDTO;
import sda.mvc.teach.dto.SimpleMathDTO;

@Service
public class MathService {

    public MathResultDTO performSimpleAdd(SimpleMathDTO simpleMathDTO) {

        Double sum = simpleMathDTO.value1 + simpleMathDTO.value2;
        return new MathResultDTO(sum, "addition");
    }

    public Double performSimpleSubtraction(SimpleMathDTO simpleMathDTO) {

        return simpleMathDTO.value1 - simpleMathDTO.value2;
    }
}
