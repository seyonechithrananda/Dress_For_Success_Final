package sample;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * The Splashscreen class.
 * Creates an animation using game developers company logo which fades away over time.
 *
 * @author Seyone Chithrananda
 * @version 1
 */

public class Splashscreen {

        /**
         *
         * @return Splashscreen scene
         */
    public Scene mainWindow ()  {

            Image image = new Image("/Resources/Backgrounds/logo.png", 700, 400, false, true);

            // Setting the image view 1
            ImageView logo = new ImageView(image);

            Group root = new Group(logo);
            VBox layout = new VBox();
            layout.getChildren().add(logo);
            root.getChildren().add(logo);

            // Setting the position of the image
            logo.setX(150);
            logo.setY(175);

            // setting the fit height and width of the image view
            logo.setFitHeight(400);
            logo.setFitWidth(700);

            // transition
            FadeTransition ft = new FadeTransition(Duration.millis(4000), logo);
            ft.setFromValue(2);
            ft.setToValue(0);
            ft.setAutoReverse(true);
            ft.play();
            ft.setCycleCount(1);

            return new Scene (root, 1000, 750, Color.BLACK);

    }

}
