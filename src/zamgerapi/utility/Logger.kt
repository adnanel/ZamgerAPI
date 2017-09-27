package zamgerapi.utility

import java.io.OutputStream
import java.io.PrintStream

fun log(msg : String) {
    System.out.println(msg);
}

fun log(ex : Exception) {
    val s = StringBuilder()
    ex.printStackTrace(PrintStream(object : OutputStream() {
        override fun write( b : Int) {
            s.append(b.toChar())
        }
    }))
    log(s.toString())
}