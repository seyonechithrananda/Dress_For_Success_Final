package sample;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.*;

/**
 * The ArrowButton class.
 *
 * @author Uroosa Imtiaz and Seyone Chithrananda
 * @version 1.11
 * <p>
 * 1.1 Uroosa Imtiaz
 * <br> Date: 2019/06/08
 * <br> Time Spent: 1 hr
 * <br> Created class (based on MainMenuButton) + added listeners, setPressedStyle() and setFreeStyle()
 * </p>
 *
 * <p>
 * <br> 1.2 - Seyone Chithrananda
 * <br> Date: 2019/06/09
 * <br> Commenting
 * </p>
 */


public class ArrowButton extends Button {

    /**
     * CSS Style for when button is pressed
     */
    private String BTN_PRESSED_STYLE;
    /**
     * CSS Style for when button is not pressed
     */

    private String BTN_FREE_STYLE;

    /**
     * height of button
     */
    private int height;

    /**
     *
     *
     * @param s  decides whether arrow should be left or right
     */

    public ArrowButton(String s) {
        int h = 150;
        int w = 200;
        height = h;
        setMinWidth(w);
        setMinHeight(h);
        setMaxWidth(w);
        setMaxHeight(h);
        if(s.equals("left"))
        {
            BTN_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Backgrounds/pressed-left-arrow.png');";
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Resources/Backgrounds/unpressed-left-button.png');";
        }
        else if(s.equals("right"))
        {
            BTN_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Resources/Backgrounds/pressed-right-arrow.png');";
            BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Resources/Backgrounds/unpressed-right-arrow.png');";
        }
        setStyle(BTN_FREE_STYLE);
        listeners();
    }

    /**
     * sets button as pressed
     */

    private void setPressedStyle() {
        setStyle(BTN_PRESSED_STYLE);
        setPrefHeight(height - 4);
        setLayoutY(getLayoutY() + 4);
    }

    /**
     * Sets the style of the free button.
     */
    private void setFreeStyle() {
        setStyle(BTN_FREE_STYLE);
        setPrefHeight(height);
        setLayoutY(getLayoutY() - 4);
    }

    /**
     * Adds the listener objects to the button.
     */
    private void listeners() {
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY))
                    setPressedStyle();
            }
        });

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY))
                    setFreeStyle();
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(new DropShadow());
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(null);
            }
        });
    }
}

