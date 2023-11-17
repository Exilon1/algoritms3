package sortlevel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ksort {

    public String[] items;

    public ksort() {
        this.items = new String[800];

        for(int i = 0; i< items.length; i++) {
            items[i] = null;
        }
    }

    public int index(String s) {
        if (s.length() != 3) {
            return -1;
        }

        String character = s.substring(0,1);
        int num;

        Pattern pattern = Pattern.compile("[a-h]");
        Matcher matcher = pattern.matcher(character);

        if (! matcher.find()) {
            return -1;
        }

        try {
            num = Integer.parseInt(s.substring(1,3));
        } catch (NumberFormatException e) {
            return -1;
        }

        int ch = ((int) character.charAt(0)) - 97;

        String result = String.valueOf(ch);
        if (num == 0) {
            result = result + "00";
        } else {
            result = result + num;
        }

        return Integer.parseInt(result);
    }

    public boolean add(String s) {
        int index = index(s);

        if (index < 0) {
            return false;
        }

        items[index] = s;

        return true;
    }
}
