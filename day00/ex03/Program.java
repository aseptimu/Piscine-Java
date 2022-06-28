package ex03;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_NUMBER_OF_WEEKS = 19;
        final String DATA_LIMIT = "42";
        long storage = 0;
        int currentWeek = 1;
        String input = scanner.nextLine();

        while (currentWeek != MAX_NUMBER_OF_WEEKS && !input.equals(DATA_LIMIT)) {
            checkString(input, currentWeek);
            storage = saveGrade(storage, scanner);
            input = scanner.nextLine();
            currentWeek++;
        }
        processGrade(storage, currentWeek);

    }

    private static void checkString(String check, int weekNumber) {
        final String WEEK_CHECK = "Week ";

        if (!check.equals(WEEK_CHECK + weekNumber)) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
    }

    private static long saveGrade(long storage, Scanner scanner) {
        final int NUMBER_OF_TESTS = 5;
        int minGrade = 10;
        int grade;

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            grade = scanner.nextInt();
            if (grade < 1 || grade > 9) {
                System.err.println("Illegal Argument");
                System.exit(-1);
            }
            if (grade < minGrade) {
                minGrade = grade;
            }
        }
        storage = storage * 10 + minGrade;
        scanner.nextLine();

        return storage;
    }

    private static void processGrade(long storage, int numberOfWeeks) {
        long grade;
        int tmp = numberOfWeeks;

        while (tmp > 1) {
            grade = getGrade(storage, tmp);
            printGrade(grade, numberOfWeeks - tmp);
            tmp--;
        }
    }

    private static long getGrade(long storage, int week) {
        long grade;
        for (int i = 2; i < week; i++) {
            storage /= 10;
        }
        grade = storage % 10;
        return grade;
    }

    private static void printGrade (long grade, int week) {
        System.out.print("Week " + (week + 1));
        for (int j = 0; j < grade; j++) {
            System.out.print('=');
        }
        System.out.println('>');
    }
}
