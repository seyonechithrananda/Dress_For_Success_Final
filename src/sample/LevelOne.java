package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.*;
import java.awt.Font;
import java.io.*;

/**
 * The LevelOne class for Dress for Success.
 * Outputs a multiple choice quiz on which clothing is worn for
 * specific weather.
 *
 * @author Seyone Chithrananda
 * @version 3
 */


@SuppressWarnings("Duplicates")
public class LevelOne {
    /**
     * Pane for the class
     */
    private AnchorPane layout;

    /**
     * used in continueButton() to switch between questions
     */
    private String currentLevel;

    /**
     * Gets playerName from Levels class, is written to file
     */
    private String playerName;

    /**
     * option A in quiz
     */
    private MainMenuButton optionA;

    /**
     * option B in quiz
     */
    private MainMenuButton optionB;

    /**
     * option C in quiz
     */
    private MainMenuButton optionC;

    /**
     * continues to next question
     */
    private MainMenuButton continueButton;

    /**
     * return to MainMenu
     */
    private MainMenuButton menu;

    /**
     * return to levelSelector
     */
    private MainMenuButton level;

    /**
     * score variable for Level 1 (out of 3)
     */
    private int levelOneScore = 0;

    /**
     * custom class for all 3 questions to compare response to answer
     */
    private QuizQuestion q1, q2, q3;

    /**
     *
     * @param name user-inputted username from Levels class
     */
    public LevelOne(String name)
    {
        this.playerName = name;
    }

    /**
     *
     * @return LevelOne scene
     */
    public Scene mainWindow()
    {
        layout = new AnchorPane();
        layout.setPadding(new Insets(10, 10, 100, 10));

        // introduces game to user
        introScreen();

        // creates MainMenu + Level2 buttons to be made visible in end screen
        menu = new MainMenuButton("Main Menu", 190, 49, 23);
        menu.setLayoutX(700);
        menu.setLayoutY(450);
        layout.getChildren().add(menu);
        menu.setVisible(false);
        level = new MainMenuButton ("Level 2", 190, 49, 23);
        level.setLayoutX(700);
        level.setLayoutY(525);
        layout.getChildren().add(level);
        level.setVisible(false);

        return new Scene (layout, 1000, 750);

    }

    /**
     * sets background + continueButton
     */
    public void introScreen() // loads level1intro.png as intro, adds Continue button
    {
        layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/level1intro.png", 1000,
                750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        currentLevel = "intro";

        addContinueButton();

    }

    /**
     * outputs questionOne() + compares response with answer to add to score
     */
    public void questionOne()
    {
        q1 = new QuizQuestion("C");

        currentLevel= "1";

        layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/summerquestion.png",
                1000, 750, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        addQuestionButtons();

        /* when user selects optionm, compares with answer for question to return either correct
           or fail message + continueButton(). */
        optionA.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(optionA, optionB, optionC);
                if (optionA.getButtonText().equals(q1.getAnswer())) {
                    levelOneScore++;
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/summeranswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });


        optionB.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(optionA, optionB, optionC);
                if (optionB.getButtonText().equals(q1.getAnswer())) {
                    levelOneScore++;
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/summeranswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });


        optionC.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(optionA, optionB, optionC);
                if (optionC.getButtonText().equals(q1.getAnswer())) {
                    levelOneScore++;
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/summeranswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });

    }

    /**
     * outputs questionTwo() + compares response with answer to add to score
     */
    public void questionTwo()
    {
        q2 = new QuizQuestion("B");
        currentLevel= "2";

        layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/rain_question.png",
                1000, 750, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        addQuestionButtons();

        /* when user selects optionm, compares with answer for question to return either correct
           or fail message + continueButton(). */
        optionA.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                if (optionA.getButtonText().equals(q2.getAnswer())) {
                    levelOneScore++;
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/rainanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });


        optionB.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(optionA, optionB, optionC);
                if (optionB.getButtonText().equals(q2.getAnswer())) {
                    levelOneScore++;
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/rainanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });


        optionC.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                if (optionC.getButtonText().equals(q2.getAnswer())) {
                    levelOneScore++;
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/rainanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });
    }

    /**
     * outputs questionTwo() + compares response with answer to add to score
     */
    public void questionThree()
    {
        q3 = new QuizQuestion("A");
        currentLevel= "3";

        System.out.println("");
        System.out.println("YOLO");

        layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/snowquestion.png",
                1000, 750, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        addQuestionButtons();

        /* when user selects option, compares with answer for question to return either correct
           or fail message + continueButton(). */
        optionA.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                if (optionA.getButtonText().equals(q3.getAnswer())) {
                    levelOneScore++;
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/snowanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });


        optionB.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().removeAll(optionA, optionB, optionC);
                if (optionB.getButtonText().equals(q3.getAnswer())) {
                    levelOneScore++;
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/snowanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });

        optionC.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("Duplicates")
            @Override
            public void handle(ActionEvent event) {
                if (optionC.getButtonText().equals(q3.getAnswer())) {
                    levelOneScore++;
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/correctanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                } else {
                    layout.getChildren().removeAll(optionA, optionB, optionC);
                    layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/snowanswer.png",
                            1000, 750, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT)));
                    addContinueButton();
                }
            }
        });



    }

    /**
     * outputs final score + pass/fail message, + makes Level2 + Main
     * Menu buttons visible.
     *
     * Writes playerName + levelOneScore to txt file
     */
    public void endScreen()
    {
        int totalQuestions = 3;
        final Font comicFont;
        String fileName = "highScoreslevel1";

        // pass
        if (levelOneScore/3 * 100 > 60) {
            layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/pass_message.png",
                    1000, 750, false, true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT)));
        }
        else { // fail
            layout.setBackground(new Background(new BackgroundImage(new Image("/Resources/Level 1/fail_message.png",
                    1000, 750, false, true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT)));

        }

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text t = new Text();
        t.setEffect(ds);
        t.setCache(true);
        t.setX(450);

        t.setY(500);
        t.setFill(Color.RED);
        t.setText(levelOneScore+"");
        t.setFont(javafx.scene.text.Font.font(null, FontWeight.BOLD, 130));
        layout.getChildren().add(t);


        level.setVisible(true);
        menu.setVisible(true);

        // writes playerName + space + score
        BufferedWriter writeScore;
        PrintWriter w;

        while (true) {
            try {
                File file = new File(System.getProperty("user.home") + "//" + "highscoreslevel1" + ".txt");
                writeScore = new BufferedWriter(new FileWriter (file.getCanonicalPath(), true));
                writeScore.write(playerName + " " + levelOneScore);
                writeScore.newLine();
                writeScore.close();
                break;
            } catch (IOException e) {
                System.out.println("f");
                e.printStackTrace();
            }
        }
        levelOneScore = 0;
    }

    /**
     * adds continueButton to answer screens for Q1-Q3
     */
    public void addContinueButton()
    {
        continueButton = new MainMenuButton("Continue", 190, 50, 23);
        continueButton.setLayoutX(400);
        continueButton.setLayoutY(600);
        layout.getChildren().add(continueButton);
        continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.getChildren().remove(continueButton);
                if (currentLevel.equals("intro")){
                    questionOne();
                }
                else if (currentLevel.equals("1"))
                    questionTwo();
                else if (currentLevel.equals("2"))
                {
                    questionThree();
                }
                else
                {
                    endScreen();
                }
            }
        });

    }

    /**
     * adds reponse buttons A, B and C for quiz
     */
    public void addQuestionButtons() // adds options for quiz (i.e: 'A', 'B', 'C')
    {
        optionA = new MainMenuButton("A", 190, 49, 23);
        optionA.setLayoutX(200);
        optionA.setLayoutY(600);
        layout.getChildren().add(optionA);

        optionB = new MainMenuButton("B", 190, 49, 23);
        optionB.setLayoutX(400);
        optionB.setLayoutY(600);
        layout.getChildren().add(optionB);

        optionC = new MainMenuButton("C", 190, 49, 23);
        optionC.setLayoutX(600);
        optionC.setLayoutY(600);
        layout.getChildren().add(optionC);

    }


    /**
     *
     * @return main menu button
     */
    public MainMenuButton getMainMenuButton ()
    {
        return menu;
    }

    /**
     *
     * @return button which goes to LevelTwo class
     */

    public MainMenuButton getLevelTwo ()
    {
        return level;
    }



}
