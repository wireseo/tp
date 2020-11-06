---
layout: page
title: User Guide
---

## User Guide

Jarvis is a desktop app for CS1101S Teaching Assistants (Avengers), optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, Jarvis can get your TA administrative tasks done faster than traditional GUI apps.

## Table of Contents

1. [Overview](#1-overview)
    - [1.1 Introduction](#11-introduction)
    - [1.2 Purpose](#12-purpose)
2. [About the User Guide](#2-about-the-user-guide)
3. [Quick Start](#3-quick-start)
4. [Navigating Jarvis](#4-navigating-jarvis)
    - [4.1 UI Layout](#41-ui-layout)
5. [Logging into Jarvis](#5-logging-into-jarvis)
6. [Features](#6-features)
    - [6.1 General Notes about Command Format](#61-general-notes-about-command-format)
    - [6.2 Viewing help : `help`](#62-viewing-help--help)
    - [6.3 Adding Information : `add`](#63-adding-information--add)
        * [6.3.1 Adding Todos : `add -t`](#631-adding-todos--t)
        * [6.3.2 Adding Events : `add -e`](#632-adding-events---e)
        * [6.3.3 Adding Deadlines : `add -d`](#633-adding-deadlines---d)
        * [6.3.4 Adding Consultations : `add -c`](#634-adding-consultations---c)
        * [6.3.5 Adding Mastery Checks : `add -mc`](#635-adding-mastery-checks---mc)
    - [6.4 Editing Information : `edit`](#64-editing-information--edit)
        * [6.4.1 Editing Login Information : `edit -l`](#641-editing-login-information---l)
        * [6.4.2 Editing Student Information : `edit -s`](#642-editing-student-information---s)
        * [6.4.3 Editing Mastery Checks : `edit -mc`](#643-editing-mastery-checks---mc)
    - [6.5 Deleting Information : `delete`](#65-deleting-information--delete)
        * [6.5.1 Deleting Tasks : `delete -t`](#651-deleting-tasks---t)
        * [6.5.2 Deleting Consultations : `delete -c`](#652-deleting-consultations---c)
        * [6.5.3 Deleting Mastery Checks : `delete -mc`](#653-deleting-mastery-checks---mc)
    - [6.6 Viewing Information : `view`](#66-viewing-information--view)
        * [6.6.1 Viewing a list of all students : `view -s`](#661-viewing-a-list-of-all-students---s)
        * [6.6.2 Viewing one student : `view -s NAME`](#662-viewing-one-student---s-name)
        * [6.6.3 Viewing all consultation sessions : `view -c`](#663-viewing-all-consultation-sessions---c)
        * [6.6.4 Viewing past consultation sessions: `view -cp`](#664-viewing-past-consultation-sessions---cp)
        * [6.6.5 Viewing upcoming consultation sessions: `view -cu`](#665-viewing-upcoming-consultation-sessions---cu)
        * [6.6.6 Viewing all Mastery Check sessions: `view -mc`](#666-viewing-all-mastery-check-sessions---mc)
        * [6.6.7 Viewing past Mastery Check sessions: `view -mcp`](#667-viewing-past-mastery-check-sessions--mcp)
        * [6.6.8 Viewing upcoming Mastery Check sessions: `view -mcu`](#668-viewing-upcoming-mastery-check-sessions--mcu)
        * [6.6.9 Viewing deadline for missions: `view -m`](#669-viewing-deadline-for-missions---m)
        * [6.6.10 Viewing deadline for quests: `view -q`](#6610-viewing-deadline-for-quests---q)
        * [6.6.11 Viewing ungraded missions: `view -um`](#6611-viewing-ungraded-missions---um)
        * [6.6.12 Viewing ungraded quests: `view -uq`](#6612-viewing-ungraded-quests---uq)
        * [6.6.13 Viewing all Tasks: `view -t`](#6613-viewing-all-tasks---t)
        * [6.6.14 Viewing all Todos: `view -tt`](#6614-viewing-all-todos---tt)
        * [6.6.15 Viewing all Events: `view -te`](#6615-viewing-all-events---te)
        * [6.6.16 Viewing all Deadlines: `view -td`](#6616-viewing-all-deadlines---td)
    - [6.7 Exiting the program: `exit`](#67-exiting-the-program--exit)
    - [6.8 Saving the data](#668-viewing-upcoming-mastery-check-sessions--mcu)
7. [Command Summary](#7-command-summary)
    - [7.1 Add Command Summary](#71-add-command-summary)
    - [7.2 Edit Command Summary](#72-edit-command-summary)
    - [7.3 Delete Command Summary](#73-delete-command-summary)
    - [7.4 View Command Summary](#74-view-command-summary)
    - [7.5 Exit Command Summary](#75-exit-command-summary)
    - [7.6 Help Command Summary](#76-help-command-summary)
8. [Glossary](#8-glossary)
    - [8.1 Difference Between Consultations and Mastery Checks](#81-difference-between-consultations-and-mastery-checks)
9. [FAQ](#9-faq)

--------------------------------------------------------------------------------------------------------------------

## 1. Overview

### 1.1 Introduction
Jarvis is a desktop app for CS1101S Teaching Assistants (Avengers), optimized for use via a Command Line Interface (CLI)
while still having the benefits of a Graphical User Interface (GUI). Jarvis in general helps to organise and simplify
CS1101S tutors' administrative tasks.

### 1.2 Purpose
As an Avenger, not only do you have immense power but you are also burdened with inevitable great responsibility.
Not to worry, Jarvis is here to empower you to manage your personal tasks while teaching others efficiently and
effectively.

--------------------------------------------------------------------------------------------------------------------

## 2. About the User Guide
This section aims to remind you of the important parts to take note of while reading the user guide.

--------------------------------------------------------------------------------------------------------------------

## 3. Quick start

1. Ensure you have Java 11 or above installed in your Computer.

1. Download the latest _`jarvis.jar`_ and your operating system's _Chrome Driver_ from [here](https://github.com/AY2021S1-CS2103T-W11-2/tp/releases/tag/v1.3).
It is crucial to have the Chrome Driver in order for Jarvis to start up. If the GUI does not launch,
please check that you have installed the correct driver:
    1. Windows: chromedriver.exe
    1. MacOS: chromedriver_mac
    1. Linux: chromedriver_linux
<br>
1. Copy both files to the folder you want to use as the _home folder_ for your Jarvis.

1. There are two options for launching Jarvis.
    1. Double-click the `jarvis.jar` file to start the app.
    1. Launch Jarvis from the the Windows Command Prompt or MacOS
    command line by navigating to the directory containing `jarvis.jar`,
    then typing the command `java -jar jarvis.jar`

    A GUI similar to the screenshot below should appear in a few seconds.

   ![Jarvis](images/userguide/Jarvis.png)

1. Upon start up, you will be prompted to log in to unlock Jarvis's
 full set of features.
 Please refer to the logging in segment below to complete your login.

1. Type the command in the command box and press Enter to execute it. E.g. typing help and pressing Enter will open the help window.
   Some example commands you can try:
   * `view -s:  Lists all Students.`
   * `view -s John Doe: Lists information about a Student named John Doe.`
   * `add -t DESCRIPTION : Adds a Todo task with specified description.`
   * `edit -s TASK_ID : Edits Student's Name, Email, Telegram.`
   * `exit : Exits the app.`

1. Refer to the Features below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## 4. Navigating Jarvis

Jarvis has a Graphical User Interface centered around a command input box on the top, surrounded by a light green
line. The green box below the command input box is the user feedback box. Jarvis provides feedback to the user through
this box.

### 4.1 UI Layout

   * The user interface is split into clearly marked tabs: `Student`, `Mission`, `Quest`, `Consultation`, `Mastery Check`, `Task`.
   * Clicking on each tab will give you the information you require for that field.
   
<br>

![Jarvis](images/userguide/Jarvis.png)

The core features are based on `Students`, `Missions`, `Quests`, `Consultations`, `Mastery Checks` and `Tasks`.
Each core feature has a tab for the organisation of its information.

<div markdown="block" class="alert alert-info">

To navigate the features, there are 2 methods which could be used individually, or mixed. We have designed
this flexibility with you, the user in mind.
 1. Only inputting commands into the box annotated "Enter command here..".
 1. Clicking on the tabs.
</div>

--------------------------------------------------------------------------------------------------------------------

## 5. Logging into Jarvis

The following is the prompt upon first login, you are prompted to key in your Source Academy username and password:

![NoLoginDetails](images/userguide/loginPrompt.png)

To log in, simply edit your login details with the following command:
<br>**Format: `edit -l u/LUMINUS_USERNAME p/LUMINUS_PASSWORD`**
<br>Examples:
* `edit -l u/nusstu\e1234567 p/testpassword`

An example of the command being inputted:

![LoginUsernamePasswordInput](images/userguide/editLoginDetails.png)

Within the green rectangle box, Jarvis will notify you if the login was successful. Upon success, all information from
Source Academy will be visible to you.

--------------------------------------------------------------------------------------------------------------------

## 6. Features

### 6.1 General Notes about Command Format

   * Words in UPPER_CASE are the parameters to be supplied by you.
   <br> e.g. in `add -t DESCRIPTION`, `DESCRIPTION` is a parameter which can be used as `add -t Mark Missions`.

   * Items in square brackets are optional.
   <br> e.g `view -s [NAME]`, name is an optional parameter. It can be used as `view -s` or as `view -s [John]`.

   * Parameters can be in any order.
   <br> e.g. if the command specifies `t/TELEGRAM e/EMAIL`, `e/EMAIL t/TELEGRAM` is also acceptable.

   * Commands with arrows indicate a multi-step process.
   <br> e.g. `delete -c → 1` means that you should enter `delete -c` first and then `1` after the prompt
   has been processed.

**Notes about Jarvis' relationship with Source Academy:** <br>
* Students’ names that are under the Avenger will be fetched automatically from sourceacademy.nus.edu.sg upon startup.
* Luminus username and passwords will be stored in plaintext.

**General Notes on Tasks:**
* Each `Task` you create, be it `Todo`, `Event` or `Deadline`, there will be an unique ID assigned to each of them, so
that there will be no 2 of the same Task ID in your Task List at any point of time. The Task ID is reflected as
<br>eg. D1, E5, T21
* The first alphabet "T", "E" and "D" refers to `Todo`, `Event`, and `Deadline` respectively, and the number followed
after the alphabet is the Task Number, which refers to the index of the `Task` you created with respect to all the
`Task` you ever created.

### 6.2 Viewing help : `help`

Shows a message explaining how to access the help page.
<br>**Format: `help`**

### 6.3 Adding Information : `add`

#### 6.3.1 Adding Todos : `-t`

Adds your personal `Todo` with a `description`.

![AddTodo](images/userguide/addTodo.png)

<br>**Format: `add -t DESCRIPTION`**
<br>Examples:
* `add -t Clear the bin`
* `add -t Return calculator to Mary`

#### 6.3.2 Adding Events : `-e`

Adds your personal `Event` with a `description`, to attend at a specific `date` and `time`.

![AddEvent](images/userguide/addEvent.png)

<br>**Format: `add -e DESCRIPTION d/YYYY-MM-DD t/HH:MM`**
<br>Examples:
* `add -e John’s birthday party d/2020-09-21 t/20:00`
* `add -e CS2103T team meeting d/2020-09-27 t/10:30`

<div markdown="block" class="alert alert-info">

An `Event` requires extra `date` and `time` specifications in order to create.
</div>

#### 6.3.3 Adding Deadlines : `-d`

Adds your personal `Deadline` with a `description`, to complete by a specific `date` and `time`.

![AddDeadline](images/userguide/addDeadline.png)

<br>**Format: `add -d DESCRIPTION d/YYYY-MM-DD t/HH:MM`**
<br>Examples:
* `add -d CS2103T Week 5 ip tasks d/2020-09-08 t/23:59`
* `add -d Research project report d/2020-10-05 t/10:30`

<div markdown="block" class="alert alert-info">

Similar to `Event`, a `Deadline` requires extra `date` and `time` specifications in order to create.
</div>

#### 6.3.4 Adding Consultations : `-c`

Adds a `Consultation` session with a `Student` at a specific `date` and `time`.
<br>**Format: `add -c NAME d/YYYY-MM-DD t/HH:MM`**
<br>Examples:
* `add -c John Doe d/2020-09-20 t/13:30`
* `add -c Mary Jane d/2021-01-02 t/09:15`

<div markdown="block" class="alert alert-info">

When you add a `Consultation` for a future date while displaying only past `Consultations`, make sure to enter `view -c` to view the complete list to check if the `Consultation` has been added correctly.
Similarly, when you add a `Consultation` for a past date while displaying only future `Consultations`, make sure to enter `view -c` to view the complete list to check if the `Consultation` has been added correctly.
</div>

#### 6.3.5 Adding Mastery Checks : `-mc`

Adds a `Mastery Check` session with a `Student` at a specific `date` and `time`.
<br>**Format: `add -mc NAME d/YYYY-MM-DD t/HH:MM`**
<br>Examples:
* `add -mc John Doe d/2020-09-20 t/13:30`
* `add -mc Mary Jane d/2021-01-02 t/09:15`

<div markdown="block" class="alert alert-info">

When you add a `Mastery Check` for a future date while displaying only past `Mastery Checks`, make sure to enter `view -mc` to view the complete list to check if the `Mastery Check` has been added correctly.
Similarly, when you add a `Mastery Check` for a past date while displaying only future `Mastery Check`, make sure to enter `view -mc` to view the complete list to check if the `Mastery Check` has been added correctly.
When a `Mastery Check` is first added, a `FAIL` default value will be assigned.
</div>

### 6.4 Editing Information : `edit`

#### 6.4.1 Editing Login Information : `-l`

You can use tags to specify the field to be edited.
<br>**Format: `edit -l u/LUMINUS_USERNAME p/LUMINUS_PASSWORD`**
<br>Examples:
* `edit -l u/nusstu\e1234567 p/testpassword`
* `edit -l p/testpassword`

<div markdown="block" class="alert alert-info">

* Do note that it takes a load time of around ~5 seconds after entering this command for the changes from Source Academy to be reflected in the GUI.
* After the students, missions and quests have loaded, take note that the `Telegram` and `Email` fields of the student are placeholder values.
* This is because Source Academy does not contain these 2 fields of any student. Editing the student details will save the updated values.
* After a TA account has been used to log in and fetch the information, logging in with a non-TA account will not change the information displayed
as we choose to give you the benefit of doubt of keying in the wrong login details.
* Whenever a TA account is used to log in, the information will always be updated to reflect the logged in TA's student,
mission and quest information.
</div>

#### 6.4.2 Editing Student Information : `-s`
<br>**Format: `edit -s INDEX n/NAME t/TELEGRAM e/EMAIL`**
<br>Examples:
* `edit -s 1 e/koolguy@gmail.com t/handsome`
* `edit -s 3 n/Timots`

#### 6.4.3 Editing Mastery Checks : `-mc`

Edits the score of a `Mastery Check` session with a `Student`.
<br>**Format: `edit -mc INDEX s/SCORE`**
<br>Examples:
* `edit -mc 1 s/0`
* `edit -mc 3 s/1`

<div markdown="block" class="alert alert-info">

Do note that the SCORE parameter can only be 0 or 1, according to the actual restrictions of Mastery Check pass/fail in CS1101S.
</div>

### 6.5 Deleting Information : `delete`

#### 6.5.1 Deleting Tasks : `-t`

Deletes a task based on the `TASK_ID` you specify.

![DeleteTask](images/userguide/deleteTask.png)

<br>**Format:`delete -t TASK_ID`**
<br>Examples:
* `delete -t T3`
* `delete -t D2`

#### 6.5.2 Deleting Consultations : `-c`

Deletes a task based on the `CONSULTATION_ID` you specify.
<br>**Format: `delete -c CONSULTATION_ID`**
<br>Examples:
* `delete -c 3`

#### 6.5.3 Deleting Mastery Checks : `-mc`

Similar to the above process of deleting consultations, deleting `Mastery Checks` first
Deletes a task based on the `MASTERYCHECK_ID` you specify.
<br>**Format: `delete -mc MASTERYCHECK_ID`**
<br>Examples:
* `delete -mc 3`

### 6.6 Viewing Information : `view`

#### 6.6.1 Viewing a list of all Students : `-s`

Shows a list of all students under the tutor in Jarvis.
Please take note of the command inputted into the command box to understand how the respective commands are inputted.

<br>**Format: `view -s`**

You may also click on the `Student` tab to do so.

![ViewAllStudentsCommand](images/userguide/viewAllStudents.png)

#### 6.6.2 Viewing one Student : `-s [NAME]`

Shows all students that match(partial and full) the student name entered after the command. The name is case
-insensitive. An example of a partial match will be `view -s do` resulting in John Doe being displayed.

![ViewOneStudentCommand](images/userguide/viewOneStudent.png)

<br>**Format: `view -s [NAME]`**
<br>Examples:
* `view -s John Doe`

#### 6.6.3 Viewing all Consultation sessions : `-c`

Shows all `confirmed consultation` sessions, both past and upcoming.
<br>**Format: `view -c`**
<br>Examples:
* `view -c`

You may also click on the `Consultation` tab to do so.

#### 6.6.4 Viewing past Consultation sessions : `-cp`

Shows all `past consultation` sessions.
<br>**Format: `view -cp`**
<br>Examples:
* `view -cp`

When the consultation time is the same as the local time (year, month, date, hour, and minute all equal), it is considered as a past consultation.

#### 6.6.5 Viewing upcoming Consultation sessions : `-cu`

Shows all `upcoming consultation` sessions.
<br>**Format: `view -cu`**
<br>Examples:
* `view -cu`

<div markdown="block" class="alert alert-info">

When the time of the consultation displayed by `view -cu` is earlier than the local time (year, month, date, hour, and minute all equal) and then caught up eventually,
it is still considered as an upcoming consultation when you enter `view -cu`. This is to encourage the tutors to have this screen open while holding the consultation session.
When you switch to another command, such as `view -c` or `view -cp`, and then come back, you may see the updated consultation list with the current local time as the standard.
</div>

#### 6.6.6 Viewing all Mastery Check sessions : `-mc`

Shows all `confirmed MC` sessions, both past and upcoming.
<br>**Format: `view -mc`**
<br>Examples:
* `view -mc`

You may also click on the `Mastery Check` tab to do so.

#### 6.6.7 Viewing past Mastery Check sessions : `-mcp`

Shows all `past MC` sessions.
<br>**Format: `view -mcp`**
<br>Examples:
* `view -mcp`

<div markdown="block" class="alert alert-info">

When the mastery check time is the same as the local time (year, month, date, hour, and minute all equal), it is considered as a past consultation.
</div>

#### 6.6.8 Viewing upcoming Mastery Check sessions : `mcu`

Shows all `upcoming MC` sessions.
<br>**Format: `view -mcu`**
<br>Examples:
* `view -mcu`

<div markdown="block" class="alert alert-info">

When the time of the mastery check displayed by `view -mcu` is earlier than the local time (year, month, date, hour, and minute all equal) and then caught up eventually,
it is still considered as an upcoming mastery check when you enter `view -mcu`. This is to encourage the tutors to have this screen open while holding the mastery check session.
When you switch to another command, such as `view -mc` or `view -mcp`, and then come back, you may see the updated mastery check list with the current local time as the standard.
</div>

#### 6.6.9 Viewing deadline for Missions : `-m`

Shows the deadline for the current mission(s).
<br>**Format: `view -m`**

You may also click on the `Mission` tab to do so.

![FetchMission](images/userguide/viewMissions.png)

#### 6.6.10 Viewing deadline for Quests : `-q`

Shows the deadline for the current quest(s).
<br>**Format: `view -q`**

You may also click on the `Quest` tab to do so.

![FetchQuest](images/userguide/viewQuests.png)

#### 6.6.11 Viewing ungraded Missions : `-um`

Shows the missions that you have not yet graded.

![ViewUngradedMissions](images/userguide/viewUngradedMissions.png)

<br>**Format: `view -um`**

#### 6.6.12 Viewing ungraded Quests : `-uq`

Shows the quests that you have not yet graded.

![ViewUngradedQuests](images/userguide/viewUngradedQuests.png)

<br>**Format: `view -uq`**

#### 6.6.13 Viewing all Tasks : `-t`

Shows the list of all your current tasks.
<br>**Format: `view -t`**

You may also click on the `Task` tab to do so.

#### 6.6.14 Viewing all Todos : `-tt`

Shows the list of all your current todos.
<br>**Format: `view -tt`**

#### 6.6.15 Viewing all Events : `-te`

Shows the list of all your current events.
<br>**Format: `view -te`**

#### 6.6.16 Viewing all Deadlines : `-td`

Shows the list of all your current deadlines.
<br>**Format: `view -td`**

### 6.7 Exiting the program : `exit`

Exits the program.
<br>**Format: `exit`**

### 7.7 Saving the data

Jarvis data are saved in the file `jarvis.json` automatically after any command that changes the data. There is no need to save manually.

<div markdown="block" class="alert alert-info">

Note that only `Student`, `Consultation`, `Mastery Check` and `Task` data are saved to the hard drive since `Mission` and `Quest` data
are likely to change frequently.
</div>

--------------------------------------------------------------------------------------------------------------------

## 7. Command Summary

### 7.1 Add Command Summary

| Function | Tag | Format, Examples |
| -------- | --- | ---------------- |
| Add Todo | -t | add -t DESCRIPTION |
| Add Event | -e | add -e DESCRIPTION d/YYYY-MM-DD t/HH:MM |
| Add Deadline | -d | add -d DESCRIPTION d/YYYY-MM-DD t/HH:MM |
| Add Consultation | -c | add -c NAME d/YYYY-MM-DD t/HH:MM |
| Add Mastery Check | -mc | add -mc NAME d/YYYY-MM-DD t/HH:MM |

### 7.2 Edit Command Summary

| Function | Tag | Format, Examples |
| -------- | --- | ---------------- |
| Edit Login details | -l | edit -l u/LUMINUS_USERNAME p/LUMINUS_PASSWORD |
| Edit Student details | -s | edit -s INDEX n/NAME t/TELEGRAM e/EMAIL |
| Edit Mastery Check | -mc | edit -mc INDEX /SCORE |

### 7.3 Delete Command Summary

| Function | Tag | Format, Examples |
| -------- | --- | ---------------- |
| Delete Task | -t | delete -t TASK_ID |
| Delete Consultation | -c | delete -c NAME <br>E.g. delete -c → 3 / delete -c John Doe → 2 |
| Delete Mastery Check | -mc | delete -mc NAME <br>E.g. delete -mc → 3 / delete -mc John Doe → 2 |

### 7.4 View Command Summary

| Function | Tag | Format, Examples |
| -------- | --- | ---------------- |
| View one Student | -s | view -s NAME |
| View all Consultations | -c | view -c NAME <br>E.g. view -c / view -c John Doe |
| View all Past Consultations | -cp | view -cp NAME <br>E.g. view -cp, view -cp John Doe |
| View all Upcoming Consultations | -cu | view -cu NAME <br>E.g. view -cu / view -cu John Doe |
| View all Mastery Checks | -mc | view -mc |
| View all Past Mastery Checks | -mcp | view -mcp |
| View all Upcoming Mastery Checks | -mcu | view -mcu  |
| View deadlines for Missions | -m | view -m |
| View deadlines for Quests | -q | view -q |
| View ungraded Missions | -um | view -um |
| View ungraded Quests | -uq | view -uq |
| View all Tasks | -t | view -t |
| View all Todos | -tt | view -tt |
| View all Events | -te | view -te |
| View all Deadlines | -td | view -td |

### 7.5 Exit Command Summary

| Function | Format, Examples |
| -------- | ---------------- |
| Exits program | `exit` |

### 7.6 Help Command Summary

| Function | Format, Examples |
| -------- | ---------------- |
| Provide help with program commands | `help` |

## 8. Glossary
### 8.1 Difference Between Consultations and Mastery Checks
Mastery Checks are a specific type of consultations that is mandatory and graded in CS1101S, unlike normal consultations, and thus are displayed in separate tabs in Jarvis.


## 9. FAQ

`Q: How do I transfer my data to another Computer?`
<br>`A: Install the app in the other computer and overwrite the empty data file(.json file) it creates with the file(.json file) that contains the data of your previous JARVIS home folder.`
