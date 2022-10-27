/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Personnel {
    private String personnelName;
    private int role;
    private String personnelPhone;
    private String personnelEmail;
    private String personnelAddress;
    private String personnelDateOfBirth;
    private String personnelUsername;
    private String personnelPassword;
    private String personnelImageUrl;   
    private boolean personnelStatus;
    
    public Personnel(String personnelName, int role, String personnelPhone, String personnelEmail, String personnelAddress, String personnelDateOfBirth, String personnelUsername, String personnelPassword, String personnelImageUrl, boolean personnelStatus) {
        this.personnelName = personnelName;
        this.role = role;
        this.personnelPhone = personnelPhone;
        this.personnelEmail = personnelEmail;
        this.personnelAddress = personnelAddress;
        this.personnelDateOfBirth = personnelDateOfBirth;
        this.personnelUsername = personnelUsername;
        this.personnelPassword = personnelPassword;
        this.personnelImageUrl = personnelImageUrl;
        this.personnelStatus   = personnelStatus;
    }

    public Personnel(String personnelUsername, String personnelPassword) {
        this.personnelUsername = personnelUsername;
        this.personnelPassword = personnelPassword;
    }
    
    public Personnel(){
    }
    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPersonnelPhone() {
        return personnelPhone;
    }

    public void setPersonnelPhone(String personnelPhone) {
        this.personnelPhone = personnelPhone;
    }

    public String getPersonnelEmail() {
        return personnelEmail;
    }

    public void setPersonnelEmail(String personnelEmail) {
        this.personnelEmail = personnelEmail;
    }

    public String getPersonnelAddress() {
        return personnelAddress;
    }

    public void setPersonnelAddress(String personnelAddress) {
        this.personnelAddress = personnelAddress;
    }

    public String getPersonnelDateOfBirth() {
        return personnelDateOfBirth;
    }

    public void setPersonnelDateOfBirth(String personnelDateOfBirth) {
        this.personnelDateOfBirth = personnelDateOfBirth;
    }

    public String getPersonnelUsername() {
        return personnelUsername;
    }

    public void setPersonnelUsername(String personnelUsername) {
        this.personnelUsername = personnelUsername;
    }

    public String getPersonnelPassword() {
        return personnelPassword;
    }

    public void setPersonnelPassword(String personnelPassword) {
        this.personnelPassword = personnelPassword;
    }

    public String getPersonnelImageUrl() {
        return personnelImageUrl;
    }

    public void setPersonnelImageUrl(String personnelImageUrl) {
        this.personnelImageUrl = personnelImageUrl;
    }
    public boolean isPersonnelStatus() {
        return personnelStatus;
    }

    public void setPersonnelStatus(boolean personnelStatus) {
        this.personnelStatus = personnelStatus;
    }
}
