package tms.c32.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Operation {
    private double num1;
    private double num2;
    private double result;
    private String operation;

    @Override
    public String toString() {
        return num1 + " " + operation + " " + num2 + " = " + result;
    }
}
