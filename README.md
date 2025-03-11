# Coup Game Backend

This is a backend server for hosting and playing **Coup**, a bluffing card game. The project is implemented in **Kotlin with Spring Boot** using a hexagonal architecture. This server exposes REST APIs and WebSockets to manage game sessions and player interactions.

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

- **Real-time Room Management via WebSockets:**
    - **Create Room:**
        - Endpoint: `/app/room/create`
        - **Messenger:** Notifies `/user/topic/room/create` with room data (sent privately to the creator).
        - **Notifier:** Broadcasts to `/topic/room` to inform all clients about the new room.
    - **Join Room:**
        - Endpoint: `/app/room/{roomId}/join`
        - **Messenger:** Notifies `/user/topic/room/{roomId}` with the room’s current state (sent privately to the joining user).
        - **Notifier:** Broadcasts to `/topic/room/{roomId}` to notify all room participants about the new user.
- **REST Endpoints for Room Data:**
    - **Find All Rooms:**
        - `GET /api/v1/room` returns a summarized list of game rooms.
    - **Find Room by ID:**
        - `GET /api/v1/room/{roomId}` returns all data for a specific room.
- **Redis Integration:**
    - Stores room data (and, in the future, player and match data).
- **AI Integration:**
    - Serves as a simulation environment for a Python-based reinforcement learning module that trains AIs to play Coup.

---

## Usage Flow

1. **Connect to the WebSocket (STOMP):**  
   Clients establish a connection to the server via the WebSocket endpoint.

2. **Retrieve Room List:**  
   Use the REST endpoint `GET /api/v1/room` (findAll) to get a summarized list of rooms.

3. **Create or Join a Room:**
    - **Create Room:**  
      Send a message to `/app/room/create` to create a new room.
        - The server responds on:
            - **Messenger:** `/user/topic/room/create` (room data sent to the creator)
            - **Notifier:** `/topic/room` (broadcasts new room creation to all clients)
    - **Join Room:**  
      Send a message to `/app/room/{roomId}/join` to join an existing room.
        - The server responds on:
            - **Messenger:** `/user/topic/room/{roomId}` (room state sent to the joining user)
            - **Notifier:** `/topic/room/{roomId}` (broadcasts updates to all clients in the room)

4. **Subscribing to Topics:**
    - **Before joining a room:**  
      Subscribe to `/topic/room` to monitor room creations and deletions.
    - **After joining a room:**  
      Unsubscribe from `/topic/room` and subscribe to `/topic/room/{roomId}` to receive real-time updates specific to that room.

5. **Test Front-End:**  
   A simplified front-end is provided in `/index.html` to simulate multiple clients (open in different browser tabs) and test WebSocket communication.

---

## Tech Stack

- **Backend:** Kotlin, Spring Boot
- **Data Store:** Redis (for room data; future support for players and matches)
- **API Protocols:**
    - **REST:** Two GET endpoints for room data.
    - **WebSockets (STOMP):** For real-time room creation, joining, and updates.
- **Front-End Testing:** A simple `/index.html` to simulate multi-client interactions.
- **AI Integration:** Python module for reinforcement learning.

---

## Contributing

Contributions are welcome! Please open issues or submit pull requests for improvements, bug fixes, or additional features.

---

## License

This project is licensed under the MIT License.
