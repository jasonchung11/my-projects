"""
Unit Test for Assignment A3

This module shows off what a good unit test for a3 should look like.

Jason Chung (jkc97), Nevin Motto (nam96)
8 October 2021
"""

import introcs
import a3


def test_complement():
    """
    Test function complement
    """
    print('Testing complement')

    # One test is really good enough here
    comp = a3.complement_rgb(introcs.RGB(250, 0, 71))
    introcs.assert_equals(255-250, comp.red)
    introcs.assert_equals(255-0,   comp.green)
    introcs.assert_equals(255-71,  comp.blue)

    # One more for good measure
    comp = a3.complement_rgb(introcs.RGB(128, 64, 255))
    introcs.assert_equals(255-128, comp.red)
    introcs.assert_equals(255-64,  comp.green)
    introcs.assert_equals(255-255, comp.blue)


def test_str5():
    """
    Test function str5
    """
    print('Testing str5')
    introcs.assert_equals('130.6',  a3.str5(130.59))
    introcs.assert_equals('130.5',  a3.str5(130.54))
    introcs.assert_equals('100.0',  a3.str5(100))
    introcs.assert_equals('100.6',  a3.str5(100.56))
    introcs.assert_equals('99.57',  a3.str5(99.566))
    introcs.assert_equals('99.99',  a3.str5(99.99))
    introcs.assert_equals('100.0',  a3.str5(99.995))
    introcs.assert_equals('22.00',  a3.str5(21.99575))
    introcs.assert_equals('21.99',  a3.str5(21.994))
    introcs.assert_equals('10.01',  a3.str5(10.013567))
    introcs.assert_equals('10.00',  a3.str5(10.000000005))
    introcs.assert_equals('10.00',  a3.str5(9.9999))
    introcs.assert_equals('9.999',  a3.str5(9.9993))
    introcs.assert_equals('1.355',  a3.str5(1.3546))
    introcs.assert_equals('1.354',  a3.str5(1.3544))
    introcs.assert_equals('0.046',  a3.str5(.0456))
    introcs.assert_equals('0.045',  a3.str5(.0453))
    introcs.assert_equals('0.006',  a3.str5(.0056))
    introcs.assert_equals('0.001',  a3.str5(.0013))
    introcs.assert_equals('0.000',  a3.str5(.0004))
    introcs.assert_equals('0.001',  a3.str5(.0009999))
    introcs.assert_equals('1.000',  a3.str5(1))
    introcs.assert_equals('0.000',  a3.str5(0.0000000001))


def test_str5_color():
    """
    Test the str5 functions for cmyk and hsv.
    """
    print('Testing str5_cmyk and str5_hsl')

    # Tests for str5_cmyk (add one more test)
    # We need to make sure the coordinates round properly
    text = a3.str5_cmyk(introcs.CMYK(98.448, 25.362, 72.8, 1.0))
    introcs.assert_equals('(98.45, 25.36, 72.80, 1.000)',text)

    text = a3.str5_cmyk(introcs.CMYK(0.0, 1.5273, 100.0, 57.846))
    introcs.assert_equals('(0.000, 1.527, 100.0, 57.85)',text)

    # Tests for str5_hsl (add two)
    text = a3.str5_hsl(introcs.HSL(269.1, 0.5654376554, 0.62))
    introcs.assert_equals('(269.1, 0.565, 0.620)', text)

    text = a3.str5_hsl(introcs.HSL(0.0, 0.432564, 1.0))
    introcs.assert_equals('(0.000, 0.433, 1.000)', text)


def test_rgb_to_cmyk():
    """
    Test translation function rgb_to_cmyk
    """
    print('Testing rgb_to_cmyk')

    # The function should guarantee accuracy to three decimal places
    rgb = introcs.RGB(255, 255, 255);
    cmyk = a3.rgb_to_cmyk(rgb);
    introcs.assert_equals(0.0, round(cmyk.cyan,3))
    introcs.assert_equals(0.0, round(cmyk.magenta,3))
    introcs.assert_equals(0.0, round(cmyk.yellow,3))
    introcs.assert_equals(0.0, round(cmyk.black,3))

    rgb = introcs.RGB(0, 0, 0);
    cmyk = a3.rgb_to_cmyk(rgb);
    introcs.assert_equals(0.0, round(cmyk.cyan,3))
    introcs.assert_equals(0.0, round(cmyk.magenta,3))
    introcs.assert_equals(0.0, round(cmyk.yellow,3))
    introcs.assert_equals(100.0, round(cmyk.black,3))

    rgb = introcs.RGB(217, 43, 164);
    cmyk = a3.rgb_to_cmyk(rgb);
    introcs.assert_equals(0.0, round(cmyk.cyan,3))
    introcs.assert_equals(80.184, round(cmyk.magenta,3))
    introcs.assert_equals(24.424, round(cmyk.yellow,3))
    introcs.assert_equals(14.902, round(cmyk.black,3))


def test_cmyk_to_rgb():
    """
    Test translation function cmyk_to_rgb
    """
    print('Testing cmyk_to_rgb')

    # We will now test the boundaries of C,M,Y,K as well as the values in
    # between with different decimal places
    cmyk = introcs.CMYK(0.0,0.0,0.0,100.0)
    rgb = a3.cmyk_to_rgb(cmyk)
    introcs.assert_equals(0,rgb.red)
    introcs.assert_equals(0,rgb.green)
    introcs.assert_equals(0,rgb.blue)

    cmyk = introcs.CMYK(0.0,0.0,0.0,0.0)
    rgb = a3.cmyk_to_rgb(cmyk)
    introcs.assert_equals(255,rgb.red)
    introcs.assert_equals(255,rgb.green)
    introcs.assert_equals(255,rgb.blue)

    cmyk = introcs.CMYK(45.6,78.08,21.435,34.0)
    rgb = a3.cmyk_to_rgb(cmyk)
    introcs.assert_equals(92,rgb.red)
    introcs.assert_equals(37,rgb.green)
    introcs.assert_equals(132,rgb.blue)

    cmyk = introcs.CMYK(100.0,0.0,0.0,0.0)
    rgb = a3.cmyk_to_rgb(cmyk)
    introcs.assert_equals(0,rgb.red)
    introcs.assert_equals(255,rgb.green)
    introcs.assert_equals(255,rgb.blue)

    cmyk = introcs.CMYK(0.0,100.0,0.0,0.0)
    rgb = a3.cmyk_to_rgb(cmyk)
    introcs.assert_equals(255,rgb.red)
    introcs.assert_equals(0,rgb.green)
    introcs.assert_equals(255,rgb.blue)

    cmyk = introcs.CMYK(0.0,0.0,100.0,0.0)
    rgb = a3.cmyk_to_rgb(cmyk)
    introcs.assert_equals(255,rgb.red)
    introcs.assert_equals(255,rgb.green)
    introcs.assert_equals(0,rgb.blue)


def test_rgb_to_hsl():
    """
    Test translation function rgb_to_hsv
    """
    print('Testing rgb_to_hsl')

    # Tests will include:
    # when the max of rgb = min of rgb
    rgb = introcs.RGB(100,100,100)
    hsl = a3.rgb_to_hsl(rgb)
    introcs.assert_equals(0.0,round(hsl.hue,3))
    introcs.assert_equals(0.0,round(hsl.saturation,3))
    introcs.assert_equals(0.392,round(hsl.lightness,3))

    # when the max of rgb is red and green>blue
    rgb = introcs.RGB(200,100,50)
    hsl = a3.rgb_to_hsl(rgb)
    introcs.assert_equals(20.0,round(hsl.hue,3))
    introcs.assert_equals(0.6,round(hsl.saturation,3))
    introcs.assert_equals(0.490,round(hsl.lightness,3))

    # when the max of rgb is red and blue > green
    rgb = introcs.RGB(255,20,69)
    hsl = a3.rgb_to_hsl(rgb)
    introcs.assert_equals(347.489,round(hsl.hue,3))
    introcs.assert_equals(1.0,round(hsl.saturation,3))
    introcs.assert_equals(0.539,round(hsl.lightness,3))

    # when the max of rgb is green
    rgb = introcs.RGB(100,200,90)
    hsl = a3.rgb_to_hsl(rgb)
    introcs.assert_equals(114.545,round(hsl.hue,3))
    introcs.assert_equals(0.5,round(hsl.saturation,3))
    introcs.assert_equals(0.569,round(hsl.lightness,3))

    # when the max of rgb is blue
    rgb = introcs.RGB(169,100,231)
    hsl = a3.rgb_to_hsl(rgb)
    introcs.assert_equals(271.603,round(hsl.hue,3))
    introcs.assert_equals(0.732,round(hsl.saturation,3))
    introcs.assert_equals(0.649,round(hsl.lightness,3))

    # when rgb is 0 0 0 (l == 0 => s = 0.0)
    rgb = introcs.RGB(0,0,0)
    hsl = a3.rgb_to_hsl(rgb)
    introcs.assert_equals(0.0,round(hsl.hue,3))
    introcs.assert_equals(0.0,round(hsl.saturation,3))
    introcs.assert_equals(0.0,round(hsl.lightness,3))

    # when rgb is maxed out
    rgb = introcs.RGB(255,255,255)
    hsl = a3.rgb_to_hsl(rgb)
    introcs.assert_equals(0.0,round(hsl.hue,3))
    introcs.assert_equals(0.0,round(hsl.saturation,3))
    introcs.assert_equals(1.0,round(hsl.lightness,3))


def test_hsl_to_rgb():
    """
    Test translation function hsv_to_rgb
    """
    print('Testing hsl_to_rgb')

    # Tests will include:
    # when Hi == 0 (H < 60)
    hsl = introcs.HSL(59.981,0.123,0.987)
    rgb = a3.hsl_to_rgb(hsl)
    introcs.assert_equals(252,rgb.red)
    introcs.assert_equals(252,rgb.green)
    introcs.assert_equals(251,rgb.blue)

    # Hi == 1
    hsl = introcs.HSL(70.696,0.1,0.82)
    rgb = a3.hsl_to_rgb(hsl)
    introcs.assert_equals(212,rgb.red)
    introcs.assert_equals(214,rgb.green)
    introcs.assert_equals(205,rgb.blue)

    # Hi == 2
    hsl = introcs.HSL(126.0,1.0,0.679)
    rgb = a3.hsl_to_rgb(hsl)
    introcs.assert_equals(91,rgb.red)
    introcs.assert_equals(255,rgb.green)
    introcs.assert_equals(108,rgb.blue)

    # Hi == 3
    hsl = introcs.HSL(200.567,0.0,1.0)
    rgb = a3.hsl_to_rgb(hsl)
    introcs.assert_equals(255,rgb.red)
    introcs.assert_equals(255,rgb.green)
    introcs.assert_equals(255,rgb.blue)

    # Hi == 4
    hsl = introcs.HSL(269.001,0.45,0.78)
    rgb = a3.hsl_to_rgb(hsl)
    introcs.assert_equals(198,rgb.red)
    introcs.assert_equals(174,rgb.green)
    introcs.assert_equals(224,rgb.blue)

    # Hi == 5
    hsl = introcs.HSL(315.43,0.64,0.38)
    rgb = a3.hsl_to_rgb(hsl)
    introcs.assert_equals(159,rgb.red)
    introcs.assert_equals(35,rgb.green)
    introcs.assert_equals(127,rgb.blue)

    # For the min of hsl.hue
    hsl = introcs.HSL(0.0,0.767,0.676)
    rgb = a3.hsl_to_rgb(hsl)
    introcs.assert_equals(236,rgb.red)
    introcs.assert_equals(109,rgb.green)
    introcs.assert_equals(109,rgb.blue)


def test_contrast_value():
    """
    Test translation function contrast_value
    """
    print('Testing contrast_value')

    # contrast == -1.0 (extreme)
    result = a3.contrast_value(0.0,-1.0)
    introcs.assert_floats_equal(0.5,result)

    result = a3.contrast_value(1.0,-1.0)
    introcs.assert_floats_equal(0.5,result)

    # contrast < 0, bottom part of sawtooth
    result = a3.contrast_value(0.1,-0.5)
    introcs.assert_floats_equal(0.3,result)

    # contrast < 0, middle of sawtooth
    result = a3.contrast_value(0.4,-0.4)
    introcs.assert_floats_equal(0.4571429,result)

    # contrast < 0, upper part of sawtooth
    result = a3.contrast_value(0.9,-0.3)
    introcs.assert_floats_equal(0.8142857,result)

    # contrast == 0.0, bottom part of sawtooth
    result = a3.contrast_value(0.1,0.0)
    introcs.assert_floats_equal(0.1,result)

    # contrast == 0, middle of sawtooth
    result = a3.contrast_value(0.6,0.0)
    introcs.assert_floats_equal(0.6,result)

    # contrast == 0.0, upper part of sawtooth
    result = a3.contrast_value(0.9,0.0)
    introcs.assert_floats_equal(0.9,result)

    # contrast > 0, bottom part of sawtooth
    result = a3.contrast_value(0.1,0.3)
    introcs.assert_floats_equal(0.05384615,result)

    # contrast > 0, middle of sawtooth
    result = a3.contrast_value(0.4,0.5)
    introcs.assert_floats_equal(0.2,result)

    # contrast > 0, upper part of sawtooth
    result = a3.contrast_value(0.9,0.4)
    introcs.assert_floats_equal(0.95714286,result)

    # contrast == 1.0 and value < 0.5
    result = a3.contrast_value(0.2,1.0)
    introcs.assert_floats_equal(0.0,result)

    # contrast == 1.0 and value >= 0.5
    result = a3.contrast_value(0.6,1.0)
    introcs.assert_floats_equal(1.0,result)


def test_contrast_rgb():
    """
    Test translation function contrast_value
    """
    print('Testing contrast_rgb')

    # Negative contrast
    rgb = introcs.RGB(240, 15, 118)
    hsv = a3.contrast_rgb(rgb,-0.4)
    introcs.assert_equals(220, rgb.red)
    introcs.assert_equals(35,  rgb.green)
    introcs.assert_equals(123, rgb.blue)

    # Positive Contrast
    rgb = introcs.RGB(120, 203, 12)
    hsv = a3.contrast_rgb(rgb,0.7)
    introcs.assert_equals(85, rgb.red)
    introcs.assert_equals(246,  rgb.green)
    introcs.assert_equals(2, rgb.blue)

    # Contrast = 0
    rgb = introcs.RGB(12, 168, 1)
    hsv = a3.contrast_rgb(rgb,0.0)
    introcs.assert_equals(12, rgb.red)
    introcs.assert_equals(168,  rgb.green)
    introcs.assert_equals(1, rgb.blue)

    # Contrast = 1
    rgb = introcs.RGB(251, 169, 15)
    hsv = a3.contrast_rgb(rgb,1.0)
    introcs.assert_equals(255, rgb.red)
    introcs.assert_equals(255, rgb.green)
    introcs.assert_equals(0, rgb.blue)


# Script Code (Prevents tests running on import)
if __name__ == "__main__":
    test_complement()
    test_str5()
    test_str5_color()
    test_rgb_to_cmyk()
    test_cmyk_to_rgb()
    test_rgb_to_hsl()
    test_hsl_to_rgb()
    test_contrast_value()
    test_contrast_rgb()
    print('Module a3 passed all tests.')
