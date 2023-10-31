import java.io.File
import java.time.*
import java.time.format.DateTimeFormatter

class Restaurant {
    companion object ResDetails{
        fun display() {
            println("------------------------------")
            println("\n \tWelcome to Taj Restaurant\n")
            println("------------------------------")
        }
        fun dateTime (f: File) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            val formatted = current.format(formatter)
            f.appendText("$formatted\n")
            //println("$formatted")
        }

        fun queries(f: File) {
            f.appendText("--------------------------\nThank you for choosing The Taj Restaurant! Enjoy your meal!\nFor any queries, please contact:\n+91 653456534\ntaj@email.com\n")
            //println("--------------------------");
            //println("Thank you for choosing The Taj Restaurant! Enjoy your meal!");
            //println("For any queries, please contact:");
            //println("+91 653456534");
            //println("taj@email.com");
            //println("--------------------------");
        }
    }

    var dineOpt: Int = 0
    var cd = CustomerDetails()

    fun diningOption(): Unit {
        println("Dine-In (1)/ Order Online (2)");
        dineOpt = readln().toInt()

        if (dineOpt == 2) {
            cd.getAccount()

        }
        else if (dineOpt == 1) {
            reserveTable()
        }
        else {
            throw ErrorException("Invalid Selection!")
            //println("Invalid Options")
        }
    }

    fun reserveTable() {
        println("-----------Table reservation----------")
        println("Enter the number of people")
        var peopleNum = readln().toInt()
        println("Would you like to avail valet service? (Y/N)")
        var valet = readln()
        peopleNum.bookingCost(valet)
    }

}

fun Int.bookingCost(v: String): Unit {
    var cd = CustomerDetails()
    var valetServiceFee = 5000
    if (v[0] == 'y' || v[0] == 'Y') {
        println("-----------------------")
        println("Reservation Charge per person : ${this}x ${1000}")
        println("Valet Charge : ${valetServiceFee}")
        println("Total Billable Amount : ${1000*this+valetServiceFee}")
        cd.details()
    }
    else {
        println("-----------------------")
        println("Reservation Charge per person : ${this}x ${1000} ")
        println("Total Billable Amount : ${1000*this}")
        cd.details()
    }
}



