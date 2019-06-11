package sample;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.*;
import javafx.scene.text.Font;

/**
 * The MainMenuButton class.
 *
 * @author Seyone Chithrananda
 * @version 2
 */

public class MainMenuButton extends Button {

    /**
     * CSS Style for when button is pressed
     */
    private final String BTN_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Resources/Backgrounds/pressedbutton.png');";

    /**
     * CSS Style for when button is not pressed
     */
    private final String BTN_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Resources/Backgrounds/button.png');";

    /**
     * height of button
     */
    private int height;


    /**
     * sets text for Button
     */
    private String buttonText;

    /**
     *
     * @param text sets Text for Button
     * @param w width of button
     * @param h height of button
     * @param f font size for button label
     */
    public MainMenuButton(String text, int w, int h, int f) {
        height = h;
        buttonText = text;
        setText(buttonText);
        setFont(Font.font("verdana", f));
        setMinWidth(w);
        setMinHeight(h);
        setMaxWidth(w);
        setMaxHeight(h);
        setStyle(BTN_FREE_STYLE);
        listeners();
    }

    /**
     * sets Button as pressed
     */
    private void setPressedStyle() {
        setStyle(BTN_PRESSED_STYLE);
        setPrefHeight(height - 4);
        setLayoutY(getLayoutY() + 4);
    }

    /**
     *
     * @return text on button
     */
    public String getButtonText()
    {
        return buttonText;
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

