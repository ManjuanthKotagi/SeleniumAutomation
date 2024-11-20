import org.testng.annotations.Test;

import java.util.ArrayList;

public class Program {

    @Test()
    public void tableTraverse() {

        String str = "vishnu1234";
        StringBuilder sb = new StringBuilder();

        char cha[] = str.toCharArray();

        int length = cha.length;
        int sum = 0;

        for (char c : cha) {
            if (Character.isDigit(c)) {
                sb.append(c);
                int number = Integer.parseInt(String.valueOf(c));
                sum = sum + number;
            }
        }

        System.out.println(sb);
        System.out.println(sum);
       // System.out.println(Integer.parseInt(String.valueOf(sum)));


    }
}
