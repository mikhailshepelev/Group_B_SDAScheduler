package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainerID;
    private String name;
    private boolean isMale;
    private String email;
    private String phoneNumber;
    private String skills;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.EAGER)
    private List<Topic> topicsList = new ArrayList<>();

    public Trainer(String name, boolean isMale, String email, String phoneNumber, String skills) {
        this.name = name;
        this.isMale = isMale;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
    }

    public Trainer() {
    }

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMale() {
        return isMale ? "Male" : "Female";
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSkills(String skills){
        this.skills = skills;
    }

    public String getSkills(){
        return skills;
    }

    public List<Topic> getTopicsList() {
        return topicsList;
    }
    public String getTopics(){
        String topics = "";
        for (Topic t: getTopicsList()) {
            topics += t.getTopicName() + " ";

        }
        return topics;
    }

    public void setTopicsList(List<Topic> topicsList) {
        this.topicsList = topicsList;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerID=" + trainerID +
                ", name='" + name + '\'' +
                ", isMale=" + isMale +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return trainerID == trainer.trainerID &&
                isMale == trainer.isMale &&
                Objects.equals(name, trainer.name) &&
                Objects.equals(email, trainer.email) &&
                Objects.equals(phoneNumber, trainer.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerID, name, isMale, email, phoneNumber);
    }
}
