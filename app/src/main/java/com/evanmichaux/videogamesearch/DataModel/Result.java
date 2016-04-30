
package com.evanmichaux.videogamesearch.DataModel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable {

    @SerializedName("aliases")
    @Expose
    private Object aliases;
    @SerializedName("api_detail_url")
    @Expose
    private String apiDetailUrl;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("date_last_updated")
    @Expose
    private String dateLastUpdated;
    @SerializedName("deck")
    @Expose
    private String deck;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("expected_release_day")
    @Expose
    private Object expectedReleaseDay;
    @SerializedName("expected_release_month")
    @Expose
    private Object expectedReleaseMonth;
    @SerializedName("expected_release_quarter")
    @Expose
    private Object expectedReleaseQuarter;
    @SerializedName("expected_release_year")
    @Expose
    private Object expectedReleaseYear;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("number_of_user_reviews")
    @Expose
    private Integer numberOfUserReviews;
    @SerializedName("original_game_rating")
    @Expose
    private Object originalGameRating;
    @SerializedName("original_release_date")
    @Expose
    private String originalReleaseDate;
    @SerializedName("platforms")
    @Expose
    private List<Platform> platforms = new ArrayList<Platform>();
    @SerializedName("site_detail_url")
    @Expose
    private String siteDetailUrl;
    @SerializedName("resource_type")
    @Expose
    private String resourceType;

    protected Result(Parcel in) {
        apiDetailUrl = in.readString();
        dateAdded = in.readString();
        dateLastUpdated = in.readString();
        deck = in.readString();
        description = in.readString();
        name = in.readString();
        originalReleaseDate = in.readString();
        siteDetailUrl = in.readString();
        resourceType = in.readString();
    }


    /**
     *
     * @return
     *     The aliases
     */
    public Object getAliases() {
        return aliases;
    }

    /**
     *
     * @param aliases
     *     The aliases
     */
    public void setAliases(Object aliases) {
        this.aliases = aliases;
    }

    /**
     *
     * @return
     *     The apiDetailUrl
     */
    public String getApiDetailUrl() {
        return apiDetailUrl;
    }

    /**
     *
     * @param apiDetailUrl
     *     The api_detail_url
     */
    public void setApiDetailUrl(String apiDetailUrl) {
        this.apiDetailUrl = apiDetailUrl;
    }

    /**
     *
     * @return
     *     The dateAdded
     */
    public String getDateAdded() {
        return dateAdded;
    }

    /**
     *
     * @param dateAdded
     *     The date_added
     */
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     *
     * @return
     *     The dateLastUpdated
     */
    public String getDateLastUpdated() {
        return dateLastUpdated;
    }

    /**
     *
     * @param dateLastUpdated
     *     The date_last_updated
     */
    public void setDateLastUpdated(String dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    /**
     *
     * @return
     *     The deck
     */
    public String getDeck() {
        return deck;
    }

    /**
     *
     * @param deck
     *     The deck
     */
    public void setDeck(String deck) {
        this.deck = deck;
    }

    /**
     *
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     *     The expectedReleaseDay
     */
    public Object getExpectedReleaseDay() {
        return expectedReleaseDay;
    }

    /**
     *
     * @param expectedReleaseDay
     *     The expected_release_day
     */
    public void setExpectedReleaseDay(Object expectedReleaseDay) {
        this.expectedReleaseDay = expectedReleaseDay;
    }

    /**
     *
     * @return
     *     The expectedReleaseMonth
     */
    public Object getExpectedReleaseMonth() {
        return expectedReleaseMonth;
    }

    /**
     *
     * @param expectedReleaseMonth
     *     The expected_release_month
     */
    public void setExpectedReleaseMonth(Object expectedReleaseMonth) {
        this.expectedReleaseMonth = expectedReleaseMonth;
    }

    /**
     *
     * @return
     *     The expectedReleaseQuarter
     */
    public Object getExpectedReleaseQuarter() {
        return expectedReleaseQuarter;
    }

    /**
     *
     * @param expectedReleaseQuarter
     *     The expected_release_quarter
     */
    public void setExpectedReleaseQuarter(Object expectedReleaseQuarter) {
        this.expectedReleaseQuarter = expectedReleaseQuarter;
    }

    /**
     *
     * @return
     *     The expectedReleaseYear
     */
    public Object getExpectedReleaseYear() {
        return expectedReleaseYear;
    }

    /**
     *
     * @param expectedReleaseYear
     *     The expected_release_year
     */
    public void setExpectedReleaseYear(Object expectedReleaseYear) {
        this.expectedReleaseYear = expectedReleaseYear;
    }

    /**
     *
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The image
     */
    public Image getImage() {
        return image;
    }

    /**
     *
     * @param image
     *     The image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     *
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The numberOfUserReviews
     */
    public Integer getNumberOfUserReviews() {
        return numberOfUserReviews;
    }

    /**
     *
     * @param numberOfUserReviews
     *     The number_of_user_reviews
     */
    public void setNumberOfUserReviews(Integer numberOfUserReviews) {
        this.numberOfUserReviews = numberOfUserReviews;
    }

    /**
     *
     * @return
     *     The originalGameRating
     */
    public Object getOriginalGameRating() {
        return originalGameRating;
    }

    /**
     *
     * @param originalGameRating
     *     The original_game_rating
     */
    public void setOriginalGameRating(Object originalGameRating) {
        this.originalGameRating = originalGameRating;
    }

    /**
     *
     * @return
     *     The originalReleaseDate
     */
    public String getOriginalReleaseDate() {
        return originalReleaseDate;
    }

    /**
     *
     * @param originalReleaseDate
     *     The original_release_date
     */
    public void setOriginalReleaseDate(String originalReleaseDate) {
        this.originalReleaseDate = originalReleaseDate;
    }

    /**
     *
     * @return
     *     The platforms
     */
    public List<Platform> getPlatforms() {
        return platforms;
    }

    /**
     *
     * @param platforms
     *     The platforms
     */
    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    /**
     *
     * @return
     *     The siteDetailUrl
     */
    public String getSiteDetailUrl() {
        return siteDetailUrl;
    }

    /**
     *
     * @param siteDetailUrl
     *     The site_detail_url
     */
    public void setSiteDetailUrl(String siteDetailUrl) {
        this.siteDetailUrl = siteDetailUrl;
    }

    /**
     *
     * @return
     *     The resourceType
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     *
     * @param resourceType
     *     The resource_type
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(apiDetailUrl);
        dest.writeString(dateAdded);
        dest.writeString(dateLastUpdated);
        dest.writeString(deck);
        dest.writeString(description);
        dest.writeString(name);
        dest.writeString(originalReleaseDate);
        dest.writeString(siteDetailUrl);
        dest.writeString(resourceType);
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
}
