# Reverse Polish Notation (RPN) Calculator

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

- I was trying to be as expressive in code as possible, by naming things according to domain terms and project
  requirements like: `SorryCannotFindSufficientNumberOfParametersInTheStack`
  , `Operation.performOperationAndAddResultToStack()`, etc., to make the code as clear as possible for those who
  understand the domain
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

- custom `Stack` implementation can go in favour of the one from SDK
- preserve stack between inputs, so the operations can be chained