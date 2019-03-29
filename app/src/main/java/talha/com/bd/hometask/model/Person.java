package talha.com.bd.hometask.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person implements Serializable
{

    @SerializedName("search_found")
    @Expose
    private Integer searchFound;
    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("error_report")
    @Expose
    private String errorReport;
    @SerializedName("search_result")
    @Expose
    private List<SearchResult> searchResult = null;
    private final static long serialVersionUID = -3358437116807873133L;

    public Person() {
    }

    public Person(String errorReport) {
        this.errorReport = errorReport;
    }

    public Integer getSearchFound() {
        return searchFound;
    }

    public void setSearchFound(Integer searchFound) {
        this.searchFound = searchFound;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getErrorReport() {
        return errorReport;
    }

    public void setErrorReport(String errorReport) {
        this.errorReport = errorReport;
    }

    public List<SearchResult> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<SearchResult> searchResult) {
        this.searchResult = searchResult;
    }

}




