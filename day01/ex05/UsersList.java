package ex05;

public interface UsersList {
    void addUser(User user);
    User retrieveUserById(Integer id) throws UserNotFoundException;
    User retrieveUserByIndex(Integer index) throws UserNotFoundException;
    Integer retrieveNumberOfUsers();
}
