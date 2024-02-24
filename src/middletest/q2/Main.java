package middletest.q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validNumber = false;
        do {
            int number = readNumber(scanner);
            if (validateNumberRange(number)) {
                System.out.println(number + "의 소수 여부 : " + PrimeNumberChecker.isPrime(number));
                validNumber = true;
            }
        } while (!validNumber);
    }

    private static int readNumber(Scanner scanner) {
        System.out.println("1 ~ 100 중 소수를 판별할 숫자를 입력하세요.");
        while (!scanner.hasNextInt()) {
            System.out.println("입력이 숫자가 아닙니다. 숫자를 입력하세요:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static boolean validateNumberRange(int number) {
        return number >= 1 && number <= 100;
    }
}
