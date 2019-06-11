package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.scene.text.Text;
import java.io.*;

/**
 * The LevelTwo class for Dress for Success
 *
 * @author Uroosa Imtiaz
 * @version 1
 */


@SuppressWarnings("Duplicates")
public class LevelTwo{
    /**
     * Pane for game
     */
    private AnchorPane layout;

    /**
     * buttons for main menu, levelSelector + next clothing type
     */
    private MainMenuButton menu, level, next;

    /**
     * buttons for viewing different variations of the same clothing item
     */
    ArrowButton left, right;

    /**
     * used a score keeper
     */
    private int levelTwoScore = 0;

    /**
     * used to determine levelTwoScore
     */
    private int count = 0;

    /**
     * used when going through user selections to determine score
     */
    private int done = 0;

    /**
     * choice for setting to dress for
     */
    private String choice="";

    /**
     * Gets playerName from Levels class
     */
    private String playerName;

    /**
     *
     * @param name String obtained from Levels class
     */
    public LevelTwo(String name)
    {
        this.playerName = name;
    }

    /**
     *
     * @return LevelThree scene
     */
    public Scene mainWindow()
    {
        layout = new AnchorPane();
        layout.setPadding(new Insets(10, 10, 100, 10));
        layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 2/choose-one-level2.PNG", 1000,
                751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        selectButtons();
        menu = new MainMenuButton("Main Menu", 190, 49, 23);
        menu.setLayoutX(700);
        menu.setLayoutY(450);
        layout.getChildren().add(menu);
        menu.setVisible(false);
        level = new MainMenuButton ("Level Three", 190, 49, 23);
        level.setLayoutX(700);
        level.setLayoutY(525);
        layout.getChildren().add(level);
        level.setVisible(false);
        return new Scene (layout, 1000, 750);
    }

    /**
     * select between scenarios
     */
    public void selectButtons() // loads level1intro.png as intro, adds Continue button
    {
        LevelButtons rain= new LevelButtons("rain");
        rain.setLayoutX(138);
        rain.setLayoutY(220);
        layout.getChildren().add(rain);

        LevelButtons snow= new LevelButtons("snow");
        snow.setLayoutX(543);
        snow.setLayoutY(222);
        layout.getChildren().add(snow);

        LevelButtons sun= new LevelButtons("sun");
        sun.setLayoutX(340);
        sun.setLayoutY(480);
        layout.getChildren().add(sun);

        rain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(rain, snow, sun);
                choice = "rain";
                display();
            }
        });

        snow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(rain, snow, sun);
                choice="snow";
                display();
            }
        });

        sun.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(rain, snow, sun);
                choice="sun";
                display();
            }
        });
    }

    /**
     *  order: rain, snow, sun for loading backgrounds
     */
    public void back(int backg) {
        String background[] = {"/Resources/Level 2/choose-rain-hat.PNG", "/Resources/Level 2/choose-snow-hat.PNG", "/Resources/Level 2/choose-sun-hat.PNG",
                "/Resources/Level 2/fchoose-rain-top.PNG", "/Resources/Level 2/fchoose-snow-top.PNG", "/Resources/Level 2/fchoose-sun-top.PNG",
                "/Resources/Level 2/dchoose-rain-pants.PNG", "/Resources/Level 2/dchoose-snow-pants.PNG", "/Resources/Level 2/dchoose-sun-pants.PNG",
                "/Resources/Level 2/echoose-rain-boots.PNG", "/Resources/Level 2/echoose-snow-shoes.PNG", "/Resources/Level 2/echoose-sun-shoes.PNG"};
        layout.setBackground(new Background(new BackgroundImage(new Image(background[backg], 1002,
                751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
    }

    /**
     * determines which item of clothing to display
     */
    public void display()
    {
        back(0);
        arrowButtons();
        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                count--;
                if (done==0) {
                    if (count == -1)
                        count = 2;
                    else if (count > 2)
                        count = 0;
                }
                else if (done ==1) {
                    if (count < 3)
                        count = 5;
                    else if (count > 5)
                        count = 3;
                }
                else if (done==2){
                    if (count<6)
                        count = 8;
                    else if (count>8)
                        count =6;
                }
                else if (done==3)
                {
                    if (count<9)
                        count=11;
                    else if (count>11)
                        count = 9;
                }
                back(count);
            }
        });

        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                count++;
                if (done==0) {
                    if (count == -1)
                        count = 2;
                    else if (count > 2)
                        count = 0;
                }
                else if (done ==1) {
                    if (count < 3)
                        count = 5;
                    else if (count > 5)
                        count = 3;
                }
                else if (done==2){
                    if (count<6)
                        count = 8;
                    else if (count>8)
                        count =6;
                }
                else if (done==3)
                {
                    if (count<9)
                        count=11;
                    else if (count>11)
                        count = 9;
                }
                back(count);
            }
        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scoreCalculate();
                done++;
                if (done == 1)
                {
                    count =3;
                    back(count);
                }
                else if (done == 2) {
                count =6;
                back(count);
                }
                else if (done ==3)
                {
                    count = 9;
                    back(count);
                }
                else if (done==4)
                {
                    layout.getChildren().removeAll(next,left,right);
                    endScreen();
                }
            }
        });
    }

    /**
     * initializes left, right and next buttons
     */
    public void arrowButtons()
    {
        left= new ArrowButton("left");
        left.setLayoutX(50);
        left.setLayoutY(390);
        layout.getChildren().add(left);

        right= new ArrowButton("right");
        right.setLayoutX(755);
        right.setLayoutY(390);
        layout.getChildren().add(right);

        next = new MainMenuButton("Next", 190, 50, 23);
        next.setLayoutX(778);
        next.setLayoutY(638);
        layout.getChildren().add(next);
    }

    /**
     * calculates score based on choices of setting and clothing
     */
    public void scoreCalculate()
    {
        if (choice.equals("rain"))
        {
            if (done==0 && count==0)
                levelTwoScore++;
            else if (done==1 && count==3)
                levelTwoScore++;
            else if (done==2 && count==6)
                levelTwoScore++;
            else if (done==3 && count==9)
                levelTwoScore++;
        }
        else if (choice.equals("snow"))
        {
            if (done==0 && count==1)
                levelTwoScore++;
            else if (done==1 && count==4)
                levelTwoScore++;
            else if (done==2 && count==7)
                levelTwoScore++;
            else if (done==3 && count==10)
                levelTwoScore++;
        }
        else if (choice.equals("sun"))
        {
            if (done==0 && count==2)
                levelTwoScore++;
            else if (done==1 && count==5)
                levelTwoScore++;
            else if (done==2 && count==8)
                levelTwoScore++;
            else if (done==3 && count==11)
                levelTwoScore++;
        }
    }

    /**
     * displays correct outfit which would score 100 in game
     */
    public void endScreen() {
        if (choice.equals("rain")) {
            layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 2/score-rain.PNG", 1002,
                    751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        } else if (choice.equals("snow")) {
            layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 2/score-snow.PNG", 1002,
                    751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        } else if (choice.equals("sun")) {
            layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 2/score-sun.PNG", 1002,
                    751, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        }

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text t = new Text();
        t.setEffect(ds);
        t.setCache(true);
        t.setX(550.0f);
        if (choice.equals("snow") || choice.equals("sun")) {
            t.setY(706.0f);
        } else
            t.setY(725.0f);
        t.setFill(Color.RED);
        t.setText(levelTwoScore * 25 + "");
        t.setFont(Font.font(null, FontWeight.BOLD, 130));
        layout.getChildren().add(t);
        level.setVisible(true);
        menu.setVisible(true);

        BufferedWriter writeScore;
        PrintWriter w;
        // writes playerName + score to txt file
        while (true) {
            try {
                File file = new File(System.getProperty("user.home") + "//" + "highscoreslevel2" + ".txt");
                writeScore = new BufferedWriter(new FileWriter (file.getCanonicalPath(), true));
                writeScore.write(playerName + " " + levelTwoScore);
                writeScore.newLine();
                writeScore.close();
                break;
            } catch (IOException e) {
                System.out.println("f");
                e.printStackTrace();
            }
        }

        levelTwoScore = 0;
        done = 0;
        count = 0;

    }

    /**
     *
     * @return button to go back to main menu
     */
    public MainMenuButton getMainMenuButton()
    {
        return menu;
    }

    /**
     *
     * @return button to go back to LevelSelector
     */
    public MainMenuButton getLevelThree()
    {
        return level;
    }
}