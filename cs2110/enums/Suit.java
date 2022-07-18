/** Provide suits of a card deck */
public enum Suit {
    CLUBS("black"), DIAMONDS("red"), HEARTS("red"), SPADES("black");

    // Enums can have fields and constructors to initialize the fields.
    // The only time the constructor can be called is in the
    // declaration of initial enum constants
    private String color;

    /** Constructor: a suit with color c <br>
     * Precondition: c is either "red" or "black" */
    Suit(String c) {
        color= c;
    }

    // Enums can have instance or static methods.
    // Examples of calling instance methods on enum values:
    // Suit.CLUBS.color();
    // Suit.HEARTS.isRed();

    /** Return the color of the suit. */
    public String color() {
        return color;
    }

    /** Return "this suit is red. */
    public boolean isRed() {
        return color.equals("red");
    }

    /** Return "this suit is black. */
    public boolean isBlack() {
        return color.equals("black");
    }

    public static void main(String[] args) {
        var ee= Suit.CLUBS;
        System.out.println("ee is: " + ee + " of color " + ee.color());

    }

}
