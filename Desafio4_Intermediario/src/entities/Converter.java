package entities;

import java.util.Stack;

public class Converter {

    Stack<Double> stack = new Stack<>();

    public String convertBinario(Double num) {
        return convertFromDecimal(num, 2);
    }

    public String convertOctal(Double num) {
        return convertFromDecimal(num, 8);
    }

    public String convertDecimal(Double num) {
        return num.toString();
    }

    public String convertHexadecimal(Double num) {
        return convertFromDecimal(num, 16);
    }

    private String convertFromDecimal(Double num, int base) {
        String digits = "0123456789ABCDEF";
        while (num > 0) {
            stack.push(num % base);
            num = Math.floor(num / base);
        }
        String result = "";
        while (!stack.isEmpty()) {
            result += digits.charAt(stack.pop().intValue());
        }
        return result;
    }

}
