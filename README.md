# ObjectOrientedWithDesignPattern-CA

Design Pattern - DAO
My MySqlCountryDAO is responsible to interact with the db via mySQL. The design keeps the code organized and modular. If at any point the program requirement changes and another table is added it is easily manageable by adding  MySqlNewTableDAO and a NewTable class.

Design Pattern - Factory Pattern
I choose the Factory Pattern because thought the project I question myself what if I want to use a different Database?
So I design the DBconnect to be abstract and the dbConnectMySQL to extend it. Now I can add as many databases I want and it won't influence on the rest of my program

Design Pattern -Singleton Design Pattern
I use Singleton on my dbConnectMySQL, it will create only once instance of my DB and I can manipulate it through the whole program. 
