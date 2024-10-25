
import java.io.Console;
import java.util.Arrays;
import java.util.Random;

public class Mastermind {
    
    public static void main(String[] args) {
        
        Console cons = System.console();

        Mastermind m = new Mastermind();
        int[] answer = m.newCode();
        System.out.println("Code generated, guess the code!");
        System.out.println(Arrays.toString(answer));

        int tries=1;
        while (tries < 13){
            System.out.printf("#%d Try:", tries);
            String s = cons.readLine();
            int[] guess = new int[s.length()];
            
            int[] noNoNumbers = {0,7,8,9};
            boolean containsAnyTarget = Arrays.stream(noNoNumbers)
                                          .anyMatch(noNoNumber -> Arrays.stream(answer).anyMatch(x -> x == noNoNumber));
            if (containsAnyTarget){
                System.err.println("Your guess can only contain numbers 1 through 6. Try again.");
                break;

            } else {
                for (int j=0; j < 4; j++){
                    guess[j] = Character.getNumericValue(s.charAt(j));
                }
                int idxChecker = 0;
                int valChecker = 0;
                for (int g=0; g < guess.length; g++){
                    for (int a=0; a < answer.length; a++){
                        if (guess[g] == answer[a]){
                            if (g == a){
                                idxChecker++;
                                if (idxChecker == 4){
                                    System.out.printf("Congrats! game won in %d tries.", tries);
                                    System.exit(0);
                                }
                                break;
                            }
                            valChecker++;
                            break;
                        }
                    }
                }
                System.out.printf("You have %d correct and %d in the wrong place.\n", idxChecker, valChecker);
            }
           
            tries++;
        }
        System.out.println("You've exceeded the maximum no. of tries! Better luck, loser.");

    }

    public int[] newCode(){
        int[] code = new int[4];
        Random rand = new Random();
        for (int i=0; i<4; i++){
            code[i] = rand.nextInt(6) + 1;
            System.out.println(code[i]);    
        }
        return code;
    }
}
