---
layout: page
title: Eryn Seo's Project Portfolio Page
---

## Project: JARVIS

JARVIS is a desktop app for CS1101S Teaching Assistants (Avengers) to help Avengers keep track of their grading duties and consultations.
The user interacts with it using CLI and it has a GUI created with JavaFX. It is written in Java and has more than 10kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the ability to view consultations and mastery checks.
  * What it does: allows the user to view all/past/upcoming consultations or mastery checks.
  * Justification: This feature improves the product significantly because the user needs to view consultation appointments created within the software.
  * Highlights: This enhancement was a completely new feature that did not exist in the AB3 codebase, and had to be designed from scratch. Due to design concerns, the class structure of Student and Consultations had to be changed multiple times which resulted in multiple attempts to refactor and restructure, as well as rewriting tests. It required an in-depth analysis of design alternatives. The implementation too was challenging as it was a completely new command for completely new classes.

* **New Feature**: Added the ability to add and delete consultations and mastery checks.
  * What it does: allows the user to add and delete consultations or mastery checks.
  * Justification: This feature improves the product significantly because the user needs to add and delete consultation appointments created within the software.
  * Highlights: This enhancement was a completely new feature that did not exist in the AB3 codebase, and had to be designed from scratch. It required an in-depth analysis of design alternatives. The implementation too was challenging as it was a completely new command for completely new classes.

* **New Feature**: Added the ability to edit mastery checks.
  * What it does: allows the user to edit mastery check scores to either pass (1) or fail (0).
  * Justification: This feature improves the product significantly because the user needs to edit mastery check scores.
  * Highlights: This enhancement was a completely new feature that did not exist in the AB3 codebase, and had to be designed from scratch. It required an in-depth analysis of design alternatives. The implementation too was challenging as it was a completely new command for a completely new class.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=wireseo)

* **Project management**:
  * In charge of implementation of all consultation and mastery check related features and overall GUI
  * Ensure that project deliverables are delivered on time

* **Enhancements to existing features**:
  * Designed the new GUI [\#12]
  * Wrote additional tests for existing features to increase coverage

* **Documentation**:
  * User Guide:
    * Added documentation for the features `view -c`, `view -cp`, `view -cu`, `view -mc`, `view -mcp`,  `view -mcu`, `add -c`, `add -mc`, `delete -c`, `delete -mc`[\#34]()
    * Added documentation for the features `edit -mc` [\#291]()
  * Developer Guide:
    * Added implementation details of the `view -c` feature.

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#287](https://github.com/AY2021S1-CS2103T-W11-2/tp/pull/287#pullrequestreview-522475093), [\#290](https://github.com/AY2021S1-CS2103T-W11-2/tp/pull/290#pullrequestreview-522476413)
  * Reported bugs and suggestions for other teams in the class (examples: [1](https://github.com/AY2021S1-CS2103T-F11-2/tp/issues/154), [2](https://github.com/AY2021S1-CS2103T-F11-2/tp/issues/152), [3](https://github.com/AY2021S1-CS2103T-F11-2/tp/issues/156))
