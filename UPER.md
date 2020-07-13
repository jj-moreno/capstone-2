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
* Finally, develop an end to the game and give notification to whether the player controlled game object successfully or unsuccessfully accomplished the tasks in the game.
<h2>
    3. Executing the Plan
</h2>
* I picked the pac man game and will create UML class diagram using draw.io website. 
* Designing my project with UML class diagram before coding which entails creating the game character objects by declaring each object's state and functionality.
* Researched the 3rd party java game development libraries seen in the list from the README.md and will use the LITIengine since it uses maven and I have previous experience creating and working with Maven projects.
* I have now reverted to developing the game using the 1st party graphics library from Java under name (AWT and Swing). I am following a tutorial named "Let's build PAC-MAN" by Youtuber Java Game Development. 
* I dug up more research and picked up learning curve on the Tiled map editor program and utiLITI program and believe now I will be able to use the 3rd party library.
* Back to implementing the Pac Man game with 1st party Java graphics library as seen in tutorial.
* Implementing a nice map and finishing out the tutorial with pac man object eating coins and providing Artificial Intelligence to ghosts objects to chase pac man.
* I will now be making another pivot in this project, I will be implementing a simpler map which correlates better to the pac man build game tutorial since AI functionality shown works much better on a simple map.
<h2>
    4. Reflection / Refactor
</h2>
* After a day and a half of research and implementation on the LITIengine Java game development library, I will not be using the 3rd party library. I am not able to render the map file using the utiliLITI program which is required as a resource by the developers of the library. 
* Youtube tutorial seemed fairly simple, I will challenge myself more and give LITIengine library one more chance.
* Apparently, utiLITI program created by the same creators of LITIengine is not compatible with the latest Tiled map editor program. Found and downloaded backwards compatibility program but now my java program does not want to read the game data resource file created by utiLITI program.
* Everything is going well, my game map is rendering in Java. Now I have developed some skill with Tiled map editor, I will make a map closer to the real pac man game this is different from tutorial.
* Having so much trouble getting my ghosts to chase pac man properly. After hours and hours of trying to fix the AI chase functionality for the ghosts on a more complicated map from the tutorial, I am concluding the AI for ghosts needs refactoring for a more complex map. 
* After so many blockers, I am happy to have learned a lot about Java game development. I learned that good documentation for source code libraries is super important. Also learned that making computer games is challenging and complex.
* The complexity of this capstone taught me the necessity of advanced Java topics like S.O.L.I.D. principles and design patterns. I hope to make bigger leaps in this subject with more study, practice, and experience.
* If I had another 24 hours, I would first revise and refactor existing code. Then create a graphics menu screen for onscreen instructions and win/loss notification.
