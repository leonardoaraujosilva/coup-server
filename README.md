# Coup Game Backend

This is a backend server for hosting and playing **Coup**, a bluffing card game. The project is implemented in **Kotlin with Spring Boot** and exposes a **REST API** for managing game sessions and player interactions.

Additionally, this server will serve as a foundation for a separate **Python-based module** that employs **reinforcement learning algorithms** to develop an AI that continuously improves to become the best Coup player possible.

## What is Coup?

Coup is a strategic bluffing game where players try to eliminate their opponents by using hidden roles and manipulating the game state through deception. Each player is given two hidden influence cards representing characters with unique abilities. The goal is to be the last player with influence remaining.

### Game Overview:
- Each player starts with **two influence cards** and **two coins**.
- On their turn, a player can take actions such as collecting coins, assassinating other players, or launching a coup.
- Players can **bluff** about their cards to take actions they might not be allowed to.
- Other players may **challenge** a bluff, forcing the bluffer to reveal a card.
- Losing both influence cards eliminates a player from the game.
- The last remaining player wins the game.

For full game rules, refer to [official Coup rules](https://www.indieboardsandcards.com/coup.php).

---

## Features

- Create, join, and manage Coup game sessions via REST API  
- Track game state and player actions  
- Implement core Coup mechanics (income, foreign aid, assassinations, challenges, etc.)  
- Allow multiple concurrent games  
- Designed to integrate with a Python-based AI module for reinforcement learning  
- WebSocket support for real-time updates (planned)

## Tech Stack

- **Backend:** Kotlin, Spring Boot
- **Database:** PostgreSQL
- **API Protocol:** REST
- **AI Integration:** Python (Reinforcement Learning)
- **Authentication:** JWT (planned)
- **WebSockets:** For real-time game updates (future feature)

## API Endpoints (WIP)

| Method | Endpoint             | Description |
|--------|----------------------|-------------|
| POST   | `/game/create`       | Create a new game session |
| POST   | `/game/{id}/join`    | Join an existing game |
| GET    | `/game/{id}/state`   | Get the current state of a game |
| POST   | `/game/{id}/action`  | Perform an action (income, assassinate, challenge, etc.) |
| GET    | `/game/{id}/players` | Retrieve player information |

---

## AI Integration

This backend will be used as a **training environment** for an AI model in Python, utilizing **reinforcement learning**. The AI will:

- Interact with the game API to play games
- Learn strategies over time based on game outcomes
- Develop optimal bluffing and challenge strategies
- Continuously improve by playing against itself and real players

The AI module will be developed separately in Python using **Deep Reinforcement Learning (DRL)** techniques, such as **Deep Q-Learning (DQN) and Proximal Policy Optimization (PPO)**.

## How to Run the Backend

### Prerequisites
- Java 17+
- Kotlin
- PostgreSQL (or another database if configured)
- Gradle

### Running the Server
```bash
git clone https://github.com/yourusername/coup-backend.git
cd coup-backend
./gradlew bootRun
```

### Running with Docker (Planned)
A Dockerfile will be provided for easier deployment.

## Contributing
We welcome contributions! Feel free to open issues and submit pull requests.

## License
This project is licensed under the MIT License.

---

> "Deception is a weapon; use it wisely."

---

### Future Roadmap
- [ ] WebSocket support for real-time updates
- [ ] Full authentication & authorization system
- [ ] Matchmaking and ranking system
- [ ] More AI training integration
