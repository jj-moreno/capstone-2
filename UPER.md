<h1>The Problem Solving Framework : 'UPER'</h1>

- U = "Understand"
- P = "Plan"
- E = "Execute"
- R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
* Minimum Viable Product is to create an ascii-based game, aka terminal based 2D game in Java from available list of game ideas (not required to choose from this list but highly encouraged to pick one from this list). Optionally, GUI 2D game can be created for bonus points.
* Must showcase object-oriented programming and design skills by creating Java classes that adhere to the four pillars of Object Oriented Programming using at least 1 interface and 1 abstract class. 
* Implement some functional based programming by using at least 1 lambda expression and 1 stream.
* End product must be functional and playable by a user (include instructions for player in the player-user view and insructions.md file).
* Project structure must maintain organization by packaging java files in a logical manner (1 package minimum)
* Write error handling (try-catch) for bad user input (incorrect key presses or invalid player-user movement)
* Will go for bonus by implementing a 3rd party Java library for game development from available 3rd party Java library list in README.md. 
<h2>
    2. Planning the Solution
</h2>
* Pick a game and plan the design at a high level using a UML class diagram. 
* Will research through the 3rd party Java library list and pick one to implement in java project. After picking one I will need to research the steps for setup/configuration and look at the available classes and class functionality in the library for implementation into Java project.
* Each game object will have its mechanics based on game environment and object functionality. The movements of a player-controlled game object are bounded by many factors; by its environment, the object functionality capacity, certain location of game object in environment, and loss of player control at certain game time intervals for dynamic changes to environment based on game outcomes. 
* Must develop the game environment, the game object(s)' properties (state) and functionality, cause and effect to object(s) state based and object interaction with game environment and any other game objects.  
* Provide instructions to player-user visually either in landing/initial load screen or always displayable in the game environment.
* Must provide error handling which means to not allow incorrect input to create a side effect (unhandled game behavior) in the game. If player-user chooses to unintentionally or intentionally give incorrect input to the player controlled game object, it must not react with behavior i.e. call functionality to change its state. In other words, the game object only functions and by consequence changes state for correct player-user input.  
* A good game not only bounds player-user inputs as good error handling but it also bounds the game object within the game environment even for correct player-user inputs i.e. the player-controlled game object state and functionality is blocked because of a collision to the bounds of the game environment (or other game objects) or when the game itself takes over game control to either bring the game to an end or to change game environment state.
* Finally develop an end to the game (all good things come to an end) and give notification to whether the player controlled game object successfully or unsuccessfully accomplished the tasks in the game.
<h2>
    3. Executing the Plan
</h2>
* I picked the pac man game and will create UML class diagram using draw.io website. 
* Designing my project with UML class diagram before coding which entails creating the game character objects by declaring each object's state and functionality.
* Researched the 3rd party java game development libraries seen in the list from the README.md and will use the litiengine since it uses maven and I have previous experience creating and working with Maven projects.
*
*
*
*
*
<h2>
    4. Reflection / Refactor
</h2>
*
*
*
*
*
*
*
*
