package sn

object MoviesReader {

    fun readMoviesFrom(fileName: String): List<String> {
        val movies = javaClass.classLoader.getResourceAsStream(fileName)
        movies.use {
            return it.reader().readLines()
        }
    }
}