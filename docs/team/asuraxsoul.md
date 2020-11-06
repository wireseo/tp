---
layout: page
title: Lim Jun Jie's Project Portfolio Page
---

## Project: JARVIS

JARVIS is a desktop app for CS1101S Teaching Assistants (Avengers), optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).
JARVIS allows Avengers to not only manage their Tutor related tasks, but also manage their personal tasks.

Given below are my contributions to the project.

* **New Feature**: Added `Add Task` feature for Tutors to add their personal tasks.
  * What it does: Allows tutors to Add Todos, Events or Deadlines.
  * Justification: This feature gives tutors ability to store their personal tasks at one place for better organization.
  * Highlights: This feature allows me to understand the main architecture of JARVIS from UI, Logic to Storage
  components. It is a very wholesome feature to add and I really enjoyed it.

* **New Feature**: Added `Delete Task` feature for Tutors to delete their personal tasks.
  * What it does: Allows tutors to Delete Todos, Events or Deadlines.
  * Justification: This feature gives tutors ability to manage their personal tasks at one place by deleting Tasks that
  are completed or not relevant anymore.
  * Highlights: Similar to `Add Task` feature, this feature allows me to understand the main architecture of JARVIS.

* **New Feature**: Added `View Task` feature for Tutors to view their different subsets of their personal tasks.
  * What it does: Allows tutors to view different Task list including `Overall Task List`, `Todo List`, `Event List`
  and `Deadline List`.
  * Justification: This feature gives tutors ability to view their Tasks quickly based on different categories.
  * Highlights: I really appreciate the usefulness and flexibility of using an Observer pattern.

* **New Feature**: Added a `history command` that allows Tutors to navigate to previous commands using up/down keys.
  * What it does: Allows tutors to navigate through previous commands entered using up and down arrow keys.
  * Justification: Enhances the CLI nature of JARVIS which gives tutors ability to skim through previous commands, and
  they do not need to retype commands that are similar to what they have typed previously.
  * Highlights: Not only does this feature provide convenience to users, it also allows GUI testing to be easier for us,
  the developer team.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=asuraxsoul)

* **Project management**:
  * Managed milestones `v1.1 - v1.3` on GitHub

* **Enhancements to existing features**:
  * Add Task Section features.
  * Update storage to store Tasks.
  * Update GUI with "Todo", "Event", "Deadline" tags for user to easily see what type of Task is that.
  * Add access to Command History using "Up" and "Down" arrow keys.

* **Documentation**:
  * User Guide:
    * Added documentation for the features `add` and `delete`.
    * Update list of content with navigable links to each sections of the UG.
  * Developer Guide:
    * Added implementation details of the `add` features for Tasks.
    * Added implementation details of the `view` features for Tasks.

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#215](https://github.com/AY2021S1-CS2103T-W11-2/tp/pull/215),
  [\#300](https://github.com/AY2021S1-CS2103T-W11-2/tp/pull/300), [\#304](https://github.com/AY2021S1-CS2103T-W11-2/tp/pull/304)
  * Reported bugs and suggestions for other teams in the same CS2103T class: [Dry run PE](https://github.com/Asuraxsoul/ped/issues)

* **Tools**:
  * Used JavaFX libraries and CSS to create portions of the Graphic User Interface.
