Coffee Machine
==============

A program that simulates the operations of a coffee machine.
It offers several drinks at different prices and requiring different resources, keeps track of the coffee machine's inventory, and allows for restocking and removing funds from the machine.

Prerequisites
-------------

This program requires Java to compile and run.

Installation
------------

1. Download this repository and unzip the .zip file in your desired location.
2. Using the command line, navigate to \Coffee-Machine-master.
3. Compile the program using the command `javac CoffeeMachine.java`.

Usage
-----

Once Coffee Machine has been compiled, it can be run from the command line by navigating to its parent folder and using the command `java Coffee-Machine-master.CoffeeMachine`.

Once the program has started, the user will be prompted to select an option: buy, fill, take, remaining, or exit.
An option is selected by inputting the text corresponding to the action to take.

**Buy:**

Select this option to buy a coffee. The different drink options and their corresponding numbers will be displayed.
The user should enter one of the listed integers to select a coffee, i.e. `1`.

If the coffee machine does not have enough resources to make the selected coffee, the program will say so.
Otherwise, the coffee machine will produce the requested coffee and adjust its inventory accordingly.

**Fill:**

Select this option to add more resources to the coffee machine. The user will be prompted to enter how much of each resource should be added.
These values should be entered as integers, i.e. to add 50 ml of water, input `50`.

**Take:**

Select this option to take all of the money from the coffee machine.

**Remaining:**

Select this option to display the coffee machine's current inventory.

**Exit:**

Select this option to exit the program.

Authors
-------

* **Kate Jordan** - [sinnenicht](https://github.com/sinnenicht/)

License
-------

This project is licensed under the MIT License.
See the [LICENSE](https://github.com/sinnenicht/Coffee-Machine/blob/master/LICENSEhttps://github.com/sinnenicht/Coffee-Machine/blob/master/LICENSEhttps://github.com/sinnenicht/Coffee-Machine/blob/master/LICENSE) for details.
