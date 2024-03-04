package org.example;

import Entity.Player;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

public class Main {
    public static String URINAMES = "https://venson.net.br/resources/data/nomes.txt";
    public static String URIFIRSTNAMES = "https://venson.net.br/resources/data/sobrenomes.txt";
    public static String URICLUBS = "https://venson.net.br/resources/data/clubes.txt";
    public static String URIPLAYERPOSITIONS = "https://venson.net.br/resources/data/posicoes.txt";

    public static String BREAKLINE = "\n";

    public static void main(String[] args) throws Exception{
        Player player = new Player();
        System.out.println(Player.publicNewPlayerDeclaration(
                player.getName(),
                player.getFisrtName(),
                player.getClub(),
                player.getPosition(),
                player.getIdade()
            )
        );
    }

    public static String getListByUri(String uri) throws Exception  {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String[] parseList(String nameList, String parseIndex) throws Exception {
        return nameList.split(parseIndex);
    }

    public static int randomIndex(int rangeIndex, int baseIndex){
        Random rand = new Random();
        return (rand.nextInt(rangeIndex) + baseIndex);
    }

    public static String[] setCamelCase(String[] indexList){
        for(int i = 0; i < indexList.length; i++){
            String curIndex = indexList[i];
            StringBuilder index = new StringBuilder();
            for(int j = 0; j < curIndex.length(); j++){
                char indexLetter = curIndex.charAt(j);
                index.append(j == 0 || index.indexOf("-") == (j-1) || index.indexOf(" ") == (j-1) ? String.valueOf(indexLetter).toUpperCase() : String.valueOf(indexLetter).toLowerCase());
            }
            indexList[i] = index.toString();
        }
        return indexList;
    }
}