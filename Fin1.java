/* 機位:
 學號:411631327
 姓名:邱振營
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Fin1 {

    static int[] num = new int[3];
    static int denom;
    static int[] result = new int[2];

    private static void inputDate() throws ArrayIndexOutOfBoundsException, ArithmeticException, InputMismatchException {
        Scanner input = new Scanner(System.in);
        System.out.println("Pls enter three integers: ");
        for (int i = 0; i < 3; i++) {
            num[i] = input.nextInt();
        }
        System.out.println(" Pls enter denom");
        denom = input.nextInt();
        for (int i = 0; i < 3; i++) {
            result[i] = num[i] / denom;
        }
    }

    public static void main(String[] args) {
        try {
            inputDate();
        } catch (ArithmeticException e) { 
            System.out.println(e);
        } catch (InputMismatchException e) { 
            System.out.println(e);
        } catch (ArrayIndexOutOfBoundsException e) { 
            System.out.println(e);
        }
    }

}
