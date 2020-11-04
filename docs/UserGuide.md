---
layout: page
title: User Guide
---

<img src="https://i.imgur.com/O63Idc0.png" width="250" />

Hall-y User Guide

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

* TOC
{:toc}

--------------------------------------------------------------------------------------------------------------------

## 1 Introduction

### 1.1 Welcome

Welcome to the Hall-y User Guide!

Hall-y (pronounced _hall-ee_) is a desktop application designed to help you manage hall residents and events.

It features a simple text interface, also known as Command Line Interface (CLI), as well as visual representations of your hall residents and events using a Graphical User Interface (GUI).

If you can type fast, Hall-y will allow you to manage hall residents and events more efficiently than traditional GUI applications.

Interested? You can jump straight to the [Getting Started](#3-getting-started) guide and start trying Hall-y now! Alternatively, you can check out Hall-y's feature list [here](#5-features).

### 1.2 Purpose of Document

The purpose of this document is to teach you how to start up Hall-y, and to provide information necessary to understand how to use this application. It will provide the commands used in Hall-y and tell you how to use them.

### 1.3 Target Audience

The target audience for Hall-y is the NUS Eusoff Hall administrative staff, who is responsible for managing residents in hall. This includes keeping track of their information, such as the rooms they stay in, their student group, their matriculation number and contact information.

--------------------------------------------------------------------------------------------------------------------

## 2 About This Document

The following table explains the formatting used in this guide, its' definition, and a relevant example.

Format | Definition, Examples
--------|------------------
`code` | Represent a command or part of a command. <br> e.g. `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 br/A104 g/M m/A0199242X`
UPPER_CASE | Represent a parameter to be supplied by the user. <br> e.g. `n/NAME` can be used as `n/John Doe`
[item] | Represent an optional parameter to be supplied by the user.<br> Parameters can be keyed in any order <br> e.g. `n/NAME [p/PHONE_NUMBER]` can be used as `n/John Doe p/91234567` or as `n/John Doe`

--------------------------------------------------------------------------------------------------------------------

## 3 Getting Started

You can get Hall-y up and running within 5 minutes. Just follow the steps below:

1. Ensure you have Java 11 or above installed in your Computer
2. Download the latest `hall-y.jar` file from [here](https://github.com/AY2021S1-CS2103T-T11-2/tp/releases/)
3. Copy the downloaded file and paste it into the folder you want to use as the home folder for your application
4. Double-click on `hall-y.jar` to start the application
5. You should see a similar GUI to the one below - notice that the application comes with some sample data:
![Initial load](https://i.imgur.com/nYAiX49.png)

Congratulations! You now have Hall-y running on your Computer.

Now, suppose you want to add a resident called Timmy Tan. He is one of your new residents with the following details:

Category | Details
-------- | ------
Phone    | 91234567
Email    | <span>first@example.com</span>
Address  | Blk 10, Bedok St 1, #02-01
Block and Room | A101
Gender | Male
Matriculation Number | A2000000X

Here is how you can add him into Hall-y:

1. Type the following command into the input box:
`add n/Timmy Tan p/91234567 e/first@example.com a/Blk 10, Bedok St 1, #02-01 br/A101 g/M m/A2000000X`
2. You should see the application update, like so:
![Add new resident](https://i.imgur.com/EaXkXD5.png)
3. Scroll down to see the resident you have just added, like so:
![Scroll down to see resident](https://i.imgur.com/JNjrMIN.png)

Congratulations! You have just added a resident called Timmy Tan.

You can continue experimenting with some of the commands below:

- `list`: lists all the residents currently in the application
- `delete 1`: deletes the first resident shown in the application
- `clear`: deletes all the contacts in the application
- `exit`: exits the application

Alternatively, you can check out Hall-y's feature list [here](#5-features) for more commands.

--------------------------------------------------------------------------------------------------------------------

## 4 Application Interface

You can refer to the diagram below to understand how Hall-y looks like:

![Hall-y's Interface](https://i.imgur.com/Awmyti6.png)

The table below shows a brief explanation of each section:

Section        | Explanation
-------------- | -----------
Input box      | You should input your command here.
Result box     | You can see the results of your command here.<br />If there is an error in your command, you can see it here too.
Blocks list    | This is the list of blocks present in your hall.<br />You should only use these blocks and rooms in your inputs.
Residents list | This is the list of residents based on your latest command. <br />When you first launch, this is the full list of residents in Hall-y.
Events list | This is the list of events currently stored in Hall-y.

--------------------------------------------------------------------------------------------------------------------

## 5 Features

### 5.1 Listing all residents : `list`

You can list all added residents by using the `list` command.

The steps for this command are as follows:
1. Enter the list command by typing `list` into the input box
2. Press enter
3. The result box will show 'Listed all residents' <br> ![](https://i.imgur.com/RuRPnAq.png)
4. The residents list will then show the list of residents <br> ![](https://i.imgur.com/qkR7DTG.png)

### 5.2 Adding a resident: `add`


You can add a new resident to Hall-y by using the `add` command.

The steps for this command are as follows:

1. Enter the add command by typing `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS br/ROOM_NUMBER g/GENDER m/MATRICULATION_NUMBER [s/STUDENT_GROUP...]` into the input box, followed by enter to execute the command
2. The result box will show the details of the added resident  
![](https://i.imgur.com/5dSSf4h.png)
3. Scroll down to the bottom of the residents list to view the newly added resident  
![](https://i.imgur.com/PPahQcr.png)


Note:
Please take note of the format required:
* `ROOM_NUMBER`:  \<Block\>\<Room Number\>, e.g. B505, C201
* `GENDER`:  M for male, F for female

Examples:

*   `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 br/A104 g/M m/A0199242X s/soccer`
*   `add n/Lee Xiao Ming p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 g/M br/A420 m/A0123456B s/basketball s/hackers`


### 5.3 Editing a resident : `edit`

You can edit an existing resident to Hall-y by using the `edit` command.

The steps for this command are as follows:

1. Enter the edit command by typing `edit [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [br/ROOM_NUMBER] [g/GENDER] [m/MATRICULATION_NUMBER] [s/STUDENT_GROUP...]` into the input box, followed by enter to execute the command
3. The result box will show the details of the edited resident  
![](https://i.imgur.com/sgWw2sz.png)
4. Scroll to the specified index of the resident list to view the update resident  
![](https://i.imgur.com/BJAWQ3y.png)


Note:
Please take note of the format required:
* `ROOM_NUMBER`:  \<Block\>\<Room Number\>, e.g. B505, C201
* `GENDER`:  M for male, F for female

Examples:
* `edit 1 p/91234567 e/johndoe@example.com br/B402`   
Edits the phone number, email address and room number of the 1st resident to be 91234567, johndoe@example.com and B402 respectively.
* `edit 2 n/Betsy Crower p/87652103`   
Edits the name of the 2nd resident and phone number to be `Betsy Crower` and 87652103 respectively.

### 5.4 Deleting a resident : `delete` - Lee Yan Cheng

This command helps you delete a resident from Hall-y.

Let's say a resident Alex Yeoh has left the hall recently, and you wish to remove his details. Assume that Alex Yeoh is the first resident in the resident list.

Parameters | Details
-------- | ------
RESIDENT_INDEX | Index of resident in the resident list

You can remove him from Hall-y by typing in the command with these parameters using the following format:`


Here’s a step by step guide:
1. Type the following command into the input box `delete 1` and press <kbd>Enter</kbd> to execute the command. <br> ![](https://i.imgur.com/CcVhFWK.png)
2. The resident list will be updated to reflect the deleted resident. <br> ![](https://i.imgur.com/myogQWb.png)

### 5.5 Listing all student groups : `list-group`

You can list all student groups by using the `list-group` command.

The steps for this command are as follows:
1. Enter the list group command by typing `list-group` into the input box
2. Press enter
3. The result box will display all the student groups:   
![](https://i.imgur.com/BOa35Ql.png)

### 5.6 Adding a hall event : `add-event` - Low Jie Feng

This command helps you add an event into Hall-y.

Let's say you are holding a new event called Hall-oween. You can add it into Hall-y using this command. Suppose that it has the following details:

Parameters | Details
---------- | -------
Name | Hall-oween
Date | 30/10/2020 20:00
Location | Dining Hall
Description | Halloween celebration at Eusoff Hall.

You can add it into Hall-y by typing in the command with these parameters using the following format:

Format: `add-event n/NAME dt/DATE l/LOCATION d/DESCRIPTION`

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command:**<br>

* `DATE` should be formatted as DD/MM/YYYY HH:mm.<br>
  e.g. 20/10/2020 15:00, 01/11/2020 09:00, 01/01/2001 18:00.
  
* `NAME` and `LOCATION` must only contain letters or numbers. It cannot contain symbols such as `/` and `@`.
  
* You can use Hall-y to save events which are already over for recording purposes.

* You cannot save duplicate events in Hall-y. Hall-y regards 2 events to be the same if, ignoring case considerations, they have the same name, date and location.
  e.g. An event called Hall Dinner, happening in the Dining Hall on 01/01/2020 15:00 is the same as an event called hall dinner, happening in the dining hall on 01/01/2020 15:00.
  
</div>

Here's a step by step guide:
1. Type the following command into the input box:
`add-event n/Hall-oween dt/30/10/2020 20:00 l/Dining Hall d/Halloween celebration at Eusoff Hall.` and press <kbd>Enter</kbd> to execute the command
![](https://i.imgur.com/eIKFbJR.png)
2. The events list will be updated to reflect the new event
![](https://i.imgur.com/0iwDXgV.png)

Here are some other examples you can try:
* add-event n/Hall DnD dt/15/12/2020 19:00 l/Dining Hall d/End of year Dinner and Dance.
* add-event n/Hall Dinner dt/01/01/2020 15:00 l/Dining Hall d/The yearly Eusoff Hall Dinner.


### 5.7 Editing a hall event : `edit-event` - Low Jie Feng

This command helps you to edit an event’s details.

Let's say an event called Hall-oween has been changed to start at 21:00 instead. These are the fields you want to change:

New Parameters | Details
-------- | ------
Date | 30/10/2020 21:00

Let’s also assume that based on the current events list as shown below, Hall-oween has the event index of 1.
![](https://i.imgur.com/5j6PgZ1.png)

You can edit the event's details by typing in the command with these parameters using the following format:

Format: `edit-event EVENT_INDEX [n/NAME] [dt/DATE] [l/LOCATION] [d/DESCRIPTION]`

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command:**<br>

* You will need to take note of the same pointers as the add-event command.

* You cannot edit an event if by editing it, you cause Hall-y to save 2 events with the same name, location and date.

* Event index refers to the index number shown in the displayed event list.

* Event index **must be a positive integer** 1, 2, 3, …

</div>

Here’s a step by step guide:
1. Type the following command into the input box:
`edit-event 1 dt/30/10/2020 21:00` and press <kbd>Enter</kbd> to execute the command
![](https://i.imgur.com/x6sVmmg.png)
2. The events list will be updated to reflect the new event
![](https://i.imgur.com/w4PS7zN.png)

Here are some other examples you can try, assuming you have at least one event saved in Hall-y:
* edit-event 1 n/Hall DnD dt/15/12/2020 19:00 d/End of year Dinner and Dance.
* edit-event 1 l/UTown

### 5.7 Deleting a hall event : `delete-event` - Low Jie Feng

This command helps you delete an event from Hall-y.

Let's say Hall-oween has been cancelled, and you wish to remove it from Hall-y.

Let’s also assume that based on the current events list as shown below, Hall-oween has the event index of 1.
![](https://i.imgur.com/5j6PgZ1.png)

You can delete the event by typing in the command with the event index using the following format:

Format: `delete-event EVENT_INDEX`

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command:**<br>

* Event index refers to the index number shown in the displayed event list.

* Event index **must be a positive integer** 1, 2, 3, …

</div>

Here's a step by step guide:
1. Type the following command into the input box: `delete-event 1` and press <kbd>Enter</kbd> to execute the command
![](https://i.imgur.com/iuGKbL1.png)
2. The events list will be updated to reflect the deleted event
![](https://i.imgur.com/QMaYoUD.png)

### 5.9 Assigning a resident to a hall event: `assign` - Lee Yan Cheng

This command helps you assign a resident to an event.

Let's say resident Alex Yeoh will be attending the Hall Lunch event. Assume Alex Yeoh is the first resident in the resident list and Hall Lunch is the first event in the event list.

Parameters | Details
-------- | ------
RESIDENT_INDEX | Index of resident in the resident list
EVENT_INDEX | Index of event in the event list

You can add him into Hall-y by typing in the command with these parameters using the following format:

Format: `assign RESIDENT_INDEX EVENT_INDEX` 

Here’s a step by step guide:
1. Type the following command into the input box `assign 1 1` and press <kbd>Enter</kbd> to execute the command. ![](https://i.imgur.com/XXmm8FI.png)
2. The event list will then be updated to show the newly assigned resident <br> ![](https://i.imgur.com/3JFM1sk.png)

Note:
* Both indices refers to the index number shown in the displayed resident and event list respectively.
* Both indices **must be a positive integer** 1, 2, 3, …​

Examples:
* `assign 1 1` assigns the 1st resident to the 1st event

### 5.10 Clearing attendee list of event: `clear-event`

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

### 5.11 Filtering residents by event: `filter-event` - Lee Yan Cheng

This command helps you to filter the resident list by event.

Let’s say you want to get the details of the residents attending the event Hall Lunch. You can filter them by using this command. Suppose that the event is the first event on the event list.

Parameters | Details
-------- | ------
EVENT_INDEX | Index of event on the event list


You can filter residents by event by typing in the command with these parameters using the following format:

Format: `filter-event EVENT_INDEX` 

Here’s a step by step guide:
1. Type the following command into the input box `filter-event 1` and press <kbd>Enter</kbd> to execute the command. <br> ![](https://i.imgur.com/xnTRZJL.png)
2. The resident list will then be updated to show attendees of the event <br> ![](https://i.imgur.com/iKSFteY.png)



Note:
* Event index refers to the index number shown in the displayed event list respectively.
* Event index **must be a positive integer** 1, 2, 3, …​

Examples:
* `filter-event 1` shows the residents that are attending the 1st event

### 5.12 Locating residents by characteristics: `find`

You can find all persons whose characteristics match the given arguments and keywords. The residents list will automatically display these residents.

The steps for this command are as follows:

1. Enter the find command by typing `find [n/KEYWORDS [MORE KEYWORDS]] [b/BLOCK] [f/FLOOR] [r/ROOM_NUMBER] [m/MATRICULATION_NUMBER] [g/GENDER] [s/STUDENT_GROUP...]` into the input box.
2. Press enter.
3. The result box will show how many residents fit the inputted characteristics. <br> ![Result box of find](https://i.imgur.com/gPMxpz9.png)
4. The residents list will be updated with the residents who fit the inputted characteristics. <br> ![Residents list of find](https://i.imgur.com/aq1YmhQ.png)


Note:
Please take note of the format required:
* `ROOM_NUMBER`:  The last 2 digits of the room numbers, e.g. 05, 12, 15, etc.
* `FLOOR`:  The number of the floor of the resident you want to find, e.g. 1, 2, 3 and so on.
* `BLOCK`: The alphabetical name of the block, e.g. A, B, C, or D
* `GENDER`:  M for male, F for female
* `KEYWORDS`: refers to any part of a resident's name, e.g. `Carl` is a keyword from `Carl Kurz`

Tips
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

### 5.13 Exporting of email : `export` - Lee Yan Cheng

This command helps you to export the list of residents' emails.

Let’s say you need to send out details of the latest circular to all residents! You can export the list of emails as a .txt file using this command. 

The current displayed resident list can be exported using the following format:
Format: `export email` 

Here’s a step by step guide:
1. Type the following command into the input box `export email` and press <kbd>Enter</kbd> to execute the command. <br> ![](https://i.imgur.com/jMP6o6w.png)
2. A data folder which contains the .txt file will be created in the same location as your Hall-y application 
3. Click the folder and the list of emails will be in the file named hally.txt <br> ![](https://i.imgur.com/CEYx5J8.png)

### 5.14 Clearing all entries : `clear`

You can clear all residents in Hall-y by using the `clear` command

The steps for this command are as follows:
1. Enter the clear command by typing `clear` into the input box.
2. Press enter
3. The result box will show "Address book has been cleared"<br> ![](https://i.imgur.com/taII762.png)
4. The resident list will now be empty.<br> ![](https://i.imgur.com/TLAwDc4.png)


### 5.15 Viewing help : `help` - Lee Yan Cheng

This command helps you to access the online user guide of Hall-y.

Let’s say you forgot a command. You can refresh your memory by using this command. 

You can request for help if you are unfamiliar with the commands. You can copy the URL and view an online copy of our user guide by using the following format.

Format: `help`

Here’s a step by step guide:
1.  Type the following command into the input box `help` and press <kbd>Enter</kbd> to execute the command. <br> ![](https://i.imgur.com/SvtfPqe.png)
4. The help window will pop out <br> ![](https://i.imgur.com/HJTJNgM.png)
5. Copy the URL and paste it into a browser of your choice to view the online user guide

### 5.16 Exiting the application : `exit`

You can exit the application by using the `exit` command

The steps for this command are as follows:
1. Enter the exit command by typing `exit` into the input box, followed by enter to execute the command.
3. The application should now be closed

### 5.17 Saving the data

Hall-y's data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

--------------------------------------------------------------------------------------------------------------------

## 6 Advanced Features

### 6.1 Changing the blocks and rooms configuration
<div markdown="block" class="alert alert-info">

**:information_source: Important note: <br> This feature is for advanced users only! Please ensure that you know what you are doing before proceeding.**

</div>

Want to add an additional block or change the room numbers? You can modify the settings file directly by following the steps below:

1) Exit Hall-y by using the `exit` command
2) Open up the `preferences.json` file which resides in the same folder as 'hall-y.jar'   
![](https://i.imgur.com/4yexKNC.png)
3) Edit the block and room settings as required.   
The default settings specifies 4 blocks(A, B, C, D), 4 floors(1 - 4) and 20 rooms(1 - 20).  
![](https://i.imgur.com/PiFpKJb.png)
3) Save the file and relaunch Hall-y.


--------------------------------------------------------------------------------------------------------------------

## 7 FAQ

**Q**: How do I transfer my data to another computer?
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Hall-y home folder.

**Q**: Where is all my save data stored?
**A**: They are stored in the `data` folder that in the Hall-y home folder

**Q**: How do I make backups of my data in Hall-y?
**A**: Copy and paste the `data` folder located in the Hall-y home folder somewhere safe. To restore the backup. Copy it back into the same home folder.

**Q**: How do I delete all my data in Hall-y?
**A**: Delete the `data` folder located in the Hall-y home folder.

--------------------------------------------------------------------------------------------------------------------

## 8 Command Summary

Action | Format, Examples
--------|------------------
**Add event** | `add-event n/NAME dt/EVENT_DATE l/LOCATION d/DESCRIPTION` <br />e.g. `add-event n/Night Cycling dt/30/10/2020 18:00 l/Meet at Hall Entrance d/A night cycling event held every semester.`
**Add resident** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS br/ROOM_NUMBER g/GENDER m/MATRICULATION_NUMBER [s/STUDENT_GROUP]…` <br> e.g. `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 br/A104 g/M m/A0199242X s/badminton`
**Assign resident** | `assign RESIDENT_INDEX EVENT_INDEX` <br> e.g. `assign 1 1`
**Clear** | `clear`
**Clear event** | `clear-event EVENT_INDEX` <br> e.g. `clear-event 1`
**Delete event** | `delete-event INDEX`<br> e.g. `delete-event 2`
**Delete resident** | `delete INDEX`<br> e.g. `delete 3`
**Edit event** | `edit INDEX [n/NAME] [dt/EVENT_DATE] [l/LOCATION] [d/DESCRIPTION] `<br> e.g.`edit 2 n/Hall Lunch for Semester 1`
**Edit resident** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [br/ROOM_NUMBER] [g/GENDER] [m/MATRICULATION_NUMBER][s/STUDENT_GROUP]…​​`<br> e.g.`edit 2 n/James Lee e/jameslee@example.com br/A210`
**Export** | `export` <br> e.g. `export email`
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

