package Dto;

public class LaboratoryDto {
    private String name;
    private String location;
    private String mobile;
    private String treatment;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getMobile() {
        return mobile;
    }

    public String getTreatment() {
        return treatment;
    }

    @Override
    public String toString() {
        return "LaboratoryDto{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", mobile='" + mobile + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}
