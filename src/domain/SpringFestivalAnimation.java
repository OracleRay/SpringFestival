package domain;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.util.Duration;
import javafx.scene.shape.Path;

public class SpringFestivalAnimation extends VBox {
    private Path path;
    private ImageView view;

    public SpringFestivalAnimation() {
        setPadding(new Insets(30));
    }

    public void rotate(double time, double speed) {
        view = new ImageView("/image/Fu.png");
        view.setFitHeight(100);
        view.setFitWidth(100);
        getChildren().addAll(view);

        // 旋转
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(1000 * time), view);
        rotateTransition.setByAngle(360 * ((360 + 45) / 360.0 + speed));
        rotateTransition.setCycleCount(1);

        // 放大
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(6000), view);
        scaleTransition.setToX(20f);
        scaleTransition.setToY(20f);
        scaleTransition.setCycleCount(1);

        ParallelTransition parallelTransition = new ParallelTransition();

        if (time == 9) {
            parallelTransition.getChildren().addAll(
                    scaleTransition,
                    rotateTransition
            );
        } else {
            parallelTransition.getChildren().addAll(
                    rotateTransition
            );
        }

        parallelTransition.play();
    }

    public void move_slow() {
        view = new ImageView("/image/lantern.png");
        view.setFitHeight(200);
        view.setFitWidth(200);

        // 先把之前的结点删除再添加新结点
        getChildren().clear();
        getChildren().addAll(view);

        // 创建路径
        path = new Path();
        path.getElements().add(new MoveTo(0, 100));
        path.getElements().add(new CubicCurveTo(100, 50, 200, 100, 200, 100));
        path.getElements().add(new CubicCurveTo(200, 100, 300, 50, 400, 100));
        path.getElements().add(new CubicCurveTo(400, 100, 500, 50, 600, 100));
        path.getElements().add(new CubicCurveTo(600, 100, 700, 50, 800, 100));
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(1500));
        pt.setPath(path);
        pt.setNode(view);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(1);
        pt.setAutoReverse(false);
        pt.play();

    }

    public void move_fast() {
        view = new ImageView("/image/lantern.png");
        view.setFitHeight(200);
        view.setFitWidth(200);

        // 先把之前的结点删除再添加新结点
        getChildren().clear();
        getChildren().addAll(view);

        path = new Path();
        path.getElements().add(new MoveTo(1000, 300));
        path.getElements().add(new LineTo(800, 0));
        path.getElements().add(new LineTo(600, 300));
        path.getElements().add(new LineTo(400, 0));
        path.getElements().add(new LineTo(200, 300));
        path.getElements().add(new LineTo(0, 0));
        path.getElements().add(new LineTo(-200, 300));
        path.getElements().add(new LineTo(-400, 0));
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(2000));
        pt.setPath(path);
        pt.setNode(view);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(1);
        pt.setAutoReverse(false);
        pt.play();
    }

    public void move_nomal() {

        view = new ImageView("/image/lantern.png");
        view.setFitHeight(200);
        view.setFitWidth(200);

        // 先把之前的结点删除再添加新结点
        getChildren().clear();
        getChildren().addAll(view);

        // 移动
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(700), view);
        translateTransition.setFromX(0);
        translateTransition.setToX(1000);
        translateTransition.setCycleCount(4);
        translateTransition.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                translateTransition
        );
        parallelTransition.play();

    }

    public void duiLian(ImageView view) {
        // 根据图片的实际高度设置图片的大小
        if (view.getImage().getHeight() < 500) {
            view.setFitHeight(70);
            view.setFitWidth(200);
        } else {
            view.setFitHeight(350);
            view.setFitWidth(70);
        }

        // 先把之前的结点删除再添加新结点
        getChildren().clear();
        getChildren().addAll(view);

        // 淡入
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), view);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.3f);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);

        // 放大
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1000), view);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                scaleTransition
        );
        parallelTransition.play();
    }

}
