import zamgerapi.ZamgerContext
import java.io.File


/**
 *  Neke informacije
 *
 *  Programme IDs:
 *
 *  2 - RI
 *  3 - AE
 *  4 - EE
 *  5 - TK
 */
fun main( args : Array<String> ) {
    val lines = File("login.txt").readLines()

    val user = lines[0]
    val pass = lines[1]

    val context = ZamgerContext(user, pass)


    val person = context.PersonApi.SearchPersonbyUser("aelezovic2")

    val a = 5
}