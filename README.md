# GoodsSimulator
Goods Simulator group project for class.

The goal of this project is to simulate the Public Goods Game. The basic structure of the Public Goods game is that players are given the same flat amount of resources. They secretly put in however much or however little they want into a central pot. After everyone has decided on what they want to do, the pot is multiplied by a set amount and then equally redistributed amongst everyone, regardless of the quantity they put in initially.

This will be done in three separate phases with one optional, stretch goal phase. 
- When implementing you should be sure that the amount each “personality” puts in a game valid amount (from nothing to everything they have)

### Phase 1:
- One round
  - Only one round of the ‘Game’ must be simulated. All earnings and losses are based on this round.
- Multiplier - Double
  - The pot is to be doubled before distribution
- Three personalities
  - There are three unique personalities.
    - The Miser: Refuses to put anything into the pot
    - The Big Spender: Always goes all in
    - The Middle Man: Always puts in half
  - Note: These will not be the only personalities.

Run the simulation on all combinations of these three personalities on three actors.

##### Main Question:
- Which personality is ‘winning’ the most often?
- Is the individual risk worth the highest mutual payout?

<em>Answer 1</em>:

[Stephen says]:
- The MiserPlayer comes out on top.
Having nothing in the game, they can only profit.
- The BigSpender (who risks the most) only makes an exact return on investment,
never a profit

### Phase 2:
	The simulation grows yet more complex.
The following variations are added.
- The goal is to find the best strategy under each condition for maximizing group profits
and maximizing an individual’s profits.
- Increase actors
Run the simulation over with more actors.
  - With more actors do winning strategies change?
    - Try running with different personality type ratios.
- Variable multiplier
  - Run the simulation with different multipliers.
    - The pot multiplier cannot at any point be greater than the number of actors.

- Flat reward:
  - The actor that contributes the most is given extra resources.
- Spectrum of giving:
  - Actors now donate based off of a varying scale.
    - I.E. More “personalities” than the initial three created in Phase 1
- Percentage reward:
  - Each actor gets a percentage of the pot equal to the amount that they entered
- Flat punishment:
  - At the end of the round all actors lose a set amount of resources.
- Minimum Entry:
  - In order to get a reward the actor must put at least x resources into the pot.

##### Main Question:
- How does this affect who is ‘winning’ the most often?
- How do different configurations matter?

<em>Answer 2</em>:

- The Cheapksate (only places minimum entry) usually comes out on top
The Miser does not do well because they are usually not included in the payout. The trend is still such that the less you pay the more likely you'll end up with the most money out of everyone with the Cheapskate always gaining the most as an individual. The exception to the case is when the percentage reward plus the flat reward (assuming you're the highest contributor) is greater than or equal to the max amount of money you can put into the pot as a player regardless of the depreciation (flat punishment) or pot multiplier

### Phase 3:
	This phase implements several major changes
The simulation is now iterative.
- Upon the conclusion of one round, another begins the effects of the previous round(s),
changing the inputs of the actors to the pot.
- Personalities make changes to their habits depending on the results that they received
There are a few way of doing this including:
  - allowing them to see the results of other actors and making a change of their own behavior based on the “success stories”.
  - This is not the only way of creating adaptive personalities.
  - [Note from Stephen]: Sounds like advance "Blood and Roses" AI to me

##### Main Question:


- Is there an equilibrium that forms?
- Is it best to take a risk and put all of your resources into flourish with the others,
	- or is it best to understand that everyone else won’t put anything in and the others will only gain from your loss.
- Try configuring and editing variables from the previous phases with this new iterative and adaptive approach.
- How does the equilibrium change?
- Finally construct the simulation with random actors such that the end state is a Nash Equilibrium.

<em>Answer 3</em>:
