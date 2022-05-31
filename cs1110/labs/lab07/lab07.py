"""
Module for implementing Lab 07 functions.

The first function first_vowel is a helper function of the second function
pigify (which is the primary function). Function pigify converts English words
to Pig-Latin.

IMPLEMENT both functions.

While you are encouraged to test your answers, you do not need to write a unit
test.

YOUR NAME AND NETID HERE
THE DATE COMPLETED HERE
"""

def first_vowel(w):
    """
    Returns: position of the first vowel; -1 if no vowels.

    Parameter w: the word to search
    Precondition: w is a nonempty string with only lowercase letters
    """
    if 'a' in w or 'e' in w or 'i' in w or 'o' in w or 'u' in w or 'y' in w[1:]:

        if 'a' in w:
            resultA = w.find('a')
        else:
            resultA = len(w)
        if 'e' in w:
            resultE = w.find('e')
        else:
            resultE = len(w)
        if 'i' in w:
            resultI = w.find('i')
        else:
            resultI = len(w)
        if 'o' in w:
            resultO = w.find('o')
        else:
            resultO = len(w)
        if 'u' in w:
            resultU = w.find('u')
        else:
            resultU = len(w)
        if 'y' in w[1:]:
            resultY = w.find('y')
        else:
            resultY = len(w)

        result = min(resultA,resultE,resultI,resultO,resultU,resultY)
        return result
    else:
        return -1


def pigify(w):
    """
    Returns: copy of w converted to Pig Latin

    See the lab handout for the complete rules on Pig Latin.

    Parameter w: the word to change to Pig Latin
    Precondition: w is a nonempty string with only lowercase letters
    """

    letter1 = w[0]

    if letter1 == 'a' or letter1 == 'e' or letter1 == 'i' or letter1 == 'o' or letter1 == 'u':
        w_vowel = w + 'hay'
        return(w_vowel)

    if letter1 == 'q':
        w_q = w[2:] + w[:2] + 'ay'
        return(w_q)

    if first_vowel(w) != -1:
        w_cons1 = w[first_vowel(w):] + w[:first_vowel(w)] + 'ay'
        return w_cons1

    elif first_vowel(w) == -1:
        w_cons2 = w + 'ay'
        return w_cons2
