# Cluedo

# Work Completed
Authors: Cian Lawlor, Dannie Zhang.
Classes: Card (charCard, weaponCard and RoomCard) and Pawn (weaponPawn and charPawn)

Author: Cian Lawlor
Classes: Board, Room, Game and Player(Movement methods)
TestCase: All joint written and above classes

Author: Dannie Zhang
Classes: Hypothesis, Map and player(Accusation methods and Notebook, card methods), Game(create player, select characters before split, findHolders, findRoom)
TestCase: Above classes

# Game functionality
This program is a Cluedo board game. It contains three parts: creating players, making movements, and make hypothesis/accusation.

Creating Players:
At the start of the game, the players will be asked to input the number of the players. The input number should only be an integer between 3 and 6. If the input is a integer outside this range or an character, the system will go back to ask for another input until the input is within this range. 

After this step, the system will goes into a loop to ask each players to input their user name and select their character pawn. The user name can not be duplicate and if the system test out the current user name is duplicated to another user name it will ask for another one. 

Before choosing their preferred character pawn, the system will print out every available character pawn for players to choose. Similarly, the player are only allowed to input an integer between 1 and the length of the character list. Once one character is selected, it will be removed from the available character list.

Once a player is created, he/she will be automatically get some cards.

Making Movement:
At the start of each turn, the players are told what positions they are in and asked if they want to check their notebooks and cards list. Then the dices are automatically rolled and they will be asked which direction they want to go. If they choose not to stay at the same place, they will have to input a number of steps they want to move. The steps should be less then the number they rolled. If the number is larger then the dice number or they input a character then the system will ask for another input. Before ending the movement, they will be told which place they are in(corridor or the name of the rooms).

Making Hypothesis/Accusation:
Only when they are in the room could they make the hypothesis or accusation. 

When they make the hypothesis, they will be asked to select the suspects and weapons from the character list and weapon list. Only an integer between 1 and list length is acceptable, any other inputs will lead to another demanding of input. 

For hypothesis, once the three elements(suspect, weapon, room) are set, they system will search the card related these elements from the previous player. Once a card is found, then the hypothesis is refuted. If none of the card is found, the system will show "nothing has been found". The player who raise the hypothesis will know the result immediately by a dialogue frame. The others could only know the result when they check their notebooks.

For accusation, after the three elements are set, the system will confirm with they player it he/she wants to go on with this hypothesis, if they choose yes then the accusation will be processed, if they choose no their turn will be finished. If they choose yes, the system will compare the accusation with the answer, if the accusation is correct, the system will print out "congratulations, you win the game", if not it will print out "sorry the answer is wrong, you have been removed from the game", and change the 'play' properities into 'False', so that the players can not go further on this game and the cards he/she possessed will not be disclosed. Other players will be informed on their notebooks "Player X has been removed from this game".

Before finishing the hypothesis/accusation, the suspect pawn and weapon pawn are going to be moved to the room where the hypothesis/accusation is raised.

# Testing
When running Junit answer yes and ok to each window to complete the testing.




