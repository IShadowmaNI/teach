package sda.mvc.teach.dto;

public class MathResultDTO {

    public Double result;
    public String operationType;
    public String failureMessage;

    public MathResultDTO(String failureMessage, String operationType) {
        this.failureMessage = failureMessage;
        this.operationType = operationType;
    }

    public MathResultDTO(Double result, String operationType) {
        this.result = result;
        this.operationType = operationType;
    }
}
