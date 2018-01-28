package sn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test

class MoviesReaderTest {

    @Test fun `read movies from file`() {
        val actual = MoviesReader.readMoviesFrom("movies.txt")

        assertThat(actual[0], equalTo("Taxi driver\t1976\tyes\tRobert De Niro, Jodie Foster"))
    }
}