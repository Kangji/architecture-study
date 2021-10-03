### Chapter 6: Achieving Openness

- In this chapter, we will make the code open to the six-pack requirement.
- 6.1. Consolidating Data Clumps
    - container and quantity occurs together for three times, and they can be considered as a data clump.
    - One might ask that it can be a `verse specific` logic, however this modification significantly simplified the code.
- 6.2. Making Sense of Conditionals
    - Martin Fowler offers several curative refactoring recipes.
        - Replace Conditional with State/Strategy
            - removes conditionals by dispersing their branches into new, smaller objects → composition
        - Replace Conditional with Polymorphism
            - use *inheritance*
        - Skilled programmers are able to know what's right before they do it. They are not innate to do that: it is the result of a lifetime of coding experiment.
        - Let's remove if-else tense!
- 6.3. Replacing Conditionals with Polymorphism
    - 6.3.1. Dismembering Conditionals
        - Introduction of `BottleNumber0` which can replace the `number == 0` branch.
    - 6.3.2. Manufacturing Objects
        - Introduction of the `Factory` which can choose the right class for given condition.
        - The willful ignorance of type is fundamental to OOP!
    - 6.3.3. Prevailing with Polymorphism
        - Replace `number == 1` branch with `BottleNumber1` following the previous steps.
        - [Q] Is the code better than introducing the Polymorphism?
        - Domain questions:

            ```
            1. How many verse variants are there?
            2. Which verses are most alike? In what way?
            3. Which verses are most different? In what way?
            4. What is the rule to determine which verse should be sung next?
            ```

- 6.4. Transitioning Between Types
    - [Q] Why the `successor` method in `BottleNumber` violates the `Liskov Substitute Principle`?
        - As the code resolved the `Primitive Obsession` by introducing `BottleNumber`, it is not proper to use `int` anymore.
        - I don't understand ☹️
        - [https://reflectoring.io/lsp-explained/](https://reflectoring.io/lsp-explained/)
    - Need to read `p.166` again!
- 6.5. Making the Easy Change
    - You can satisfy the `six-pack requirment` by easily adding a new class that stands for bottle number 6.
    - "Make the change easy, then make the easy change." - Kent Beck
- 6.6. Defending the Domain
    - You need to defend the requirements of `BottleNumber` to make it reusable.
    - "Clever shortcuts are a false economy. Invest in code that tells the truth. Just write it down."
- 6.7. Summary
    - We have make the class open to the change, "six-pack requirement." We introduced a factory method to make it open. In #7, we are now exploring different styles of factories.
