package Entity;

import Function.Util;

public class Player {
    private static final int BASEAGE = 17;
    private static final int RANGEAGE = 23;
    private final String name;
    private final String fisrtName;
    private final String club;
    private final String position;
    private final int age;

    public static String publicNewPlayerDeclaration(String playerName, String playerFirstName, String playerClub, String playerPosition, String playerAge){
        String declaration;
        declaration = "Nova estrela do futebol! " + playerName + " " + playerFirstName + " de " +
                playerAge + " anos de idade está começando sua carreira no " +
                playerClub + " como " + playerPosition + "!";
        return declaration;
    }

    public Player() throws Exception{
        String[] name = Util.setCamelCase(Util.parseList(
                Util.getListByUri(Util.URINAMES),
                Util.BREAKLINE
        ));
        String[] fisrtName = Util.setCamelCase(Util.parseList(
                Util.getListByUri(Util.URIFIRSTNAMES),
                Util.BREAKLINE
        ));
        String[] club = Util.parseList(
                Util.getListByUri(Util.URICLUBS),
                Util.BREAKLINE
        );
        String[] position = Util.setCamelCase(Util.parseList(
                Util.getListByUri(Util.URIPLAYERPOSITIONS).replaceAll(Util.DOUBLEQUOTES, Util.EMPTYSTRING),
                Util.COMMA + Util.BREAKLINE
        ));

        this.name = Util.randomStringByArray(name);
        this.fisrtName = Util.randomStringByArray(fisrtName);
        this.club = Util.randomStringByArray(club);
        this.position = Util.randomStringByArray(position);
        this.age = Util.randomIndexWithBase(RANGEAGE, BASEAGE);
    }

    public Player(String name, String fisrtName, String club, String position, int age){
        this.name = name;
        this.fisrtName = fisrtName;
        this.club = club;
        this.position = position;
        this.age = age;
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

    public String getAgeAsString(){
        return String.valueOf(this.age);
    }
}
