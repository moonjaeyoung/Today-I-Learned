package util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-09 오후 5:36
 * @Homepage : https://github.com/gusdnd852
 */
public interface Encoder {
    static String korean(String input) {
        try {
            return new String(input.getBytes(StandardCharsets.ISO_8859_1), "euc-kr");
        } catch (UnsupportedEncodingException ignore) {
            return "UnsupportedEncodingException Occurred";
        }
    }

    static String japanese(String input) {
        try {
            return new String(input.getBytes(StandardCharsets.ISO_8859_1), "euc-jp");
        } catch (UnsupportedEncodingException ignore) {
            return "UnsupportedEncodingException Occurred";
        }
    }
}
