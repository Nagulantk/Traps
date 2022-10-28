import java.util.Scanner;
public class Traps {
    static int trapsCount = 0;
    static int N2;
    static int N1,y;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
         N1 = input.nextInt();
        N2 = input.nextInt();
       y = input.nextInt();
        calculatingTrap();
    }
    public static int digitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum = sum + (number % 10);
            number = number / 10;
        }
        return sum;
    }
    public static void calculatingTrap() {
    while(N1<=N2) {
         if (y < 3) {
             y = 3;
         }
        boolean condition=checkingTrap(N1);
         if (condition) {
                     y--;
                 }

         N1++;
    }
      if (trapsCount == 0) {
                System.out.println("None");
            }
        }

    public static boolean checkingTrap(int sum)
    {
        if (sum == y || sum % y == 0 || y % sum == 0){
            System.out.print(N1+" ");
            y=y+2;
            trapsCount++;
            return false;
        }
       else  if(sum>9)
        {sum = digitSum(sum);
          return  checkingTrap(sum);
        }
       return true;
    }
}