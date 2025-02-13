"""
The class definition for the class lab

The class Length should meet the specification outlined below. It has two
(hidden) attributes accessible behind getters.  It has a __str__ method for
object representation and a method for converting from one unit to another.

Initial skeleton by W. White (wmw2)

YOUR NAME AND NETID HERE
THE DATE COMPLETED HERE
"""


class Length(object):
    """
    A class representing a measurement of length.

    Length is defined as a numerical value plus a unit of measurement.
    """
    # MUTABLE ATTRIBUTES
    # Attribute _value: The measured length
    #Invariant: _value is a float
    #
    # IMMUTABLE ATTRIBUTES
    # Attribute _unit: The unit of measurement
    #Invariant: _unit is a string and either 'ft' or 'm'


    # GETTERS AND SETTERS GO HERE

    def getUnit(self):
        return self._unit

    def getValue(self):
        return self._value

    def setValue(self,v):
        assert type(v) == float
        self._value = v

    def __init__(self,v,u='ft'):

        """
        A class representing a measurement of length.

        Length is defined as a numerical value plus a unit of measurement.
        """
        # MUTABLE ATTRIBUTES
        # Attribute _value: The measured length
        #Invariant: _value is a float
        #
        # IMMUTABLE ATTRIBUTES
        # Attribute _unit: The unit of measurement
        #Invariant: _unit is a string and either 'ft' or 'm'
        assert type(v) == float
        assert type(u) == str and u == 'ft' or u == 'm'
        self.setValue(v)
        self._unit = u
        # self.setValue(v)
        # self.setUnit(u)

    # __str__ METHOD

    def __str__(self):
        """
        Returns a string representation of the length

        Example: If l = Length(12.0,'m'), str(l) returns '12.0 m'
        """
        return str(self._value)+' '+self._unit


    # Method measure

    def measure(self,unit):
        """
        Returns the measurement value for the given unit.

        If unit is the same as getUnit(), this method returns the same as getValue().
        Otherwise, it converts the measure to the other unit.  Note that there are
        0.3048 meters (exactly) in a foot.

        Example: If l = Length(12.0,'ft'), then l.measure('ft') returns 12.0 but
        l.measure('m') returns 3.6576

        Parameter unit: The unit of measurement
        Precondition: unit is a string and either 'ft' or 'm'
        """
        assert type(unit) == str
        assert unit == 'ft' or unit == 'm'

        if unit == self._unit:
            return self._value

        elif unit == 'ft':
            # conversion from m to ft
            return (self._value / 0.3048)

        elif unit == 'm':
            # conversion from ft to m
            return (self._value * 0.3048)
