# -JUnit5_Advanced_Part3
Do check out ReadMeFile,Change Test Instance lifecycle with @TestInstance (PER_CLASS, PER_METHOD) few some other Concepts are involved.

# Change Test Instance lifecycle with @TestInstance (PER_CLASS, PER_METHOD)

**1.** we know that Bydefault Junit creates a new instance of a testClass for each TestMethod.If you have three testMethods in a Single Test Class,
when you run all test methods in this test class for each test method junit will create a new instance of a class.

**2.** If you want execute all test methods in same test instance then you can Annoate testClass with **@TestInstance(LifeCycle.PER_CLASS)**
when u using this mode only one instanes will be created per Testclass it is very helpful when you working with **Integration Testing**.

**we will learn how to make good test methodRuns in a SingleInstance of a testClass.**

# Code Explanation Follow Here[io package]:-

This code consists of **two Java classes:**

**UsersDatabase and UsersDatabaseMapImpl.** The UsersDatabase is an **interface** that defines the methods for a simple user database, while **UsersDatabaseMapImpl** is a class that implements the **UsersDatabase interface using a HashMap.**

Let's go through each class and their methods:

# UsersDatabase interface:

**1.** void init(): Initializes the user database.

**2.** void close(): Closes the user database.

**3.** Map save(String userId, Map userDetails): Saves a user with the given userId and userDetails.

**4.** Map update(String userId, Map user): Updates the user with the given userId and new user details.

**5.** Map find(String userId): Finds and returns the user with the given userId.

**6.** void delete(String userId): Deletes the user with the given userId.

# UsersDatabaseMapImpl class:

**Map<String, Map> users:**  A HashMap that stores user data, where the key is the user ID (a String) and the value is a Map containing user details.

**1.** public void init(): Initializes the users HashMap.

**2.** public void close(): Sets the users HashMap to null, effectively closing the user database.

**3.** public Map save(String userId, Map userDetails): Saves a user by putting the userId and userDetails into the users HashMap. Returns the previous value associated with the userId, or null if there was no previous value.

**4.** public Map update(String userId, Map user): Updates a user by putting the new user details into the users HashMap with the given userId. Returns the updated user details.

**5.** public Map find(String userId): Finds and returns the user details associated with the given userId from the users HashMap. Returns null if the user is not found.

**6.** public void delete(String userId): Deletes the user with the given userId by removing the entry from the users HashMap.

In summary, this code demonstrates a simple user database implementation using a HashMap. The UsersDatabase interface defines the methods for interacting with the user database, and the UsersDatabaseMapImpl class provides an implementation of this interface using a HashMap.

# Code Explanation Follow Here[Service package]:-

This code consists of **two Java classes:**

**UserService and UserServiceImpl.**

The **UserService is an interface** that defines the **methods for a user service, while UserServiceImpl is a class that implements the UserService interface using the UsersDatabase interface from your previous code.**

Let's go through each class and their methods:

# UserService interface:

**1.** String createUser(Map userDetails): Creates a new user with the given userDetails and returns the generated user ID.

**2.** Map updateUser(String userId, Map userDetails): Updates the user with the given userId and new userDetails. Returns the updated user details.

**3.** Map getUserDetails(String userId): Retrieves and returns the user details for the user with the given userId.

**4.** void deleteUser(String userId): Deletes the user with the given userId.

# UserServiceImpl class:

UsersDatabase usersDatabase: A reference to the UsersDatabase interface, which is used to interact with the user database.
public UserServiceImpl(UsersDatabase usersDatabase): Constructor that takes a UsersDatabase instance as a parameter and initializes the usersDatabase field.

**1.** public String createUser(Map userDetails): Generates a random user ID using UUID.randomUUID().toString(), adds the user ID to the userDetails map, saves the user using the usersDatabase.save() method, and returns the generated user ID.

**2.** public Map updateUser(String userId, Map userDetails): Finds the existing user with the given userId using the usersDatabase.find() method. If the user is  not found, it throws an IllegalArgumentException. Updates the user's first and last name with the new values from the userDetails map, and then
 updates the user in the database using the usersDatabase.update() method. Returns the updated user details.

**3.**  public Map getUserDetails(String userId): Retrieves and returns the user details for the user with the given userId using the usersDatabase.find() method.

**4.**  public void deleteUser(String userId): Finds the existing user with the given userId using the usersDatabase.find() method. If the user is not found, it throws an IllegalArgumentException. Deletes the user from the database using the usersDatabase.delete() method.

In summary, this code demonstrates a user service implementation that interacts with a user database through the UsersDatabase interface. The UserService interface defines the methods for managing users, and the UserServiceImpl class provides an implementation of this interface using the UsersDatabase interface.
