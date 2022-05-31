"""
A module with several recursive functions on sequences

YOUR NAME AND NETID HERE
THE DATE COMPLETED HERE
"""


# IMPLEMENT ALL OF THESE FUNCTIONS

def sum_list(thelist):
    """
    Returns the sum of the integers in list thelist.

        Example: sum_list([34]) is 34
        Example: sum_list([7,34,1,2,2]) is 46

    Parameter thelist: the list to sum
    Precondition: thelist is a list of ints
    """
    # 1. Handle Small data
    if len(thelist) == 0:
        return 0
    elif len(thelist) == 1:
        return thelist[0]

    # 2. Break into 2 parts
    left = thelist[0]
    right = sum_list(thelist[1:])

    # 3. Combine the result
    return left+right


def numberof(thelist, v):
    """
    Returns the number of times v occurs in thelist.

    Parameter thelist: The list to count from
    Precondition: thelist is a list of ints

    Parameter v: The value to count
    Precondition: v is an int
    """
    # HINT: Divide and conquer only applies to one of the arguments, not both

    # 1. Handle Small Data
    if len(thelist) == 0:
        return 0
    elif len(thelist) == 1:
        if v in thelist:
            return 1
        else:
            return 0

    # 2. Break into 2 parts
    left = numberof(thelist[:1],v)
    right = numberof(thelist[1:],v)

    # 3. Combine the result
    return left+right
# OPTIONAL EXERCISES

def remove_dups(thelist):
    """
    Returns a COPY of thelist with adjacent duplicates removed.

    Example: for thelist = [1,2,2,3,3,3,4,5,1,1,1]
    the answer is [1,2,3,4,5,1]

    Parameter thelist: The list to modify
    Precondition: thelist is a list of ints
    """
    # HINT: You can still do this with divide-and-conquer
    # The tricky part is combining the answers
    if thelist == []:
        return []
    elif len(thelist) == 1:
        return [thelist[0]]

        left = remove_dups(thelist[:1])
        right = remove_dups(thelist[1:])

        if left[0] == right[0]:
            return right
        else:
            return left+right


def number_not(thelist, v):
    """
    Returns the number of elements in thelist that are NOT v.

    Parameter thelist: the list to search
    Precondition: thelist is a list of ints

    Parameter v: the value to search for
    Precondition: v is an int
    """
    if thelist == []:
        return 0
    elif len(thelist) == 1:
        if thelist[0] == v:
            return 0
        else:
            return 1

    left = number_not(thelist[:1],v)
    right = number_not(thelist[1:],v)

    return left+right


def remove_first(thelist, v):
    """
    Returns a COPY of thelist but with the FIRST occurrence of v removed (if present).

    Note: This can be done easily using the method index. Don't do that.
    Do it recursively.

    Parameter thelist: the list to search
    Precondition: thelist is a list of ints

    Parameter v: the value to search for
    Precondition: v is an int
    """

    if thelist == []:
        return []
    elif len(thelist) == 1:
        if thelist[0] == v:
            return []
        else:
            return thelist

    left = remove_first(thelist[:1],v)

    if left == v or left == []:
        return thelist[1:]

    right = remove_first(thelist[1:],v)

    return left+right
