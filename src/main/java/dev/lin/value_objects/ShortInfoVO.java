package dev.lin.value_objects;

import java.util.Arrays;

/* 
 * ShortInfo es un Value Object de MovieDTO
 * Contiene datos inmutables de la llamada API
 * 
 * No hay que confundir nunca una entidad con un value object. 
 * La principal diferencia es que las primeras poseen una identidad, 
 * un identificador que las hace únicas de cara a otra instancia de la misma clase. 
 * Un value object en cambio no posee identidad, por lo que las comparaciones entre value 
 * objects deben hacerse basándose en su contenido, y no un identificador o referencia.
 */
public class ShortInfoVO {

    private String name;
    private String url;
    private String image;
    private String[] genre;
    // Eliminado: private LocalDate releaseDate; - no existe en el JSON

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String[] getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShortInfoVO other = (ShortInfoVO) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        if (!Arrays.equals(genre, other.genre))
            return false;
        return true;
    }
}