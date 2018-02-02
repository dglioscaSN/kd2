package sn

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test

class VideoStoreTest {

    @Test fun `find movie with a specified title`() {
        val moviesCollection = listOf(oceansEleven)
        val videoStore = VideoStore(moviesCollection)

        val actual = videoStore.find("Ocean's Eleven")

        assertThat(actual, equalTo(oceansEleven))
    }

    @Test fun `find all movies came out in a specific year`() {
        val moviesCollection = listOf(oceansEleven, harryPotter, donnieDarko)
        val videoStore = VideoStore(moviesCollection)

        val actual = videoStore.cameOutIn(2001)

        assertThat(actual, equalTo(moviesCollection))
    }

    @Test fun `no movies found in a specific year`() {
        val moviesCollection = listOf(oceansEleven, harryPotter, donnieDarko)
        val videoStore = VideoStore(moviesCollection)

        val actual = videoStore.cameOutIn(2002)

        assertThat(actual, equalTo(emptyList()))
    }

    @Test fun `award winner in a specific year`() {
        val moviesCollection = listOf(theoryOfEverything, birdman, donnieDarko)

        val videoStore = VideoStore(moviesCollection)
        val actual = videoStore.awardWinner(true, 2015)

        assertThat(actual, equalTo(listOf(theoryOfEverything, birdman)))
    }

    @Test fun `actors performing in a movie in a specific year`() {
        val moviesCollection = listOf(nineteenhundred, allPresidentsMan)
        val videoStore = VideoStore(moviesCollection)

        val actual = videoStore.sameActorName("Robert")

        assertThat(actual, equalTo(listOf(nineteenhundred, allPresidentsMan)))
    }

}