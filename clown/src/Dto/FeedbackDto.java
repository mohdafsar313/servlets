package Dto;

public class FeedbackDto {
    private String name;
    private String email;
    private String mobile;
    private String rating;
    private String message;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getRating() {
        return rating;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "FeedbackDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", rating='" + rating + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
