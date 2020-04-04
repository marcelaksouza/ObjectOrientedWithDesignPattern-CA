# ObjectOrientedWithDesignPattern-CA

Design Pattern - DAO
My MySqlCountryDAO is responsible to interact with the db via mySQL. 
The design keeps the code organized and modular. If at any point the program requirement changes and another table is added it is easily manageable by adding  MySqlNewTableDAO and a NewTable class.

Design Pattern - Builder Pattern
The builder pattern was implemented in the Country class 

Design Pattern -Singleton Design Pattern
I use Singleton on my dbConnectMySQL, it will create only once instance of my DB and I can manipulate it through the whole program. 
