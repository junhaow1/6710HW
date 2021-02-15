package comp1110.homework.X01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * A JavaFX application which draws a recursive tree.
 *
 * Some JavaFX classes that may be useful:
 * - javafx.geometry.Point2D: used to store a 2D coordinate
 * - javafx.scene.shape.Line: creates a line segment for display,
 * key attributes are startX/Y and endX/Y (each with getters and setters
 * e.g. getStartX(), setStartX())
 * - javafx.scene.transform.Rotate: used to create a rotation transformation
 * which can be applied to objects or points
 */
public class RecursiveTree extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create the root stack pane
        primaryStage.setTitle("Recursive Tree");
        StackPane root = new StackPane();

        // Set scene of stage with size 150x150 and show the stage
        primaryStage.setScene(new Scene(root, 150, 150));
        primaryStage.show();
    }

    // Leave the main method as is, required to launch JavaFX
    public static void main(String[] args) {
        launch(args);
    }
}
