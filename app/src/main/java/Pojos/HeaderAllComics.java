package Pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HeaderAllComics {

    @SerializedName("isSuccess")
    @Expose
    private boolean isSuccess;
    @SerializedName("result")
    @Expose
    private List<DataAllComics> dataAllComicsList;
    @SerializedName("displayMessage")
    @Expose
    private String displayMessage;
    @SerializedName("errorMessages")
    @Expose
    private Object errorMessages;

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public List<DataAllComics> getResult() {
        return dataAllComicsList;
    }

    public void setResult(List<DataAllComics> result) {
        this.dataAllComicsList = result;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public Object getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Object errorMessages) {
        this.errorMessages = errorMessages;
    }
}
