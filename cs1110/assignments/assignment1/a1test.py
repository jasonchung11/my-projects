"""
Test script for module a1

When run as a script, this module invokes several procedures that
test the various functions in the module a1.

Author: Jason Chung (jkc97) and Nevin Motto (nam96)
Date:   22 September 2021
"""

import introcs
import a1


def testA():
    """
    Test procedure for Part A
    """

    # testing funciton before_space with 1 space
    print('Testing function before_space')
    inputA = 'asdfkjskj dhbfdjv'
    before_result = a1.before_space(inputA)
    introcs.assert_equals('asdfkjskj',before_result)
    #testing function before_space with 2 separated spaces
    inputA2 = 'asdf asdf ghjk'
    before_result2 = a1.before_space(inputA2)
    introcs.assert_equals('asdf',before_result2)
    #testing function before_space with a string starting with a space
    inputA3 = ' asdfad'
    before_result3 = a1.before_space(inputA3)
    introcs.assert_equals('',before_result3)
    #testing function before_space with 2 consecutive spaces
    inputA4 = 'asdf  asdf'
    before_result4 = a1.before_space(inputA4)
    introcs.assert_equals('asdf',before_result4)

    # testing function after_space with 1 space
    print('Testing function after_space')
    after_result = a1.after_space(inputA)
    introcs.assert_equals('dhbfdjv',after_result)
    # testing function after_space with 2 separated spaces
    after_result2 = a1.after_space(inputA2)
    introcs.assert_equals('asdf ghjk',after_result2)
    # testing function after_space with a string starting with a space
    after_result3 = a1.after_space(inputA3)
    introcs.assert_equals('asdfad',after_result3)
    #testing function after_space with 2 consecutive spaces
    after_result4 = a1.after_space(inputA4)
    introcs.assert_equals(' asdf',after_result4)
    #testing function after_space with a string ending with a space
    inputA5 = 'asdfasdfasdf '
    after_result5 = a1.after_space(inputA5)
    introcs.assert_equals('',after_result5)



def testB():
    """
    Test procedure for Part B
    """

    # testing function first_inside_quotes with 1 pair
    print('Testing function first_inside_quotes')
    inputB = 'akseflh"hello"lsadkfj'
    resultB = a1.first_inside_quotes(inputB)
    introcs.assert_equals('hello',resultB)
    # testing function first_inside_quotes with 2 pairs
    inputB2 = 'aslkd"jsdk"skld"jdsas"sdkl'
    resultB2 = a1.first_inside_quotes(inputB2)
    introcs.assert_equals('jsdk',resultB2)
    # testing function first_inside_quotes with nothing inside quotes
    inputB3 = '""'
    resultB3 = a1.first_inside_quotes(inputB3)
    introcs.assert_equals('',resultB3)
    # testing function first_inside_quotes with nothing outside quotes
    inputB4 = '"asdf"'
    resultB4 = a1.first_inside_quotes(inputB4)
    introcs.assert_equals('asdf',resultB4)

    # testing function get_old
    print('Testing function get_old')
    input_json = '{ "err":"", "old":"1 Bitcoin", ' \
    '"new":"38781.518240835 Euros", "valid":true }'
    result_get_old = a1.get_old(input_json)
    introcs.assert_equals('1 Bitcoin',result_get_old)
    # testing function get_old with an invalid JSON
    input_json_error = '{ "err":"Currency amount is invalid.", "old":"", ' \
    ' "new":"", "valid":false }'
    result_get_old_err = a1.get_new(input_json_error)
    introcs.assert_equals('',result_get_old_err)

    # testing function get_new
    print('Testing function get_new')
    result_get_new = a1.get_new(input_json)
    introcs.assert_equals('38781.518240835 Euros',result_get_new)
    # testing function get_new with an invalid JSON
    result_get_new_err = a1.get_old(input_json_error)
    introcs.assert_equals('',result_get_new_err)


    # testing function has_error with a "valid":true
    print('Testing function has_error')
    result_has_error = a1.has_error(input_json)
    introcs.assert_equals(False,result_has_error)
    #testing function has_error with a "valid":false
    input_json_false = '{ "err":"Currency amount is invalid.", "old":"", ' \
    '"new":"", "valid":false }'
    result_has_error2 = a1.has_error(input_json_false)
    introcs.assert_equals(True,result_has_error2)


def testC():
    """
    Test procedure for Part C
    """

    # testing function query_website with proper inputs
    print('Testing function query_website')
    result_query_website = a1.query_website('USD','CUP',2.5)
    introcs.assert_equals('{ "err":"", "old":"2.5 United States Dollars", ' \
    '"new":"64.375 Cuban Pesos", "valid":true }',result_query_website)
    # testing function query_website with an improper source input
    result_query_website2 = a1.query_website('UgD','CUP',1093.2)
    introcs.assert_equals('{ "err":"Source currency code is invalid.", ' \
    '"old":"", "new":"", "valid":false }',result_query_website2)

    # testing function query_website with an improper exchange input
    result_query_website3 = a1.query_website('USD','CkP',9324.2)
    introcs.assert_equals('{ "err":"Exchange currency code is invalid.", ' \
    '"old":"", "new":"", "valid":false }',result_query_website3)


def testD():
    """
    Test procedure for Part D
    """

    # testing function is_currency (true)
    print('Testing function is_currency')
    result_is_currency = a1.is_currency('EUR')
    introcs.assert_equals(True,result_is_currency)
    # testing function is_currency (false)
    result_is_currency_false = a1.is_currency('ayo')
    introcs.assert_equals(False,result_is_currency_false)

    # testing function exchange for a conversion of 1.0 USD to AED, which
    # should yield the result of 3.6729 AED
    print('Testing function exchange')
    result_exchange = a1.exchange('USD','AED',1.0)
    introcs.assert_floats_equal(3.6729,result_exchange)
    # testing function exchange for a conversion of 1.0 AMD to CUP, which
    # should yield the result of 0.13040509177483 CUP
    result_exchange2 = a1.exchange('AMD','CUP',2.5)
    introcs.assert_floats_equal(0.13040509177483,result_exchange2)


testA()
testB()
testC()
testD()
print('Module a1 passed all tests.')
