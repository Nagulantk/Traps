import java.util.Scanner;
public class Traps {
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
        int trapsCount = 0;
        for (int i = N1; i <= N2; i++) {
            if (y < 3) {
                y = 3;
            }
            if (i == y) {
                y=printingTrap(i,y);
                trapsCount++;
            } else if (i % y == 0 || y % i == 0) {
                y=printingTrap(i,y);
                trapsCount++;
            } else {
                int sum = i;
                int c=1;
                while (sum > 9) {
                    sum = digitSum(sum);
                    if (sum == y || sum % y == 0 || y % sum == 0) {
                      y=printingTrap(i,y);
                      c=0;
                        trapsCount++;
                        break;
                    }
                }
                if (c==1) {
                    y = y - 1;
                }
            }
        }
        if(trapsCount==0)
        {
            System.out.println("None");
        }
    }
    public static int printingTrap(int number,int y)
    {
        System.out.print(number+" ");
        y=y+2;
        return y;
    }
}