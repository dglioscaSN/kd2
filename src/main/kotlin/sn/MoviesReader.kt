package sn

object MoviesReader {

    fun readMoviesFrom(fileName: String): List<Movie> {
        val movies = javaClass.classLoader.getResourceAsStream(fileName)
        movies.use {
            return it.reader()
                .readLines()
                .map { it.toMovie() }
        }
    }

    private fun String.toMovie(): Movie {
        val splitLine = split('\t')
        val title = splitLine[0]
        val year = splitLine[1].toInt()
        val awardWinner = splitLine[2]
        val actors = splitLine[3]
        return Movie(
            title,
            year,
            awardWinner,
            actors
        )
    }

}