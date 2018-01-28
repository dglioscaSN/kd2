package sn

object MoviesReader {

    fun readMoviesFrom(fileName: String): List<Movie> {
        val movies = javaClass.classLoader.getResourceAsStream(fileName)
        movies.use {
            return it.reader().readLines().map { it.split('\t')[0] }.map { Movie(it) }
        }
    }

    data class Movie(val title: String)
}