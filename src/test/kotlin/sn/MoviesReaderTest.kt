package sn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test

class MoviesReaderTest {

    @Test fun `read movies from file`() {
        val actual = MoviesReader.readMoviesFrom("movies.txt")

        assertThat(actual.size, equalTo(5))
    }

    @Test fun `movies title from file tab separated`() {
        val actual = MoviesReader.readMoviesFrom("movies.txt")

        assertThat(actual[0].title, equalTo("Taxi driver"))
    }

    @Test fun `read all movies info from tab separated file`() {
        val actual = MoviesReader.readMoviesFrom("movies.txt")

        assertThat(actual[0], equalTo(Movie("Taxi driver", 1976, "yes", listOf("Robert De Niro", "Jodie Foster"))))
    }

    @Test fun `make year a number`() {
        val actual = MoviesReader.readMoviesFrom("movies.txt")

        assertThat(actual[0], equalTo(Movie("Taxi driver", 1976, "yes", listOf("Robert De Niro", "Jodie Foster"))))
    }

    @Test fun `split actors into a list`() {
        val actual = MoviesReader.readMoviesFrom("movies.txt")

        assertThat(actual[0], equalTo(Movie("Taxi driver", 1976, "yes", listOf("Robert De Niro", "Jodie Foster"))))
    }
}