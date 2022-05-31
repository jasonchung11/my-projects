"""
A simple die roller

Author: Jason Chung (jkc97)
Date: 9/2/21
"""

import random

first = int(input('Type the first number: '))
last = int(input('Type the last number: '))
print('Choosing two numbers between ' +str(first) +' and ' +str(last) +'.')

x = random.randint(first,last)
y = random.randint(first,last)

roll = x+y

print('The sum is ' +str(roll) +'.')
