/** Provide the four basic directions. */
public enum Direction {
    NORTH, EAST, WEST, SOUTH;

    /** Print out info to illustrate use of methods in an enum and the fact that it extends class
     * Enum */
    public static void main(String[] args) {
        // Show that Direction extends Enum.
        Enum<Direction> e= Direction.EAST;
        System.out.println("Here is e: " + e);
        System.out.println("e instanceof Enum: " + (e instanceof Enum) + "\n");

        System.out.println("The name() of e is: " + e.name());
        System.out.println("The toString() value of e is: " + e.toString() + "\n");

        for (Direction s : Direction.values()) {
            System.out.println(s + "\'s ordinal number is: " + s.ordinal());
        }

        var d= valueOf("SOUTH");

        var k= Direction.SOUTH.compareTo(Direction.EAST);
        System.out.println("Value of comparing SOUTH to EAST: " + k);

    }

    /* This class is converted to the following:
     *
     * class Direction extends Enum {
     public static final Direction NORTH= new Direction();
     public static final Direction EAST= new Direction();
     public static final Direction WEST= new Direction();
     public static final Direction SOUTH= new Direction();

     private Direction() {}; // Constructor is private!

     /** Return an array of the four static values. * /
     public static Directions[] values{} {...}

     /** Return the ordinal number of d.
       *  The first (NORTH) is 0, second is 1, ... * /
     public int ordinal() {...}

     /** Return the name of this Direction (as a string).
       *  e.g. "NORTH" * /
     public int ordinal() {...}
    }

    // You can use either == or equals(..). equals(...) uses ==
    // We prefer == because wrong use of types detected at compile time, e.g.
    //       Direction.NORTH == SUIT.SPADES
     */
}
