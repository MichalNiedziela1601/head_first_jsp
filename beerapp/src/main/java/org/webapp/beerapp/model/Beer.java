package org.webapp.beerapp.model;

public class Beer {

    private Long id;
    private String brewery;
    private String name;
    private String genre;

    public Beer() {

    }

    public Beer(Long id, String brewery, String name, String genre) {
        this.id = id;
        this.brewery = brewery;
        this.name = name;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beer beer = (Beer) o;

        if (!id.equals(beer.id)) return false;
        if (brewery != null ? !brewery.equals(beer.brewery) : beer.brewery != null) return false;
        if (name != null ? !name.equals(beer.name) : beer.name != null) return false;
        return genre != null ? genre.equals(beer.genre) : beer.genre == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (brewery != null ? brewery.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", brewery='" + brewery + '\'' +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
