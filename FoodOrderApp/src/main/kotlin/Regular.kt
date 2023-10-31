import java.io.File

class Regular: Orders(), BillPayment {
    var delivery = 150f
    var points = 0.5f
    var discount = 0.2f
    var totalAmount = 0f



    override fun payBill() {
        var rev = arrayListOf<Review>()
        var billFile = File("BillRegular.txt")
        billFile.createNewFile()

        billFile.writeText( "----------------------\nThe TAJ Restaurant\n")
        billFile.appendText("Gandhi Nagar, Bengaluru\n")

        Menu.displayMenu()
        makeOrder()
        confirmation(billFile)
        total = calculate()
        totalAmount = total.billTotal(delivery,discount)

        billFile.appendText("Total Amount: $total\n")
        billFile.appendText("----------------------\nRegular Account Billing\n----------------------\n")
        billFile.appendText("Delivery Charge :${delivery}\nRegular Member Discount : ${discount*100}%\nTotal Billable Amount : ${totalAmount} \n")

        points.calcPoints(totalAmount, billFile)

        //println("----------------------\nRegular Account Billing\n----------------------\n")
        //println("Delivery Charge :${delivery}")
        //println("Regular Member Discount : ${discount*100}%")
        //println("Total Billable Amount : ${totalAmount}")

        Restaurant.dateTime(billFile)
        Restaurant.queries(billFile)

        var c = billFile.readText()
        println(c)

        println("Please rate your experience with our app (1 to 5)")
        var num = readln().toInt()
        rev.add(Review(num))
        Review.showRev(rev[0].shopexp)


    }


}

