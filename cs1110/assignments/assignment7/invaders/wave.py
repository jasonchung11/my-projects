"""
Subcontroller module for Alien Invaders

This module contains the subcontroller to manage a single level or wave in
the Alien Invaders game.  Instances of Wave represent a single wave. Whenever
you move to a new level, you are expected to make a new instance of the class.

The subcontroller Wave manages the ship, the aliens and any laser bolts on
screen. These are model objects.  Their classes are defined in models.py.

Most of your work on this assignment will be in either this module or
models.py. Whether a helper method belongs in this module or models.py is
often a complicated issue.  If you do not know, ask on Piazza and we will
answer.

Jason Chung (jkc97) and Nevin Motto (nam96)
9 December 2021
"""
from game2d import *
from consts import *
from models import *
import random

# PRIMARY RULE: Wave can only access attributes in models.py via getters/setters
# Wave is NOT allowed to access anything in app.py (Subcontrollers are not
# permitted to access anything in their parent. To see why, take CS 3152)


class Wave(object):
    """
    This class controls a single level or wave of Alien Invaders.

    This subcontroller has a reference to the ship, aliens, and any laser bolts
    on screen. It animates the laser bolts, removing any aliens as necessary.
    It also marches the aliens back and forth across the screen until they are
    all destroyed or they reach the defense line (at which point the player
    loses). When the wave is complete, you  should create a NEW instance of
    Wave (in Invaders) if you want to make a new wave of aliens.

    If you want to pause the game, tell this controller to draw, but do not
    update.  See subcontrollers.py from Lecture 24 for an example.  This
    class will be similar to than one in how it interacts with the main class
    Invaders.

    All of the attributes of this class are to be hidden. You may find that
    you want to access an attribute in class Invaders. It is okay if you do,
    but you MAY NOT ACCESS THE ATTRIBUTES DIRECTLY. You must use a getter
    and/or setter for any attribute that you need to access in Invaders.
    Only add the getters and setters that you need for Invaders. You can keep
    everything else hidden.

    """
    # HIDDEN ATTRIBUTES:
    # Attribute _ship: the player ship to control
    # Invariant: _ship is a Ship object or None
    #
    # Attribute _aliens: the 2d list of aliens in the wave
    # Invariant: _aliens is a rectangular 2d list containing Alien objects or None
    #
    # Attribute _bolts: the laser bolts currently on screen
    # Invariant: _bolts is a list of Bolt objects, possibly empty
    #
    # Attribute _dline: the defensive line being protected
    # Invariant : _dline is a GPath object
    #
    # Attribute _lives: the number of lives left
    # Invariant: _lives is an int >= 0
    #
    # Attribute _time: the amount of time since the last Alien "step"
    # Invariant: _time is a float >= 0.0
    #
    # Attribute _orient: the direction that the Aliens move
    # 0-right, 1-downAfterRight, 2-left, 3-downAfterLeft
    # Invariant: _orient is an integer 0..2
    #
    # Attribute _lastSpace: if the spacebar was pressed in the last frame
    # Invariant: _lastSpace is a bool
    #
    # Attribute _shotsteps: how many steps the aliens take before shooting a bolt
    # Invariant: _shotsteps is an integer 1..BOLT_RATE
    #
    # Attribute _stepsSinceShot: how many steps the aliens took since last shot
    # Invariant: _stepsSinceShot is an integer 0..BOLT_RATE
    #
    # Attribute _lalienX: the x value of the left-most alien
    # Invariant: _lalienX is an int or float 0..GAME_WIDTH
    #
    # Attribute _ralienX: the x coordinate of the right-most alien
    # Invariant: _ralienX is an int or float 0..GAME_WIDTH
    #
    # Attribute _balienY: the y coordinate of the bottom-most alien
    # Invariant: _balienY is an int or float 0..GAME_HEIGHT
    #
    # Attribute _animator: the animation coroutine
    # Invariant: _animator is either None or a coroutine
    #
    # Attribute _frame: the frame of the ship sprite sheet
    # Invariant: _frame is a int from 0 to 7
    #
    # Attribute _timeShip: the time passed after the ship was hit
    # Invariant: _timeShip is an int or float >= 0
    #
    # Attribute _waveOver: if the wave has concluded
    # Invariant: _waveOver is a bool
    #
    # Attribute _deadAliens: how many aliens have been killed throughout the game
    # Invariant: _deadAliens is an int >= 0
    #
    # Attribute _win: if the game has been won or not
    # Invariant: _win is a bool

    def getLives(self):
        """
        Returns the number of lives remaining in the game
        """
        return self._lives

    def getShip(self):
        """
        Returns the player ship to control as a Ship object
        """
        return self._ship

    def setShip(self,ship):
        """
        Sets the player ship to control

        Parameter ship: The ship object
        Precondition: ship is either a Ship object or None
        """
        self._ship = ship

    def getAliens(self):
        """
        Returns the 2D list of all aliens in the wave.
        """
        return self._aliens

    def getDeadAliens(self):
        """
        Returns the number of aliens (int) that have been killed throughout
        the game.
        """
        return self._deadAliens

    def getWaveOver(self):
        """
        Returns a bool for whether the wave is over: True if over;
        False otherwise
        """
        return self._waveOver

    def getWin(self):
        """
        Returns a boolean expression for whether the game has been won:
        True if won; False otherwise
        """
        return self._win

    def __init__(self):
        """
        Initializes the wave by setting attributes for the Aliens, Dline, Bolts,
        and Ship.

        The initializer also sets _time, _orient, _lastSpace, _shotsteps
        _stepsSinceShot, _animator, _frame, _timeShip, _lives, _deadAliens,
        _waveOver, and _win their initial values.
        """
        self._makeAliens()
        self._makeDline()
        self._bolts = []
        self._ship = Ship(SHIP_IMAGE,0)
        self._time = 0
        self._orient = 0
        self._lastSpace = False
        self._shotsteps = random.randint(1,BOLT_RATE)
        self._stepsSinceShot = 0
        self._animator = None
        self._frame = 0
        self._timeShip = 0
        self._lives = SHIP_LIVES
        self._deadAliens = 0
        self._waveOver = False
        self._win = False

    # UPDATE METHOD TO MOVE THE SHIP, ALIENS, AND LASER BOLTS
    def update(self, input, dt, lastkeys):
        """
        The method to move the ship, aliens, and laser bolts

        Parameter input: The user input to move the ship left or right
        Precondition: None

        Parameter dt: The time in seconds since last update
        Precondition: dt is a number (int or float)

        Parameter lastkeys: The number of keys pressed in the last frame
        Precondition: lastkeys is an int >=0
        """
        if not self._ship is None:
            self._updateShip(input)
        self._marchAliens(dt)
        if not self._ship is None:
            self._shootShipBolt(input,lastkeys)
        self._shootAlienBolt()
        self._deleteBolt()
        for x in self._bolts:
            x.moveBolt()
        if not self._aliens is None:
            self._boltCollision()
            self._setBottomAlien()
        self._runShipAnimator(dt)
        if not self._ship is None:
            self._ship.frame = self._frame

        if self._lives > 0:
            self._win = True
        if self._lives == 0:
            self._win = False
        if self._balienY < DEFENSE_LINE + ALIEN_HEIGHT/2:
            self._win = False
        if self._deadAliens == ALIEN_ROWS*ALIENS_IN_ROW or self._lives == 0 \
        or self._balienY < DEFENSE_LINE+ALIEN_HEIGHT/2:
        #if self._deadAliens == ALIEN_ROWS*ALIENS_IN_ROW or self._lives == 0:
            self._ship = None
            self._dline = None
            self._waveOver = True


    # DRAW METHOD TO DRAW THE SHIP, ALIENS, DEFENSIVE LINE AND BOLTS
    def draw(self,view):
        """
        Draws the ship, aliens, defense line, and bolts

        Parameter view: The game view
        Precondition: view is an instance of Gview
        """
        for x in self._aliens:
            for alien in x:
                if not alien is None:
                    alien.draw(view)

        if not self._ship is None:
            self._ship.draw(view)
        if not self._dline is None:
            self._dline.draw(view)
        for x in self._bolts:
            x.draw(view)

    # HELPER METHODS FOR INITIALIZING AND MOVING SHIP, ALIENS, BOLTS
    def _makeAliens(self):
        """
        Creates a 2D list of Aliens in a grid-pattern, stored in _aliens
        """
        self._aliens = []
        y_pos = GAME_HEIGHT - ALIEN_CEILING - ALIEN_HEIGHT*ALIEN_ROWS - \
                ALIEN_V_SEP*(ALIEN_ROWS-1) + ALIEN_HEIGHT/2
        img_pos = 0
        for x in range(ALIEN_ROWS):
            row = []
            x_pos = ALIEN_H_SEP + ALIEN_WIDTH/2
            for y in range(ALIENS_IN_ROW):
                row.append(Alien(x_pos, y_pos,
                ALIEN_IMAGES[(img_pos//2)%len(ALIEN_IMAGES)]))
                x_pos += ALIEN_H_SEP + ALIEN_WIDTH
            self._aliens.append(row)
            y_pos = y_pos + ALIEN_V_SEP + ALIEN_HEIGHT
            img_pos += 1

    def _makeDline(self):
        """
        Creates the Dline, an instance of GPath and stored in _dline
        """
        self._dline = GPath(points=[0,DEFENSE_LINE,GAME_WIDTH,DEFENSE_LINE],
        linewidth=1, linecolor=YELLOW_COLOR)

    def _updateShip(self,input):
        """
        Moves the ship by adding or subtracting the movement factor
        SHIP_MOVEMENT each frame that a key is pressed.

        The method also prevents the ship from exiting the window, stopping
        it at the edges.

        Parameter input: The user input to move the ship left or right
        Precondition: input is an instance of GInput (inherited from GameApp)
        """
        if input.is_key_down('left'):
            self._ship.x -= SHIP_MOVEMENT
        if input.is_key_down('right'):
            self._ship.x += SHIP_MOVEMENT
        if self._ship.x <= SHIP_WIDTH/2:
            self._ship.x = SHIP_WIDTH/2
        if self._ship.x >= GAME_WIDTH - SHIP_WIDTH/2:
            self._ship.x = GAME_WIDTH - SHIP_WIDTH/2
        # Feature for switching sides
        # if self._ship.x < -SHIP_WIDTH/2:
        #     self._ship.x = GAME_WIDTH+SHIP_WIDTH/2
        # if self._ship.x > GAME_WIDTH+SHIP_WIDTH/2:
        #     self._ship.x = -SHIP_WIDTH/2

    def _marchAliens(self,dt):
        """
        Marches the Aliens of the 2D list attribute _aliens

        The method also calls helper method _setOutsideAliens()
        to set the the x coordinates of the leftmost and rightmost aliens
        in _ralienX and _lalienX

        Parameter dt: The time in seconds since last update
        Precondition: dt is a number (int or float)
        """
        self._time += dt
        if self._time >= ALIEN_SPEED:
            r_alien_bound = GAME_WIDTH - ALIEN_H_SEP - ALIEN_WIDTH/2
            l_alien_bound = ALIEN_H_SEP + ALIEN_WIDTH/2
            self._setOutsideAliens()
            if self._ralienX + ALIEN_H_WALK > r_alien_bound \
            and self._orient == 0:
                self._orient = 1
            if self._lalienX - ALIEN_H_WALK < l_alien_bound \
            and self._orient == 2:
                self._orient = 3
            for a in self._aliens:
                for alien in a:
                    if not alien is None:
                        if self._orient == 0:
                            alien.x += ALIEN_H_WALK
                        if self._orient == 1:
                            alien.y -= ALIEN_V_WALK
                        if self._orient == 2:
                            alien.x -= ALIEN_H_WALK
                        if self._orient == 3:
                            alien.y -= ALIEN_V_WALK
            if self._orient == 1:
                self._orient = 2
            if self._orient == 3:
                self._orient = 0;
            self._time = 0
            self._stepsSinceShot += 1

    def _setOutsideAliens(self):
        """
        Sets the x position of the right and left outside aliens, storing them
        in _ralienX and _lalienX
        """
        max_x = 0
        min_x = GAME_WIDTH
        for x in self._aliens:
            for alien in x:
                if not alien is None:
                    if alien.x > max_x:
                        max_x = alien.x
                    if alien.x < min_x:
                        min_x = alien.x
        self._ralienX = max_x
        self._lalienX = min_x

    def _setBottomAlien(self):
        """
        Stores the y position of the bottom-most alien in the attribute _balienY
        """
        min_y = GAME_HEIGHT
        for x in self._aliens:
            for alien in x:
                if not alien is None:
                    if alien.y < min_y:
                        min_y = alien.y
        self._balienY = min_y

    def _shootShipBolt(self,input,lastkeys):
        """
        Fires the bolt from the top of the ship.

        Parameter input: The user input to move the ship left or right
        Precondition: input is an instance of GInput (inherited from GameApp)

        Parameter lastkeys: The number of keys pressed in the last frame
        Precondition: lastkeys is an int >= 0
        """
        keysPressed = input.keys
        change = 'spacebar' in keysPressed and self._lastSpace == False \
        and not self.playerBoltOnScreen()

        if change:
            self._bolts.append(Bolt(self._ship.x,
            self._ship.y+SHIP_HEIGHT/2+BOLT_HEIGHT/2,
            True))

        self._lastSpace = 'spacebar' in keysPressed

    def _shootAlienBolt(self):
        """
        Randomly selects a remaining alien to fire a bolt

        The alien selected is the bottom alien of that column.
        """
        # PICKING ALIEN TO FIRE
        if self._stepsSinceShot >= self._shotsteps:
            shot = False
            while shot is False:
                rand_col = random.randint(0,ALIENS_IN_ROW-1)
                a = self._chooseAlien(rand_col)
                if not a is None:
                    self._bolts.append(Bolt(a.x,
                    a.y-ALIEN_HEIGHT/2-BOLT_HEIGHT/2,False))
                    shot = True
            self._stepsSinceShot = 0
            self._shotsteps = random.randint(1,BOLT_RATE)

    def _chooseAlien(self,rand_col):
        """
        Returns the x position of the column if an alien remains or None

        If the random column contains no aliens the method returns None.

        Parameter rand_col: A random column in the 2D list of _aliens
        Precondition: rand_col is an int 0..ALIENS_IN_ROW
        """
        for x in self._aliens:
            if not x[rand_col] is None:
                return x[rand_col]
        return None

    def playerBoltOnScreen(self):
        """
        Returns True if a player bolt is on the screen; False otherwise
        """
        var = False
        for x in self._bolts:
            if x.getIsPlayerBolt():
                var = True
        return var

    def _deleteBolt(self):
        """
        Removes the bolt from _bolts once it leaves the game screen
        """
        for x in self._bolts:
            if x.y > GAME_HEIGHT + BOLT_HEIGHT/2 or x.y < -BOLT_HEIGHT/2:
                self._bolts.remove(x)

    def _boltCollision(self):
        """
        Determines if the bolt collides with the ship or the alien.

        The method removes the bolt from _bolts if a collision happens, and
        animates the collision between a bolt and the ship through a coroutine.
        The method also adds to the attribute _deadAliens each time a collision
        happens between a bolt and an alien.
        """
        for x in range(len(self._aliens)):
            for alien_pos in range(len(self._aliens[x])):
                for bolt in self._bolts:
                    if not self._aliens[x][alien_pos] is None:
                        if self._aliens[x][alien_pos].collides(bolt):
                            self._aliens[x][alien_pos] = None
                            self._bolts.remove(bolt)
                            self._deadAliens += 1
        if not self._ship is None:
            for bolt in self._bolts:
                if self._ship.collides(bolt):
                    self._bolts.remove(bolt)
                    self._animator = self._makeShipAnimator()
                    next(self._animator)

    def _runShipAnimator(self,dt):
        """
        The driver for the animation coroutine

        Parameter dt: The number of seconds since the last animation frame
        Precondition: dt is a float >= 0.0
        """
        if not self._animator is None:
            try:
                self._animator.send(dt)
            except:
                self._animator = None
                self._ship = None
                self._frame = 0
                self._timeShip = 0
                self._lives -= 1

    def _makeShipAnimator(self):
        """
        The animation coroutine.
        """
        while self._timeShip <= DEATH_SPEED:
            dt = (yield)
            self._frame = int((self._timeShip/DEATH_SPEED)*7)
            self._timeShip += dt


    # HELPER METHODS FOR COLLISION DETECTION
