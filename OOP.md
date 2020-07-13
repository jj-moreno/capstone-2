Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation
 - Used for protecting direct access to properties of a class by making the properties private and bundling the data in those properties with methods that operate on that data. 
 - I create an Employee class, and I want to protect properties like ssn and salary from being manipulated or read. 
 - Many times another class may not need to know the ssn of an employee or if another class is allowed to update salary then we establish a setter function but with a criterion check.





********************
2. Inheritance

 - Used to establish a parent and child relationship between classes for code reusability and efficiency. 
 - Example is if we have a Creature class and we want to establish a more specific Creature class like dog, bear, or lion. Then we can establish properties and behavior that is common among creatures. 
 - Some of those commonalities can be created in the Creature class like hunger level or type of skin property and eat or sleep behavior.
 - Then we create Dog, bear, and Lion classes that extend from Creature class to inherit those properties and methods previously mentioned in Creature class.
 - This is code reusability, we don't repeat ourselves and we make our programs more efficient.



********************
3. Abstraction
 - Used to take out unnecessary details and focus solely on general perception of an entity to conceptualize the entity, and it's functionality.
 - We can have abstract classes and abstract methods and this allows abstract classes to hand down methods as concepts (with no implementation details given). 
 - The benefit is the subclasses have a conceptual perception on how to implement functionality.
 - If we have a Hunt interface, or an Abstract Creature class, then any implementing class can take on the functionality in Hunt interface or Creature class by taking in the conceptual aspects of each.  






********************
4. Polymorphism
 - Used to conceptualize entities into multiple perceptions by overriding inherited functionality from inherited classes and or providing method implementation from abstract classes.
 - Ex: Creature class has a move() method and each subclass of Creature has move() method handed down to it and it can use method overriding to implement its own move functionality. 
- Ex: Creature also implements Hunt interface and now a Creature subclass can take on multiple perceptions by implementing its own perception on functionality for move() and hunt() methods.  




Please write 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  



