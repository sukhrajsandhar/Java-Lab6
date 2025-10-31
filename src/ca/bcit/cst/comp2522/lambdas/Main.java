/*
 * Course: COMP 2522
 * Lab: 6
 * File: Main.java
 * Author: Sukhraj Sandhar
 * Date: 2025-10-31
 * Description:
 * Demonstrates the use of Java lambda expressions and functional interfaces.
 */

package ca.bcit.cst.comp2522.lambdas;

import java.util.*;
import java.util.function.*;

/**
 * Demonstrates lambdas with Predicate, Function, Consumer, Supplier,
 * UnaryOperator, and Comparator on a hockey team.
 */
public class Main
{
    /**
     * Main entry point.
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        HockeyTeam team = new HockeyTeam("Burnaby Blizzards");

        team.addPlayer(new HockeyPlayer("Alex Morgan", "F", 1999, 21));
        team.addPlayer(new HockeyPlayer("Jordan Lee", "D", 1998, 10));
        team.addPlayer(new HockeyPlayer("Chris Wong", "F", 2000, 25));
        team.addPlayer(new HockeyPlayer("Sam Patel", "G", 1997, 0));
        team.addPlayer(new HockeyPlayer("Devon Clark", "D", 1996, 7));
        team.addPlayer(new HockeyPlayer("Liam Torres", "F", 2001, 15));

        // 1. Supplier: Create a call-up player and add to team
        Supplier<HockeyPlayer> callUpSupplier = () -> new HockeyPlayer("Call-Up Carter", "F", 2003, 5);
        HockeyPlayer callUp = callUpSupplier.get();
        team.addPlayer(callUp);
        System.out.println("Added new player: " + callUp);

        // 2. Predicates: Forwards with 20+ goals
        Predicate<HockeyPlayer> isForward = p -> p.getPosition().equals("F");
        Predicate<HockeyPlayer> has20PlusGoals = p -> p.getGoals() >= 20;

        System.out.println("\n🏒 Forwards with 20+ goals:");
        for (HockeyPlayer p : team.getRoster())
        {
            if (isForward.and(has20PlusGoals).test(p))
            {
                System.out.println(" - " + p);
            }
        }

        // 3. Function: Map player to label string
        Function<HockeyPlayer, String> playerLabel = p -> p.getName() + " — " + p.getGoals() + "G";

        System.out.println("\nPlayer Labels:");
        for (HockeyPlayer p : team.getRoster())
        {
            System.out.println(" - " + playerLabel.apply(p));
        }

        // 4. Consumer: Print only player names
        Consumer<HockeyPlayer> printName = p -> System.out.println(p.getName());

        System.out.println("\nPlayer Names:");
        team.getRoster().forEach(printName);

        // 5. UnaryOperator: Convert string to uppercase
        UnaryOperator<String> toUpper = s -> s.toUpperCase();

        System.out.println("\nNames in Uppercase:");
        for (HockeyPlayer p : team.getRoster())
        {
            System.out.println(" - " + toUpper.apply(p.getName()));
        }

        // 6. Comparator: Sort players by goals (descending)
        team.getRoster().sort((a, b) -> Integer.compare(b.getGoals(), a.getGoals()));

        System.out.println("\nSorted by Goals (Descending):");
        team.getRoster().forEach(p -> System.out.println(" - " + p));
    }
}
