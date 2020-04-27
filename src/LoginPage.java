
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author MohammedHams
 */
public class LoginPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Add Student");

        btn.setOnAction((ActionEvent event) -> {
            StackPane root = new StackPane();
            
            Label label1 = new Label("Login Name");
            label1.setTranslateY(-80);
            TextField loginNameText = new TextField();
            loginNameText.setTranslateY(-50);
            
            Label lable2 = new Label("Password");
            lable2.setTranslateY(-10);
            TextField PasswordNameText = new TextField();
            PasswordNameText.setTranslateY(20);
            
            Button login = new Button("OK");
            login.setOnAction((ActionEvent event1) -> {
                File f = new File("‪‪D:\\1.txt");
                
                try {
                    FileWriter fw = new FileWriter(f);
                    PrintWriter pw = new PrintWriter(fw);
                    
                    MessageDigest md = MessageDigest.getInstance("md5");
                    byte[] messageDigest = md.digest(PasswordNameText.getText().getBytes());
                    BigInteger number = new BigInteger(1, messageDigest);
                    String hashtext = number.toString(16);
                    pw.print(loginNameText.getText() + " " + hashtext);
                    
                    pw.flush();
                    pw.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            Button exit = new Button("Exit");
            
            exit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.exit(0);
                }
            });
            login.setTranslateY(60);
            login.setTranslateX(-50);
            exit.setTranslateY(60);
            root.getChildren().addAll(label1, loginNameText, lable2, PasswordNameText, login, exit);
            Stage newStage = new Stage();
            Scene scene = new Scene(root, 300, 200);
            newStage.setTitle("Login Page");
            newStage.setScene(scene);
            newStage.show();
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

 
    public static void main(String[] args) {
        launch(args);
    }

}
