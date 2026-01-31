# Kotlin Practice Project Overview

This is a multi-module Kotlin JVM project designed for learning Kotlin syntax and experimenting with AI chatbot technologies (Spring AI, RAG).

## Project Structure

- **`kotlin-basic/`**: A module dedicated to learning Kotlin fundamental syntax.
  - **Exercises**: Found in `src/main/kotlin/syntax/exercises/`. These files contain `TODO` blocks for practice.
  - **Solutions**: Found in `src/main/kotlin/syntax/solutions/`.
  - **Topics**: Variables, Null Safety, Functions, Control Flow, Classes, Coroutines, Reflection, etc.
- **`kotlin-chatbot/`**: A module for building a chatbot using Spring AI and RAG (Retrieval-Augmented Generation).

## Technologies & Frameworks

- **Language**: Kotlin (JVM)
- **Build System**: Gradle (Kotlin DSL)
- **Testing**:
  - JUnit 5
  - Kotest (Assertions and Runner)
- **Libraries**:
  - Kotlin Coroutines
  - Kotlin Reflection
  - Spring AI (Planned/In Progress)

## Building and Running

Use the Gradle wrapper (`./gradlew`) for all tasks.

### Build and Test
```bash
# Full build
./gradlew build

# Run tests for a specific module
./gradlew :kotlin-basic:test
./gradlew :kotlin-chatbot:test
```

### Running Applications
```bash
# Run the basic module (Main entry point)
./gradlew :kotlin-basic:run

# Run the chatbot module
./gradlew :kotlin-chatbot:run
```

## Development Conventions

### 1. Verification First
Before submitting any code changes, ensure they pass compilation and relevant tests:
- Run `./gradlew :<module>:test` to verify logic.
- Run `./gradlew build` to ensure project-wide integrity.

### 2. Clarity and Communication
- **Ask Before Acting**: If a request is ambiguous or lacks specific details (e.g., target module, specific file, desired implementation style), always ask for clarification before proceeding.
- **Refer to `Agents.md`**: This file contains specific rules for agent behavior in this repository.

### 3. File Paths and References
- Always verify file paths exist before suggesting modifications.
- Mimic the existing coding style (e.g., using `val` by default, semicolon-free Kotlin code, and specific package structures).

## Key Files
- `CLAUDE.md`: High-level instructions for AI agents.
- `Agents.md`: Detailed project rules and commands.
- `build.gradle.kts` (Root): Project-wide configuration.
- `settings.gradle.kts`: Multi-module structure definition.
