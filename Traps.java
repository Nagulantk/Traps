import java.util.Scanner;
public class Traps {
    static int trapsCount = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N1 = input.nextInt();
        int N2 = input.nextInt();
        int y = input.nextInt();
        calculatingTrap(N1, N2, y);
    }
    public static int digitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum = sum + (number % 10);
            number = number / 10;
        }
        return sum;
    }
    public static void calculatingTrap(int N1, int N2, int y) {
        if(N1<=N2) {
         if (y < 3) {
             y = 3;
         }
         if (N1 == y || N1 % y == 0 || y % N1 == 0) {
             y = printingTrap(N1, y);
         } else {
             int sum = N1;
             int c = 1;
             while (sum > 9) {
                 sum = digitSum(sum);
                 if (sum == y || sum % y == 0 || y % sum == 0) {
                     y = printingTrap(N1, y);
                     c = 0;
                     break;
                 }
             }
             if (c == 1) {
                 y = y - 1;
             }
         }
         N1++;
         calculatingTrap(N1, N2, y);
        }

        else {
            if (trapsCount == 0) {
                System.out.println("None");
            }
        }
    }
    public static int printingTrap(int number,int y)
    {
        System.out.print(number+" ");
        y=y+2;
        trapsCount++;

        return y;
    }
}