🔹 Project Title:
Automation Framework for saucedemo.com using Selenium, Cucumber, JUnit, and Extent Reports

🔹 Description:
This project is a test automation framework developed to validate the functionality of the saucedemo.comweb application. The framework is built using Java, Selenium WebDriver, Cucumber (BDD), and JUnit 4 for test execution.
The automation design follows the Page Object Model (POM) for enhanced maintainability and scalability.
To enhance reporting and test visibility, Extent Reports have been integrated to generate detailed HTML, PDF, and Spark reports with system info, test status, and screenshots.

🔹 Key Features:

Key Features

✅ Automated Test Cases
Covers:

Login

Product selection

Cart functionality

Checkout flow

✅ BDD with Cucumber + JUnit 4
Implements Behavior-Driven Development using:

Cucumber feature files

Step Definitions

JUnit 4 Test Runners

✅ Page Object Model (POM)
Ensures:

Clean separation between test logic and UI interactions

Reusability and maintainability

✅ Extent Reports Integration
Generates:

Spark Reports

HTML Reports

PDF Reports
Includes:

Step-level execution status (Pass / Fail)

OS and environment information

Optional screenshots for failed steps

✅ Cross-Browser Execution Ready
Easily extendable with WebDriverManager

✅ Configurable Properties

Customizable report output paths

Switchable environments via .properties files
🔹 Technology Stack:
Tool/Library	Description
Java	Programming Language
Selenium WebDriver	UI automation
Cucumber	BDD framework
JUnit 4	Test runner
Extent Reports	Advanced test reporting
Maven	Build and dependency management
Eclipse/IntelliJ	IDE for development

## 📁 Folder Structure

```
project-root/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/                  --> Page Object Classes
│   ├── test/
│   │   └── java/
│   │       ├── stepDefinitions/        --> Step Definitions for Cucumber
│   │       ├── runners/                --> Test Runner (JUnit)
│   │       └── hooks/                  --> Extent Hooks for Report Lifecycle
├── resources/
│   ├── features/                       --> Cucumber feature files
│   └── extent-config.properties        --> Configuration for Extent Reports
├── Reports/                            --> Generated Extent Reports
└── pom.xml                             --> Maven dependencies
```


Reports include:

✅ Scenario name

✅ Step-level execution details

✅ Status: Pass / Fail

✅ Embedded screenshots (optional)

✅ OS and environment info

Future Enhancements

Planned improvements:

🚀 CI/CD integration with Jenkins

🌐 Support for cross-browser testing via WebDriverManager

🐳 Docker-based grid execution
