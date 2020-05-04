
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Majd Talji <en.majd.talji@gmail.com>
 */
public class Main extends Application {

    ScrollBar redScroller;
    ScrollBar greenScroller;
    ScrollBar blueScroller;
    Label redLabel;
    Label greenLabel;
    Label blueLabel;
    Rectangle selectedColorShape;
    Label selectedColorLabel;
    Color color = Color.rgb(127, 127, 127, 1);

    public String getColorValue() {
        return "Color: " + (int) redScroller.getValue() + ", " + (int) greenScroller.getValue() + ", " + (int) blueScroller.getValue();
    }

    @Override
    public void start(Stage stage) throws Exception {
        redLabel = new Label("Red");
        greenLabel = new Label("Green");
        blueLabel = new Label("Blue");
        redScroller = new ScrollBar();
        greenScroller = new ScrollBar();
        blueScroller = new ScrollBar();
        selectedColorShape = new Rectangle();
        selectedColorLabel = new Label();

        redScroller.setBlockIncrement(1);
        redScroller.setMin(0);
        redScroller.setMax(255);
        redScroller.setValue(127);
        redScroller.setOrientation(Orientation.HORIZONTAL);

        greenScroller.setBlockIncrement(1);
        greenScroller.setMin(0);
        greenScroller.setMax(255);
        greenScroller.setValue(127);
        greenScroller.setOrientation(Orientation.HORIZONTAL);

        blueScroller.setBlockIncrement(1);
        blueScroller.setMin(0);
        blueScroller.setMax(255);
        blueScroller.setValue(127);
        blueScroller.setOrientation(Orientation.HORIZONTAL);

        selectedColorLabel.setText(getColorValue());
        selectedColorShape.setFill(color);

        redLabel.setPrefSize(60, 25);
        greenLabel.setPrefSize(60, 25);
        blueLabel.setPrefSize(60, 25);
        redScroller.setPrefSize(200, 25);
        greenScroller.setPrefSize(200, 25);
        blueScroller.setPrefSize(200, 25);
        selectedColorShape.setWidth(145);
        selectedColorShape.setHeight(80);
        selectedColorLabel.setPrefSize(145, 25);

        redLabel.setTranslateX(40);
        redLabel.setTranslateY(40);
        greenLabel.setTranslateX(40);
        greenLabel.setTranslateY(80);
        blueLabel.setTranslateX(40);
        blueLabel.setTranslateY(120);
        redScroller.setTranslateX(120);
        redScroller.setTranslateY(40);
        greenScroller.setTranslateX(120);
        greenScroller.setTranslateY(80);
        blueScroller.setTranslateX(120);
        blueScroller.setTranslateY(120);
        selectedColorShape.setTranslateX(350);
        selectedColorShape.setTranslateY(40);
        selectedColorLabel.setTranslateX(350);
        selectedColorLabel.setTranslateY(125);

        redLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px");
        redLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px");
        greenLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px");
        blueLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px");
        selectedColorLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: gray");
        redScroller.setStyle("-fx-background-color: red");
        greenScroller.setStyle("-fx-background-color: green");
        blueScroller.setStyle("-fx-background-color: blue");        

        ChangeListener myListener = new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                int red = (int) redScroller.getValue();
                int green = (int) greenScroller.getValue();
                int blue = (int) blueScroller.getValue();

                color = Color.rgb(red, green, blue, 1);
                selectedColorShape.setFill(color);
                selectedColorLabel.setText(getColorValue());

            }
        };

        redScroller.valueProperty().addListener(myListener);
        greenScroller.valueProperty().addListener(myListener);
        blueScroller.valueProperty().addListener(myListener);

        Group root = new Group();

        root.getChildren().add(redLabel);
        root.getChildren().add(greenLabel);
        root.getChildren().add(blueLabel);
        root.getChildren().add(redScroller);
        root.getChildren().add(greenScroller);
        root.getChildren().add(blueScroller);
        root.getChildren().add(selectedColorShape);
        root.getChildren().add(selectedColorLabel);

        Scene scene = new Scene(root, 540, 180);
        stage.setTitle("Color Picker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
