"""
A module devoted to while-loops

YOUR NAME(S) AND NETID(S) HERE
DATE COMPLETED HERE
"""


# REQUIRED FUNCTIONS
def duplicate_copy(nums,a):
    """
    Returns a COPY of nums but with all occurrences of a duplicated

    Examples: duplicate_copy([1,2,3,1], 1) returns [1,1,2,3,1,1].
              duplicate_copy([1,2,3,1], 4) returns [1,2,3,1].
              duplicate_copy([1,1], 1) returns [1,1,1,1].

    Parameter nums: list to copy
    Precondition: nums is a list of ints

    Parameter a: value to search for
    Precondition: a is an int
    """
    copy = []  # Accumulator
    i = 0
    # IMPLEMENT A WHILE LOOP HERE
    while i < len(nums):
        if nums[i] == a:
            copy.append(num[i])

        copy.append(num[i])
        i += 1
    # END WHILE LOOP

    # Return result
    return copy


def duplicate(nums,a):
    """
    MODIFIES thelist so that all occurrences of a are duplicated

    This function should have NO RETURN STATEMENT

    Examples: If a = [1,2,3,1] then a becomes [1,1,2,3,1,1] after duplicate(a,1).
              If a = [1,2,3,1] then a remains [1,2,3,1] after duplicate(a,4).

    Parameter nums: list to modify
    Precondition: nums is a list of ints

    Parameter a: value to search for
    Precondition: a is an int
    """
    # IMPLEMENT A WHILE LOOP HERE
    i = 0
    length = len(nums)
    while i < length:
        if nums[i] == a:
            nums.insert(i,nums[i])
            i += 1
            length += 1

        i += 1



    # END WHILE LOOP

    pass


# OPTIONAL FUNCTION
def exp(x,err=1e-6):
    """
    Returns the value of (e ** x) to with the given margin of error.

    Do NOT return (math.E ** x).  This function is more exact that that answer.

    The value (e ** x) is given by the Power Series

        1 + x + (x ** 2)/2 + (x ** 3)/3! + ... + (x ** n)/ n! + ...

    We cannot add up infinite values in a program.  So we APPROXIMATE (e ** x)
    by choosing a value n and stopping at that:

        1 + x + (x ** 2)/2 + (x ** 3)/3! + ... + (x ** n)/ n!

    The error of this approximation is

        abs( (x ** (n+1))/(n+1)!)

    which we want less than err.  So to compute e ** x, we just keep computing
    term = (x ** n)/ n! in a loop until this value is less than our error.  If it
    is not less than the error, we add it to the accumulator, which we return at
    the end.

    Hint: (x**(n+1))/(n+1)!  == (x**n)/n! * x/(n+1)
    Use this fact to simplify your loop.

    Parameter x: the exponent for e ** x
    Precondition: x is a numbers

    Parameter err: The margin of error (OPTIONAL: default is e-6)
    Precondition: err > 0 is a number
    """
    approx = 0.0  # Approximation of e ** x
    term   = 1.0  # 1 is the first term in the Power Series
    n = 0         # term 1 corresponds to (x ** 0)/0!

    # IMPLEMENT A WHILE LOOP HERE

    # END WHILE LOOP

    # Return result
    return approx
