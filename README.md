# GoodsSimulator
Goods Simulator group project for class.

The goal of this project is to simulate the Public Goods Game. The basic structure of the Public Goods game is that players are given the same flat amount of resources. They secretly put in however much or however little they want into a central pot. After everyone has decided on what they want to do, the pot is multiplied by a set amount and then equally redistributed amongst everyone, regardless of the quantity they put in initially.

This will be done in three separate phases with one optional, stretch goal phase. 

Phase 1:
One round
Only one round of the ‘Game’ must be simulated. All earnings and losses are based on this round.
Multiplier - Double
The pot is to be doubled before distribution
Three personalities
There are three unique personalities.
The Miser: Refuses to put anything into the pot
The Big Spender: Always goes all in
The Middle Man: Always puts in half
Note: These will not be the only personalities.  When implementing you should be sure that the amount each “personality” puts in can be anything from nothing to all in.
Run the simulation on all combinations of these three personalities on three actors.

Main Question: Which personality is ‘winning’ the most often? Is the individual risk worth the highest mutual payout?

Answer 1:

Phase 2:
	The simulation grows yet more complex. The following variables are added. The goal is to 
find the best strategy under each condition for maximizing group profits and maximizing an    	individual’s profits. 
Increase actors
Run the simulation over with more actors. With more actors do winning strategies change?
Try running with different personality type ratios.
Variable multiplier
Run the simulation with different multipliers. The pot multiplier cannot at any point be greater than the number of actors.
Flat reward: The actor that contributes the most is given extra resources.
Spectrum of giving: Actors now donate based off of a varying scale. I.E. More “personalities” than the initial three created in Phase 1
Percentage reward: Each actor gets a percentage of the pot equal to the amount that they entered
Flat punishment: At the end of the round all actors lose a set amount of resources. 	
Minimum Entry: In order to get a reward the actor must put at least x resources into the pot.

Main Question: How does this affect who is ‘winning’ the most often? How do different configurations matter?

Answer 2: 

Phase 3:  This phase implements several major changes
The simulation is now iterative. Upon the conclusion of one round, another begins the effects of the previous round(s), changing the inputs of the actors to the pot.
Personalities make changes to their habits depending on the results that they received
There are a few way of doing this including allowing them to see the results of other actors and making a change of their own behavior based on the “success stories”. This is not the only way of creating adaptive personalities.
Main Question: Is there an equilibrium that forms? Is it best to take a risk and put all of your resources into flourish with the others, or is it best to understand that everyone else won’t put anything in and the others will only gain from your loss. Try configuring and editing variables from the previous phases with this new iterative and adaptive approach. How does the equilibrium change? Finally construct the simulation with random actors such that the end state is a Nash Equilibrium.

Answer 3:
