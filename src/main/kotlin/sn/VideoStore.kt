package sn

class VideoStore(val movies: List<Movie>) {

    fun findMovie(title: String): Movie? = movies.find { it.title == title }

    fun cameOutIn(year: Int) : List<Movie> = movies.filter { it.year == year }

    fun awardWinner(awardWinner: Boolean): List<Movie> = movies.filter { isAwardWinner(it) == awardWinner }

    private fun isAwardWinner(it: Movie) = it.awardWinner == "yes"
}