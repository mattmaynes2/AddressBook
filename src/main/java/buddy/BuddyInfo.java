package buddy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

/**
 * Created by mattmaynes on 1/12/2017.
 */
@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String phoneNumber;

    protected BuddyInfo () {
        this.phoneNumber = "";
        this.name = "";
    }

    public BuddyInfo (String name) {
        this();
        this.name = name;
    }

    public BuddyInfo (String name, String phoneNumber) {
        this(name);
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean equals (BuddyInfo other) {
        return this.name.equals(other.name) &&
                this.phoneNumber.equals(other.phoneNumber);
    }

    public String toString () {
        return this.name + (this.phoneNumber.length() > 0 ? " " + this.phoneNumber : "");
    }
}
