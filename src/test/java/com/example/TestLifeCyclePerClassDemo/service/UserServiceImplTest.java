package com.example.TestLifeCyclePerClassDemo.service;

import com.example.TestLifeCyclePerClassDemo.io.UsersDatabase;
import com.example.TestLifeCyclePerClassDemo.io.UsersDatabaseMapImpl;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //This annotation allows us to test our method order wise we give @Order(Numbers)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //This allows us  to create a Single Instance for total test class method one instance will be created
// for all test methods to run Unit test cases.All
//test methods share single instance of the class,this allows the methods depends on each other.
//and share information between ech other
public class UserServiceImplTest {

    //Before all After all methods are not static becoz only one instance is created for total
    //TestClassMethods ,No longer Static,if i comment
    //@TestInstance(TestInstance.Lifecycle.PER_CLASS) new instance will be created for evrey method
    //then we need to add static BeforeAll and AfterAll methods.

 UsersDatabase usersDatabase;
 UserService userService;

 String createdUserId=" ";
    @BeforeAll
    void setup() {
        // Create & initialize database
usersDatabase=new UsersDatabaseMapImpl();
usersDatabase.init();
userService= new UserServiceImpl(usersDatabase);
    }

    @AfterAll
    void cleanup() {
        // Close connection
        // Delete database
        usersDatabase.close();
    }

    @Test
    @Order(1)
    @DisplayName("Create User works")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId() {

        //Arrange
        Map<String,String> user = new HashMap<>();
        user.put("firstName","Rahul");
        user.put("lastName","Thammali");


        //Act
        //this createdUser is notnull we should check
      createdUserId = userService.createUser(user);

        //Assert
        assertNotNull(createdUserId,"User id should not be Null");

    }


    //To update user the second test method will needs to have access
    //to user Id,and this user Id will be created by first test method.
    @Test
    @Order(2)
    @DisplayName("Update user works")
    void testUpdateUser_whenProvidedWithValidDetails_returnsUpdatedUserDetails() {
        //Arrange
        Map<String,String> newUserDetails = new HashMap<>();
   newUserDetails.put("firstName","John");
        newUserDetails.put("lastName","Carter");

       //Act
        Map updatedDetails = userService.updateUser(createdUserId,newUserDetails);

      //Assert
        assertEquals(newUserDetails.get("firstName"),updatedDetails.get("firstName"),
                "Returned value of user's first Name is incorrect");
        assertEquals(newUserDetails.get("lastName"),updatedDetails.get("lastName"),
                "Returned value of user's last Name is incorrect");
    }

    @Test
    @Order(3)
    @DisplayName("Find user works")
    void testGetUserDetails_whenProvidedWithValidUserId_returnsUserDetails() {
//Act
        Map userDetails = userService.getUserDetails(createdUserId);

        //Assert
        assertNotNull(userDetails,"user Details  should not null");
        assertEquals(createdUserId,userDetails.get("userId"),
                "Returned user details contains incorrect user id");
    }

    @Test
    @Order(4)
    @DisplayName("Delete user works")
    void testDeleteUser_whenProvidedWithValidUserId_returnsUserDetails() {

    }

}
