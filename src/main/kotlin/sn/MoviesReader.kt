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
        return Movie(
            splitLine[0],
            splitLine[1],
            splitLine[2],
            splitLine[3]
        )
    }

}