# 📱 Appium Mobile Automation Framework - SwagLabs Android App


## 🚀 Overview

This is an End-to-End (E2E) **Appium automation framework** developed in Java to test the SwagLabs Android mobile application. It uses:

- **Appium** for mobile automation
- **TestNG** as the test runner
- **Allure** for beautiful and detailed test reports
- **Maven** for project build and dependency management

---

## 🧪 Features

- 🔐 Login with valid credentials
- 🛍️ Add products to cart
- 🛒 Checkout process
- 🔚 Logout functionality
- 📊 Allure reporting integrated
- 🤖 Works on Android emulator or real devices

---

🔧 1. Prerequisites
Before starting, make sure the following are installed:

Tool	Purpose
✅ Java (JDK 11 or 17 or 21)	Required for Appium and Maven
✅ Maven	For dependency management
✅ Node.js	Required to install Appium
✅ Appium Server	For mobile automation
✅ Appium Inspector	To locate mobile elements
✅ Android Studio	To create and manage virtual devices
✅ Eclipse / IntelliJ IDEA	IDE to write and run the framework
✅ Allure Commandline	For report generation

⚙️ 2. Project Structure
AppiumProject/
├── pom.xml
├── testng.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Pages/ (LoginPage.java, ProductPage.java etc.)
│   └── test/
│       └── java/
│           └── tests/ (LoginTest.java, ProductTest.java etc.)
├── config.properties
├── target/
├── allure-results/
└── allure-report/

🤖 3. Install Appium Server and Inspector
bash
Copy
Edit
npm install -g appium
appium doctor
appium --allow-cors
Use https://inspector.appiumpro.com to inspect elements from your virtual/emulated device.

