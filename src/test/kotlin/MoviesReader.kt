import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test

class MoviesReader {

    @Test fun `read movies from file`() {
        val movies = javaClass.classLoader.getResourceAsStream("movies.txt")
        movies.use { val actual = it.reader().readLines()
            assertThat(actual[0], equalTo("movie_title   year  award_winner  actors_comma_separated"))
        }
    }
}