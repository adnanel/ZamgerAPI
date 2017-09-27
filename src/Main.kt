import zamgerapi.CourseAPI
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

    context.CourseAPI.GetProgrammeForSemester(CourseAPI.PROGRAMME_RI, 5).forEach {
        try {
            val course = context.CourseAPI.GetCourseById(it.CourseID.toInt())
        } catch ( ex : Exception ) {
            ex.printStackTrace()
        }
    }
}