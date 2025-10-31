/*
 * Course: COMP 2522
 * Lab: 6
 * File: HockeyTeam.java
 * Author: Sukhraj Sandhar
 * Date: 2025-10-31
 * Description:
 * Represents a hockey team containing a name and a roster of players.
 */

package ca.bcit.cst.comp2522.lambdas;

import java.util.*;

/**
 * Models a hockey team that holds multiple players.
 * Provides accessors and mutators for the team roster.
 */
public class HockeyTeam
{
    private final String name;
    private final List<HockeyPlayer> roster;

    /**
     * Constructs a hockey team.
     * @param name name of the team
     */
    public HockeyTeam(String name)
    {
        this.name = name;
        this.roster = new ArrayList<>();
    }

    /** @return team name */
    public String getName()
    {
        return name;
    }

    /** @return list of players */
    public List<HockeyPlayer> getRoster()
    {
        return roster;
    }

    /**
     * Adds a player to the roster.
     * @param player the player to add
     */
    public void addPlayer(HockeyPlayer player)
    {
        roster.add(player);
    }

    /** @return formatted string for entire roster */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(name + " Roster:\n");
        for (HockeyPlayer p : roster)
        {
            sb.append(" - ").append(p).append("\n");
        }
        return sb.toString();
    }
}
