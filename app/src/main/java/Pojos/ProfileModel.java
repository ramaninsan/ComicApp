package Pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileModel {

    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("profilePicture")
    @Expose
    private String profilePicture;
    @SerializedName("streetAddress")
    @Expose
    private String streetAddress;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("facebookUrl")
    @Expose
    private String facebookUrl;
    @SerializedName("twitterUrl")
    @Expose
    private String twitterUrl;
    @SerializedName("instagramUrl")
    @Expose
    private String instagramUrl;
    @SerializedName("linkedInUrl")
    @Expose
    private String linkedInUrl;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("hasSubscription")
    @Expose
    private boolean hasSubscription;
    @SerializedName("subscribedOn")
    @Expose
    private String subscribedOn;
    @SerializedName("subscribedEndsOn")
    @Expose
    private String subscribedEndsOn;
    @SerializedName("banStatus")
    @Expose
    private boolean banStatus;
    @SerializedName("banEndTime")
    @Expose
    private int banEndTime;
    @SerializedName("currentLevel")
    @Expose
    private int currentLevel;
    @SerializedName("calculatedExperience")
    @Expose
    private int calculatedExperience;
    @SerializedName("currentExperience")
    @Expose
    private int currentExperience;
    @SerializedName("experienceForNextLevel")
    @Expose
    private int experienceForNextLevel;
    @SerializedName("rewardPoints")
    @Expose
    private int rewardPoints;
    @SerializedName("inventory")
    @Expose
    private Object inventory;
    @SerializedName("achievements")
    @Expose
    private Object achievements;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("normalizedUserName")
    @Expose
    private String normalizedUserName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("normalizedEmail")
    @Expose
    private String normalizedEmail;
    @SerializedName("emailConfirmed")
    @Expose
    private boolean emailConfirmed;
    @SerializedName("passwordHash")
    @Expose
    private String passwordHash;
    @SerializedName("securityStamp")
    @Expose
    private String securityStamp;
    @SerializedName("concurrencyStamp")
    @Expose
    private String concurrencyStamp;
    @SerializedName("phoneNumber")
    @Expose
    private Object phoneNumber;
    @SerializedName("phoneNumberConfirmed")
    @Expose
    private boolean phoneNumberConfirmed;
    @SerializedName("twoFactorEnabled")
    @Expose
    private boolean twoFactorEnabled;
    @SerializedName("lockoutEnd")
    @Expose
    private Object lockoutEnd;
    @SerializedName("lockoutEnabled")
    @Expose
    private boolean lockoutEnabled;
    @SerializedName("accessFailedCount")
    @Expose
    private int accessFailedCount;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public String getLinkedInUrl() {
        return linkedInUrl;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isHasSubscription() {
        return hasSubscription;
    }

    public void setHasSubscription(boolean hasSubscription) {
        this.hasSubscription = hasSubscription;
    }

    public String getSubscribedOn() {
        return subscribedOn;
    }

    public void setSubscribedOn(String subscribedOn) {
        this.subscribedOn = subscribedOn;
    }

    public String getSubscribedEndsOn() {
        return subscribedEndsOn;
    }

    public void setSubscribedEndsOn(String subscribedEndsOn) {
        this.subscribedEndsOn = subscribedEndsOn;
    }

    public boolean isBanStatus() {
        return banStatus;
    }

    public void setBanStatus(boolean banStatus) {
        this.banStatus = banStatus;
    }

    public int getBanEndTime() {
        return banEndTime;
    }

    public void setBanEndTime(int banEndTime) {
        this.banEndTime = banEndTime;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getCalculatedExperience() {
        return calculatedExperience;
    }

    public void setCalculatedExperience(int calculatedExperience) {
        this.calculatedExperience = calculatedExperience;
    }

    public int getCurrentExperience() {
        return currentExperience;
    }

    public void setCurrentExperience(int currentExperience) {
        this.currentExperience = currentExperience;
    }

    public int getExperienceForNextLevel() {
        return experienceForNextLevel;
    }

    public void setExperienceForNextLevel(int experienceForNextLevel) {
        this.experienceForNextLevel = experienceForNextLevel;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public Object getInventory() {
        return inventory;
    }

    public void setInventory(Object inventory) {
        this.inventory = inventory;
    }

    public Object getAchievements() {
        return achievements;
    }

    public void setAchievements(Object achievements) {
        this.achievements = achievements;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNormalizedUserName() {
        return normalizedUserName;
    }

    public void setNormalizedUserName(String normalizedUserName) {
        this.normalizedUserName = normalizedUserName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNormalizedEmail() {
        return normalizedEmail;
    }

    public void setNormalizedEmail(String normalizedEmail) {
        this.normalizedEmail = normalizedEmail;
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSecurityStamp() {
        return securityStamp;
    }

    public void setSecurityStamp(String securityStamp) {
        this.securityStamp = securityStamp;
    }

    public String getConcurrencyStamp() {
        return concurrencyStamp;
    }

    public void setConcurrencyStamp(String concurrencyStamp) {
        this.concurrencyStamp = concurrencyStamp;
    }

    public Object getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Object phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPhoneNumberConfirmed() {
        return phoneNumberConfirmed;
    }

    public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
        this.phoneNumberConfirmed = phoneNumberConfirmed;
    }

    public boolean isTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public Object getLockoutEnd() {
        return lockoutEnd;
    }

    public void setLockoutEnd(Object lockoutEnd) {
        this.lockoutEnd = lockoutEnd;
    }

    public boolean isLockoutEnabled() {
        return lockoutEnabled;
    }

    public void setLockoutEnabled(boolean lockoutEnabled) {
        this.lockoutEnabled = lockoutEnabled;
    }

    public int getAccessFailedCount() {
        return accessFailedCount;
    }

    public void setAccessFailedCount(int accessFailedCount) {
        this.accessFailedCount = accessFailedCount;
    }

}
