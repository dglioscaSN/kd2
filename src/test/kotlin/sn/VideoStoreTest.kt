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
        val donnieDarko = Movie("Donnie Darko", 2001, "no", listOf("Jake Gyllenhaal", "Jena Malone", "Mary McDonnell"))
        val movieCollection = listOf(oceansEleven, harryPotter, donnieDarko)
        val videoStore = VideoStore(movieCollection)
        val movies = videoStore.cameOutIn(2002)

        assertThat(movies, equalTo(emptyList()))
    }

    @Test fun `award winner in a specific year`() {
        val theoryOfEverything = Movie("The Theory of Everything", 2015, "yes", listOf("Eddie Redmayne", "Felicity Jones", "Tom Prior"))
        val birdman = Movie("Birdman or (The Unexpected Virtue of Ignorance)", 2015, "yes", listOf("Michael Keaton", "Zach Galifianakis", "Edward Norton"))
        val donnieDarko = Movie("Donnie Darko", 2001, "no", listOf("Jake Gyllenhaal", "Jena Malone", "Mary McDonnell"))
        val movieCollection = listOf(theoryOfEverything, birdman, donnieDarko)
        val videoStore = VideoStore(movieCollection)
        val movies = videoStore.awardWinner(true, 2015)

        assertThat(movies, equalTo(listOf(theoryOfEverything, birdman)))
    }

    @Test fun `actors performing in a movie in a specific year`() {
        val nineteenhundred = Movie("1900", 1976, "no", listOf("Robert De Niro", "Gérard Depardieu"))
        val allPresidentsMan = Movie("All the President's men", 1976, "no", listOf("Dustin Hoffman", "Robert Redford"))
        val movieCollection = listOf(nineteenhundred, allPresidentsMan)

        val videoStore = VideoStore(movieCollection)
        val movies = videoStore.moviesWithSameActorName("Robert")

        assertThat(movies, equalTo(listOf(nineteenhundred, allPresidentsMan)))
    }

}