package Pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataAllComics implements Serializable {

    @SerializedName("serialNumber")
    @Expose
    private String serialNumber;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("comicTitle")
    @Expose
    private String comicTitle;
    @SerializedName("synopsis")
    @Expose
    private String synopsis;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("coverImage")
    @Expose
    private String coverImage;
    @SerializedName("coverImageIos")
    @Expose
    private String coverImageIos;
    @SerializedName("thumbnailImage")
    @Expose
    private String thumbnailImage;
    @SerializedName("illustration")
    @Expose
    private String illustration;
    @SerializedName("released")
    @Expose
    private String released;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("serialization")
    @Expose
    private String serialization;
    @SerializedName("postedBy")
    @Expose
    private String postedBy;
    @SerializedName("chapters")
    @Expose
    private int chapters;
    @SerializedName("postedOn")
    @Expose
    private String postedOn;
    @SerializedName("updatedOn")
    @Expose
    private String updatedOn;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("rating")
    @Expose
    private int rating;
    @SerializedName("hasParentalControl")
    @Expose
    private boolean hasParentalControl;
    @SerializedName("comicStatus")
    @Expose
    private int comicStatus;
    @SerializedName("comicType")
    @Expose
    private int comicType;
    @SerializedName("followedBy")
    @Expose
    private int followedBy;
    @SerializedName("keywords")
    @Expose
    private String keywords;
    @SerializedName("comment")
    @Expose
    private Object comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComicTitle() {
        return comicTitle;
    }

    public void setComicTitle(String comicTitle) {
        this.comicTitle = comicTitle;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCoverImageIos() {
        return coverImageIos;
    }

    public void setCoverImageIos(String coverImageIos) {
        this.coverImageIos = coverImageIos;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getIllustration() {
        return illustration;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSerialization() {
        return serialization;
    }

    public void setSerialization(String serialization) {
        this.serialization = serialization;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public String getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(String postedOn) {
        this.postedOn = postedOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isHasParentalControl() {
        return hasParentalControl;
    }

    public void setHasParentalControl(boolean hasParentalControl) {
        this.hasParentalControl = hasParentalControl;
    }

    public int getComicStatus() {
        return comicStatus;
    }

    public void setComicStatus(int comicStatus) {
        this.comicStatus = comicStatus;
    }

    public int getComicType() {
        return comicType;
    }

    public void setComicType(int comicType) {
        this.comicType = comicType;
    }

    public int getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(int followedBy) {
        this.followedBy = followedBy;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
