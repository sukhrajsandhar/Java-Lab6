package ca.bcit.cst.comp2522.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Main driver for Lab 6 — practicing lambdas.
 * Demonstrates Supplier, Predicate, Function, Consumer, UnaryOperator,
 * Comparator, aggregation, and a custom functional interface.
 *
 * @author Sukhraj
 * @author Arshia
 * @author Rodrick
 * @author Abdullah
 * @author Indy
 *
 * @version 1.0
 */
public final class Main
{
    private static final int CURRENT_YEAR = 2025;
    private static final int MIN_AGE = 20;
    private static final int MIN_GOALS_15 = 15;
    private static final int MIN_GOALS_20 = 20;

    private Main() { }

    /**
     * Custom functional interface defined inside Main (to keep total files = 3).
     */
    @FunctionalInterface
    interface EligibilityRule
    {
        /**
         * Tests whether a player meets minimum age and goal requirements.
         *
         * @param player the player to test
         * @param minAge minimum required age
         * @param minGoals minimum required goals
         * @param currentYear current year to compute age
         * @return true if eligible, otherwise false
         */
        boolean test(final HockeyPlayer player,
                     final int minAge,
                     final int minGoals,
                     final int currentYear);
    }

    /**
     * Application entry point.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(final String[] args)
    {
        final HockeyTeam team = sampleTeam();
        final List<HockeyPlayer> roster = team.getRoster();

        System.out.println("=== Original Roster ===");
        printRoster(roster);

        // 1) Supplier — create a call-up player and add to team
        final Supplier<HockeyPlayer> callUpSupplier =
            () -> new HockeyPlayer("Call-Up Player", "F", 2005, 12);
        roster.add(callUpSupplier.get());
        System.out.println("\nAfter Supplier call-up:");
        printRoster(roster);

        // 2) Predicate — forwards with 20+ goals
        final Predicate<HockeyPlayer> isForward = p -> "F".equals(p.getPosition());
        final Predicate<HockeyPlayer> has20Plus = p -> p.getGoals() >= MIN_GOALS_20;

        System.out.println("\nForwards with 20+ goals:");
        for (final HockeyPlayer p : roster)
        {
            if (isForward.and(has20Plus).test(p))
            {
                System.out.println(p.getName() + " — " + p.getGoals() + "G");
            }
        }

        // 3) Function — map player to label string
        final Function<HockeyPlayer, String> label =
            p -> p.getName() + " — " + p.getGoals() + "G";
        System.out.println("\nPlayer labels (Function):");
        for (final HockeyPlayer p : roster)
        {
            System.out.println(label.apply(p));
        }

        // 4) Consumer — print just the name
        final Consumer<HockeyPlayer> printName = p -> System.out.println(p.getName());
        System.out.println("\nConsumer — player names:");
        for (final HockeyPlayer p : roster)
        {
            printName.accept(p);
        }

        // 5) UnaryOperator — uppercase names
        final UnaryOperator<String> toUpper = String::toUpperCase;
        System.out.println("\nUppercase names (UnaryOperator):");
        for (final HockeyPlayer p : roster)
        {
            System.out.println(toUpper.apply(p.getName()));
        }

        // 6) Comparator — sort by goals DESC
        final Comparator<HockeyPlayer> byGoalsDesc =
            (a, b) -> Integer.compare(b.getGoals(), a.getGoals());
        Collections.sort(roster, byGoalsDesc);
        System.out.println("\nSorted by goals (DESC):");
        printRoster(roster);

        // 7) Aggregation — total goals
        int totalGoals = 0;
        for (final HockeyPlayer p : roster)
        {
            totalGoals += p.getGoals();
        }
        System.out.println("\nTotal team goals: " + totalGoals);

        // 8) Custom Functional Interface — EligibilityRule
        final EligibilityRule rule = (player, minAge, minGoals, currentYear) ->
        {
            final int age = currentYear - player.getYearOfBirth();
            return age >= minAge && player.getGoals() >= minGoals;
        };

        System.out.println("\nEligible players (age ≥ 20 and goals ≥ 15):");
        for (final HockeyPlayer p : roster)
        {
            if (rule.test(p, MIN_AGE, MIN_GOALS_15, CURRENT_YEAR))
            {
                System.out.println(p.getName()
                                   + " — age " + (CURRENT_YEAR - p.getYearOfBirth())
                                   + ", goals " + p.getGoals());
            }
        }
    }

    /** Creates a small example roster. */
    private static HockeyTeam sampleTeam()
    {
        final List<HockeyPlayer> players = new ArrayList<>();
        players.add(new HockeyPlayer("Alex Morgan", "F", 2002, 21));
        players.add(new HockeyPlayer("Ben Carter", "D", 1999, 6));
        players.add(new HockeyPlayer("Casey Young", "F", 2004, 28));
        players.add(new HockeyPlayer("Drew Singh", "G", 2000, 0));
        players.add(new HockeyPlayer("Eva Chen", "D", 2001, 5));
        players.add(new HockeyPlayer("Farah Ali", "F", 2003, 19));
        return new HockeyTeam("BCIT Blizzards", players);
    }

    /** Prints all players in a readable format. */
    private static void printRoster(final List<HockeyPlayer> roster)
    {
        for (final HockeyPlayer p : roster)
        {
            System.out.println(p);
        }
    }
}
