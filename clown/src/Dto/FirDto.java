package Dto;

public class FirDto {
    private String complaintname;
    private String dateofincident;
    private String location;
    private String crimeType;

    public void setComplaintname(String complaintname) {
        this.complaintname = complaintname;
    }

    public void setDateofincident(String dateofincident) {
        this.dateofincident = dateofincident;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public String getComplaintname() {
        return complaintname;
    }

    public String getDateofincident() {
        return dateofincident;
    }

    public String getLocation() {
        return location;
    }

    public String getCrimeType() {
        return crimeType;
    }

    @Override
    public String toString() {
        return "FirDto{" +
                "complaintname='" + complaintname + '\'' +
                ", dateofincident='" + dateofincident + '\'' +
                ", location='" + location + '\'' +
                ", crimeType='" + crimeType + '\'' +
                '}';
    }
}
