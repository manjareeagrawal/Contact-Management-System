public class User {
    private String name;
    private String phone;
    private String email;
    private String category;

    public User(String name, String phone, String email, String category) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
