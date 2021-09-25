# Ch.5 Separating Responsibilites

## Recall: OCP

- Open-Closed Principle: The code must be open for extension and closed for modification.
  1. For now, it is not open for six-pack requirements.
  2. So, identify the code smell and proceed.

## Identifying Patterns in Code

- Practice describing the characteristics of the code.
  - Any patterns that you see
  - Anything you like or hate
  - Anything you don't understand
- For me:
  - Container, Pronoun look similar and Quantity, Action, Successor look similar
  (each group has same conditional branch)

## Argument `number` is Ambiguous

- I haven't think about this, but after reading a book, I totall agree with this statement.

## Applying OOP

- Avoid conditions in OOP. Why?

## Primitive Obsession

- What is it? Why is it code smell?

## Object

- Object is not "thing", but "idea".
- What we make into object must be identified by its behavior, not characteristics.
- `name things in one higher level of abstraction` rule applies more to methods than to classes.

## Extracted Class

- First duplicate methods.
- Fully connect extracted class before modification.
- Then refactor.

## Benefits of Immutability

- **Thread Safe!!!!!!!!!!!!!!!**
- Easy to test

## Cache Performance

- [Hit Cost] + [Miss Rate] * [Miss Cost]

## I would prefer...

```ruby
class BottleNumber
  def successor
    if number == 0
      BottleNumber.new(99)
    else
      BottleNumber.new(number - 1)
    end
  end
end

class Bottles
  def verse(number)
    bottle_number = BottleNumber.new(number)
    next_bottle_number = bottle_number.successor
    # ...
  end
end
```

