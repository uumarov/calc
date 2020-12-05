package com.javamentor.calculator;

public class Operand {
    enum Numeral {
        ARABIC, ROMAN
    }

    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 10;

    private Numeral type;
    private int value;

    public Operand(String number) {
        this.type = typeOf(number);
        setValue(number);
    }

    private boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isInRange(int num) {
        return num >= MIN_VALUE && num <= MAX_VALUE;
    }

    private boolean isRoman(String number) {
        try {
            Util.romanToArabic(number);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private Numeral typeOf(String number) throws NumberFormatException {
        Numeral type;
        if (isNumeric(number)) {
            int num = Integer.parseInt(number);
            if (isInRange(num)) {
                type = Numeral.ARABIC;
            } else {
                throw new NumberFormatException("Число должно быть в диапазоне от " + MIN_VALUE + " до " + MAX_VALUE + " включительно");
            }
        } else if (isRoman(number)) {
            type = Numeral.ROMAN;
        } else {
            throw new NumberFormatException("Неверный формат числа");
        }
        return type;
    }

    public Numeral getType() {
        return type;
    }

    public boolean typeEquals(Operand operand) {
        return this.type == operand.getType();
    }

    private void setType(Numeral type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    private void setValue(int value) {
        this.value = value;
    }

    private void setValue(String number) {
        if (this.type == Numeral.ROMAN) {
            int val = Util.romanToArabic(number);
            setValue(val);
        } else if (this.type == Numeral.ARABIC) {
            int val = Integer.parseInt(number);
            setValue(val);
        }
    }

    @Override
    public String toString() {
        String value = "";
        if (this.type == Numeral.ARABIC) {
            value = String.valueOf(getValue());
        } else if (this.type == Numeral.ROMAN) {
            value = Util.arabicToRoman(this.value);
        }
        return value;
    }

    private String getResult(int res) {
        String result = "";
        if (this.type == Numeral.ARABIC) {
            result = String.valueOf(res);
        } else if (this.type == Numeral.ROMAN) {
            result = Util.arabicToRoman(res);
        }
        return result;
    }


    public String add(Operand operand) {
        int a = this.value;
        int b = operand.getValue();
        int res = a + b;
        return getResult(res);
    }

    public String subtract(Operand operand) {
        int a = this.value;
        int b = operand.getValue();
        int res = a - b;
        return getResult(res);
    }

    public String multiply(Operand operand) {
        int a = this.value;
        int b = operand.getValue();
        int res = a * b;
        return getResult(res);
    }

    public String divide(Operand operand) {
        int a = this.value;
        int b = operand.getValue();
        int res = a / b;
        return getResult(res);
    }

}
