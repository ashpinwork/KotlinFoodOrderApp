import aggregation.Address
import aggregation.Name

class CustomerDetails {
    var opt = ""
    var n = Name()
    var a = Address()
    var r = Regular()
    var p = Premium()
    var g = Guest()

    fun getAccount() {

        println("Enter your customer ID: \n(Enter G for Guest)");
        opt = readln()

        // lambda function
        val check: (String) -> Unit = { n: String ->
            when(n[0]) {
                'r', 'R' -> r.payBill()
                'p', 'P' -> p.payBill()
                'g', 'G' -> g.payBill()
                else -> throw ErrorException("Invalid Customer ID")

            }
        }
        check.invoke(opt)
    }
    fun details() {
        println("-------Customer Details--------");
        println("\t Personal");
        println("First Name:");
        n.fName = readln();
        println("Middle Name:");
        n.mName = readln();
        println("Last Name:");
        n.lName = readln();
        println("Phone Number:");
        n.phoneNum = readln().toInt();
        println("Email ID: ");
        n.emailID = readln();
        println("\t Address");
        println("Locality: ");
        a.locality = readln();
        println("City: ");
        a.city = readln();
        println("State: ");
        a.state = readln();
        println("PinCode: ");
        a.pinCode = Integer.valueOf(readln());

        println("-------Confirmation--------");
        println("\t Personal")
        println("First Name: ${n.fName}")
        println("Middle Name:${n.mName}")
        println("Last Name:${n.lName}")
        println("Phone Number:${n.phoneNum}")
        println("Email ID: ${n.emailID}")
        println("\t Address")
        println("Locality: ${a.locality}")
        println("City: ${a.city}")
        println("State: ${a.state}")
        println("PinCode: ${a.pinCode}")
    }
}
