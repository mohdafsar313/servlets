package Dto;

public class DonationDto {
    private String name;
    private String email;
    private String mobile;
    private String amount;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "DonationDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
