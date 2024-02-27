package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

public class Main {
    public static String uriNames = "https://venson.net.br/resources/data/nomes.txt";
    public static String uriFirstName = "https://venson.net.br/resources/data/sobrenomes.txt";

    public static void main(String[] args) throws Exception{
        String[] nameList = parseUriList(getUriList(uriNames));
        String[] firstNameList = parseUriList(getUriList(uriFirstName));
        printRandomicName(nameList, firstNameList);
    }

    public static String getUriList(String uri) throws Exception  {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String[] parseUriList(String nameList) throws Exception {
        return nameList.split("\n");
    }

    public static void printRandomicName(String[] nameList, String[] firstNameList) throws Exception{
        Random rand = new Random();
        System.out.println("Nome aleatório: " + nameList[rand.nextInt(nameList.length)] + " " + firstNameList[rand.nextInt(firstNameList.length)]);
    }
}