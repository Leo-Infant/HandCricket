
import java.util.Random;
import java.util.Scanner;

class HandCricket {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int score1;
    static int score2;
    static int target;

    static int computer() {
        int com = random.nextInt(6) + 1;
        System.out.println("Computer's value: " + com);
        return com;
    }

    static int user() {
        System.out.print("Enter Your Value: ");
        int value = scanner.nextInt();
        while (value > 6) {
            System.out.println("You have Entered more than 6 !!");
            System.out.print("Enter your value: ");
            value = scanner.nextInt();
        }
        return value;
    }

    static int toss() {
        System.out.println("Choose: \n 1. Odd\n 2. Even");
        System.out.print("Enter your Choice (1/2): ");
        int choice = scanner.nextInt();

        int toss = user() + computer();

        if (toss % 2 == 0) {
            if (choice == 2) {
                System.out.println("You Won the Toss");
                System.out.println("Choose: \n 1. Batting\n 2. Bowling");
                System.out.print("Enter your Choice (1/2): ");
                int choice2 = scanner.nextInt();
                if (choice2 == 1) {
                    System.out.println("You chose to Bat");
                    return 1;
                } else {
                    System.out.println("You chose to Bowl");
                    return 2;
                }
            } else {
                System.out.println("You Lost the Toss");
                int choice2 = random.nextInt(2) + 1;
                if (choice2 == 1) {
                    System.out.println("Computer chose to Bat");
                    return 2;
                } else {
                    System.out.println("Computer chose to Bowl");
                    return 1;
                }
            }
        } else {
            if (choice == 1) {
                System.out.println("You Won the Toss");
                System.out.println("Choose: \n 1. Batting\n 2. Bowling");
                System.out.print("Enter your Choice (1/2): ");
                int choice2 = scanner.nextInt();
                if (choice2 == 1) {
                    System.out.println("You chose to Bat");
                    return 1;
                } else {
                    System.out.println("You chose to Bowl");
                    return 2;
                }
            } else {
                System.out.println("You Lost the Toss");
                int choice2 = random.nextInt(2) + 1;
                if (choice2 == 1) {
                    System.out.println("Computer chose to Bat");
                    return 2;
                } else {
                    System.out.println("Computer chose to Bowl");
                    return 1;
                }
            }
        }
    }

    static int bat(int target) {
        System.out.println("\n\nYou are Batting now !!!");
        int p1, p2;
        score1 = 0;
        do {
            p1 = user();
            p2 = computer();
            if (p1 != p2) {
                score1 += p1;
                System.out.println("((<<---Your Score!!--->>)) = " + score1);
                if (target != -1 && score1 > target) {
                    System.out.println("You have chased the target!");
                    break;
                }
            } else {
                System.out.println();
                System.out.println("You're Out !!!!!!");
            }
        } while (p1 != p2);

        return score1;
    }

    static int bowl(int target) {
        System.out.println("\n\nYou are Bowling now !!!");
        int p1, p2;
        score2 = 0;
        do {
            p1 = user();
            p2 = computer();
            if (p1 != p2) {
                score2 += p2;
                System.out.println("((<<---Computer's Score!!--->>)) = " + score2);
                if (target != -1 && score2 > target) {
                    System.out.println("Computer has chased the target!");
                    break;
                }
            } else {
                System.out.println();
                System.out.println("Computer is Out !!!!!!");
            }
        } while (p1 != p2);

        return score2;
    }

    static void game(int innings) {
        int result1, result2;
        if (innings == 1) {
            result1 = bat(-1); // Batting without target
            System.out.println("Target is --->>> " + (score1 + 1));
            target = score1 + 1;
            result2 = bowl(target); // Bowling with target
        } else {
            result2 = bowl(-1); // Bowling without target
            System.out.println("Target is --->>> " + (score2 + 1));
            target = score2 + 1;
            result1 = bat(target); // Batting with target
        }
        result(result1, result2);
    }

    static void result(int score1, int score2) {
        if (score1 > score2) {
			System.out.println();
            System.out.println("<<<------Player won------>>>");
        } else if (score1 == score2) {
			System.out.println();
            System.out.println("------>Match Draw<------");
        } else {
			System.out.println();
            System.out.println("!!======Computer Won======!!");
        }
    }

    public static void main(String[] args) {
        int innings = toss();
        game(innings);
    }
}
