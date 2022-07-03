package ex02;

public class Program {
    public static void main(String[] args) {
        UsersArrayList users = new UsersArrayList();
        User newUser = null;

        Integer numberOfUsers = 14;
        System.out.println("Number of users: " + numberOfUsers);
        for (Integer i = 0; i < numberOfUsers; i++) {
            newUser = new User((char)(i + 'a') + "Alex", 100);
            users.addUser(newUser);
        }
        System.out.println("User on index " + numberOfUsers / 2 + " is: "
                            + users.retrieveUserByIndex(numberOfUsers / 2).getName());
        System.out.println("User with id 10: " + users.retrieveUserById(10).getName());
        System.out.println("Total number of users: " + users.retrieveNumberOfUsers());
        try {
            System.out.println("Trying to retrieve user by index 14: ");
            users.retrieveUserByIndex(14);
        } catch (UserNotFoundException e) {
            System.out.println(e);
        }

    }
}
