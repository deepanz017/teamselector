package com.peelu.teamselector;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peelu.teamselector.model.Player;
import com.peelu.teamselector.model.Players;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dabroal on 5/7/18.
 */
public class TeamSelector {
    public static Integer maxPlayers = 11;
    public static Integer maxWicketKeepers=1;
    public static Integer maxAllrounders=3;
    public static Integer maxBatsmen = 5;
    public static Integer maxBowlers = 5;

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/deepanshu/teamselector/src/main/resources/players.json");

        ObjectMapper objectMapper = new ObjectMapper();

        Players players = objectMapper.readValue(file, Players.class);
        int a =1;
        List<Player> selectedPlayers = new ArrayList<Player>();
        double value = knapSack(100, players.getPlayers(), players.getPlayers().size()-1, selectedPlayers,
                0,0,0,0);
        System.out.println(value);
    }

    private static double knapSack(double totalCost,
                                   List<Player> players,
                                   int endIndex,
                                   List<Player> selectedPlayers,
                                   Integer batsmenCount,
                                   Integer bowlersCount,
                                   Integer allroundersCount,
                                   Integer wicketKeepersCount) {



        if(endIndex < 0) return 0;
        if(totalCost<0) return 0;
        Player player = players.get(endIndex);
        List<Player> playerListIfSelected = new ArrayList<>(selectedPlayers);
        playerListIfSelected.add(player);
        List<Player> playerListIfNotSelected = new ArrayList<>(selectedPlayers);

        System.out.println("knapSack(" + totalCost + "," + player.getName());
        double valueWithPlayerSelected = -1;
        double valueWithPlayerNotSelected = -1;
//        System.out.println(player.getName());
//        players.remove(player);
        PlayerTypeEnum playerTypeEnum = PlayerTypeEnum.getPlayerType(player);
        switch (playerTypeEnum) {
            case WK:
                if(player.getCredits() < totalCost && wicketKeepersCount < maxWicketKeepers) {
                    valueWithPlayerSelected = player.getPoints()+ knapSack(totalCost - player.getCredits(), players, endIndex - 1, playerListIfSelected,
                            batsmenCount, bowlersCount, allroundersCount, wicketKeepersCount + 1);
                } else
                valueWithPlayerNotSelected = knapSack(totalCost, players, endIndex -1, playerListIfNotSelected,
                        batsmenCount, bowlersCount, allroundersCount, wicketKeepersCount);
                break;
            case BAT:
                if(player.getCredits() < totalCost && batsmenCount < maxBatsmen) {
                    valueWithPlayerSelected = player.getPoints()+ knapSack(totalCost - player.getCredits(), players, endIndex - 1, playerListIfSelected,
                            batsmenCount+1, bowlersCount, allroundersCount, wicketKeepersCount);
                } else
                    valueWithPlayerNotSelected = knapSack(totalCost, players, endIndex -1, playerListIfNotSelected,
                            batsmenCount, bowlersCount, allroundersCount, wicketKeepersCount);
                break;
            case BOWL:
                if(player.getCredits() < totalCost && bowlersCount < maxBowlers) {
                    valueWithPlayerSelected = player.getPoints()+ knapSack(totalCost - player.getCredits(), players, endIndex - 1, playerListIfSelected,
                            batsmenCount, bowlersCount + 1, allroundersCount, wicketKeepersCount);
                } else
                    valueWithPlayerNotSelected = knapSack(totalCost, players, endIndex -1, playerListIfNotSelected,
                            batsmenCount, bowlersCount, allroundersCount, wicketKeepersCount);
                break;
            case ALL:
                if(player.getCredits() < totalCost && allroundersCount < maxAllrounders) {
                    valueWithPlayerSelected = player.getPoints()+ knapSack(totalCost - player.getCredits(), players, endIndex - 1, playerListIfSelected,
                            batsmenCount, bowlersCount, allroundersCount+1, wicketKeepersCount);
                } else
                    valueWithPlayerNotSelected = knapSack(totalCost, players, endIndex -1, playerListIfNotSelected,
                            batsmenCount, bowlersCount, allroundersCount, wicketKeepersCount);
                break;


        }
        if(valueWithPlayerNotSelected > valueWithPlayerSelected){
            System.out.println(player.getName() + " Not Selected");
            selectedPlayers = playerListIfNotSelected;
            return valueWithPlayerNotSelected;
        } else {
            System.out.println(player.getName() + " Selected");
            selectedPlayers = playerListIfSelected;
            return valueWithPlayerSelected;
        }
    }

    public enum PlayerTypeEnum {
        ALL,
        BOWL,
        BAT,
        WK;
        PlayerTypeEnum() {
        }

        public static PlayerTypeEnum getPlayerType(Player player) {
            return PlayerTypeEnum.valueOf(player.getType().getName());
        }
    }
}
