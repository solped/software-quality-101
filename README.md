# AYCAP Software Quality Workshop

---

This [workshop](./src/main/java/com/krungsri/workshop/tdd/README.md) aims to improve and develop software quality mindset, there are 3 hands-on workshops which teach you

- Test-Driven Development (TDD)
- [Clean-code](./src/main/resources/static/clean-code-checklist.pdf)
- Code Refactoring

---

## Prerequisite

- [Java 8](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/install.html)
- Prior knowledge in [Design Pattern (GoF)](https://en.wikipedia.org/wiki/Design_Patterns)

---

## Workshop 1 - TDD Basic

This aims to give you basic understanding of how to adopt TDD on your daily basis(No Test Double)

- [Calculator](./src/main/java/com/krungsri/workshop/tdd/cal/instruction.md)
- [Login](./src/main/java/com/krungsri/workshop/tdd/login/instruction.md)
- [String Processor](./src/main/java/com/krungsri/workshop/tdd/string/instruction.md)

---

## Workshop 2 - TDD with Test Double

This aims to give you `Test Double` concept implemented by [mockito](https://site.mockito.org/), you will learn how to
mock or stub external dependencies

- [Payment Broker](./src/main/java/com/krungsri/workshop/tdd/payment/instruction.md)

---

## Workshop 3 - Code Refactoring

This workshop applies all the concept we have learnt about TDD, Clean-code, Test Double and Code Refactoring. You will practice refactoring an existing API endpoint

- [Transaction Processing API](./src/main/java/com/krungsri/workshop/instruction.md)

---

## Useful commands

Start the Web application

```shell
mvn spring-boot:run
```

Run the test

```shell
mvn test
```