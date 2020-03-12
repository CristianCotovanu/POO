CRISTIAN COTOVANU 324CD

Project purpose:
	Implementation of a minimalistic version of a MMO console game.

Implementation:
	Entities: 
		Hero - class used to display the main entity of the game.
		Angel - class used to display a character that buffs heroes.
		Skill - class that interacts with Hero and modifies specific attributes.
		Land - class used just for double-dispatch purpose to get terrain damage amplifier.
	Class design:
    		- Visitor Pattern
    			-> Skill-Hero: Hero is visited by skill done through two interfaces describing specific 
                            methods. Skill modifies specific fields in heroso that the effect 
                            can be seen at the output. 
    			-> Skill-Terrain: Terrain is visited by skill done through two interfaces describing specific 
                            methods. Skill modifies specific fields in hero. Only purpose of this at the moment
                            is that of getting the specific bonus for each skill based on 
                            terrain type.
    			-> Angel-Hero: Hero is visited by angel done through two interfaces describing specific 
                            methods. Skill modifies specific fields in hero. Angel modifies specific fields 
                            in a hero object(damage multipliers, hp, xp).
            - Observer Pattern
                -> GrandMagician - Hero, Angel, Fight, AngelController: 
                    created an interface for IObservers and an abstract class
                    for Observable behaviors. GrandMagician gets notifications from each type
                    of activity done by an angel: spawn, hero kill, hero revive, hero hit,
                    hero help also from hero kills.
    		- Factory Pattern
    			-> Skills - instantiate and fill a list of skills for each hero type.
    			-> Terrain - instantiate terrain of specific type.
    			-> Heroes - instantiate heroes of specific race.
    			-> Angels - instantiate angels of specific race.
    		- Abstract Factory Pattern
    		    -> Heroes Strategies - one factory for each hero race.
    		- Strategy Pattern
    		    -> Heroes Strategies, create an interface with a method for each type of
    		        strategy a hero posseses
    		- Singleton used for Map, GrandMagician and WriteFile.
    		- FileSystem used to manipulate io.
        	- Classes used for constants placed in every package they are relevant to.
    	Class interactions:
    		GameEngine has all game logic by which I mean hero interactions, eliminating dead heroes
    		from the game, applying damage overtime and stun debuffs.
    		Fight - handles an exchange of skills between 2 characters.heroes and experience exchanges.
    		Each Hero has 2 skills that will be applied to the opponent when a fight happens.
    		Skill - handles effects and damage appliers to an enemy hero.
    		Contains links to the caster hero and the current terrain type so that can
    		compute damage to the opponent based on the parameters.
    		MoveHero - handles all the move logic for moving a player between tiles.
            AngelController - handles all angel logic(instantiating, blessing players,
            angels leaving the map)
            GrandMagician notifying is done used the NotificationType enum, each element representing 
            a type of message written to the output file.
            