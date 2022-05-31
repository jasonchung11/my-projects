"""
Models module for Alien Invaders

This module contains the model classes for the Alien Invaders game. Anything
that you interact with on the screen is model: the ship, the laser bolts, and
the aliens.

Just because something is a model does not mean there has to be a special
class for it. Unless you need something special for your extra gameplay
features, Ship and Aliens could just be an instance of GImage that you move
across the screen. You only need a new class when you add extra features to
an object. So technically Bolt, which has a velocity, is really the only model
that needs to have its own class.

With that said, we have included the subclasses for Ship and Aliens. That is
because there are a lot of constants in consts.py for initializing the
objects, and you might want to add a custom initializer.  With that said,
feel free to keep the pass underneath the class definitions if you do not want
to do that.

You are free to add even more models to this module.  You may wish to do this
when you add new features to your game, such as power-ups.  If you are unsure
about whether to make a new class or not, please ask on Piazza.

Jason Chung (jkc97) and Nevin Motto (nam96)
9 December 2021
"""
from consts import *
from game2d import *
from introcs import Point2

# PRIMARY RULE: Models are not allowed to access anything in any module other
# than consts.py.  If you need extra information from Gameplay, then it should
# be a parameter in your method, and Wave should pass it as a argument when it
# calls the method.


class Ship(GSprite):
    """
    A class to represent the game ship.

    At the very least, you want a __init__ method to initialize the ships
    dimensions. These dimensions are all specified in consts.py.

    You should probably add a method for moving the ship.  While moving a
    ship just means changing the x attribute (which you can do directly),
    you want to prevent the player from moving the ship offscreen.  This
    is an ideal thing to do in a method.

    You also MIGHT want to add code to detect a collision with a bolt. We
    do not require this.  You could put this method in Wave if you wanted to.
    But the advantage of putting it here is that Ships and Aliens collide
    with different bolts.  Ships collide with Alien bolts, not Ship bolts.
    And Aliens collide with Ship bolts, not Alien bolts. An easy way to
    keep this straight is for this class to have its own collision method.

    However, there is no need for any more attributes other than those
    inherited by GImage. You would only add attributes if you needed them
    for extra gameplay features (like animation).
    """

    # INITIALIZER TO CREATE A NEW SHIP
    def __init__(self,src,frame):
        """
        Initializes a new Ship object.

        Ship is defined as a GSprite representing the user's interactive
        game piece.

        Parameter src: the source of the picture appearance of the ship
        Precondition: src is a .png file and an 8-frame sprite sheet

        Parameter frame: the frame of the the GSprite
        Precondition: frame is an int 0..7

        """
        super().__init__(x=GAME_WIDTH/2, y=SHIP_BOTTOM+SHIP_HEIGHT/2,
        width=SHIP_WIDTH, height=SHIP_HEIGHT, format = SHIP_FORMAT, source=src,
        frame = frame)

    # METHODS TO MOVE THE SHIP AND CHECK FOR COLLISIONS

    def collides(self,bolt):
        """
        Returns True if an alien bolt touches the Ship object; False otherwise.

        Parameter bolt: The bolt being detected for collision
        Precondition: bolt is an instance of Bolt
        """
        pos = (bolt.getX(), bolt.getY()-BOLT_HEIGHT/2)
        if bolt.getIsAlienBolt() and self.contains(pos):
            return True
        return False


class Alien(GImage):
    """
    A class to represent a single alien.

    At the very least, you want a __init__ method to initialize the alien
    dimensions. These dimensions are all specified in consts.py.

    You also MIGHT want to add code to detect a collision with a bolt. We
    do not require this.  You could put this method in Wave if you wanted to.
    But the advantage of putting it here is that Ships and Aliens collide
    with different bolts.  Ships collide with Alien bolts, not Ship bolts.
    And Aliens collide with Ship bolts, not Alien bolts. An easy way to
    keep this straight is for this class to have its own collision method.

    However, there is no need for any more attributes other than those
    inherited by GImage. You would only add attributes if you needed them
    for extra gameplay features (like giving each alien a score value).
    """

    # INITIALIZER TO CREATE AN ALIEN
    def __init__(self,x,y,src):
        """
        Initializes a new Alien object.

        Alien is defined as a GImage displaying the game's opponents.

        Parameter x: the x-position of the middle of the alien
        Precondition: x is an int or float
        ALIEN_WIDTH/2..GAME_WIDTH-ALIEN_WIDTH/2

        Parameter y: the y-position of the middle of the alien
        Precondition: y is an int or float
        ALIEN_HEIGHT/2..GAME_HEIGHT-ALIEN_HEIGHT/2

        Parameter src: the source of the picture appearance of the alien
        Precondition: src is a .png file
        """
        super().__init__(x=x, y=y, width=ALIEN_WIDTH, height=ALIEN_HEIGHT,
                        source=src)

    # METHOD TO CHECK FOR COLLISION (IF DESIRED)
    def collides(self,bolt):
        """
        Returns True if a ship bolt touches the alien; False otherwise.

        Parameter bolt: The bolt being detected for collision
        Precondition: bolt is an instance of Bolt
        """
        pos = (bolt.getX(),bolt.getY()+BOLT_HEIGHT/2)
        if bolt.getIsPlayerBolt() and self.contains(pos):
                return True
        return False


class Bolt(GRectangle):
    """
    A class representing a laser bolt.

    Laser bolts are often just thin, white rectangles. The size of the bolt
    is determined by constants in consts.py. We MUST subclass GRectangle,
    because we need to add an extra (hidden) attribute for the velocity of
    the bolt.

    The class Wave will need to look at these attributes, so you will need
    getters for them.  However, it is possible to write this assignment with
    no setters for the velocities.  That is because the velocity is fixed and
    cannot change once the bolt is fired.

    In addition to the getters, you need to write the __init__ method to set
    the starting velocity. This __init__ method will need to call the __init__
    from GRectangle as a  helper.

    You also MIGHT want to create a method to move the bolt.  You move the
    bolt by adding the velocity to the y-position.  However, the getter
    allows Wave to do this on its own, so this method is not required.
    """
    # INSTANCE ATTRIBUTES:
    # Attribute _velocity: the velocity in y direction
    # Invariant: _velocity is an int or float
    #
    # Attribute _isPlayerBolt: the entity a bolt belongs to (True-ship,
    # False-alien)
    # Invariant: _isPlayerBolt is a bool

    # LIST MORE ATTRIBUTES (AND THEIR INVARIANTS) HERE IF NECESSARY

    # GETTERS AND SETTERS (ONLY ADD IF YOU NEED THEM)
    def getIsPlayerBolt(self):
        """
        Returns True if the bolt was fired by the player ship; False otherwise
        """
        return self._isPlayerBolt

    def getIsAlienBolt(self):
        """
        Returns True if the bolt was fired by the Alien; False otherwise
        """
        return not self._isPlayerBolt

    def getX(self):
        """
        Returns the x-value of the bolt's center
        """
        return self.x

    def getY(self):
        """
        Returns the y-value of the bolt's center
        """
        return self.y

    # INITIALIZER TO SET THE VELOCITY
    def __init__(self,x,y,isPlayerBolt):
        """
        Initializes a new Bolt object.

        Bolt is defined as a GRectangle representing the projectile fired
        by either an Alien or the player.

        Parameter x: the starting x-coordinate of the bolt's center.
        Precondition: x is an int or float 0..GAME_WIDTH

        Parameter y: the starting y-coordinate of the bolt's center.
        Precondition: y is an int or float 0..GAME_HEIGHT

        Parameter isPlayerBolt: whether a bolt belongs to an alien or the player
        Precondition: isPlayerBolt is a bool
        """
        super().__init__(x=x,y=y,width=BOLT_WIDTH,height=BOLT_HEIGHT,
        fillcolor=YELLOW_COLOR,linecolor=YELLOW_COLOR,linewidth=0)
        self._isPlayerBolt = isPlayerBolt
        if self._isPlayerBolt:
            self._velocity = BOLT_SPEED
        if not self._isPlayerBolt:
            self._velocity = -BOLT_SPEED

    # ADD MORE METHODS (PROPERLY SPECIFIED) AS NECESSARY
    def moveBolt(self):
        """
        Moves the bolt by adding the bolt's velocity to its y-position each
        frame.
        """
        self.y += self._velocity

# IF YOU NEED ADDITIONAL MODEL CLASSES, THEY GO HERE
