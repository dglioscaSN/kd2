package sn

class VideoStore(val movies: List<Movie>) {

    fun findMovie(title: String): Movie? = movies.find { it.title == title }

    fun cameOutIn(year: Int) : List<Movie> {
        return movies.filter { it.year == year }
    }
}