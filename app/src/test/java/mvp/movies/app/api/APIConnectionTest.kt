package mvp.movies.app.api

import org.junit.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL
import java.nio.charset.Charset


class APIConnectionTest {

    @Test
    @Throws(Exception::class)
    fun testAvailability() {
        val connection =
            URL("https://api.themoviedb.org/3/discover/movie?api_key=0c594548fb5cfb6bc6f353b5b10b9fc4").openConnection()
        val inputStream = connection.getInputStream()

        val buffer = StringBuffer()
        BufferedReader(InputStreamReader(inputStream, Charset.defaultCharset())).use { reader ->
            reader.readLine().map {
                buffer.append(it)
            }
        }
        assert(buffer.isNotEmpty())
    }
}