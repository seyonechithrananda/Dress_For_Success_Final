package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The Main (driver) class for Dress for Success
 *
 * @author Seyone Chithrananda and Uroosa Imtiaz
 * @version 3
 */

public class Main extends Application {

    /**
     * Width of stage
     */
    private static final int WIDTH = 1000;
    /**
     * height of stage
     */
    private static final int HEIGHT = 750;

    /**
     * main stage
     */
    static Stage mainWindow;

    /**
     * Scenes which the program goes through
     * mainMenu - choose between instructions, levelSelector, highScores + exit
     * levelOne, levelTwo, levelThree - chosen in the levelSelector scene.
     */
    Scene mainMenu, splashscreen, learnGame, levelSelector, levelOne, levelTwo, levelThree, highScores;

    /**
     * declaration of LevelOne class
     */
    LevelOne l1;

    /**
     * decleration of HighScores class
     */
    HighScores hs;

    /**
     * decleration of LevelTwo class
     */
    LevelTwo l2;

    /**
     * decleration of LevelThree class
     */
    LevelThree l3;

    /**
     * main pane for Game
     */
    private AnchorPane pane;

    /**
     * user selected name
     */
    private String playerName;

    /**
     *
     * @param primaryStage the main stage upon which all scenes at set to
     * @throws Exception throws exception for Timer
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        mainWindow = primaryStage;
        primaryStage.setResizable(false);

        pane = new AnchorPane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.setMinSize(WIDTH, HEIGHT);
        pane.setMaxSize(WIDTH, HEIGHT);

        primaryStage.setTitle("Dress for Success");

        MainMenu main = new MainMenu();
        mainMenu = main.menuWindow();

        Splashscreen splash = new Splashscreen();
        splashscreen = splash.mainWindow();

        Instructions instructions = new Instructions();
        learnGame = instructions.mainWindow();

        Levels level = new Levels();
        levelSelector = level.mainWindow();

        l1 = new LevelOne(playerName);
        levelOne = l1.mainWindow();

        l2 = new LevelTwo(playerName);
        levelTwo = l2.mainWindow();

        l3 = new LevelThree(playerName);
        levelThree = l3.mainWindow();

        hs = new HighScores();
        highScores = hs.mainWindow();

        /* sets action for all buttons in MainMenu, instructions, Choose Level, etc
            by calling accessor methods to a scene when the button is clicked/
        */
        main.getPlayButton().setOnAction(e -> mainWindow.setScene(levelSelector));
        main.getInstructionsButton().setOnAction(event -> mainWindow.setScene(learnGame));
        main.getScoreButton().setOnAction(e ->mainWindow.setScene(highScores()));
        main.getExitButton().setOnAction(e ->mainWindow.close());
        instructions.getMainMenuButton().setOnAction(e -> mainWindow.setScene(mainMenu));
        level.getLevelOneButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playerName = level.getPlayerName();
                mainWindow.setScene(level1());
            }
        });
        level.getLevelTwoButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playerName = level.getPlayerName();
                mainWindow.setScene(level2());
            }
        });
        level.getLevelThreeButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playerName = level.getPlayerName();
                mainWindow.setScene(level3());
            }
        });
        hs.getMainMenuButton().setOnAction(event -> mainWindow.setScene(mainMenu));
        l1.getMainMenuButton().setOnAction(e -> mainWindow.setScene(mainMenu));
        l1.getLevelTwo().setOnAction(event -> mainWindow.setScene(level2()));
        l2.getMainMenuButton().setOnAction(event-> mainWindow.setScene(mainMenu));
        l2.getLevelThree().setOnAction(event-> mainWindow.setScene(level3()));
        l3.getMainMenuButton().setOnAction(event-> mainWindow.setScene(mainMenu));
        l3.getLevelSelector().setOnAction(event-> mainWindow.setScene(levelSelector));

        // timer which waits for splashscreen animation to set mainMenu scene
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Platform.runLater(() -> mainWindow.setScene(mainMenu));
            }
        };

        mainWindow.setScene(splashscreen);
        mainWindow.show();

        timer.schedule(task, 3000); // sets delay of 3000 before executing mainMenu scene in run
        mainWindow.show(); // shows mainMenu

    }


    /**
     * sets Action event for when the MainMenu or Level2 Buttons are clicked
     * @return mainWindow of Level1
     */
    public Scene level1()
    {
        l1= new LevelOne(playerName);
        levelOne = l1.mainWindow();
        l1.getMainMenuButton().setOnAction(event -> mainWindow.setScene(mainMenu));
        l1.getLevelTwo().setOnAction(event-> mainWindow.setScene(level2()));
        return levelOne;
    }

    /**
     * sets Action event for when the MainMenu or Level3 Buttons are clicked
     * @return mainWindow of Level2
     */
    public Scene level2()
    {
        l2 = new LevelTwo(playerName);
        levelTwo = l2.mainWindow();
        l2.getMainMenuButton().setOnAction(event -> mainWindow.setScene(mainMenu));
        l2.getLevelThree().setOnAction(event-> mainWindow.setScene(level3()));
        return levelTwo;
    }

    /**
     * sets Action event for when the MainMenu or Choose Level Buttons are clicked
     * @return mainWindow of Level3
     */
    public Scene level3()
    {
        l3 = new LevelThree(playerName);
        levelThree = l3.mainWindow();
        l3.getMainMenuButton().setOnAction(event-> mainWindow.setScene(mainMenu));
        l3.getLevelSelector().setOnAction(event-> mainWindow.setScene(levelSelector));
        return levelThree;
    }

    /**
     * sets action for when main menu is pressed in high scores, returns HighScores scene
     * @return mainWindow of HighScores class
     */

    public Scene highScores()
    {
        hs = new HighScores();
        highScores = hs.mainWindow();
        hs.getMainMenuButton().setOnAction(event-> mainWindow.setScene(mainMenu));
        return highScores;
    }


    /**
     * Launches program
     * @param args main method of driver class
     */
    public static void main(String[] args) {
        launch(args);
    }
}