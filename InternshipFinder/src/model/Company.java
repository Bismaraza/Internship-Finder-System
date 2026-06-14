package model;

public class Company {
    private int id;
    private int employerId;
    private String companyName;
    private String description;
    private String city;
    private String address;
    private String email;
    private String phone;
    private boolean verified;

    public Company() {}

    public Company(int id, int employerId, String companyName, String description, String city, String address, String email, String phone, boolean verified) {
        this.id = id;
        this.employerId = employerId;
        this.companyName = companyName;
        this.description = description;
        this.city = city;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.verified = verified;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEmployerId() { return employerId; }
    public void setEmployerId(int employerId) { this.employerId = employerId; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public boolean isVerified() { return verified; }
    public void setVerified(boolean verified) { this.verified = verified; }

}
