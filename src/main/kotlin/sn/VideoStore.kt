package sn

class VideoStore(private val movies: List<Movie>) {

    fun find(title: String) = movies.find { it.title == title }
    fun cameOutIn(year: Int) = movies.filter { it.year == year }
    fun awardWinner(awardWinner: Boolean, year: Int) = movies.filter { isAwardWinner(it) == awardWinner }.filter { it.year == year }
    fun moviesWithSameActorName(actorName: String) = movies.filter { it.actors.containsActor(actorName) }

    private fun isAwardWinner(it: Movie) = it.awardWinner == "yes"
    private fun List<String>.containsActor(actorName: String) = this.find { it.contains(actorName) } != null
}
