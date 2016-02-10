Turtle Interpreter
==================

Overview of my extensions:
* Repeat Command
* Globbing Turtle Names
* Multiple Turtle Calls with ','
* Command Line Support

Repeat Command
--------------
Use this command to repeat a set of commands for a specified number of times.
Ex:
```
> repeat 4
  move frank 4
  right frank 90
  end
```  
  
This will repeat the set of command
```
  move frank 4
  right frank 90
```
  four times.
  
  
Globbing
--------
This feature enables pattern matching in turtle names.
Ex:
```
> move a* 10
```

This will move all turtles starting with 'a' 10 times.

Multiple Turtle Calls
---------------------
This feature enables parsing one command for as many turtle as you want.
Ex:
```
> move frank,freya 4
```

This will move both frank and freya 4 steps ahead.

Note: The extensions like Globbing and Multiple Turtle Calls can be used together for better usage of the interpreter.

Command Line Support
--------------------
This extension kicks in when the user is using the command line to run the interpreter. 
While using the command line the interpreter throws errors, in case of any, and uses a beautiful
indentation to align the input commands.

Ex:
```
> new cute nicolai 0 0
Error: Turtle type 'cute' not defined.
> move nicolai 4
Error: Turtle 'nicolai' not found.
>
```



