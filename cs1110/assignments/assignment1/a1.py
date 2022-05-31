"""
Module for currency exchange

This module provides several string parsing functions to implement a
simple currency exchange routine using an online currency service.
The primary function in this module is exchange.

Authors: Jason Chung (jkc97) and Nevin Motto (nam96)
Date:    22 September 2021
"""

import introcs


def before_space(s):
    """
    Returns a copy of s up to, but not including, the first space

    Parameter s: the string to slice
    Precondition: s is a string with at least one space
    """

    space = s.index(' ')
    before_s = s[:space]
    return before_s


def after_space(s):
    """
    Returns a copy of s after, but not including, the first space

    Parameter s: the string to slice
    Precondition: s is a string with at least one space
    """

    space = s.index(' ')
    after_s = s[space+1:]
    return after_s


def first_inside_quotes(s):
    """
    Returns the first substring of s between two (double) quotes

    A quote character is one that is inside a string, not one that
    delimits it.  We typically use single quotes (') to delimit a
    string if want to use a double quote character (") inside of it.

    Examples:
    first_inside_quotes('A "B C" D') returns 'B C'
    first_inside_quotes('A "B C" D "E F" G') also returns 'B C',
    because it only picks the first such substring

    Parameter s: a string to search
    Precondition: s is a string containing at least two double quotes
    """

    start = s.index('"')
    end = s.index('"', start+1)
    result = s[start+1:end]
    return result


def get_old(json):
    """
    Returns the original value in the response to a currency query

    Given a JSON response to a currency query, this returns the
    string inside double quotes (") immediately following the keyword
    "old". For example, if the JSON is

    '{ "err":"", "old":"1 Bitcoin", "new":"38781.518240835 Euros",
    "valid":true }'

    then this function returns '1 Bitcoin' (not '"1 Bitcoin"').

    This function returns the empty string if the JSON response
    contains an error message.

    Parameter json: a json string to parse
    Precondition: json is the response to a currency query
    """

    old_pos = json.index('old')
    after_old = json[old_pos+5:]
    result = first_inside_quotes(after_old)
    return result


def get_new(json):
    """
    Returns the converted value in the response to a currency query

    Given a JSON response to a currency query, this returns the
    string inside double quotes (") immediately following the keyword
    "new". For example, if the JSON is

    '{ "err":"", "old":"1 Bitcoin", "new":"38781.518240835 Euros",
    "valid":true }'

    then this function returns '38781.518240835 Euros' (not
    '"38781.518240835 Euros"').

    This function returns the empty string if the JSON response
    contains an error message.

    Parameter json: a json string to parse
    Precondition: json is the response to a currency query
    """

    new_pos = json.index('new')
    after_new = json[new_pos+5:]
    result = first_inside_quotes(after_new)
    return result

    # new_pos = json.index('"new":')
    # #print(new_pos)
    # start_new = json.index('"', new_pos+6)
    # #print(start_new)
    # end_new = json.index('"', start_new+1)
    # #print(end_new)
    # result = json[start_new+1:end_new]
    # #print(result)
    # return result


def has_error(json):
    """
    Returns True if the query has an error; False otherwise.

    Given a JSON response to a currency query, this returns the
    opposite of the value following the keyword "valid". For example,
    if the JSON is

    '{ "err":"Currency amount is invalid.", "old":"", "new":"", "valid":false }'

    then the query is not valid, so this function returns True (It
    does NOT return the message 'Source currency code is invalid').

    Parameter json: a json string to parse
    Precondition: json is the response to a currency query
    """

    valid_pos = json.index('"valid":')
    #print(valid_pos)
    start_valid = json.find('false', valid_pos+8)
    #print(start_valid)
    has_false = bool(start_valid+1)
    #print(has_false)
    return has_false


def query_website(src,dst,amt):
    """
    Returns a JSON string that is a response to a currency query.

    A currency query converts amt money in currency src to the
    currency dst. The response should be a string of the form

    '{ "err":"", "old":"<old-amt>", "new":"<new-amt>", "valid":true }'

    where the values old-amount and new-amount contain the value
    and name for the original and new currencies. If the query is
    invalid, both old-amount and new-amount will be empty, while
    "valid" will be followed by the value false (and "err" will have
    an error message).

    Parameter src: the currency on hand
    Precondition: src is a string with no spaces or non-letters

    Parameter dst: the currency to convert to
    Precondition: dst is a string with no spaces or non-letters

    Parameter amt: amount of currency to convert
    Precondition: amt is a float
    """

    web_address = 'http://cs1110.cs.cornell.edu/2021fa/a1?src='+src+'&dst=' \
    +dst+'&amt='+str(amt)
    json_returned = introcs.urlread(web_address)
    return json_returned


def is_currency(code):
    """
    Returns: True if code is a valid (3 letter code for a) currency
    It returns False otherwise.

    Parameter code: the currency code to verify
    Precondition: code is a string with no spaces or non-letters.
    """
    # ensure code is 3 letters and is upper
    # using has_error and query_website functions as supplements to execute
    # return True or False

    json_returned = query_website(code,'EUR',10.3)
    #print(json_returned)
    return not has_error(json_returned)


def exchange(src, dst, amt):
    """
    Returns the amount of currency received in the given exchange.

    In this exchange, the user is changing amt money in currency
    src to the currency dst. The value returned represents the
    amount in currency dst.

    The value returned has type float.

    Parameter src: the currency on hand
    Precondition: src is a string for a valid currency code

    Parameter dst: the currency to convert to
    Precondition: dst is a string for a valid currency code

    Parameter amt: amount of currency to convert
    Precondition: amt is a float
    """

    # json_string = query_website(src,dst,amt)
    # print(json_string)

    json_received = query_website(src,dst,amt)
    #sprint(json_received)
    new = get_new(json_received)
    #print(new)
    amount = float(before_space(new))
    #print(amount)
    return amount

    # use get_new and before_space!
