package sn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test

class MoviesReaderTest {

    @Test fun `read movies from file`() {
        val actual = MoviesReader.readMoviesFrom("movies.txt")

        assertThat(actual[0], equalTo("movie_title   year  award_winner  actors_comma_separated"))
    }
}