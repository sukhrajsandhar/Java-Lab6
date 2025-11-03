/*
 * Course: COMP 2522
 * Description:
 * Represents a hockey player with a name, position, birth year, and goal count.
 * Lab: 6
 * File: HockeyPlayer.java
 *
 * @author Sukhraj
 * @author Arshia
 * @author Rodrick
 * @author Abdullah
 * @author Indy
 *
 * @version 1.0
 *
 * Date: 2025-10-31
 */

package ca.bcit.cst.comp2522.lambdas;

/**
 * Models a single hockey player.
 * @author Sukhraj
 * @version 1.0
 */
public class HockeyPlayer
{
    private final String name;
    private final String position; // F = Forward, D = Defense, G = Goalie
    private final int yearOfBirth;
    private int goals;

    /**
     * Constructs a HockeyPlayer.
     * @param name player's name
     * @param position player's position
     * @param yearOfBirth player's birth year
     * @param goals player's goal count
     */
    public HockeyPlayer(String name,
                        String position,
                        int yearOfBirth,
                        int goals)
    {
        this.name = name;
        this.position = position;
        this.yearOfBirth = yearOfBirth;
        this.goals = goals;
    }

    /** @return player's name */
    public String getName()
    {
        return name;
    }

    /** @return player's position */
    public String getPosition()
    {
        return position;
    }

    /** @return player's year of birth */
    public int getYearOfBirth()
    {
        return yearOfBirth;
    }

    /** @return player's goal count */
    public int getGoals()
    {
        return goals;
    }

    /** Adds one goal to this player. */
    public void scoreGoal()
    {
        goals++;
    }

    /** @return formatted string representation */
    @Override
    public String toString()
    {
        final String details;
        details = name + " (" + position + ") — " + goals + "G";

        return details;
    }
}
