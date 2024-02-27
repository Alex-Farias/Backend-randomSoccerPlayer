package Entity;

import org.example.Main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.util.Collections.replaceAll;

public class Player {
    private final String name;
    private final String fisrtName;
    private final String club;
    private final String position;
    private final int idade;

    public static String publicNewPlayerDeclaration(String playerName, String playerFirstName, String playerClub, String playerPosition, String playerIdade){
        String declaration;
        declaration = "Nova estrela do futebol " + playerName + " " + playerFirstName + " de " +
                playerIdade + " anos de idade está começando sua carreira no " +
                playerClub + " como " + playerPosition + "!";
        return declaration;
    }

    public Player() throws Exception{
        String[] name = Main.setCamelCase(Main.parseList(
                Main.getListByUri(Main.URINAMES),
                Main.BREAKLINE
        ));
        String[] fisrtName = Main.setCamelCase(Main.parseList(
                Main.getListByUri(Main.URIFIRSTNAMES),
                Main.BREAKLINE
        ));
        String[] club = Main.parseList(
                Main.getListByUri(Main.URICLUBS),
                Main.BREAKLINE
        );
        String[] position = Main.setCamelCase(Main.parseList(
                Main.getListByUri(Main.URIPLAYERPOSITIONS).replaceAll("\"", ""),
                ",\n"
        ));
        int idade = Main.randomIndex(23, 17);

        this.name = name[Main.randomIndex(name.length, 0)];
        this.fisrtName = fisrtName[Main.randomIndex(fisrtName.length, 0)];
        this.club = club[Main.randomIndex(club.length, 0)];
        this.position = position[Main.randomIndex(position.length, 0)];
        this.idade = idade;
    }

    public Player(String name, String fisrtName, String club, String position, int idade){
        this.name = name;
        this.fisrtName = fisrtName;
        this.club = club;
        this.position = position;
        this.idade = idade;
    }

    public String getName(){
        return this.name;
    }

    public String getFisrtName(){
        return this.fisrtName;
    }

    public String getClub(){
        return this.club;
    }

    public String getPosition(){
        return this.position;
    }

    public String getIdade(){
        return String.valueOf(this.idade);
    }
}
