package sn

class VideoStore(val movies: List<Movie>) {

    fun findMovie(title: String): Movie? = movies.find { it.title == title }

    fun cameOutIn(year: Int) : List<Movie> = movies.filter { it.year == year }

    fun awardWinner(awardWinner: String): List<Movie> = movies.filter { it.awardWinner == awardWinner }
}