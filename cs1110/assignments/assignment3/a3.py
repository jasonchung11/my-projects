"""
Functions for Assignment A3

This file contains the functions for the assignment. You should replace the
stubs with your own implementations.

Jason Chung (jkc97), Nevin Motto (nam96)
8 October 2021
"""


import introcs
import math


def complement_rgb(rgb):
    """
    Returns the complement of color rgb.

    Parameter rgb: the color to complement
    Precondition: rgb is an RGB object
    """
    return introcs.RGB(255-rgb.red, 255-rgb.green, 255-rgb.blue)


def str5(value):
    """
    Returns value as a string, but expanded or rounded to be exactly 5
    characters.

    The decimal point counts as one of the five characters.

    Examples:
        str5(1.3546)  is  '1.355'.
        str5(21.9954) is  '22.00'.
        str5(21.994)  is  '21.99'.
        str5(130.59)  is  '130.6'.
        str5(130.54)  is  '130.5'.
        str5(1)       is  '1.000'.

    Parameter value: the number to conver to a 5 character string.
    Precondition: value is a number (int or float), 0 <= value <= 360.
    """
    float_value = float(value)
    if float_value >= 100.0 and float_value <= 360.0:
        rounded_value = round(float_value,1)

    elif float_value >= 10 and float_value < 100:
        rounded_value = round(float_value,2)

    elif float_value < 10 and float_value >= 0:
        rounded_value = round(float_value,3)

    str_rounded_value = str(rounded_value)

    if len(str_rounded_value) < 5:
        str_rounded_value = str_rounded_value + '0'
    if len(str_rounded_value) < 5:
        str_rounded_value = str_rounded_value + '0'

    return str_rounded_value


def str5_cmyk(cmyk):
    """
    Returns the string representation of cmyk in the form "(C, M, Y, K)".

    In the output, each of C, M, Y, and K should be exactly 5 characters long.
    Hence the output of this function is not the same as str(cmyk)

    Example: if str(cmyk) is

          '(0.0,31.3725490196,31.3725490196,0.0)'

    then str5_cmyk(cmyk) is '(0.000, 31.37, 31.37, 0.000)'. Note the spaces
    after the commas. These must be there.

    Parameter cmyk: the color to convert to a string
    Precondition: cmyk is an CMYK object.
    """

    str_return = '(' + str5(cmyk.cyan) + ', ' + str5(cmyk.magenta) + ', ' \
    + str5(cmyk.yellow) + ', ' + str5(cmyk.black) + ')'
    return str_return


def str5_hsl(hsl):
    """
    Returns the string representation of hsl in the form "(H, S, L)".

    In the output, each of H, S, and L should be exactly 5 characters long.
    Hence the output of this function is not the same as str(hsv)

    Example: if str(hsl) is

          '(0.0,0.313725490196,0.5)'

    then str5_hsv(hsl) is '(0.000, 0.314, 0.500)'. Note the spaces after the
    commas. These must be there.

    Parameter hsl: the color to convert to a string
    Precondition: hsl is an HSL object.
    """
    str_return = '(' + str5(hsl.hue) + ', ' + str5(hsl.saturation) + ', ' \
     + str5(hsl.lightness) + ')'
    return str_return


def rgb_to_cmyk(rgb):
    """
    Returns a CMYK object equivalent to rgb, with the most black possible.

    Formulae from https://www.rapidtables.com/convert/color/rgb-to-cmyk.html

    Parameter rgb: the color to convert to a CMYK object
    Precondition: rgb is an RGB object
    """
    # The RGB numbers are in the range 0..255.
    # Change the RGB numbers to the range 0..1 by dividing them by 255.0.
    r = rgb.red/255.0
    g = rgb.green/255.0
    b = rgb.blue/255.0
    k = 1 - max(r,g,b)

    if k == 1:
        c = m = y = 0.0
        k = 100.0
    else:
        c = (1-r-k)/(1-k)*100.0
        m = (1-g-k)/(1-k)*100.0
        y = (1-b-k)/(1-k)*100.0
        k = k*100.0

    return introcs.CMYK(c,m,y,k)


def cmyk_to_rgb(cmyk):
    """
    Returns an RGB object equivalent to cmyk

    Formulae from https://www.rapidtables.com/convert/color/cmyk-to-rgb.html

    Parameter cmyk: the color to convert to a RGB object
    Precondition: cmyk is an CMYK object.
    """
    # The CMYK numbers are in the range 0.0..100.0. Deal with them in the
    # same way as the RGB numbers in rgb_to_cmyk()

    c = cmyk.cyan/100.0
    m = cmyk.magenta/100.0
    y = cmyk.yellow/100.0
    k = cmyk.black/100.0

    r = round((1-c)*(1-k)*255)
    g = round((1-m)*(1-k)*255)
    b = round((1-y)*(1-k)*255)

    return introcs.RGB(r,g,b)


def rgb_to_hsl(rgb):
    """
    Return an HSL object equivalent to rgb

    Formulae from https://en.wikipedia.org/wiki/HSL_and_HSV

    Parameter rgb: the color to convert to a HSL object
    Precondition: rgb is an RGB object
    """

    r = rgb.red/255
    g = rgb.green/255
    b = rgb.blue/255
    M = max(r,g,b)
    m = min(r,g,b)

    if M == m:
        h = 0.0
    elif M == r and g >= b:
        h = 60.0 * (g-b)/(M-m)
    elif M == r and g < b:
        h = 60.0 * (g-b)/(M-m) + 360.0
    elif M == g:
        h = 60.0 * (b-r)/(M-m) + 120.0
    elif M == b:
        h = 60.0 * (r-g)/(M-m) + 240.0

    l = (M+m)/2.0

    if l == 0.0 or l == 1.0:
        s = 0.0

    else:
        s = (M-l)/min(l,1.0-l)

    return introcs.HSL(h,s,l)


def hsl_to_rgb(hsl):
    """
    Returns an RGB object equivalent to hsl

    Formulae from https://en.wikipedia.org/wiki/HSL_and_HSV

    Parameter hsl: the color to convert to a RGB object
    Precondition: hsl is an HSL object.
    """

    H = hsl.hue
    S = hsl.saturation
    L = hsl.lightness

    Hi = math.floor(H/60)
    f = H/60 - Hi
    c = min(L,1-L)*S
    p = L + c
    q = L - c
    u = L - (1 - 2*f) * c
    v = L + (1 - 2*f) * c

    if Hi == 0 or Hi == 5:
        r = p
    elif Hi == 1:
        r = v
    elif Hi == 2 or Hi == 3:
        r = q
    elif Hi == 4:
        r = u

    if Hi == 0:
        g = u
    elif Hi == 1 or Hi == 2:
        g = p
    elif Hi == 3:
        g = v
    elif Hi == 4 or Hi == 5:
        g = q

    if Hi == 0 or Hi == 1:
        b = q
    elif Hi == 2:
        b = u
    elif Hi == 3 or Hi == 4:
        b = p
    elif Hi == 5:
        b = v

    r = round(r*255)
    g = round(g*255)
    b = round(b*255)

    return introcs.RGB(r,g,b)


def contrast_value(value,contrast):
    """
    Returns value adjusted to the "sawtooth curve" for the given contrast

    At contrast = 0, the curve is the normal line y = x, so value is
    unaffected. If contrast < 0, values are pulled closer together, with all
    values collapsing to 0.5 when contrast = -1.  If contrast > 0, values are
    pulled farther apart, with all values becoming 0 or 1 when contrast = 1.

    Parameter value: the value to adjust
    Precondition: value is a float in 0..1

    Parameter contrast: the contrast amount (0 is no contrast)
    Precondition: contrast is a float in -1..1
    """
    x = value
    c = contrast

    if c >= -1 and c < 1:

        if x < (0.25 + 0.25*c):
            y = ((1-c)/(1+c)) * x

        elif x > (0.75 - 0.25*c):
            y = ((1-c)/(1+c)) * (x - (3-c)/4) + (3+c)/4

        else:
            y = ((1+c)/(1-c)) * (x - (1+c)/4) + (1-c)/4

    elif c == 1:

        if x >= 0.5:
            y = 1

        else:
            y = 0

    return y


def contrast_rgb(rgb,contrast):
    """
    Applies the given contrast to the RGB object rgb

    This function is a PROCEDURE.  It modifies rgb and has no return value.
    It should apply contrast_value to the red, blue, and green values.

    Parameter rgb: the color to adjust
    Precondition: rgb is an RGB object

    Parameter contrast: the contrast amount (0 is no contrast)
    Precondition: contrast is a float in -1..1
    """

    r = rgb.red/255
    g = rgb.green/255
    b = rgb.blue/255

    sca_r = contrast_value(r,contrast)
    sca_g = contrast_value(g,contrast)
    sca_b = contrast_value(b,contrast)

    rgb.red = round(sca_r * 255)
    rgb.green = round(sca_g * 255)
    rgb.blue = round(sca_b * 255)
