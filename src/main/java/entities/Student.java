package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sID;

    private String name;
    private boolean isMale;
    private String phoneNumber;
    private String email;

    @ManyToOne
    private Course course;

    public Student(String name, boolean isMale, String phoneNumber, String email) {
        this.name = name;
        this.isMale = isMale;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Student(String name, boolean isMale, String phoneNumber, String email, Course course) {
        this.name = name;
        this.isMale = isMale;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.course = course;
    }

    public Student() {
    }

    public int getSID() {
        return sID;
    }

    public void setSID(int sID) {
        this.sID = sID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMale() {
        return isMale ? "Male":"Female";
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sID=" + sID +
                ", name='" + name + '\'' +
                ", isMale=" + isMale +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sID == student.sID &&
                isMale == student.isMale &&
                Objects.equals(name, student.name) &&
                Objects.equals(phoneNumber, student.phoneNumber) &&
                Objects.equals(email, student.email) &&
                Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sID, name, isMale, phoneNumber, email, course);
    }
}