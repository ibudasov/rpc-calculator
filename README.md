# Reverse Polish Calculator

Some of the best calculators in the world have an ‘RPN’ (reverse polish notation) mode.

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
