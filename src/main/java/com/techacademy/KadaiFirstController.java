package com.techacademy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/")
    public String index() {
        return "test";
    }

    @GetMapping("/dayofweek/{val1}")
    public String dispDayWeek(@PathVariable String val1) {
        int year = Integer.parseInt(val1.substring(0, 4));
        int month = Integer.parseInt(val1.substring(4, 6)) - 1;
        int day = Integer.parseInt(val1.substring(6, val1.length()));

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String week = "";
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                week = "Sunday";
                break;
            case Calendar.MONDAY:
                week = "Monday";
                break;
            case Calendar.TUESDAY:
                week = "Tuesday";
                break;
            case Calendar.WEDNESDAY:
                week = "Wednesday";
                break;
            case Calendar.THURSDAY:
                week = "Thuesday";
                break;
            case Calendar.FRIDAY:
                week = "Friday";
                break;
            case Calendar.SATURDAY:
                week = "Saturday";
                break;
            default:
                week = "";
                break;
        }

        return week;
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 + val2;
        return "実行結果 : " + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 - val2;
        return "実行結果 : " + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 * val2;
        return "実行結果 : " + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 / val2;
        return "実行結果 : " + res;
    }
}
