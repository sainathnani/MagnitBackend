# MagnitBackend
Contains backend code for Hackathon


Developed completely on SpringBoot and its dependencies.

SQL scripts are also attached that has 3 tables - Questions, Options, Question_Options respectively.

Master data for Questions and Options reside in Questions and Options respectively. A mapping table Question_Options has all the data that links questions to Options.

Every question that pops up is handled dynamically (keeping in mind the crux of hackathon). On every 'Next' a call to API is made that
generates questions and options assocaited with them along with linked Options if any.

Code initially loads the first question on UI and the form can be filled until you see Submit. On Submit the happiness index is calculated and displayed at UI.

## Tools and Platforms Used
   Tools -  IntelliJ,
   Java Framework - Spring,
   Database - MySQL
