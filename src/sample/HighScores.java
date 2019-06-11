package sample;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Returns scene which displays high scores for all 3 levels from text files.
 * <p>
 * References
 * <br> StackOverflow - Reading from file using Scanner. Retrieved from https://stackoverflow.com/questions/33627975/reading-info-using-scanner-from-text-file
 * </p>
 *
 * @author Seyone Chithrananda
 * @version 1.2
 *
 *
 *
 */

public class HighScores {
    /**
     * the usernames from Level 1
     */
    private ArrayList<String> levelOneNames = new ArrayList<>(0);
    private ArrayList<Integer> levelOneScores = new ArrayList<>(0);
    /**
     * the usernames from sample.Resources.Level 2
     */
    private ArrayList<String> levelTwoNames = new ArrayList<>(0);
    /**
     * the scores from sample.Resources.Level 2
     */
    private ArrayList<Integer> levelTwoScores = new ArrayList<>(0);
    /**
     * the usernames from Level 3
     */
    private ArrayList<String> levelThreeNames = new ArrayList<>(0);
    /**
     * the scores from Level 3
     */
    private ArrayList<Integer> levelThreeScores = new ArrayList<>(0);
    /**
     * The Pane of the Game.
     */
    private AnchorPane layout;

    /**
     * label for Level1 usernames
     */
    private Label userName1;

    /**
     * label for Level1 scores
     */
    private Label userScore1;

    /**
     * label for Level2 usernames
     */

    private Label userName2;

    /**
     * label for Level2 scores
     */
    private Label userScore2;

    /**
     * label for Level3 usernames
     */
    private Label userName3;

    /**
     * label for Level3 scores
     */
    private Label userScore3;

    /**
     * button that goes back to main menu
     */
    private MainMenuButton mainMenuButton;

    /**
     * returns Scene object with high scores when called
     */
    public Scene mainWindow ()
    {
        layout = new AnchorPane();

        // reads scores from file, sorts scores, displays scores
        readUserScores();
        sortList();
        displayScores();

        // initializes mainMenuButton
        mainMenuButton = new MainMenuButton("Main Menu", 190, 49, 23);
        mainMenuButton.setLayoutX(405);
        mainMenuButton.setLayoutY(600);
        layout.getChildren().add(mainMenuButton);

        // returns scene
        return new Scene(layout, 1000, 750);
    }


    /**
     * reads user scores from 3 .txt files in try-catch blocks
     */
    public void readUserScores()
    {
        // reads each line of user scores and names from Level 1
        try {
            File file = new File(System.getProperty("user.home") + "//" + "highscoreslevel1" + ".txt");
            Scanner in = new Scanner(new File(String.valueOf(file)));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line!=null) {
                    // adds username
                    levelOneNames.add(line.substring(0, line.indexOf(' ')));
                    // adds score
                    levelOneScores.add(Integer.parseInt(line.substring(line.indexOf(' ') + 1)));
                }
            }
        } catch (IOException e) {
        }

        // reads each line of user scores and names from sample.Resources.Level 2
        try {
            File file = new File(System.getProperty("user.home") + "//" + "highscoreslevel2" + ".txt");
            Scanner in = new Scanner(new File(String.valueOf(file)));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line!=null) {
                    // adds username
                    levelTwoNames.add(line.substring(0, line.indexOf(' ')));
                    // adds score
                    levelTwoScores.add(Integer.parseInt(line.substring(line.indexOf(' ') + 1)));
                }
            }
        } catch (IOException e) {
        }

        // reads each line of user scores and names from Level 3
        try {
            File file = new File(System.getProperty("user.home") + "//" + "highscoreslevel3" + ".txt");
            Scanner in = new Scanner(new File(String.valueOf(file)));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line!=null) {
                    // adds username
                    levelThreeNames.add(line.substring(0, line.indexOf(' ')));
                    // adds score
                    levelThreeScores.add(Integer.parseInt(line.substring(line.indexOf(' ') + 1)));
                }
            }
        } catch (IOException e) {
        }
    }


    /**
     * sorts scores by greatest to least, adjusts order of names
     */
    public void sortList () {
        for (int x = 0; x<levelOneScores.size(); x++) {

            // sorting algorithm: insertion sort
            int temp = levelOneScores.get(x), pos = x;
            String tempName = levelOneNames.get(x);

            while (pos >0 && temp> levelOneScores.get(pos -1))
            {
                levelOneScores.set(pos, levelOneScores.get(pos -1));
                levelOneNames.set(pos, levelOneNames.get(pos -1));
                pos--;
            }
            levelOneScores.set(pos, temp);
            levelOneNames.set(pos, tempName);
        }

        for (int x = 0; x<levelTwoScores.size(); x++) {
            int temp = levelTwoScores.get(x), pos = x;
            String tempName = levelTwoNames.get(x);

            while (pos >0 && temp> levelTwoScores.get(pos -1))
            {
                levelTwoScores.set(pos, levelTwoScores.get(pos -1));
                levelTwoNames.set(pos, levelTwoNames.get(pos -1));
                pos--;
            }
            levelTwoScores.set(pos, temp);
            levelTwoNames.set(pos, tempName);
        }

        for (int x = 0; x<levelThreeScores.size(); x++) {
            int temp = levelThreeScores.get(x), pos = x;
            String tempName = levelThreeNames.get(x);

            while (pos >0 && temp> levelThreeScores.get(pos -1))
            {
                levelThreeScores.set(pos, levelThreeScores.get(pos -1));
                levelThreeNames.set(pos, levelThreeNames.get(pos -1));
                pos--;
            }
            levelThreeScores.set(pos, temp);
            levelThreeNames.set(pos, tempName);
        }
    }

    // displays scores using Labels
    public void displayScores()
    {
        // number of scores to output
        int numOutput1;
        int numOutput2;
        int numOutput3;

        // sets background
        BackgroundImage levelOne = new BackgroundImage(new Image("/Resources/Backgrounds/highscore.png", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        layout.setBackground(new Background(levelOne));

        if (levelOneScores.size()<=10)
            numOutput1 = levelOneScores.size();
        else
            numOutput1 = 10;

        if (levelTwoScores.size()<=10)
            numOutput2 = levelTwoScores.size();
        else
            numOutput2 = 10;

        if (levelThreeScores.size()<=10)
            numOutput3 = levelThreeScores.size();
        else
            numOutput3 = 10;

        // displays level 1, 2, and 3 usernames + scores
        for (int i = 0; i<numOutput1; i++) {
            userName1 = new Label(levelOneNames.get(i));
            userName1.setLayoutX(150);
            userName1.setLayoutY(200 + i * 40);
            userName1.setFont(Font.font("Helvetica", 22));
            layout.getChildren().add(userName1);

            userScore1 = new Label(String.valueOf(levelOneScores.get(i)));
            userScore1.setLayoutX(280);
            userScore1.setLayoutY(200 + i * 40);
            userScore1.setFont(Font.font("Helvetica", 22));
            layout.getChildren().add(userScore1);
        }

        for (int i = 0; i<numOutput2; i++) {
            userName2 = new Label(levelTwoNames.get(i));
            userName2.setLayoutX((410));
            userName2.setLayoutY(200 + i * 40);
            userName2.setFont(Font.font("Helvetica", 22));
            layout.getChildren().add(userName2);

            userScore2 = new Label(String.valueOf(levelTwoScores.get(i)));
            userScore2.setLayoutX(580);
            userScore2.setLayoutY(200 + i * 40);
            userScore2.setFont(Font.font("Helvetica", 22));
            layout.getChildren().add(userScore2);
        }

        for (int i = 0; i<numOutput3; i++)
        {
            userName3 = new Label(levelThreeNames.get(i));
            userName3.setLayoutX((680));
            userName3.setLayoutY(200 + i * 40);
            userName3.setFont(Font.font("Helvetica", 22));
            layout.getChildren().add(userName3);

            userScore3 = new Label(String.valueOf(levelThreeScores.get(i)));
            userScore3.setLayoutX(880);
            userScore3.setLayoutY(200 + i * 40);
            userScore3.setFont(Font.font("Helvetica", 22));
            layout.getChildren().add(userScore3);
        }

    }

    /**
     *
     * @return mainMenuButton
     */
    public MainMenuButton getMainMenuButton ()
    { return mainMenuButton; }


}



