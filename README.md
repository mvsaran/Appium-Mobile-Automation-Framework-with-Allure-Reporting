
# 📱 Appium Mobile Automation Framework — SwagLabs Android App

## 🚀 Overview
This is an **End-to-End (E2E) Appium Automation Framework** for the **SwagLabs Android app**, built with:

- **Appium** for mobile automation
- **TestNG** for test orchestration
- **Maven** for dependency management
- **Allure** for advanced test reporting

---

## 🧩 Key Features

✅ Login with valid credentials  
✅ Add products to cart  
✅ Complete checkout process  
✅ Logout functionality  
✅ Generates beautiful Allure HTML reports  
✅ Supports Android emulator or real devices

---

## 🔧 1️⃣ Prerequisites

| Tool | Purpose |
|------|---------|
| **Java JDK (11, 17, or 21)** | Required for Appium & Maven |
| **Maven** | Build & dependencies |
| **Node.js** | Required to install Appium |
| **Appium Server** | Mobile test execution |
| **Appium Inspector** | Locate mobile elements |
| **Android Studio** | SDK + Emulator |
| **IDE (Eclipse/IntelliJ)** | To develop & run |
| **Allure Commandline** | Generate test reports |

---

## 📂 2️⃣ Project Structure

```
AppiumProject/
├── pom.xml               # Maven config + Allure plugin
├── testng.xml            # TestNG suite config
├── src/
│   ├── main/java/
│   │   └── Pages/        # Page classes (LoginPage.java, etc.)
│   └── test/java/
│       ├── Base/         # BaseClass.java (starts Appium Server)
│       └── tests/        # Test classes (LoginTest.java, etc.)
├── src/test/resources/
│   ├── config.properties # Appium server config
│   ├── apps/             # APK files
├── allure-results/       # Raw test results
├── allure-report/        # Final HTML report
└── target/
```

---

## ⚙️ 3️⃣ Configuration (`config.properties`)

**Example:**
```properties
appiumJSPath=C:\Users\YourName\AppData\Roaming\npm\node_modules\appium\build\lib\main.js
ipAddress=127.0.0.1
port=4723
```
➡️ Update paths as per your machine.

---

## 📌 4️⃣ Appium Setup (Server + Inspector)

✅ **Step 1:** Install Node.js  
✅ **Step 2:** Install Appium Server (`npm install -g appium`)  
✅ **Step 3:** Install Appium Doctor (`npm install -g appium-doctor`)  
✅ **Step 4:** Install Appium Inspector ([Download](https://github.com/appium/appium-inspector/releases))  
✅ **Step 5:** Start Appium:  
- Terminal: `appium`  
- Or use your `BaseClass` → `startServer()` starts Appium automatically  
✅ **Step 6:** Inspect elements:  
- Open Inspector → Fill Desired Capabilities → Start Session → Locate elements

---

## ▶️ 5️⃣ How to Run Tests

mvn clean test
- `BaseClass` will load configs, start Appium Server, and run tests.
- TestNG will execute your test suite defined in `testng.xml`.
- Allure results are generated in `allure-results/`.

## 📊 6️⃣ Allure Reporting 📈

### ✅ Add Allure to `pom.xml`

Add the **Allure TestNG adapter** and **Allure Maven plugin**:

```xml
<dependencies>
  <!-- Allure TestNG Adapter -->
  <dependency>
    <groupId>io.qameta.allure</groupId>
    <artifactId>allure-testng</artifactId>
    <version>2.24.0</version>
  </dependency>
  <!-- Other dependencies -->
</dependencies>

<build>
  <plugins>
    <!-- Allure Maven Plugin -->
    <plugin>
      <groupId>io.qameta.allure</groupId>
      <artifactId>allure-maven</artifactId>
      <version>2.11.2</version>
    </plugin>
  </plugins>
</build>
```

---

### ✅ Add Allure Annotations

In your test classes:

```java
import io.qameta.allure.*;

@Epic("SwagLabs Mobile Tests")
@Feature("Login Feature")

public class LoginTest {
  @Test(description = "Valid login test")
  @Severity(SeverityLevel.CRITICAL)
  @Description("Tests valid login with standard user credentials")
  public void validLoginTest() {
    // Your test logic
  }
}
```

---

### ✅ Install Allure CLI (one-time)

# Windows / Mac / Linux
npm install -g allure-commandline --save-dev
Check:
allure --version

### ✅ Generate the HTML Report

After running:
mvn clean test
Run:
allure generate allure-results --clean -o allure-report
allure open allure-report
This will:
- Process `allure-results/`
- Create an interactive HTML report in `allure-report/`
- Open it in your browser

## ✔️ 7️⃣ Final Notes

✅ Appium Server can run **headlessly** via `BaseClass` or manually via Terminal.  
✅ Update `config.properties` as needed.  
✅ Validate locators with Appium Inspector.  
✅ Keep your emulator/device connected.

---

## 📣 Ready to 🚀

**Fork → Clone → Install → Run → Generate Report → Done!**
