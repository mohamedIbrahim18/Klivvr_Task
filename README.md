# Android Internship Assignment

## Description

This project is an Android application designed to display a list of approximately 200,000 cities from a JSON file. Users can filter the list by a given prefix string and view city details on Google Maps. The goal is to showcase problem-solving skills, UX judgment, and code quality.

## Features

- **Load and display cities:** Load a list of cities from a JSON file and display them.
- **Filter cities:** Filter cities by a case-insensitive prefix with fast runtime search.
- **Alphabetical order:** Display cities in alphabetical order (city name first, country code after).
- **Responsive UI:** Update the list with every character added/removed from the filter.
- **City details:** Show city and country code as the title and coordinates as the subtitle in each city's cell.
- **Map integration:** Tap on a city to view its location on Google Maps.

## Architecture

The project follows the Clean Architecture pattern, separating the code into different layers:

- **App Layer:** Contains Android-specific code, including UI and navigation.
- **Data Layer:** Manages data sources, repositories, and data transformations.
- **Domain Layer:** Defines business logic, including use cases and entities.

## Design Patterns

- **MVVM (Model-View-ViewModel):** Ensures a separation of concerns, making the code more modular and testable.
- **Dependency Injection (DI):** Implemented using Dagger Hilt to manage dependencies efficiently.
- **Coroutines:** Used for asynchronous operations, providing a clean and efficient way to handle background tasks.

## Technical Details

- Language: Kotlin
- Minimum SDK: Android 5.0 (Lollipop)
- Libraries Used:
  * JSON serialization
  * Dependency Injection (Dagger Hilt)
  * Android Jetpack Suite (Compose, ViewModel, LiveData, etc.)
  * Coroutines    

## Screenshots
<img src="https://github.com/user-attachments/assets/af7794da-e446-4940-a298-cd0fdf7e0b50" alt="Screenshot of the app's main screen" width="200">
