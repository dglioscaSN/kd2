package sn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test

class MoviesReaderTest {
    private val movies = "movies.txt"

    @Test fun `read movies from file`() {
        val actual = MoviesReader.readMoviesFrom(movies)

        assertThat(actual.size, equalTo(5))
    }

    @Test fun `movies title from file tab separated`() {
        val actual = MoviesReader.readMoviesFrom(movies)

        assertThat(actual[0].title, equalTo("Taxi driver"))
    }

    @Test fun `read all movies info from tab separated file`() {
        val actual = MoviesReader.readMoviesFrom(movies)

        assertThat(actual[0], equalTo(Movie("Taxi driver", 1976, "yes", listOf("Robert De Niro", "Jodie Foster"))))
    }

}