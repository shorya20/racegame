Student name:Shorya Sinha
Student number:200446066

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called [carcharacteristics]

This superclass is extended into at least two subclasses called [usercar and AIracers]

For each of the named subclasses complete the following...

Subclass 1. 

Subclass [usercar] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [position]

These/this new properties/property are used by the subclass in the following way: [The position of the userracer is used in the usercar subclass to set the changing position of the racer depending upon the outcome of the fight method in the mainclass. The position property is declared on line 7]

Subclass [usercar] extends the superclass by overriding the following methods (there must be at least one): [setClassplayer line28]

These overridden methods are used in the working code in the following places: [the SetClassplayer method is called in the mainclass(line90). The parameters of the setClassplayer takes in the userracerobj object of type carcharacteristics and integer points. This overriding method will call upon the superclass method of the same override method(setClassplayer) and change the calculation of the method by changing the values of the String instance variables of the userracerobj's playerclass, corneringrating,tenacityrating and aggressionrating from their pre-set values in the superclass method.]

Subclass 2. 

Subclass [AIracers] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [deadoralive (line11)]

These/this new properties/property are used by the subclass in the following way: [The boolean instance variable deadoralive will be called by the mainclass to check the whether the subclasses of the AIracers superclass, Goblin and Orc are deadoralive. This will be checked by calling upon the method deadoralive which takes an object of type carcharacteristics and calls upon the health instance variable to check whether it is less than or equal to 0. If it's true, then it sets the instance variable deadoralive to be true, if false, then the variable is set to false. The variable is then returned using the getter method getdeadoralive]

Subclass [AIracers] extends the superclass by overriding the following methods (there must be at least one): [setClassnonplayer (line19)]

These overridden methods are used in the working code in the following places: [setClassnonplayer method of the subclass AIracers is called upon by the mainclass to initialise and override the setClassnonplayer method in the carcharacteristics method. This is benefitial because AIracers acts as a superclass to the subclasses Orc and Goblin, therefore to implement the override methods for both the classes, we send the substitution principle object of superclass type carcharacteristics with subclass type AIracers declared AIobj (95 & 105). Then we declare another object myobj1/myobj2 which is also declared with substitution principle, but this time with AIracers as the superclass and Goblin/Orc as the subclass. After all these steps, then we call upon the setClassnonplayer of the myobj1/myobj2 instances, with sending the AIobj as the argument. This will set the default values for myobj. Now we can change those values by calling upon the Goblin subclass setClassnonplayer method using dynamic binding. ]


LEVEL TWO

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in [mainclass and line 47]. The name of the superclass used in this example is [carcharacteristics] and the subclasses used are [usercar].

Late dynamic binding can be seen in [mainclass (line 48,49)].

[This example of substitution principle used for polymorphism is an important factor as it initialises the usercar object tempmyobj with the superclass type being carcharacteristics. tempmyobj is to be assigned the same reference to userracerobj, and userracerobj will be used to further execute functions of the racing simulator such as: store and get points, store and get health, store and get race position, etc.]

Example 2.

The substitution principle can be seen in use in [mainclass and line 97,107]. The name of the superclass used in this example is [AIracers] and the subclasses used are [Goblin].

Late dynamic binding can be seen in [mainclass (99,100,101,etc.)].

[This example of polymorphism is an important factor as it initialises the Goblin and Orc objects myobj1/myobj2(racer types which are crucial for the simulation of this race). These 2 subclasses inherit from the same superclass AIracers and are a crucial factor in storing different types of AIracers in the arraylist allAIobjects. The superclass AIracers is also a subclass of the of the superclass carcharacteristics and therefore the instances myobj1/myobj2 which are to be stored in the Arraylist can perform overriding/access properties from the superclass carcharacteristics.]
