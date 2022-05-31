"""
A simple application displaying a text and an image.

The purpose of this lab is to familiarize you with the basics of the game2d package.
This will help you get started on the last assignment.

<YOUR NAME HERE>
<DATE HERE>
"""
from game2d import *

#### CONSTANTS ####

# The initial width of the game display
GAME_WIDTH  = 840
# The initial height of the game display
GAME_HEIGHT = 630

# The initial state of the application
STATE_BEGIN  = 0
# After the font is loaded and initialized
STATE_FINISH = 1

# The number of steps between animation frames
FRAME_STEP = 5

class LabApp(GameApp):
    """
    The application class for this lab.

    In this lab, you will implement three hidden lab attributes.  Read the instructions
    and look at the constants above.
    """
    # HIDDEN ATTRIBUTES
    # Attribute _message: The message to display on the screen
    # Invariant: _message is a GLabel or None
    #
    # Attribute _image: The image to decorate the welcome message
    # Invariant: _image is a GTile, a GImage, or None
    #
    # Attribute _state: The current application state
    # Invariant: _state is one of STATE_BEGIN, STATE_FINISHED

    def start(self):
        """
        Initializes the application.

        This method is distinct from the built-in initializer __init__ (which
        you should not override or change). This method is called once the
        game is running.
        """
        self._message = GLabel(text = "Hello World!", font_name = "CuteFrog.ttf", font_size = 64, x = self.width/2, y = self.height/2)
        self._image = GImage(source = "heart.png", width = 128, height = 128, x = self.width/2, y = self.height/2)
        self._state = STATE_BEGIN

    # GImage(x = self.width/2, y = self.height/2, width = 128, height = 128, source = 'heart.png')
    def update(self,dt):
        """
        Updates the game objects each frame.

        This method is used when we want to change the objects (change the positions or
        add new objects) AFTER the application is initialized.  In our case, we need it
        because fonts do not finish loading until after start() has completed.
        """
        if self._state == STATE_BEGIN:
            messageBot = self._message.bottom
            self._image.top = messageBot
            self._state = STATE_FINISH

    def draw(self):
        """
        Draws the game objects to the view.

        Every single thing you want to draw in this game is a GObject. To draw a
        GObject g, simply use the method g.draw(self.view). It is that easy!
        """
        self._message.draw(self.view)




# Application code
if __name__ == '__main__':
    # Create and run the lab application
    LabApp(width=GAME_WIDTH,height=GAME_HEIGHT).run()
