Java Twitter console
====================

---------------------------------------------------

This is a solution to a Java Console Twitter clone

The aim of the challenge.
-------------------------

Create a console app that emulates the basic Twitter functions.

The application needs to be driven by TDD and BDD by using Java, JUnit and Mockito.

The main goal behind the challenge was to identify how fast I could learn Java, JUnit, Mockito, Maven and IntelliJ within 3 1/2 days and be able to implement a solution using those Technologies. 

Features
------------
**User creating**: a new user called *Spike* can be created  
**Posting**: *Spike* can publish messages to a personal timeline  
**Reading**: *Spike* can view *Nikesh’s* timeline  
**Following**: *Leo* can subscribe to *Spike* and *Nikesh's* timelines, and view an aggregated list of all subscriptions  


Technologies used
-----------------

  * Testing
    * JUnit 4.0
    * Mockito 1.10.19

  * Back end framework
    * Java

  * Project structure
    * Maven

Testing and running environment setup
--------------------------------------

In order to edit, view or modify the source code, you will need to clone the repo shown below, access the folder and execute the following commands to be functional.


```sh
$ git clone https://github.com/Willibaur/console-Twitter-Java
$ cd console-Twitter-Java
```



Unit tests
-------------------------

Unit test were done for both classes, User and Twitter.

I have not managed how to use Mockito in the best way to mock objects for my test, at the moment test coverage for Twitter class is at low level.


ToDo
--------------

Introduce mock behaviour for User class.

Increase validations across menu options.

Display timeline and messages with time stamp.


Contributors
------------

* [William Bautista](https://github.com/Willibaur)
*
