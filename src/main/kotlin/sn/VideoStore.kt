package sn

class VideoStore(val movies: List<Movie>) {

    fun findMovie(title: String): Movie? = movies.find { it.title == title }

    fun cameOutIn(year: Int) : List<Movie> = movies.filter { it.year == year }

    fun awardWinner(awardWinner: Boolean, year: Int): List<Movie> = movies.filter { isAwardWinner(it) == awardWinner }.filter { it.year == year }

    fun moviesWithSameActorName(actorName: String): List<Movie> {
        return movies.filter { it.actors.containActor(actorName) }
    }

    private fun isAwardWinner(it: Movie) = it.awardWinner == "yes"
}

private fun List<String>.containActor(actorName: String): Boolean {
    return this.find { it.contains(actorName) } != null
}
