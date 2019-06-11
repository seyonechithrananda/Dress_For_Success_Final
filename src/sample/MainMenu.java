package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.image.Image;

/**
 * The MainMenu class.
 *
 * @author Seyone Chithrananda
 * @version 1
 */


public class MainMenu {

    /**
     * Pane of MainMenu class
     */
    private AnchorPane layout1;

    /**
     * LevelButtons to Play, view High Score, Instructions or exit program
     * These buttons are clipped from the MainMenu background and the range
     * only includes the region where the text is on the button.
     */
    private LevelButtons playButton, scoreButton, instructionsButton, exitButton;

    /**
     * returns MainMenu as scene
     * @return scene
     */

    private HighScores hs;

    public Scene menuWindow ()
    {
        layout1 = new AnchorPane();
        layout1.setPadding(new Insets(10, 10, 100, 10));

        playButton = new LevelButtons("play");
        playButton.setLayoutX(463);
        playButton.setLayoutY(89);
        layout1.getChildren().add(playButton);

        scoreButton = new LevelButtons("scores");
        scoreButton.setLayoutX(743);
        scoreButton.setLayoutY(98);
        layout1.getChildren().add(scoreButton);

        instructionsButton = new LevelButtons("instructions");
        instructionsButton.setLayoutX(397);
        instructionsButton.setLayoutY(498);
        layout1.getChildren().add(instructionsButton);

        exitButton = new LevelButtons("exit");
        exitButton.setLayoutX(720);
        exitButton.setLayoutY(471);
        layout1.getChildren().add(exitButton);

        BackgroundImage background;
        background = new BackgroundImage(new Image("/Resources/Backgrounds/mainmenu.png", 1002,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layout1.setBackground(new Background(background));

        return new Scene(layout1, 1000, 750);

    }

    /**
     * returns Play button
     * @return playButton
     */
    public LevelButtons getPlayButton (){
        return playButton;
    }

    /**
     * returns Exit button
     * @return exitButton
     */
    public LevelButtons getExitButton (){
        return exitButton;
    }

    /**
     * returns Instructions button
     * @return instructionsButton
     */

    public LevelButtons getInstructionsButton (){
        return instructionsButton;
    }

    /**
     * returns Score button
     * @return scoreButton
     */

    public LevelButtons getScoreButton(){
        return scoreButton;
    }

    /**
     * sets action for when main menu is pressed in high scores, returns HighScores scene
     * @return mainWindow of HighScores class
     */
    public Scene highScores()
    {
        hs = new HighScores();
        Scene highScores = hs.mainWindow();
      // hs.getMainMenuButton().setOnAction(event-> mainWindow.setScene(mainMenu));
        return highScores;
    }


}
