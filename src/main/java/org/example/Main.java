package org.example;

import Entity.Player;

public class Main {

    public static void main(String[] args) throws Exception{
        Player player = new Player();
        System.out.println(Player.publicNewPlayerDeclaration(
                player.getName(),
                player.getFisrtName(),
                player.getClub(),
                player.getPosition(),
                player.getAgeAsString()
            )
        );
    }
}