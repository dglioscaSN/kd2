package sn

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class VideoRentalShopTest {

    @Test fun `can rent a dvd`() {
        val videoStore = VideoStore(listOf(oceansEleven))
        val videoRentalShop = VideoRentalShop(videoStore)

        val (result, rentalShop)  = videoRentalShop.rent(oceansEleven)
        assertThat(result, equalTo(true))
        val (expected, _) = rentalShop.rent(oceansEleven)
        assertThat(expected, equalTo(false))
    }

    class VideoRentalShop(private val videoStore: VideoStore, private val currentlyRented: List<Movie> = emptyList()) {

        fun rent(movie: Movie) =
            if (videoStore.find(movie.title) == null)
                Pair(false, this)
            else {
                if (currentlyRented.contains(movie)) {
                    Pair(false, this)
                } else {
                    Pair(true, VideoRentalShop(this.videoStore, currentlyRented.plus(oceansEleven)))
                }
            }
    }

}
// java Currency
// concept of single user?
// what to return?
// use a monad result?
