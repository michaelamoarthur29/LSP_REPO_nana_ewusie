The Template Method pattern is implemented in the Report abstract class through the generateReport() method, which defines a fixed workflow: loadData(), formatHeader(), formatBody(), and formatFooter(). 
These methods are declared abstract and implemented by subclasses such as StudentReport and CourseReport, allowing variation in behavior while preserving the overall structure.
This ensures consistency across reports while enabling polymorphism, as each subclass provides its own implementation of the steps. 
The use of a List<Report> in the driver demonstrates polymorphism by treating different report types uniformly.
