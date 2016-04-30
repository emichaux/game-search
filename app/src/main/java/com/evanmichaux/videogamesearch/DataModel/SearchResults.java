
package com.evanmichaux.videogamesearch.DataModel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResults  implements Parcelable {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("number_of_page_results")
    @Expose
    private Integer numberOfPageResults;
    @SerializedName("number_of_total_results")
    @Expose
    private Integer numberOfTotalResults;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<Result>();
    @SerializedName("version")
    @Expose
    private String version;

    protected SearchResults(Parcel in) {
        error = in.readString();
        version = in.readString();
    }

    /**
     *
     * @return
     *     The error
     */
    public String getError() {
        return error;
    }

    /**
     *
     * @param error
     *     The error
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     *
     * @return
     *     The limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     *
     * @param limit
     *     The limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     *
     * @return
     *     The offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     *
     * @param offset
     *     The offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     *
     * @return
     *     The numberOfPageResults
     */
    public Integer getNumberOfPageResults() {
        return numberOfPageResults;
    }

    /**
     *
     * @param numberOfPageResults
     *     The number_of_page_results
     */
    public void setNumberOfPageResults(Integer numberOfPageResults) {
        this.numberOfPageResults = numberOfPageResults;
    }

    /**
     *
     * @return
     *     The numberOfTotalResults
     */
    public Integer getNumberOfTotalResults() {
        return numberOfTotalResults;
    }

    /**
     *
     * @param numberOfTotalResults
     *     The number_of_total_results
     */
    public void setNumberOfTotalResults(Integer numberOfTotalResults) {
        this.numberOfTotalResults = numberOfTotalResults;
    }

    /**
     *
     * @return
     *     The statusCode
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     *
     * @param statusCode
     *     The status_code
     */
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    /**
     *
     * @return
     *     The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     *
     * @param results
     *     The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     *
     * @return
     *     The version
     */
    public String getVersion() {
        return version;
    }

    /**
     *
     * @param version
     *     The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(results);
        dest.writeString(error);
        dest.writeInt(limit);
        dest.writeInt(offset);
        dest.writeInt(numberOfPageResults);
        dest.writeInt(numberOfTotalResults);
        dest.writeInt(statusCode);
        dest.writeString(version);
    }
    public static final Creator<SearchResults> CREATOR = new Creator<SearchResults>() {
        @Override
        public SearchResults createFromParcel(Parcel in) {
            return new SearchResults(in);
        }

        @Override
        public SearchResults[] newArray(int size) {
            return new SearchResults[size];
        }
    };
}
