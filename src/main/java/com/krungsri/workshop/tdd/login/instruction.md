# Login Manager

---

### Tasks

Implements a login manager that allows to do `login` operations by username and password.

---

#### Acceptance Criteria

* Given **credentials are valid**, when call `login`, then should return `True`.
* Given **credential are invalid**, when call `login`, then should throw `InvalidCredentialException`.
* Given **password is empty**, when call `login`, then should throw `EmptyPasswordException`.