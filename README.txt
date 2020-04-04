# ObjectOrientedWithDesignPattern-CA

Design Pattern - DAO
My MySqlCountryDAO is responsible to interact with the db via mySQL. 
The design keeps the code organized and modular. 
If at any point in the program is required to add another table it can be easily manageable by adding 
MySqlNewTableDAO.java file and a NewTable.java class.

Design Pattern - Builder Pattern
The builder pattern was implemented in the Country class this pattern give a modularization between the 
construction and the object, and it also gives a better control in the object construction process. 

Design Pattern -Singleton Design Pattern
I use Singleton on my dbConnectMySQL, it will create only once instance of my DB and I can manipulate it 
through the whole program. A db instance is initiate when the program starts and closed when its ends 
by clicking exit
