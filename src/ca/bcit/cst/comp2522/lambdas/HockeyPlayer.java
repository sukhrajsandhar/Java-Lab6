package ca.bcit.cst.comp2522.lambdas;

/**
 * Models a single hockey player.
 * Each player has a name, position ("F", "D", or "G"), year of birth, and goal count.
 *
 * @author Sukhraj Sandhar
 * @author Arshia Adamian
 * @author Rodrick Vizigro
 * @author Indy Grewal
 * @author Abdullah Alasmy
 *
 * @version 1.0
 */
public class HockeyPlayer
{
    private final String name;
    private final String position;
    private final int yearOfBirth;
    private final int goals;

    /**
     * Constructs a HockeyPlayer.
     *
     * @param name the player's name
     * @param position the player's position ("F", "D", or "G")
     * @param yearOfBirth the player's birth year
     * @param goals the player's goal count
     */
    public HockeyPlayer(final String name, final String position,
                        final int yearOfBirth, final int goals)
    {
        this.name = name;
        this.position = position;
        this.yearOfBirth = yearOfBirth;
        this.goals = goals;
    }

    /** @return player's name */
    public String getName() { return name; }

    /** @return player's position */
    public String getPosition() { return position; }

    /** @return player's year of birth */
    public int getYearOfBirth() { return yearOfBirth; }

    /** @return player's goals */
    public int getGoals() { return goals; }

    @Override
    public String toString()
    {
        return name + " — " + position + " — " + yearOfBirth + " — " + goals + "G";
    }
}
