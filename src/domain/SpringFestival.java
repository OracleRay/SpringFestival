package domain;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SpringFestival extends Application {

    private static String url = SpringFestival.class.getResource("/music/chunJieXuQu.mp3").toString();
    private double second = 1000;
    private double time = 0.001;

    public static void main(String[] args) {
        //≤•∑≈“Ù¿÷
        MediaPlayer player = new MediaPlayer(new Media(url));
        player.play();

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane pane = new BorderPane();

        // …Ë÷√±≥æ∞Õº∆¨
        ImagePattern imagePattern = new ImagePattern(new Image("/image/background.jpg"), 0, 0, 1, 1, true);
        pane.setBackground(new Background(new BackgroundFill(imagePattern, CornerRadii.EMPTY, Insets.EMPTY)));

        SpringFestivalAnimation animation_top = new SpringFestivalAnimation();
        animation_top.setAlignment(Pos.CENTER);

        SpringFestivalAnimation animation_left = new SpringFestivalAnimation();
        animation_left.setAlignment(Pos.CENTER_LEFT);

        SpringFestivalAnimation animation_center = new SpringFestivalAnimation();
        animation_center.setAlignment(Pos.CENTER);

        SpringFestivalAnimation animation_right = new SpringFestivalAnimation();
        animation_right.setAlignment(Pos.CENTER_RIGHT);

        // ¥¥Ω® ±º‰÷·
        Timeline timeline = new Timeline();
        timeline.setAutoReverse(true);

        // ≤Â»Îπÿº¸÷°∂Øª≠
        KeyFrame rotate_left = new KeyFrame(Duration.millis(time * second), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                animation_left.rotate(1, 0);

            }
        });

        time += 1;

        KeyFrame rotate_center = new KeyFrame(Duration.millis(time * second), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                animation_center.rotate(1, 0);

            }
        });

        time += 1;

        KeyFrame rotate_right = new KeyFrame(Duration.millis(time * second), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                animation_right.rotate(9, 5);

            }
        });

        time += 9;

        KeyFrame move_slow = new KeyFrame(Duration.millis(time * second), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                // …Ë÷√–¬±≥æ∞Õº∆¨
                ImagePattern imagePattern = new ImagePattern(new Image("/image/snow.png"), 0, 0, 1, 1, true);
                pane.setBackground(new Background(new BackgroundFill(imagePattern, CornerRadii.EMPTY, Insets.EMPTY)));
                animation_left.move_slow();
                animation_center.move_slow();
                animation_right.move_slow();
            }
        });

        time += 2;

        KeyFrame move_fast = new KeyFrame(Duration.millis(time * second), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                animation_left.move_fast();
                animation_center.move_fast();
                animation_right.move_fast();

            }
        });

        time += 2;

        KeyFrame move_slow_again = new KeyFrame(Duration.millis(time * second), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                animation_left.move_slow();
                animation_center.move_slow();
                animation_right.move_slow();

            }
        });

        time += 1.5;

        KeyFrame move_fast_again = new KeyFrame(Duration.millis(time * second), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                animation_left.move_fast();
                animation_center.move_fast();
                animation_right.move_fast();
            }
        });

        time += 2;

        KeyFrame move_nomal = new KeyFrame(Duration.millis(time * second), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                animation_left.move_nomal();
                animation_center.move_nomal();
                animation_right.move_nomal();
            }
        });

        time += 3.2;

        KeyFrame duiLian_left = new KeyFrame(Duration.millis(time * second), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                animation_left.duiLian(new ImageView("/image/duilian_left.jpg"));

            }
        });

        time += 1;

        KeyFrame duiLian_head = new KeyFrame(Duration.millis(time * second), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                animation_top.duiLian(new ImageView("/image/duilian_head.jpg"));

            }
        });

        time += 1;

        KeyFrame duiLian_right = new KeyFrame(Duration.millis(time * second), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                animation_right.duiLian(new ImageView("/image/duilian_right.jpg"));

            }
        });

        time += 1;

        timeline.getKeyFrames().addAll(
                rotate_left,
                rotate_center,
                rotate_right,
                move_slow,
                move_fast,
                move_slow_again,
                move_fast_again,
                move_nomal,
                duiLian_left,
                duiLian_head,
                duiLian_right
        );
        timeline.play();

        pane.setTop(animation_top);
        pane.setLeft(animation_left);
        pane.setCenter(animation_center);
        pane.setRight(animation_right);

        Scene scene = new Scene(pane, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Happy New Year To You!");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/image/Fu.png")));
        primaryStage.show();
    }

}




