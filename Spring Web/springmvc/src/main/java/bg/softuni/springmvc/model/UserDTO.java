package bg.softuni.springmvc.model;

public class UserDTO {

  private String fname;
  private String lname;

  public String getFname() {
    return fname;
  }

  public UserDTO setFname(String fname) {
    this.fname = fname;
    return this;
  }

  public String getLname() {
    return lname;
  }

  public UserDTO setLname(String lname) {
    this.lname = lname;
    return this;
  }

  @Override
  public String toString() {
    return "UserDTO{" +
        "fname='" + fname + '\'' +
        ", lname='" + lname + '\'' +
        '}';
  }
}
