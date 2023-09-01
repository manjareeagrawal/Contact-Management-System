import java.util.UUID;

public interface UserService
{
    User createUser(UUID uuid, String name, String phone, String email, String category);
    User getUserById(UUID id);
    User getUserByName(String name);
    void removeUserById(UUID uuid);
    void removeUserByName(String name);
    User displayUser(User user);
    void printAllUsers(String hashMap);

    User updateUser(UUID uuid3);

    User finalUpdateEntry(User u, String updatedValue, int updateChoice, UUID uuid3);

    void sortTreeMapByColumn(int sortChoice);
}
