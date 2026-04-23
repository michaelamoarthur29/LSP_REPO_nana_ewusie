Heuristic 1:
Name:
H2.1: All data should be hidden within its class

Explanation:
This heuristic emphasizes encapsulation by requiring that data be kept private and only accessed through defined methods. In lecture, this was discussed as a way to protect the internal state of a class and reduce unintended interactions between classes. This improves maintainability because changes to the internal implementation do not affect other parts of the system.

Heuristic 2:
Name:
H3.2: Do not create god classes/objects in your system

Explanation:
This heuristic warns against having a single class that controls too much of the system’s logic. In lecture, the HeatFlowRegulator example showed how a central “controller” class can take on too many responsibilities, making the system harder to modify. Avoiding god classes improves readability and maintainability by distributing responsibilities across multiple classes.

Heuristic 3:
Name:
H2.9: Keep related data and behavior in one place

Explanation:
This heuristic states that data and the operations that act on that data should be grouped together within the same class. In lecture, this was illustrated by moving logic into the appropriate class instead of relying on external controller classes. This improves readability and maintainability by making classes more cohesive and easier to understand.
