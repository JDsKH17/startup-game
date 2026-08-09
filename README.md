# Startup Game

Startup Game is a console-based Java game inspired by the classic Battleship style of gameplay. The player attempts to locate and sink three startups hidden on a 7 × 7 grid.

This project is an improved version of an earlier `SimpleStartupGame` implementation. The earlier version is preserved in the repository's `simple-startup-game` branch.

## Game Overview

The game contains three startups:

- **Messi**
- **Iniesta**
- **Pedri**

Each startup occupies **3 contiguous cells**, either horizontally or vertically.

The player enters guesses using coordinates such as `a1` or `d5`. The goal is to sink all three startups using as few guesses as possible.

## Features

- 7 × 7 game grid.
- Three startups with individual names.
- Random startup placement.
- Horizontal and vertical startup placement.
- Prevention of overlapping startups.
- Detection of hits, misses, and completely sunk startups.
- Guess counter.
- Final performance message based on the number of guesses.
- Console-based user interaction.

## Technologies Used

- **Java**
- `ArrayList`
- `Random`
- `Scanner`
- Object-oriented programming
- Console input/output

## Project Structure

The main version is divided into three Java classes:

```text
StartupGame/
├── StartupGame.java
├── Startup.java
└── GameHelper.java
```

### `StartupGame.java`

Contains the main game logic, including creating and naming startups, placing them, reading guesses, checking guesses, counting attempts, and ending the game.

### `Startup.java`

Represents an individual startup. It stores the startup name and its occupied grid locations. Its `checkYourself()` method determines whether a guess is a miss, a hit, or sinks the startup.

### `GameHelper.java`

Supports game setup by reading user input, generating random positions, choosing horizontal or vertical placement, preventing invalid or overlapping placements, and converting grid indexes into coordinate strings.

## Grid System

The game uses a **7 × 7 grid**, giving a total of 49 cells.

Columns are represented by:

```text
a b c d e f g
```

Rows are represented by:

```text
0 1 2 3 4 5 6
```

Valid guesses therefore use coordinates such as:

```text
a0
b3
d5
g6
```

The game expects lowercase coordinates.

## Startup Placement

The `GameHelper` class randomly selects a starting position and alternates between horizontal and vertical placement.

- Horizontal placement uses an increment of `1`.
- Vertical placement uses an increment of `7`.

Before a startup is placed, the game checks that:

1. The startup remains inside the grid.
2. Its cells are not already occupied.

This prevents invalid placements and overlapping startups.

## Gameplay

When the game starts:

1. Three startups are created.
2. Their names are assigned.
3. Each startup is randomly placed on the grid.
4. The player is repeatedly asked to enter a coordinate.
5. The guess is checked against the remaining startups.
6. The result is displayed as `miss`, `hit`, or `Kill`.
7. A sunk startup is removed from the active startup list.
8. The game ends when all startups have been sunk.

## Performance

The game counts the total number of guesses.

Finishing the game in **18 guesses or fewer** produces the better performance message. Taking more than 18 guesses produces a different final message.

## Previous Version

This project evolved from an earlier and simpler implementation called `SimpleStartupGame`.

The earlier version used:

- A single startup.
- A simple numeric location system.
- Integer guesses instead of grid coordinates.
- `SimpleStartup` and `GameHelper2` classes.

The original implementation is preserved in the repository's:

```text
simple-startup-game
```

branch.

This allows the repository to show the progression from the simpler implementation to the more complete `StartupGame`.

## How to Run

Keep the main classes in separate Java files:

```text
StartupGame.java
Startup.java
GameHelper.java
```

Compile them:

```bash
javac StartupGame.java Startup.java GameHelper.java
```

Then run:

```bash
java StartupGame
```

## Java Concepts Demonstrated

This project demonstrates:

- Classes and objects
- Encapsulation
- Private fields
- Methods
- Object creation
- `ArrayList`
- Arrays
- `Random`
- `Scanner`
- Loops
- Conditional statements
- Method decomposition
- Object interaction
- Basic game-state management
- Console input/output

## Notes

The source uploaded for the project combines multiple Java classes into one file for sharing. In the actual repository, the classes should remain in their corresponding `.java` files because `StartupGame` and `Startup` are public classes.

The project uses Java's standard library and does not require external dependencies.
