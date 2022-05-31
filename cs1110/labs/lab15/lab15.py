"""
A module with several recursive functions

YOUR NAME AND NETID HERE
THE DATE COMPLETED HERE
"""


# IMPLEMENT ALL OF THESE FUNCTIONS

def replace(thelist,a,b):
    """
    Returns a COPY of thelist but with all occurrences of a replaced by b.

    Example: replace([1,2,3,1], 1, 4) = [4,2,3,4].

    Parameter thelist: The list to count from
    Precondition: thelist is a list of ints

    Parameter a: The value to replace
    Precondition: a is an int

    Parameter b: The value to replace with
    Precondition: b is an int
    """
    # HINT: Divide and conquer only applies to one of the arguments, not all three
    if len(thelist) == 0:
        return thelist

    if len(thelist) == 1:

        if thelist[0] == a:
            return [b]
        else:
            return thelist

    left = replace(thelist[:1],a,b)
    right = replace(thelist[1:],a,b)

    return left+right


def oddsevens(thelist):
    """
    Returns a COPY of the list with odds at front, evens in the back.

    Odd numbers are in the same order as thelist. Evens are reversed.

    Example:
        oddsevens([3,4,5,6]) returns [3,5,6,4].
        oddsevens([2,3,4,5,6]) returns [3,5,6,4,2].
        oddsevens([1,2,3,4,5,6]) returns [1,3,5,6,4,2].

    Parameter thelist: The list to modify
    Precondition: thelist is a list of ints (may be empty)
    """


    if thelist == [] or len(thelist) == 1:
        return thelist

    left = oddsevens(thelist[:1])
    right = oddsevens(thelist[1:])

    if (left[0] % 2) == 1:
        return left + right
    else:
        return right + left
    # HINT: How you break up the list is important.  A bad division will
    # make it almost impossible to combine the answer together.
    # However, if you look at all three examples in the specification you
    # will see a pattern that should help you define the recursion.

    # if type(thelist) == int:
    #     return [thelist]
    # if len(thelist) == 0:
    #     return thelist
    #
    # left = oddsevens(thelist[0])
    # right = oddsevens(thelist[1:])
    #
    # if (left[0] % 2) == 1:
    #     return left+right
    # else:
    #     return right+left

    if len(thelist) == 0 or len(thelist) == 1:
        return thelist

    left = oddsevens(thelist[:1])
    right = oddsevens(thelist[1:])

    if (left[0] % 2) == 1:
        return left+right
    else:
        return right+left

# OPTIONAL EXERCISES

def flatten(thelist):
    """
    Returns a COPY of thelist flattened to remove all nested lists

    Flattening takes any nested list and recursively dumps its contents into the
    parent list.

    Examples:
        flatten([[1,2],[3,4]]) is [1,2,3,4]
        flatten([[1,[2,3]],[[4],[5,[6,7]]]]) is [1,2,3,4,5,6,7]
        flatten([1,2,3]) is [1,2,3]

    Parameter thelist: the list to flatten
    Precondition: thelist is a list of either ints or lists which satisfy the precondition
    """
    if thelist == []:
        return []



### Numeric Examples ###

def sum_to(n):
    """
    Returns the sum of numbers 1 to n.

        Example: sum_to(3) = 1+2+3 = 6,
        Example: sum_to(5) = 1+2+3+4+5 = 15

    Parameter n: the number of ints to sum
    Precondition: n >= 1 is an int.
    """
    return 0 # Stub return.  Replace this.


def num_digits(n):
    """
    Returns the number of the digits in the decimal representation of n.

        Example: num_digits(0) = 1
        Example: num_digits(3) = 1
        Example: num_digits(34) = 2
        Example: num_digits(1356) = 4

    Parameter n: the number to analyze
    Precondition: n >= 0 is an int
    """
    return 0 # Stub return.  Replace this.


def sum_digits(n):
    """
    Returns the sum of the digits in the decimal representation of n.

        Example: sum_digits(0) = 0
        Example: sum_digits(3) = 3
        Example: sum_digits(34) = 7
        Example: sum_digits(345) = 12

    Parameter n: the number to analyze
    Precondition: n >= 0 is an int.
    """
    return 0 # Stub return.  Replace this.


def number2(n):
    """
    Returns the number of 2's in the decimal representation of n.

        Example: number2(0) = 0
        Example: number2(2) = 1
        Example: number2(234252) = 3

    Parameter n: the number to analyze
    Precondition: n >= 0 is an int.
    """
    return 0 # Stub return.  Replace this.


def into(n, c):
    """
    Returns the number of times that c divides n,

        Example: into(5,3) = 0 because 3 does not divide 5.
        Example: into(3*3*3*3*7,3) = 4.

    Parameter n: the number to analyze
    Precondition: n >= 1 is an int

    Parameter c: the number to divide by
    Precondition: c > 1 are ints.
    """
    return 0 # Stub return.  Replace this.


# IF YOU REALLY WANT A CHALLENGE
def related(p,q):
    """
    Returns True if Persons p and q are related; False otherwise.

    We say that two people are related if they have a common person in their family
    tree (including themselves). A recursive way of saying this is that they are
    related if

        (1) they are the same person, or
        (2) one is related to an ancestor (parent, grandparent, etc.) of another

    If either p or q is None, this function returns False.

    Parameter p: a person to compare
    Precondition: p is a Person object OR None

    Parameter q: a person to compare
    Precondition: q is a Person object OR None
    """
    return False # Stub return.  Replace this.
