---
layout: page
title: User Guide
---

Hall-y is a **desktop app for managing hall residents, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, Hall-y will allow you to add, edit, view, and delete hall residents' records faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------



## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [p/PHONE_NUMBER]` can be used as `n/John Doe p/91234567` or as `n/John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a resident: `add`

Adds a resident to Hall-y.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS r/ROOM_NUMBER g/GENDER m/MATRICULATION_NUMBER`

* ROOM_NUMBER is in the format \<Block\>\<Room Number\>, e.g. B505, C201, etc
* GENDER: either M for male or F for female

Examples:

*   `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 r/A104 g/M m/A0199242X`
*   `add n/Mary Dill p/98236802 e/marryd@example.com a/Jane street, block 29, #02-01 r/B205 g/F m/A0192352T`

### Listing all residents : `list`

Shows a list of all residents registered in Hall-y.

Format: `list`

### Editing a resident : `edit`

Edits an existing resident in Hall-y.

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [r/ROOM_NUMBER] [g/GENDER] [m/MATRICULATION_NUMBER]…​`

* Edits the resident at the specified `INDEX`. The index refers to the index number shown in the displayed resident list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com r/B402` Edits the phone number, email address and room number of the 1st resident to be 91234567, johndoe@example.com and B402 respectively.
*  `edit 2 n/Betsy Crower p/87652103` Edits the name of the 2nd resident and phone number to be `Betsy Crower` and 87652103 respectively.

### Locating residents by name: `find`

Finds residents whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Residents matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting a resident : `delete`

Deletes the specified resident from Hall-y.

Format: `delete INDEX`

* Deletes the resident at the specified `INDEX`.
* The index refers to the index number shown in the displayed resident list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd resident in Hall-y.
* `find Betsy` followed by `delete 1` deletes the 1st resident in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from Hall-y.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

Hall-y's data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Exporting of email : `export`

Exports the email address of all entries in Hall-y as a .txt file.

Format: `export`

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Hall-y home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS r/ROOM_NUMBER g/GENDER m/MATRICULATION_NUMBER` <br> e.g., `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 r/A104 g/M m/A0199242X`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [r/ROOM_NUMBER] [g/GENDER] [m/MATRICULATION_NUMBER]…​​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com r/A210`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`
**Export** | `export`
