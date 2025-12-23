package Utils;

import javax.swing.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateFormatter extends JFormattedTextField.AbstractFormatter {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Object stringToValue(String text) throws ParseException {
        return LocalDate.parse(text, formatter);
    }

    @Override
    public String valueToString(Object value) {
        if (value == null) return "";
        Calendar cal = (Calendar) value;
        return LocalDate.of(
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH)
        ).format(formatter);
    }
}
