package sn

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test

class VideoStoreTest {

    @Test fun `find movie with a specified title`() {
        val oceansEleven = Movie("Ocean's Eleven", 2001, "no", listOf("George Clooney", "Brad Pitt", "Julia Roberts"))
        val videoStore = VideoStore(listOf(oceansEleven))
        val movie: Movie? = videoStore.findMovie("Ocean's Eleven")

        assertThat(movie, equalTo(oceansEleven))
    }
}