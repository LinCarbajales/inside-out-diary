package dev.lin.dtos;

import dev.lin.value_objects.ShortInfoVO;

import com.google.gson.annotations.SerializedName;

public class MovieDTO {

    // imdbId property
    private String imdbId;

    @SerializedName("short")
    private ShortInfoVO shortInfo;

    public String getImdbId() {
        return imdbId;
    }

    public ShortInfoVO getShortInfo() {
        return shortInfo;
    }

}