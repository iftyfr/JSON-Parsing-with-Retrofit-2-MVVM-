package talha.com.bd.hometask.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Person implements Serializable
{

    @SerializedName("search_found")
    private Integer searchFound;

    @SerializedName("error")
    private Integer error;

    @SerializedName("error_report")
    private String errorReport;

    @SerializedName("search_result")
    private List<SearchResult> searchResult = null;

    public Person() {
    }

    Person(String errorReport) {
        this.errorReport = errorReport;
    }

    public Integer getSearchFound() {
        return searchFound;
    }

    public Integer getError() {
        return error;
    }

    public String getErrorReport() {
        return errorReport;
    }

    public List<SearchResult> getSearchResult() {
        return searchResult;
    }
}




