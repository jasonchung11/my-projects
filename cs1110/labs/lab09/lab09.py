"""
Module for implementing Lab 09 functions.

This module uses the Time class provided by the module time.  It contains two
functions: add_time1, add_time2.  You are to implement these functions.

YOUR NAME AND NETID HERE
THE DATE COMPLETED HERE
"""
from clock import Time


def add_time1(time1, time2):
    """
    Returns the sum of time1 and time2 as a new Time object

    DO NOT ALTER time1 or time2, even though they are mutable

    Examples:
        The sum of 12hr 13min and 13hr 12min is 25hr 25min
        The sum of 1hr 59min and 3hr 2min is 5hr 1min

    Parameter time1: the starting time
    Precondition: time1 is a Time object

    Parameter time2: the time to add
    Precondition: time2 is a Time object
    """
    Xhours = time1.hours
    Xminutes = time1.minutes
    Yhours = time2.hours
    Yminutes = time2.minutes

    final_minutes = Xminutes + Yminutes
    final_hours = Xhours + Yhours


    if final_minutes > 59:
        final_hours = final_hours + 1
        final_minutes = final_minutes - 60

    final_time = Time(final_hours,final_minutes)

    return final_time



def add_time2(time1, time2):
    """
    Modifies time1 to be the sum of time1 and time2

    DO NOT RETURN a new time object. Modify the object time1 instead.

    Examples:
        The sum of 12hr 13min and 13hr 12min is 25hr 25min
        The sum of 1hr 59min and 3hr 2min is 5hr 1min

    Parameter time1: the starting time
    Precondition: time1 is a Time object

    Parameter time2: the time to add
    Precondition: time2 is a Time object
    """

    Xhours = time1.hours
    Xminutes = time1.minutes
    Yhours = time2.hours
    Yminutes = time2.minutes

    final_minutes = Xminutes + Yminutes
    final_hours = Xhours + Yhours


    if final_minutes > 59:
        final_hours = final_hours + 1
        final_minutes = final_minutes - 60

    time1.hours = final_hours
    time1.minutes = final_minutes
    #time1 = Time(final_hours,final_minutes)
    #add_time1(final_hours,final_minutes)
