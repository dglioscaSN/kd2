package sn

class VideoStore(val movies: List<Movie>) {
    fun findMovie(title: String): Movie? {
        return movies.find { it.title == title }
    }
}