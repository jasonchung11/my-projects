"""
User interface for module currency

When run as a script, this module prompts the user for two currencies and
an amount. It prints out the result of converting the first currency to
the second.

Author: Jason Chung (jkc97) and Nevin Motto (nam96)
Date:   22 September 2021
"""

import a1

src = input('Enter original currency: ')
dst = input('Enter desired currency: ')
amt = float(input('Enter original amount: '))
result = a1.exchange(src,dst,amt)
print('You can exchange ' + str(amt) + ' ' + src + ' for ' + str(result) + ' ' + dst + '.')
