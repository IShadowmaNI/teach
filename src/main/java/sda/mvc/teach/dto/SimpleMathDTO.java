package sda.mvc.teach.dto;

public class SimpleMathDTO {

    public Double value1;
    public Double value2;
    public Double value3;

    public Double getValue1() {
        return value1;
    }

    public void setValue1(Double value1) {
        this.value1 = value1;
    }

    public Double getValue2() {
        return value2;
    }

    public void setValue2(Double value2) {
        this.value2 = value2;
    }

    public Double getValue3() {
        return value3;
    }

    public void setValue3(Double value3) {
        this.value3 = value3;
    }

    public Boolean isEmpty() {
        return value1 == null && value2 == null;
    }

}
