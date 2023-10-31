import java.io.File

class Premium: Orders(), BillPayment {
    var delivery = 50f
    var points = 1.2f
    var discount = 0.4f
    var totalAmount = 0f

    override fun payBill() {
        var rev = arrayListOf<Review>()
        var billFile = File("BillPremium.txt")
        billFile.createNewFile()

        billFile.writeText( "----------------------\nThe TAJ Restaurant\n")
        billFile.appendText("Gandhi Nagar, Bengaluru\n")

        Menu.displayMenu()
        makeOrder()
        confirmation(billFile)
        total = calculate()
        totalAmount = total.billTotal(delivery,discount)

        billFile.appendText("Total Amount: $total\n")
        billFile.appendText("----------------------\nPremium Account Billing\n----------------------\n")
        billFile.appendText("Delivery Charge :${delivery}\nPremium Member Discount : ${discount*100}%\nTotal Billable Amount : ${totalAmount} \n")

        points.calcPoints(totalAmount, billFile)

        Restaurant.dateTime(billFile)
        Restaurant.queries(billFile)

        var c= billFile.readText()
        println(c)

        println("Please rate your experience with our app (1 to 5)")
        var num = readln().toInt()
        rev.add(Review(num))
        Review.showRev(rev[0].shopexp)
    }
}

fun Float.billTotal(del: Float, disc: Float): Float {
    return (del + this *(1-disc))
}

fun Float.calcPoints(t: Float, f:File): Unit {
    f.appendText("Points obtained on this purchase $this * $t = ${this*t}\n")
}