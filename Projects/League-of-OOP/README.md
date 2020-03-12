Project purpose:

	Implementation of a minimalistic version of a MMO console game.

Implementation:

	Entities: 
		Hero - class that is used to display the main entity.
		Skill - class that interacts with Hero and modifies specific attributes.
		Land - class used just for double-dispatch purpose to get terrain damage amplifier.
		
	Class design:
		- Visitor Pattern
			-> Skill-Hero: Hero is visited by skill. Skill modifies specific fields in hero
							so that the effect can be seen at the output.
			-> Skill-Terrain: Terrain is visited by skill. Only purpose of this at the moment
							is that of getting the specific bonus for each skill based on 
							terrain type.
		- Factory Pattern
			-> Skills - instantiate and fill a list of skills for each hero type.
			-> Terrain - instantiate terrain of specific type.
			-> Heroes - instantiate characters.heroes of specific race.
		- Singleton used for Map.
		- FileSystem used to manipulate io.
		- Classes used for constants placed in every package they are relevant to.
	Class interactions:
		GameEngine has all game logic by which I mean hero interactions, eliminating dead characters.heroes
		from the game, applying damage overtime and stun debuffs.
		
		Fight - handles an exchange of skills between 2 characters.heroes and experience exchanges.
		Each Hero has 2 skills that will be applied to the opponent when a fight happens.
		
		Skill - handles effects and damage appliers to an enemy hero.
		Contains links to the caster hero and the current terrain type so that can
		compute damage to the opponent based on the parameters.

		MoveHero - handles all the move logic for moving a player between tiles.
