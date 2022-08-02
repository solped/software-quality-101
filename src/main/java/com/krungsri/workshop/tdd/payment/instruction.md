# Payment Broker

---

### Tasks

Implements a [payment broker](../payment) that allows to do `pay` operations with a wallet and payment provider, in this
example you need to use `mock` and `stub` in order to complete test without calling to external payment provider

---

#### Acceptance Criteria

* Given **wallet has fund and provider is available and deposit succeeds**, when call `pay`, then should return `true`.
* Given **wallet does not have fund**, when call `pay`, then should throw `InsufficientFundsException`.
* Given **provider is not available**, when call `pay`, then should throw `ProviderNotAvailableException`.