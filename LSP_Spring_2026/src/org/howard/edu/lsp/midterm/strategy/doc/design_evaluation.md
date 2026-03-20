There are a number of problems with the current PriceCalculator design that make it challenging to expand and maintain.

First, the Open/Closed Principle is broken by the class. The calculatePrice method needs to be updated each time a new customer type or discount rule is added. This reduces the system's flexibility and raises the possibility of introducing bugs.

Second, a number of conditional statements (if statements) based on string comparisons are used in the design. This method is not scalable, and as more cases are added, the code becomes more difficult to read and maintain.

Third, the use of string literals like "REGULAR", "MEMBER", and "VIP" lacks type safety and increases the possibility of typos.

Additionally, there is little cohesiveness because all pricing logic is concentrated in one approach. To increase readability and modularity, each pricing rule should ideally be contained within its own class.

The design is a good candidate for refactoring using the Strategy Pattern because it is generally inflexible, tightly coupled, and difficult to extend.
