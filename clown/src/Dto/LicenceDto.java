package Dto;

public class LicenceDto {
    private String name;
    private String email;
    private String mobile;
    private String licenseType;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
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

    public String getLicenseType() {
        return licenseType;
    }

    @Override
    public String toString() {
        return "LicenceDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", licenseType='" + licenseType + '\'' +
                '}';
    }
}
