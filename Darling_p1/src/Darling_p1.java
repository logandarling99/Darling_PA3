import java.security.SecureRandom;
import java.util.Scanner;

public class Darling_p1 {

    public static double Question(SecureRandom rand, int diffLevel, int arithType){
        int num1 = rand.nextInt((int)Math.pow(10, diffLevel));
        int num2 = rand.nextInt((int)Math.pow(10, diffLevel));
        if(arithType == 5){
            arithType = rand.nextInt(4) + 1;
        }

        double answer = 0;

        if(arithType == 1){
            System.out.println("How much is " + num1 + " plus " + num2 + "?");
            answer = num1 + num2;
        }
        else if(arithType == 2){
            System.out.println("How much is " + num1 + " times " + num2 + "?");
            answer = num1 * num2;
        }
        else if(arithType == 3){
            System.out.println("How much is " + num1 + " minus " + num2 + "?");
            answer = num1 - num2;
        }
        else if(arithType == 4){
            while(num2 == 0){
                num2 = rand.nextInt((int)Math.pow(10, diffLevel));
            }
            System.out.println("How much is " + num1 + " divided by " + num2 + "?");
            answer = (double) num1 / (double) num2;
        }

        return answer;
    }

    public static void response(SecureRandom rand, boolean isCorrect){
        int responseNum = rand.nextInt(4) + 1;
        if(isCorrect){
            switch (responseNum){
                case 1:
                    System.out.println("Very good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }
        else{
            switch (responseNum){
                case 1:
                    System.out.println("No. Please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don't give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }
    }

    public static int diffLevel(Scanner in){
        System.out.println("Enter the difficulty level: ");
        int difflevel = in.nextInt();
        return difflevel;
    }

    public static int problemType(Scanner in){
        System.out.println("Enter the problem type you want (1 = addition, 2 = multiplication, 3 = subtraction, 4 = division):");
        int probType = in.nextInt();
        return probType;
    }

    public static void main(String ...args){
        Scanner scnr = new Scanner(System.in);
        SecureRandom randNum = new SecureRandom();
        double userResponse;
        double answer;
        final double THRESHOLD = 0.0001;
        int difficultyLevel = 1;
        int arithType = 1;
        int session = 1;

        while(session == 1){
            int correct = 0;
            int wrong = 0;
            int questionNum = 0;
            difficultyLevel = diffLevel(scnr);
            arithType = problemType(scnr);
            answer = Question(randNum, difficultyLevel, arithType);
            questionNum++;
            userResponse = scnr.nextDouble();

            while(questionNum < 10){

                if(Math.abs(userResponse - answer) < THRESHOLD){
                    correct++;
                    response(randNum, true);
                    answer = Question(randNum, difficultyLevel, arithType);
                }
                else{
                    wrong++;
                    response(randNum, false);
                    answer = Question(randNum, difficultyLevel, arithType);
                }
                questionNum++;
                userResponse = scnr.nextDouble();

            }

            if(Math.abs(userResponse - answer) < THRESHOLD){
                correct++;
                response(randNum, true);
            }
            else{
                wrong++;
                response(randNum, false);
            }

            System.out.println("Number of questions correct: " + correct);
            System.out.println("Number of questions wrong: " + wrong);
            if((correct*10) >= 75){
                System.out.println("Congratulations, you are ready to go to the next level.");
            }
            else{
                System.out.println("Please ask your teacher for extra help.");
            }

            System.out.println("Would you like to start a new session (type 1 for yes): ");
            session = scnr.nextInt();
            if(session != 1) System.exit(0);
        }

    }
}
