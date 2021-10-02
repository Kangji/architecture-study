## Removing `if` statement

- Although the auther argued that the if-else statement should be removed in OOP,
  it has not been disappeared, rather it is just moved to extract class.
- So hereby in chapter 6, the author introduces factory pattern, which includes if-else branch that returns an object.
- Factory is a pattern that using branch only to determine which object to use, and each object contains the specified logic in its method, **without** branches.

## Factory Pattern is Beautiful lol

## But There is an issue with ISP in Ch.6

- It violates ISP, because class `BottleNumber0` doesn't need `pronoun()`.

