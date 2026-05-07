# README: SimpleShop Android App

This document provides a comprehensive guide on how to configure, build, and run the **SimpleShop** application.

## 1. Project Overview
SimpleShop is a modern e-commerce mobile application prototype built using **Kotlin** and **Jetpack Compose**. It demonstrates a clean MVVM architecture, premium UI/UX design, and core shopping functionalities including user authentication, product browsing, and cart management.

---

## 2. Visual Walkthrough
Below are mockups of the key screens in the application.

### Login Screen
Minimalist and secure entry point.
![Login Screen](file:///C:/Users/Shraban/.gemini/antigravity/brain/93b4be05-4730-4f80-86c1-1734f8538f9f/login_screen_mockup_1778105222370.png)

### Home Screen (Product Catalog)
Dynamic grid displaying a variety of premium tech products.
![Home Screen](file:///C:/Users/Shraban/.gemini/antigravity/brain/93b4be05-4730-4f80-86c1-1734f8538f9f/home_screen_mockup_1778105289211.png)

### Shopping Cart
Summary of selected items with total calculation.
![Cart Screen](file:///C:/Users/Shraban/.gemini/antigravity/brain/93b4be05-4730-4f80-86c1-1734f8538f9f/cart_screen_mockup_1778105443995.png)

---

## 3. Project Structure
The project follows a standard Android modular structure:

```text
SimpleShop/
├── app/                        # Main application module
│   ├── build.gradle            # Module-level build configuration
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/example/simpleshop/
│           │   ├── MainActivity.kt        # Entry point & Navigation
│           │   ├── model/                 # Data models (Product, User, CartItem)
│           │   ├── ui/
│           │   │   ├── screens/           # UI Screens (Login, Home, Cart)
│           │   │   └── theme/             # Design system (Color, Theme, Type)
│           │   └── viewmodel/             # State management (ShopViewModel)
│           └── res/                       # Android resources
├── build.gradle                # Project-level build configuration
├── settings.gradle             # Project settings & module inclusion
├── gradle.properties           # Gradle environment settings
└── gradle/wrapper/             # Gradle wrapper configuration
```

---

## 4. Configuration & Setup

### Prerequisites
- **Android Studio** (Hedgehog or later recommended)
- **JDK 17** (Usually bundled with Android Studio)
- **Internet Connection** (For initial dependency download)

### Step-by-Step Guide
1. **Open Project**: Launch Android Studio and select `Open`. Navigate to `C:\Users\Shraban\.gemini\antigravity\scratch\SimpleShop`.
2. **Gradle Sync**: The IDE will automatically trigger a Gradle sync. This will download Jetpack Compose, Material 3, and Navigation libraries.
3. **Select Device**: Choose an Android Emulator or connect a physical device via ADB.
4. **Build & Run**: Press `Shift + F10` or click the green **Run** icon in the toolbar.

---

## 5. Technical Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose (Material 3)
- **Architecture**: MVVM
- **Navigation**: Jetpack Navigation Compose
- **State Management**: Kotlin Flow & StateFlow
