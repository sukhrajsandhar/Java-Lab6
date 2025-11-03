package ca.bcit.cst.comp2522.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * Models a hockey team.
 * A HockeyTeam has a name and a roster of HockeyPlayer objects.
 * The roster can be modified (players added) from the main program.
 *
 * @author Sukhraj
 * @author Arshia
 * @author Rodrick
 * @author Abdullah
 * @author Indy
 *
 * @version 1.0
 */
public class HockeyTeam
{
    private final String name;
    private final List<HockeyPlayer> roster;

    /**
     * Constructs a HockeyTeam with a given name and an empty roster.
     *
     * @param name the team's name
     */
    public HockeyTeam(final String name)
    {
        this.name = name;
        this.roster = new ArrayList<>();
    }

    /**
     * Constructs a HockeyTeam with an existing roster.
     *
     * @param name team name
     * @param roster list of HockeyPlayer objects
     */
    public HockeyTeam(final String name, final List<HockeyPlayer> roster)
    {
        this.name = name;
        this.roster = roster;
    }

    /** @return the team name */
    public String getName() { return name; }

    /** @return the team roster */
    public List<HockeyPlayer> getRoster() { return roster; }

    /**
     * Adds a player to the team roster.
     *
     * @param player the player to add
     */
    public void addPlayer(final HockeyPlayer player)
    {
        roster.add(player);
    }
}
