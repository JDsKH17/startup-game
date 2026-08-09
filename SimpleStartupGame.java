import java.util.Scanner;
public class SimpleStartupGame{
public static void main(String[] args){

    int numOfGuesses = 0;
    GameHelper helper = new GameHelper();

    SimpleStartup startup = new SimpleStartup();

    int randomNum= (int) (Math.random() *6);

    int[] locations = {randomNum,randomNum+1,randomNum+2};
    startup.setLocationCells(locations);

    boolean isAlive = true;
    while(isAlive){
        int guess = helper.getUserInput("enter a number");
        String result = startup.checkYourself(guess);
        numOfGuesses++;
        if(result.equals("Kill")){
            isAlive = false;
            System.out.println("You took " + numOfGuesses +" guesses \n Game Over");
        }
    }
}
}

class SimpleStartup {
  private int[] locationCells;
  private int numOfHits = 0;

  public void setLocationCells(int[] locs){
    locationCells = locs;
  }
  public String checkYourself(int guess){
    String result = "miss";
    for (int cell : locationCells){
        if (guess == cell){
            result = "hit";
            numOfHits++;
            break;
        }
    }
    if (numOfHits == locationCells.length){
        result = "Kill";
    }
    System.out.println(result);
    return result;
  }
}


    class GameHelper {
    static  Scanner scanner = new Scanner(System.in);
        public int getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextInt();
}
}
