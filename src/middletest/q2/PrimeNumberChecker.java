package middletest.q2;

import java.util.Scanner;

public class PrimeNumberChecker {

    private PrimeNumberChecker() {}

    public static void run(Scanner scanner) {
        int number = promptForValidNumber(scanner);
        displayPrimeStatus(number);
    }

    private static int promptForValidNumber(Scanner scanner) {
        int number;
        while (true) {
            System.out.println("1 ~ 100 중 소수를 판별할 숫자를 입력하세요.");
            while (!scanner.hasNextInt()) {
                System.out.println("입력이 숫자가 아닙니다. 숫자를 입력하세요.");
                scanner.next(); // 잘못된 입력을 건너뜀.
            }
            number = scanner.nextInt();
            if (!validateNumberRange(number)) {
                System.out.println("숫자가 1과 100 사이에 있어야 합니다.");
                continue; // 다시 숫자를 입력받음.
            }
            break; // 유효한 숫자가 입력되면 반복 종료.
        }
        return number;
    }

    private static boolean validateNumberRange(int number) {
        return number >= 1 && number <= 100;
    }

    private static void displayPrimeStatus(int number) {
        boolean isPrime = PrimeNumberChecker.isPrime(number);
        System.out.println(number + "의 소수 여부 : " + isPrime);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
