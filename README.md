# Reverse Polish Calculator

The calculator has a stack that can contain real numbers.
• The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators.
• Numbers are pushed on to the stack. Operators operate on numbers that are on the stack. • Available operators are +, -, *, /, sqrt, undo, clear.
• Operators pop their parameters off the stack, and push their results back onto the stack.
• The ‘clear’ operator removes all items from the stack.
• The ‘undo’ operator undoes the previous operation. “undo undo” will undo the previo us two operations.
• sqrt performs a square root on the top item from the stack.
• The ‘+’, ‘-’, ‘*’, ‘/’ operators perform addition, subtraction, multiplication and division respectively on the top two items from the stack.
• After processing an input string, the calculator displays the current contents of the stack as a space-separated list.
• Numbers should be stored on the stack to at least 15 decimal places of precision, but displayed to 10 decimal places (or less if it causes no loss of precision).
• All numbers should be formatted as plain decimal strings (ie. no engineering formatting).
• If an operator cannot find a sufficient number of parameters on the stack, a warning is displayed:
operator <operator> (position: <pos>): insufficient parameters
• After displaying the warning, all further processing of the string terminates and the current state of the stack is displayed.

## Ideas behind the design

- I was trying to follow Hexagonal/DDD approach, by splitting the whole project to `domain`, `application`
  and `infrastructure` layers
- `infrastructure` layer contains only CLI interface, but later on — will be able to support also web interface
- All the calculator logic is contained in the `domain` layer, and adding a new operation shall not involve anything
  from `application` or `infrastructure` layers

## Install

`git clone git@github.com:ibudasov/rpn-calculator.git`

## Use

`MainKt.main` 👈 run it in your IDE 💁‍

## Todo

- not all the operations are supported: clear and undo are missing, but the foundation for them is there
- code coverage can be improved, but I believe, the main things are covered
- `Stack` is implemented on top of mutable `List`, which will cause troubles with multithreading
- formatting of the numbers is just not happening
- processing edge cases like not enough operands in the stack, division by `0`, etc
