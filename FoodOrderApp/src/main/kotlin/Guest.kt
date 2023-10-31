import java.io.File

class Guest: Orders(), BillPayment {
    var delivery = 300f
    var totalAmount = 0f

    override fun payBill() {

        var cd = CustomerDetails()
        var rev = arrayListOf<Review>()
        var billFile = File("BillGuest.txt")
        billFile.createNewFile()

        billFile.writeText( "----------------------\nThe TAJ Restaurant\n")
        billFile.appendText("Gandhi Nagar, Bengaluru\n")

        Menu.displayMenu()
        makeOrder()
        confirmation(billFile)
        total = calculate()
        totalAmount = total.billTotal(delivery)

        billFile.appendText("Total Amount: $total\n")
        billFile.appendText("----------------------\nGuest Billing\n----------------------\n")
        billFile.appendText("Delivery Charge :${delivery}\nTotal Billable Amount : ${totalAmount} \n")
        Restaurant.dateTime(billFile)
        Restaurant.queries(billFile)

        var c = billFile.readText()
        println(c)

        cd.details()

        println("--------------------------")
        println("Please rate your experience with our app (1 to 5)")
        var num = readln().toInt()
        rev.add(Review(num))
        Review.showRev(rev[0].shopexp)
    }
}

fun Float.billTotal(del: Float): Float {
    return (this + del)
}