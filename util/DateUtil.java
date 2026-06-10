package Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static LocalDateTime agora() {
        return LocalDateTime.now();
    }

    public static String formatar(LocalDateTime dt) {
        if (dt == null) {
            return "";
        }
        return dt.format(FORMATTER);
    }
}