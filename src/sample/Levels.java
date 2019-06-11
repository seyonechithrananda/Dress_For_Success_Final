package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * The Levels class.
 *
 * @author Seyone Chithrananda
 * @version 1
 */

public class Levels {

    /**
     * Pane for Levels class
     */
    private AnchorPane layout;

    /**
     * used to select between 3 levels
     */
    private MainMenuButton level1,level2,level3;

    /**
     * get playerName in introScreen()
     */
    private String playerName;

    /**
     *
     * @return Scene to enter username + choose level
     */
    public Scene mainWindow() {
        layout = new AnchorPane();
        layout.setPadding(new Insets(10, 10, 100, 10));

        introScreen();

        level1 = new MainMenuButton("Level 1", 190, 49, 23);
        level1.setLayoutX(400);
        level1.setLayoutY(335);

        level2 = new MainMenuButton("Level 2", 190, 49, 23);
        level2.setLayoutX(400);
        level2.setLayoutY(410);


        level3 = new MainMenuButton("Level 3", 190, 49, 23);
        level3.setLayoutX(400);
        level3.setLayoutY(485);

        return new Scene(layout, 1000, 750);

    }

    /**
     * gets playerName + prompt to continue
     */
    public void introScreen()
    {
        layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Backgrounds/username.png", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        final TextField name = new TextField();
        name.setPromptText("Enter your username (maximum 15 letters):");
        name.setPrefColumnCount(15); // max size of username - 15 characters
        name.setPrefSize(100, 40);
        name.setMinWidth(200);
        name.setMaxWidth(200);
        name.setMinHeight(40);
        name.setMaxHeight(40);
        name.setLayoutX(405);
        name.setLayoutY(500);

        name.setOnAction(event -> playerName = name.getText());

        MainMenuButton enterBtn = new MainMenuButton("Enter", 190, 50, 23);
        enterBtn.setLayoutX(405);
        enterBtn.setLayoutY(600);


        enterBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (name.getText().length()!=0) {
                    playerName = name.getText();
                    playerName = playerName.trim();
                    layout.getChildren().removeAll(name, enterBtn);
                    chooseLevel();
                }
                else
                    name.setText("You didn't enter an username.");
            }
        });



        layout.getChildren().addAll(name, enterBtn);
    }

    /**
     * gets user to choose level (Main.java redirects to 3 levels)
     */
    public void chooseLevel()
    {
        BackgroundImage background;
        background = new BackgroundImage(new Image("/Resources/Backgrounds/levels.PNG", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layout.setBackground(new Background(background));

        addButtons();

    }

    /**
     * adds Level buttons to choose which level to play
     */
    public void addButtons() {
        layout.getChildren().add(level1);

        layout.getChildren().add(level2);

        layout.getChildren().add(level3);
    }


    /**
     *
     * @return LevelOne button
     */
    public MainMenuButton getLevelOneButton()
    { return level1;}

    /**
     *
     * @return LevelTwo button
     */
    public MainMenuButton getLevelTwoButton()
    { return level2;}

    /**
     *
     * @return LevelThree button
     */
    public MainMenuButton getLevelThreeButton()
    { return level3;}

    /**
     *
     * @return playerName
     */
    public String getPlayerName()
    {
        return playerName;
    }
}
