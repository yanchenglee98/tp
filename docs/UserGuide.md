---
layout: page
title: User Guide
---

## 1 Introduction

### 1.1 Welcome

Welcome to the Hall-y User Guide!

Hall-y (pronounced _hall-ee_) is a desktop application designed to help you manage hall residents and events.

It features a simple text interface, also known as Command Line Interface (CLI), as well as visual representations of your hall residents and events using a Graphical User Interface (GUI).

If you can type fast, Hall-y will allow you to manage hall residents and events more efficiently than traditional GUI applications.

Interested? You can jump straight to the [Getting Started](#4-Getting-Started) guide and start trying Hall-y now! Alternatively, you can check out Hall-y's feature list [here](#6-Features).

### 1.2 Purpose of Document

The purpose of this document is to teach you how to start up Hall-y, and to provide information necessary to understand how to use this application. It will provide the commands used in Hall-y and tell you how to use them.

### 1.3 Target Audience

The target audience for Hall-y is the NUS Eusoff Hall administrative staff, who is responsible for managing residents in hall. This includes keeping track of their information, such as the rooms they stay in, their student group, their matriculation number and contact information.

--------------------------------------------------------------------------------------------------------------------

## 2 Table of Contents

* TOC
{:toc}

--------------------------------------------------------------------------------------------------------------------

## 3 About This Document

The following table explains the formatting used in this guide and its definition.

Format | Definition, Examples
--------|------------------
`code` | Represent a command or part of a command. <br> e.g. `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 br/A104 g/M m/A0199242X`
UPPER_CASE | Represent a parameter to be supplied by the user. <br> e.g. `n/NAME` can be used as `n/John Doe`
[item] | Represent an optional parameter to be supplied by the user. <br> e.g. `n/NAME [p/PHONE_NUMBER]` can be used as `n/John Doe p/91234567` or as `n/John Doe`

--------------------------------------------------------------------------------------------------------------------

## 4 Getting Started

You can get Hall-y up and running within 5 minutes. Just follow the steps below:

1. Ensure you have Java 11 or above installed in your Computer
2. Download the latest `hall-y.jar` file from [here](https://github.com/AY2021S1-CS2103T-T11-2/tp/releases/)
3. Copy the downloaded file and paste it into the folder you want to use as the home folder for your application
4. Double-click on `hall-y.jar` to start the application
5. You should see a similar GUI to the one below - notice that the application comes with some sample data:
![Initial load](https://i.imgur.com/wK8eZdd.png)

Congratulations! You now have Hall-y running on your Computer.

Now, suppose you want to add a resident called Timmy Tan. He is one of your new residents with the following details:

Category | Details
-------- | ------
Email    | first@example.com
Address  | Blk 10, Bedok St 1, #02-01
Block and Room | A100
Gender | Male
Matriculation Number | A2000000X

Here is how you can add him into Hall-y:

1. Type the following command into the input box:
`add n/Timmy Tan p/91234567 e/first@example.com a/Blk 10, Bedok St 1, #02-01 br/A100 g/M m/A2000000X`
2. You should see the application update, like so:
![Add new resident](https://i.imgur.com/ixYwySO.png)
3. Scroll down to see the resident you have just added, like so:
![Scroll down to see resident](https://i.imgur.com/4j23ZAa.png)

Congratulations! You have just added a resident called Timmy Tan.

You can continue experimenting with some of the commands below:

- `list`: lists all the residents currently in the application
- `delete 1`: deletes the first resident shown in the application
- `clear`: deletes all the contacts in the application
- `exit`: exits the application

Alternatively, you can check out Hall-y's feature list [here](#6-Features) for more commands.

--------------------------------------------------------------------------------------------------------------------

## 5 Application Interface

You can refer to the diagram below to understand how Hall-y looks like:

![Hall-y's Interface](https://i.imgur.com/59MxOwe.png)

The table below shows a brief explanation of each section:

Section        | Explanation
-------------- | -----------
Input box      | You should input your command here.
Result box     | You can see the results of your command here.<br />If there is an error in your command, you can see it here too.
Blocks list    | This is the list of blocks present in your hall.<br />You should only use these blocks and rooms in your inputs.
Residents list | This is the list of residents based on your latest command. <br />When you first launch, this is the full list of residents in Hall-y.
Events list | This is the list of events currently stored in Hall-y.

--------------------------------------------------------------------------------------------------------------------

## 6 Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [p/PHONE_NUMBER]` can be used as `n/John Doe p/91234567` or as `n/John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

### 6.1 Listing all residents : `list`

You can list all added residents by using the `list` command.

The steps for this command are as follows:
1. Enter the list command by typing `list` into the input box
2. Press enter
3. The result box will show 'Listed all residents' <br> ![](https://i.imgur.com/RuRPnAq.png)
4. The residents list will then show the list of residents <br> ![](https://i.imgur.com/qkR7DTG.png)

### 6.2 Adding a resident: `add`


You can add a new resident to Hall-y by using the `add` command.

The steps for this command are as follows:

1. Enter the add command by typing `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS br/ROOM_NUMBER g/GENDER m/MATRICULATION_NUMBER [s/STUDENT_GROUP...]` into the input box 
2. Press enter
3. The result box will show the details of the added resident![](https://i.imgur.com/xZOvAVP.png)
4. Scroll down to the bottom of the residents list to view the newly added resident
![](https://i.imgur.com/FGmNSKv.png)

#### Note:
Please take note of the format required:
* `ROOM_NUMBER`:  \<Block\>\<Room Number\>, e.g. B505, C201
* `GENDER`:  M for male, F for female

Examples:

*   `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 br/A104 g/M m/A0199242X s/soccer`
*   `add n/Lee Xiao Ming p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 g/M br/A420 m/A0123456B s/badminton s/dance`


### 6.3 Editing a resident : `edit`

You can edit an existing resident to Hall-y by using the `edit` command.

The steps for this command are as follows:

1. Enter the edit command by typing `edit [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [br/ROOM_NUMBER] [g/GENDER] [m/MATRICULATION_NUMBER] [s/STUDENT_GROUP...]` into the input box 
2. Press enter
3. The result box will show the details of the added resident![To update](https://i.imgur.com/xZOvAVP.png)
4. Scroll to the specified index of the resident list to view the update resident
![To update](https://i.imgur.com/FGmNSKv.png)

#### Note:
Please take note of the format required:
* `ROOM_NUMBER`:  \<Block\>\<Room Number\>, e.g. B505, C201
* `GENDER`:  M for male, F for female

Examples:
* `edit 1 p/91234567 e/johndoe@example.com br/B402`   
Edits the phone number, email address and room number of the 1st resident to be 91234567, johndoe@example.com and B402 respectively.
* `edit 2 n/Betsy Crower p/87652103`   
Edits the name of the 2nd resident and phone number to be `Betsy Crower` and 87652103 respectively.

### 6.4 Deleting a resident : `delete`

You can delete a resident specified at an index by using the `delete` command followed with the index.

The steps for this command are as follows:
1. Enter the delete command by typing `delete INDEX` into the input box. <br> With `INDEX` being the corresponding index of the specified resident as seen on the list <br> ![](https://i.imgur.com/koD3cte.png)
2. Press enter
3. The result box will show 'Deleted Person:' and the details of the deleted resident <br> ![](https://i.imgur.com/1JOAAFM.png)
4. The resident list will be updated <br> ![](https://i.imgur.com/DCVZiEt.png)

### 6.5 Listing all student groups : `list-group`

You can list all student groups by using the `list-group` command.

The steps for this command are as follows:
1. Enter the list group command by typing `list-group` into the input box
2. Press enter
3. The result box will display all the student groups: 
![TODO: Placeholder](https://i.imgur.com/oCRZHbD.png)

### 6.6 Adding a hall event : `add-event`

You can add a hall event by using the `add-event` command.

The steps for this command are as follows:

1. Enter the add event command by typing `add-event n/NAME d/DESCRIPTION` into the input box
2. Press enter
3. The result box will show the new event created:
![New event added](https://i.imgur.com/70Va3Dt.png)
4. The events list will show the newly added event:
<img src="https://i.imgur.com/mNjKNOT.png" width="250"/>

### 6.7 Deleting a hall event : `delete-event`

You can delete a hall event specified at an index by using the `delete-event` command followed by the index.

The steps for this command are as follows:
1. Enter the delete event command by typing `delete-event INDEX` into the input box. <br>with `INDEX` being the corresponding index of the specified event as seen on the events list
2. Press enter
3. The result box will show 'Deleted Event:' and the details of the deleted event: 
![](https://i.imgur.com/DIRx3Zx.png)

### 6.8 Assigning a resident to a hall event: `assign`

You can assign a resident to a hall event by using the `assign` command followed by the index of the resident and event.

The steps for this command are as follows:
1. Enter the assign command by typing `assign RESIDENT_INDEX EVENT_INDEX` into the input box. <br>with `RESIDENT_INDEX` being the corresponding index of the specified resident as seen on the residents list.
And `EVENT_INDEX` being the corresponding index of the specified event as seen on the events list. <br> ![](https://i.imgur.com/D2dDf0n.png)
2. Press enter
3. The result box will show 'Assigned resident to event' <br> ![](https://i.imgur.com/gs3jTTM.png)
4. The event list will then be updated to show the newly assigned resident <br> ![](https://i.imgur.com/NmfcXzX.png)

Note:
* Both indices refers to the index number shown in the displayed resident and event list respectively.
* Both indices **must be a positive integer** 1, 2, 3, …​

Examples:
* `assign 1 1` assigns the 1st resident to the 1st event

### 6.9 Clearing attendee list of event: `clear-event`

You can clear the attendee list of an event by using the `clear-event` command followed by the index of the event.

The steps for this command are as follows:
1. Enter the clear event command by typing `clear-event EVENT_INDEX` into the input box. <br> with `EVENT_INDEX` being the corresponding index of the specified event as seen on the events list. <br>![](https://i.imgur.com/det13Su.png)
2. Press enter
3. The result box will show 'Cleared attendee list of Event:' followed by the details of the event <br> ![](https://i.imgur.com/7TxhF41.png)
4. The event list will then be updated to show the cleared event <br> ![](https://i.imgur.com/sFGxyMY.png)


Note:
* Event index refers to the index number shown in the displayed event list respectively.
* Event index **must be a positive integer** 1, 2, 3, …​

Examples:
* `clear-event 1` clears the attendee list of the 1st event

### 6.10 Filtering residents by event: `filter-event`

You can filter residents by event by using the `filter-event` command followed by the index of the event.

The steps for this command are as follows:
1. Enter the filter event command by typing `filter-event EVENT_INDEX` into the input box. <br> with `EVENT_INDEX` being the corresponding index of the specified event as seen on the events list. <br>![](https://i.imgur.com/det13Su.png)
2. Press enter
3. The result box will show 'Displaying residents attending event' followed by the name of the event <br> ![](https://i.imgur.com/aY4uzhd.png)
4. The resident list will then be updated to show attendees of the event <br> ![](https://i.imgur.com/6bzwmjV.png)


Note:
* Event index refers to the index number shown in the displayed event list respectively.
* Event index **must be a positive integer** 1, 2, 3, …​

Examples:
* `filter-event 1` shows the residents that are attending the 1st event

### 6.11 Locating residents by characteristics: `find`

You can find all persons whose characteristics match the given arguments and keywords. The residents list will automatically display these residents.

The steps for this command are as follows:

1. Enter the find command by typing `find [n/KEYWORDS [MORE KEYWORDS]] [b/BLOCK] [f/FLOOR] [r/ROOM_NUMBER] [m/MATRICULATION_NUMBER] [g/GENDER] [s/STUDENT_GROUP...]` into the input box.
2. Press enter.
3. The result box will show how many residents fit the inputted characteristics. <br> ![Result box of find](https://i.imgur.com/TAiW2DU.png)
4. The residents list will be updated with the residents who fit the inputted characteristics. <br> ![Residents list of find](https://i.imgur.com/0ZUuAn8.png)


#### Note:
Please take note of the format required:
* `ROOM_NUMBER`:  The last 2 digits of the room numbers, e.g. 05, 12, 15, etc.
* `FLOOR`:  The number of the floor of the resident you want to find, e.g. 1, 2, 3 and so on.
* `BLOCK`: The alphabetical name of the block, e.g. A, B, C, or D
* `GENDER`:  M for male, F for female
* `KEYWORDS`: refers to any part of a resident's name, e.g. `Carl` is a keyword from `Carl Kurz`

### Tips
* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* When searching with names, residents matching at least one keyword with names will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`
* For the rest of the parameters, like block and floor, residents matching all of them will be returned (i.e. `AND` search, where the returned resident will live on this floor AND in this block)

Examples:
* `find n/John` returns `john` and `John Doe`
* `find l/3 s/badminton` returns `Alice Pauline`, `Fiona Kunz` who live on the third floor and are in the `Badminton` student group. <br> ![Example 2](https://i.imgur.com/hAmEOib.png)


Note:
* The index refers to the index number shown in the displayed resident list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd resident in Hall-y.
* `find Betsy` followed by `delete 1` deletes the 1st resident in the results of the `find` command.

### 6.12 Exporting of email : `export`

You can export the email address of all added entries as a .txt file by using the `export` command.

The steps for this command are as follows:
1. Enter the `export` command with `email` as follows `export email` into the input box
2. Press enter
3. The result box will show 'List of emails exported' <br> ![](https://i.imgur.com/cJchdRv.png)
4. A data folder which contains the .txt file will be created in the same location as your Hall-y application 
5. Click the folder and the list of emails will be in the file named hally.txt <br> ![](https://i.imgur.com/CEYx5J8.png)

### 6.13 Clearing all entries : `clear`

You can clear all residents in Hall-y by using the `clear` command

The steps for this command are as follows:
1. Enter the clear command by typing `clear` into the input box.
2. Press enter
3. The result box will show "Address book has been cleared"<br> ![](https://i.imgur.com/taII762.png)
4. The resident list will now be empty ![](https://i.imgur.com/fUTbPZJ.png)

### 6.14 Viewing help : `help`

You can request for help if you are unfamiliar with the commands. You can copy the URL and view an online copy of our user guide by using the `help` command.

The steps for this command are as follows:
1. Enter the help command by typing `help` into the input box
2. Press enter
3. The result box will show 'Opened help window.' <br> ![](https://i.imgur.com/QiH0mzl.png)
4. The help window will pop out <br> ![](https://i.imgur.com/Tw8tt6j.png)
5. Copy the URL and paste it into a browser of your choice to view the online user guide

### 6.15 Exiting the application : `exit`

You can exit the application by using the `exit` command

The steps for this command are as follows:
1. Enter the exit command by typing `exit` into the input box.
2. Press enter
3. The application should now be closed

### 6.16 Saving the data

Hall-y's data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

--------------------------------------------------------------------------------------------------------------------

## 7 FAQ

**Q**: How do I transfer my data to another computer?\
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Hall-y home folder.

**Q**: Where is all my save data stored?\
**A**: They are stored in the `data` folder that in the Hall-y home folder

**Q**: How do I make backups of my data in Hall-y?\
**A**: Copy and paste the `data` folder located in the Hall-y home folder somewhere safe. To restore the backup. Copy it back into the same home folder.

**Q**: How do I delete all my data in Hall-y?\
**A**: Delete the `data` folder located in the Hall-y home folder.

--------------------------------------------------------------------------------------------------------------------

## 8 Command Summary

Action | Format, Examples
--------|------------------
**Add event** | `add-event n/NAME d/DESCRIPTION`
**Add resident** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS br/ROOM_NUMBER g/GENDER m/MATRICULATION_NUMBER [s/STUDENT_GROUP]…` <br> e.g. `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 br/A104 g/M m/A0199242X s/badminton`
**Assign resident** | `assign RESIDENT_INDEX EVENT_INDEX` <br> e.g. `assign 1 1`
**Clear** | `clear`
**Clear event** | `clear-event EVENT_INDEX` <br> e.g. `clear-event 1`
**Delete event** | `delete-event INDEX`
**Delete resident** | `delete INDEX`<br> e.g. `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [br/ROOM_NUMBER] [g/GENDER] [m/MATRICULATION_NUMBER][s/STUDENT_GROUP]…​​`<br> e.g.`edit 2 n/James Lee e/jameslee@example.com br/A210`
**Export** | `export`
**Find** | `find [n/KEYWORDS [MORE KEYWORDS]] [b/BLOCK] [f/FLOOR] [r/ROOM_NUMBER] [m/MATRICULATION_NUMBER] [g/GENDER] [s/STUDENT_GROUP...]`<br> e.g. `find b/B l/2 g/F`
**Filter event** | `filter-event EVENT_INDEX` <br> e.g. `filter-event 1`
**Help** | `help`
**List all residents** | `list`
**List all student groups** | `list-group`

--------------------------------------------------------------------------------------------------------------------

## Appendix A: Glossary

* **Command Line Interface (CLI)**: Text interface to interact with the application by typing the command
* **Graphical User Interface (GUI)**: Visual interface to interact with the application
* **Hall admin**: An administrative staff to handle hall-related matters
* **Matriculation number**: Unique identification for NUS students, which they will obtain when they matriculate into NUS
* **Student group**: An interest group for the hall residents to conduct extracurricular activities
