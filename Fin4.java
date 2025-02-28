import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/* 機位:
   學號:411631327
   姓名:邱振營
   
*/

public class Fin4 extends Application {
    private TextField textField_length;
    private TextField textField_weight;
    private Label result;
    
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(20);
        HBox one = new HBox(20);
        
        Label label_1 = new Label("請輸入身高");
        textField_length = new TextField();
        one.getChildren().addAll(label_1, textField_length);
        
        HBox two = new HBox(20);
        Label label_2 = new Label("請輸入體重");
        textField_weight = new TextField();
        two.getChildren().addAll(label_2, textField_weight);
        
        HBox three = new HBox(20);
        Button boy = new Button("男");
        Button girl = new Button("女");
        Button clear = new Button("清空");
        three.getChildren().addAll(boy, girl, clear);
        
        HBox four = new HBox(10);
        result = new Label("結果:");
        four.getChildren().addAll(result);
        
        // 使用有名稱內部類別處理男生按鈕事件
        boy.setOnAction(new BoyButtonHandler());
        
        // 使用匿名內部類別處理女生按鈕事件
        girl.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                double length = Integer.parseInt(textField_length.getText()) * 0.01;
                double weight = Integer.parseInt(textField_weight.getText());
                double bmi = weight / (length * length);
                String condiction = "";
                
                if(bmi <= 18.3){
                    condiction = "過輕";
                } else if (18.3 < bmi && bmi <= 24.0) {
                    condiction = "正常";
                } else {
                    condiction = "肥胖";
                }
                result.setText(String.format("%s,%s,%.2f", "女", condiction, bmi)); 
            }
        });
        
        // 使用 Lambda Expression 處理清空按鈕事件
        clear.setOnAction((t) -> {
            textField_length.clear();
            textField_weight.clear();
            result.setText("結果:");
        });
        
        root.getChildren().addAll(one, two, three, four);
        
        Scene scene = new Scene(root, 300, 150);
        primaryStage.setTitle("411630907 Fin4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // 有名稱內部類別 - 處理男生按鈕事件
    private class BoyButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent t) {
            double length = Integer.parseInt(textField_length.getText()) * 0.01;
            double weight = Integer.parseInt(textField_weight.getText());
            double bmi = weight / (length * length);
            String condiction = "";
            
            if(bmi <= 19.2){
                condiction = "過輕";
            } else if (19.2 < bmi && bmi <= 25.6) {
                condiction = "正常";
            } else {
                condiction = "肥胖";
            }
            result.setText(String.format("%s,%s,%.2f", "男", condiction, bmi));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}