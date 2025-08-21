package dev.lin.dtos;

import dev.lin.value_objects.ShortInfoVO;
import dev.lin.value_objects.TopInfoVO;

import com.google.gson.annotations.SerializedName;

public class MovieDTO {

    // imdbId property
    private String imdbId;

    @SerializedName("short")
    private ShortInfoVO shortInfo;

    @SerializedName("top")
    private TopInfoVO topInfo;

    public String getImdbId() {
        return imdbId;
    }

    public ShortInfoVO getShortInfo() {
        return shortInfo;
    }

    public TopInfoVO getTopInfo() {
        return topInfo;
    }
}