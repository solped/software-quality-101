# Transaction Processing API

---

### Background

There is a SpringBoot's RESTful API server which consist of transaction endpoints

| Endpoint                                | Description                       |
|-----------------------------------------|-----------------------------------|
| GET http://localhost:8080/transactions  | List all existing transactions    |
| POST http://localhost:8080/transactions | Process given list of transaction |                                |

### Tasks

Refactor the process transaction endpoint according
to [clean-code & principle](../../../../resources/static/clean-code-checklist.pdf)
and ensure that all functionalities are working properly.
---

#### Acceptance Criteria

* Given **valid transactions**, when call `processTransaction` endpoint, then should return 200 HTTP status.
* Given **empty transactions**, when call `processTransaction`, then should throw return 500 with NoTransactionProvided
  exception.
* Given **transactions with invalid payment type**, when call `processTransaction`, then should throw return 500 with InvalidTransactionPaymentType
  exception.
* Given **transactions with invalid payment method**, when call `processTransaction`, then should throw return 500 with InvalidTransactionPaymentMethod
    exception.