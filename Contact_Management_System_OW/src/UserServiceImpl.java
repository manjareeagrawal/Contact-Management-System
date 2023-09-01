import java.util.*;

public class UserServiceImpl implements UserService {
    private final HashMap<UUID, User> userMap;
    private final LinkedHashMap<UUID, User> linkedHashMap;
    private final TreeMap<UUID, User> treeMap;
    private final LinkedList<User> linkedList;
    private final ArrayList<User> arrayList;

    public UserServiceImpl() {
        userMap = new HashMap<>();
        linkedHashMap = new LinkedHashMap<>();
        treeMap = new TreeMap<>();
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();

        UUID manjareeUUID = UUID.randomUUID();
        UUID sakshiUUID = UUID.randomUUID();
        UUID bhavyaUUID = UUID.randomUUID();
        UUID jasneetUUID = UUID.randomUUID();

        User Manjaree = new User("Manjaree", "123456", "manjaree@gmail", "Personal");
        User Sakshi = new User("Sakshi", "456789", "sakshi@gmail", "Business");
        User Bhavya = new User("Bhavya", "234567", "Bhavya@gmail", "Business");
        User Jasneet = new User("Jasneet", "543215", "jasneet@gmail", "Personal");

        userMap.put(manjareeUUID, Manjaree);
        userMap.put(sakshiUUID, Sakshi);
        userMap.put(bhavyaUUID, Bhavya);
        userMap.put(jasneetUUID, Jasneet);

        linkedHashMap.put(manjareeUUID, Manjaree);
        linkedHashMap.put(sakshiUUID, Sakshi);
        linkedHashMap.put(bhavyaUUID, Bhavya);
        linkedHashMap.put(jasneetUUID, Jasneet);

        treeMap.put(manjareeUUID, Manjaree);
        treeMap.put(sakshiUUID, Sakshi);
        treeMap.put(bhavyaUUID, Bhavya);
        treeMap.put(jasneetUUID, Jasneet);

        linkedList.add(Manjaree);
        linkedList.add(Sakshi);
        linkedList.add(Bhavya);
        linkedList.add(Jasneet);

        arrayList.add(Manjaree);
        arrayList.add(Sakshi);
        arrayList.add(Bhavya);
        arrayList.add(Jasneet);
    }

    public User createUser(UUID id, String name, String phone, String email, String category) {
        User user = new User(name, phone, email, category);
        userMap.put(id, user);
        linkedHashMap.put(id, user);
        treeMap.put(id, user);
        linkedList.add(user);
        arrayList.add(user);
        return user;
    }
    public User getUserById(UUID id) {
        try {
            return userMap.get(id);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    public User getUserByName(String name) {
        for (User user : userMap.values()) {
            try {
                if (user.getName().equalsIgnoreCase(name)) {
                    return user;
                }
            }
            catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
        return null;
    }

    public void removeUserById(UUID uuid) {
        try {
            userMap.remove(uuid);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void removeUserByName(String name) {
        UUID idToRemove = null;
        try {
            for (Map.Entry<UUID, User> entry : userMap.entrySet()) {
                User user = entry.getValue();
                if (user.getName().equalsIgnoreCase(name)) {
                    idToRemove = entry.getKey();
                    break;
                }
            }
            if (idToRemove != null) {
                userMap.remove(idToRemove);
            }
        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void printAllUsers(String dsType) {
        System.out.println("Printing users in " + dsType + ":");
        switch (dsType) {
            case "HashMap":
                for (User user : userMap.values()) {
                    displayUser(user);
                }
                break;
            case "LinkedHashMap":
                for (User user : linkedHashMap.values()) {
                    displayUser(user);
                }
                break;
            case "TreeMap":
                for (User user : treeMap.values()) {
                    displayUser(user);
                }
                break;
            case "LinkedList":
                for (User user : linkedList) {
                    displayUser(user);
                }
                break;
            case "ArrayList":
                for (User user : arrayList) {
                    displayUser(user);
                }
                break;
            default:
                System.out.println("Invalid data structure type.");
                break;
        }
    }

    @Override
    public User updateUser(UUID uuid3)
    {
        User user=userMap.get(uuid3);
        return user;
    }

    @Override
    public User finalUpdateEntry(User u, String updatedValue, int updateChoice, UUID uuid3) {
        switch (updateChoice) {
            case 1:
                u.setName(updatedValue);
                break;
            case 2:
                u.setEmail(updatedValue);
                break;
            case 3:
                u.setPhone(updatedValue);
                break;
            case 4:
                u.setCategory(updatedValue);
                break;
            default:
                System.out.println("Invalid update choice.");
                return u;
        }

        userMap.replace(uuid3, u);
        linkedHashMap.replace(uuid3, u);
        treeMap.replace(uuid3, u);

        return u;
    }

    public void sortTreeMapByColumn(int sortChoice) {
        TreeMap<UUID, User> sortedTreeMap = new TreeMap<>((uuid1, uuid2) -> {
            User user1 = treeMap.get(uuid1);
            User user2 = treeMap.get(uuid2);

            switch (sortChoice) {
                case 1:
                    return user1.getName().compareToIgnoreCase(user2.getName());

                case 2:
                    return user1.getEmail().compareToIgnoreCase(user2.getEmail());

                case 3:
                    return user1.getPhone().compareToIgnoreCase(user2.getPhone());

                case 4:
                    return user1.getCategory().compareToIgnoreCase(user2.getCategory());

                default:
                    throw new IllegalArgumentException("Invalid sorting choice.");
            }
        });

        sortedTreeMap.putAll(treeMap);

        switch (sortChoice) {
            case 1:
                System.out.println("Sorted by Name in TreeMap:");
                break;
            case 2:
                System.out.println("Sorted by Email in TreeMap:");
                break;
            case 3:
                System.out.println("Sorted by Phone in TreeMap:");
                break;
            case 4:
                System.out.println("Sorted by Category in TreeMap:");
                break;
        }

        for (User user : sortedTreeMap.values()) {
            displayUser(user);
        }
    }



    public User displayUser(User user) {

        System.out.println("Name: " + user.getName());
        System.out.println("Phone No: " + user.getPhone());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Category: " + user.getCategory());
        return user;
    }
}
