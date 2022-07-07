package ex05;

public class UsersArrayList implements UsersList {
    private Integer capacity = 10;
    private User[] users = new User[capacity];
    private Integer size = 0;


    @Override
    public void addUser(User user) throws NullPointerException {
        size++;
        if (size > capacity) {
            Integer moreCapacity = capacity + capacity / 2;
            User[] moreUsers = new User[moreCapacity];
            for (int i = 0; i < capacity; i++) {
                moreUsers[i] = users[i];
            }
            users = moreUsers;
            capacity = moreCapacity;
        }
        if (user != null) {
            users[size - 1] = user;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public User retrieveUserById(Integer id) throws UserNotFoundException {
        for (int i = 0; i < size; i++) {
            if (users[i].getIdentifier().equals(id))
                return (users[i]);
        }
        throw new UserNotFoundException();
    }

    @Override
    public User retrieveUserByIndex(Integer index) throws UserNotFoundException, ArrayIndexOutOfBoundsException {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (users[index] == null) {
            throw new UserNotFoundException();
        }
        return (users[index]);
    }

    @Override
    public Integer retrieveNumberOfUsers() {
        return (size);
    }
}
