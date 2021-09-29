package stacks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Neha.Sony
 */

public class Validation {
    public static void main(String[] args) {
        if ( String.valueOf( "-+").matches( "[-+*/()]" ) ) {
            System.out.println(Boolean.TRUE);
        }
        else System.out.println(Boolean.FALSE);
    }
}