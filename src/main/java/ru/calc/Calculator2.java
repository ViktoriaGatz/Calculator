// Наследование - inheritance
package ru.calc;

final class Calculator2 extends Calculator {
    // private String strinG;
    // private int answeR = 0;
    private int x;

    Calculator2() {
        this.setStrinG("0");
    }

    Calculator2(String c) {
        // x = super.Pattern4(c);
        // System.out.println("last number = " + x);
        this.setStrinG(c);
    }

    @Override // Переопределить метод из родительского класса // Необязательно?
    public boolean MyDelete(String str) {
        String s = new String(str);
        s = s.replaceAll("\\d|\\+|\\*|/|-", "");
        if (s.length() == 0)
            return false;
        else
            return true;
    }
}
