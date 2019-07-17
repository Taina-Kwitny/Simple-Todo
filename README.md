# Pre-work SimpleTodo
SimpleTodo is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Gallahër-Brel Charles

Time spent: 10 hours spent in total

## User Stories

The following functionality is completed:

* [X] User can successfully add and remove items from the todo list
* [X] User can tap a todo item in the list and bring up an edit screen for the todo item and then have any changes to the text reflected in the todo list.
* [X] User can persist todo items and retrieve them properly on app restart

Here's a walkthrough of implemented user stories:

[Link to Video Walkthrough](https://www.dropbox.com/s/utwxnjbf115sz6h/SimpleTodo_walkthrough_001.mp4?dl=true)

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** Interesting enough but, I sometimes have an hard time with the manipulation of XML files for the UI.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** The `ArrayAdapter` can convert an `ArrayList` into a `ListView`. An advantage of this Adapter is that it is more efficient memory wise. The only rows kept in memory are the visible ones.

## Notes

Working of `Intent` wasn't obvious at first.

## License

GNU General Public License v3.0