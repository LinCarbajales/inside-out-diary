package dev.lin.value_objects;

import dev.lin.dtos.ReleaseYearDTO;
import com.google.gson.annotations.SerializedName;

public class TopInfoVO {

    @SerializedName("releaseYear")
    private ReleaseYearDTO releaseYear;

    public ReleaseYearDTO getReleaseYear() {
        return releaseYear;
    }

    // Método para obtener el año como int
    public Integer getYearAsInt() {
        if (releaseYear == null) {
            return null;
        }
        return releaseYear.getYear();
    }
}