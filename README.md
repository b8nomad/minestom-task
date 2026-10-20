# Minestom Task

A lightweight Minecraft server built with [Minestom](https://minestom.net/), using Java and Maven.

## Features

- **Customizable Welcome Message** — Change the welcome message displayed to players when they join the server.
- **Message Command** — Use `/message <Changed Message>` to update the welcome message at runtime.
- **Player Join Event Tracker** — Detect when players join the server and display the configured welcome message.
- **Player Disconnection Logging** — Log a message to the console when a player disconnects.

## Commands

| Command                      | Description                                      | Example                          |
|------------------------------|--------------------------------------------------|----------------------------------|
| `/message <Changed Message>` | Changes the welcome message for joining players. | `/message Welcome to my server!` |

The updated message applies to players who join after the change.

## Requirements

- Java 25 or newer
- Minecraft 26.2 version
- Maven
- IntelliJ IDEA (recommended)

## Setup

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA as a Maven project.
3. Ensure the Project SDK is set to Java 25 or newer.
4. Reload the Maven project to download dependencies.

## Build

Run the following command from the project root:

```bash
mvn clean package
```

## Run the Server

Start the application using Maven:

```bash
mvn exec:java
```

The server listens on port `25565`.

Connect using a compatible Minecraft Java Edition client at:

```text
localhost:25565
```

## Event Tracking

### Player Join

When a player joins, the server sends them the currently configured welcome message.

### Player Disconnect

When a player disconnects, the server logs their username to the console.

## Notes

- The welcome message is stored in a Minestom data tag on the server instance.
- The message can be changed without restarting the server.
- The welcome message is runtime-only and is not automatically preserved across server restarts.
