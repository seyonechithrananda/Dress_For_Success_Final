package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * The Instructions class for Dress for Success
 *
 * @author Seyone Chithrananda
 * @version 2
 */


public class Instructions {

    /**
     * The pane for instructions (layout is used by entire game)
     */
    private AnchorPane layout;

    /**
     * background for "sun"
     */
    private BackgroundImage backgroundSun;

    /**
     * background for "snow"
     */
    private BackgroundImage backgroundSnow;

    /**
     * background for "rain"
     */
    private BackgroundImage backgroundRain;

    /**
     * Array of Backgrounds
     */
    private BackgroundImage[] learnBackground;

    /**
     * used to switch between backgrounds using if-else statements
     */
    private int currentBackground;

    /**
     * button which returns to MainMenu
     */
    private MainMenuButton home;

    /**
     *
     * @return scene with Instructions
     */

    public Scene mainWindow() {

        currentBackground = 0;

        // initialize layout
        layout = new AnchorPane();
        layout.setPadding(new Insets(10, 10, 100, 10));

        // loads backgrounds with images.
        loadBackgrounds();

        // sets background to "sun" BackgroundImage
        layout.setBackground(new Background(learnBackground[currentBackground]));
        addButtons();

        // returns 1000 x 750 scene
        return new Scene(layout, 1000, 750);

    }

    /**
     * loads 3 backgrounds for snow, sun and rain
     */
    public void loadBackgrounds() {

        learnBackground = new BackgroundImage[3];
        Image sun = new Image ("/Resources/Learn/1.png");
        Image snow = new Image ("/Resources/Learn/3.png");
        Image rain = new Image("/Resources/Learn/2.png");

        backgroundSun = new BackgroundImage(new Image("/Resources/Learn/1.png", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        backgroundSnow = new BackgroundImage(new Image("/Resources/Learn/3.png", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        backgroundRain = new BackgroundImage(new Image("/Resources/Learn/2.png", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        learnBackground[0] = backgroundSun;
        learnBackground[1] = backgroundSnow;
        learnBackground[2] = backgroundRain;
    }

    /**
     * adds buttons to traverse between 3 BackgroundImages
     */
    public void addButtons() {
        MainMenuButton next = new MainMenuButton("Next", 190, 49, 23);
        next.setLayoutX(750);
        next.setLayoutY(700);
        layout.getChildren().add(next);

        MainMenuButton back = new MainMenuButton("Back", 190, 49, 23);
        back.setLayoutX(60);
        back.setLayoutY(700);
        layout.getChildren().add(back);

        home = new MainMenuButton("Main Menu", 190, 49, 23);
        home.setLayoutX(405);
        home.setLayoutY(700);
        layout.getChildren().add(home);
       // home.setOnAction(event -> displayMainMenu());

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (currentBackground != learnBackground.length - 1) {
                    currentBackground++;
                } else {
                    currentBackground = 0;
                }
                layout.setBackground(new Background(learnBackground[currentBackground]));
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (currentBackground!=0) {
                    currentBackground--;
                }
                else
                {
                    currentBackground= learnBackground.length - 1;
                }
                layout.setBackground(new Background(learnBackground[currentBackground]));
            }
        });
    }

    /**
     *
     * @return MainMenuButton which returns to the main menu
     */
    public MainMenuButton getMainMenuButton (){
        return home;
    }

}
