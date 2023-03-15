import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pokemon.Attaque;
import pokemon.Pokemon;
import pokemon.Type;
import sauvegarde.GenerateurSauveurManager;
import utils.Triple;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Visualiseur extends Application {

    @Override
    public void start(Stage stage) throws IOException
    {
        GenerateurSauveurManager manager = new GenerateurSauveurManager();
        Triple<List<Type>,List<Attaque>,List<Pokemon>> res = manager.genere();
        System.out.println(res.getPremier());
        System.out.println(res.getSecond());
        System.out.println(res.getTroisieme());
        URL url = new File("resources/view/accueil.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
