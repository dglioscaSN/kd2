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

    @Test fun `find all movies came out in a specific year`() {
        val oceansEleven = Movie("Ocean's Eleven", 2001, "no", listOf("George Clooney", "Brad Pitt", "Julia Roberts"))
        val harryPotter = Movie("Harry Potter and the Sorcerer's Stone", 2001, "no", listOf("Daniel Radcliffe", " Rupert Grint", "Richard Harris"))
        val donnieDarko = Movie("Donnie Darko", 2001, "no", listOf("Jake Gyllenhaal", "Jena Malone", "Mary McDonnell"))
        val movieCollection = listOf(oceansEleven, harryPotter, donnieDarko)
        val videoStore = VideoStore(movieCollection)
        val movies = videoStore.cameOutIn(2001)

        assertThat(movies, equalTo(movieCollection))
    }

    @Test fun `no movies found in a specific year`() {
        val oceansEleven = Movie("Ocean's Eleven", 2001, "no", listOf("George Clooney", "Brad Pitt", "Julia Roberts"))
        val harryPotter = Movie("Harry Potter and the Sorcerer's Stone", 2001, "no", listOf("Daniel Radcliffe", " Rupert Grint", "Richard Harris"))
        val donnieDarko = Movie("Donnie Darko", 2001, "no", listOf( "Jake Gyllenhaal", "Jena Malone", "Mary McDonnell"))
        val movieCollection = listOf(oceansEleven, harryPotter, donnieDarko)
        val videoStore = VideoStore(movieCollection)
        val movies = videoStore.cameOutIn(2002)

        assertThat(movies, equalTo(emptyList()))
    }
}