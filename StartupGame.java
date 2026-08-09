import java.util.ArrayList;

public class StartupGame{
        private GameHelper helper = new GameHelper();
        private ArrayList<Startup> Startups = new ArrayList<Startup>();
        private int numOfGuesses = 0;

        private void setUpGame(){
            Startup one = new Startup();
            Startup two = new Startup();
            Startup three = new Startup();
            one.setName("Messi");
            two.setName("Ineista");
            three.setName("Pedri");
            Startups.add(one);
            Startups.add(two);
            Startups.add(three);

            System.out.println("                                      ...Now the game will start...");
            System.out.println(" The field of the Game is a 7*7 Grid.\nthe horizontal line is numberd as 0,1,2,3... and the vertical is a,b,c...\nYour goal is to sink 3 Startups(Messi , Iniesta , Pedri) and every startup is taking three contiguous squares vertically or horizontally\nTry to sink them in fewest number of guesses\nFinally you can only type your hit like (a1) or (d5) you can't add anyting alse and the letters must be small don't captalize anyletter");

            for(Startup startup : Startups){
                ArrayList<String> newLocation = helper.placeStartup(3);
                startup.setLocationCells(newLocation);
            }
        }
        private void startPlaying(){
            while(!Startups.isEmpty()){
                String userGuess = helper.getUserInput("Enter a Guess");
                checkUserGuess(userGuess);
            }
            finishGame();
        }

        private void checkUserGuess(String userGuess){
            numOfGuesses++;
            String result = "miss";
            for(Startup startupToTest : Startups){
                result = startupToTest.checkYourself(userGuess);
                if(result.equals("hit")){
                    break;
                }
                if(result.equals("Kill")){
                    Startups.remove(startupToTest);
                    break;
                }
            }
                    System.out.println(result);
        }
        private void finishGame(){
            System.out.println("All startups are dead! Your stock now is worthless");
            if (numOfGuesses <= 18 ){
            System.out.println("Well Done ! It only took you " + numOfGuesses + " guesses.\nYou got out before your options sank.");
            }else{
                System.out.println(" Took you long enough " + numOfGuesses + " guesses -_- \nCongratulations!! Fish now is dancing with your options ;) :0" );
            }
    }
public static void main(String[] args){
    StartupGame Game = new StartupGame();
    Game.setUpGame();
    Game.startPlaying();
}
}



