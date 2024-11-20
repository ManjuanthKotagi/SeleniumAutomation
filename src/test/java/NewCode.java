import org.testng.annotations.Test;

public class NewCode {

    @Test()
    public void reverseInteger() {

        int integerArray[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int length = integerArray.length;
        int reversedArray[] = new int[length];

        for (int i = 0; i < length; i++) {
            reversedArray[length - 1 - i] = integerArray[i];
        }
        for (int i = 0; i < reversedArray.length; i++) {
            System.out.println("Reversed Array is : " + reversedArray[i]);
        }
    }
}