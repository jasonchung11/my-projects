"""
A test script to test the module funcs.py

Jason Chung jkc97
9.14.21
"""
import introcs      # For assert_equals and assert_true
import funcs        # This is what we are testing


# TEST PROCEDURE
def test_asserts():
    """
    This is a simple test procedure to help you understand how assert works
    """
    print('Testing the introcs asserts')
    introcs.assert_equals('b c', 'ab cd'[1:4])
    #introcs.assert_equals('b c', 'ab cd'[1:3])     # UNCOMMENT ONLY WHEN DIRECTED

    introcs.assert_true(3 < 4)
    introcs.assert_equals(3, 1+2)

    introcs.assert_equals(3.0, 1.0+2.0)
    #introcs.assert_equals(6.3, 3.1+3.2)            # UNCOMMENT ONLY WHEN DIRECTED

def test_has_a_vowel():
    """
    This is a simple test procedure to see if has_a_vowel() works
    """
    print('Testing function has_a_vowel')
    input = 'ooweoowowow'
    result = funcs.has_a_vowel(input)
    introcs.assert_equals(True,result)

def test_replace_first():
    """
    This is a simple test procedure to see if replace_first() works
    """
    print('Testing function replace_first')
    result = funcs.replace_first('jason','a',' ')
    introcs.assert_equals('j son',result)

# SCRIPT CODE (Call Test Procedures here)
test_asserts()
test_has_a_vowel()
test_replace_first()
print('Module funcs is working correctly')
