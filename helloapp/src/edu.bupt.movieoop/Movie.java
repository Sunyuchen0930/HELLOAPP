public class Movie {
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private double score;
    private String country;
    private String actors;

    public Movie() {
    }

    public Movie(String name, double score, String country, String actors,int id) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.actors = actors;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}
