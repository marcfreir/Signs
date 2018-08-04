package com.azo.marcfreir.signs;

import java.util.ArrayList;

public class InterpreterSign {

    private ArrayList<Sign> signs = new ArrayList<Sign>() {
        {
            add(new Sign(20, 1, 18, 2, "Aquarius", "@drawable/aquarius"));

            add(new Sign(19, 2, 20, 3, "Pisces", "@drawable/pisces"));

            add(new Sign(21, 3, 19, 4, "Aries", "@drawable/aries"));

            add(new Sign(20, 4, 20, 5, "Taurus", "@drawable/taurus"));

            add(new Sign(21, 5, 20, 6, "Gemini", "@drawable/gemini"));

            add(new Sign(21, 6, 22, 7, "Cancer", "@drawable/cancer"));

            add(new Sign(23, 7, 22, 8, "Leo", "@drawable/leo"));

            add(new Sign(23, 8, 22, 9, "Virgo", "@drawable/virgo"));

            add(new Sign(23, 9, 22, 10, "Libra", "@drawable/libra"));

            add(new Sign(23, 10, 21, 11, "Scorpio", "@drawable/scorpio"));

            add(new Sign(22, 11, 21, 12, "Sagittarius", "@drawable/sagittarius"));

            add(new Sign(22, 12, 19, 1, "Capricorn", "@drawable/capricorn"));
        }
    };

    //METHOD INTERPRETER SIGN
    public Sign interpret(int day, int month) {
        Sign sign = null;
        for (Sign s : signs) {
            if (s.getMonthfirst() == month && day >= s.getDayfirst()) {
                sign = s;
                break;
            } else if (s.getMonthlast() == month && day <= s.getDaylast()) {
                sign = s;
                break;
            }
        }
        return sign;
    }
}
