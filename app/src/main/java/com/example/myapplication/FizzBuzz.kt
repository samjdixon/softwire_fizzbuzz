import java.lang.NumberFormatException
import kotlin.system.exitProcess


fun main() {

    setup()

    while (true) {
        var to = getinput()
        println(count(0, to))
    }

}


fun getinput(): Int {
    //Will only return integers greater than or equal to zero
    var valid_input = false
    var to = -1


    while (valid_input == false) {
        println("What number would you like to go to?")
        var user_input = readLine()!!
        try {
            to = user_input.toInt()
            if (to >= 0) {
                valid_input = true
            } else {
                println("You need to enter a number greater than or equal to zero!")
            }
        } catch (e: NumberFormatException) {
            println("You need to enter a number!")
            quit()
        }

    }
    return (to)
}

fun quit() {
    println("Would you like to quit? \nEnter Q if you do, anything else to keep playing.")
    var user_input = readLine()
    if (user_input == "Q" || user_input == "q") {
        println("Goodbye!")
        exitProcess(0)
    }
}

fun setup() {
    println("Welcome to FizzBuzz!")
}

fun count(from: Int, to: Int): String {
    var display = ""
    for (i in from..to) {
        display += (fizzbuzz(i) + "\n")
    }
    return (display)
}

fun fizzbuzz(number: Int): String {
    var output = ""
    if (number.rem(3) == 0) {
        output = output + "Fizz"
    }
    if (number.rem(5) == 0) {
        output = output + "Buzz"
    }
    if (number.rem(7) == 0) {
        output = output + "Bang"
    }

    if (number.rem(11) == 0) {
        output = "Bong"
    }  //NB that Bong supersedses Fizz, Buzz and Bang

    if (number.rem(13) == 0) {
        //Fezz is inserted immediately before the first "B"
        var B_position = output.indexOf("B")
        if (B_position != -1) {
            output =
                output.slice(0..B_position - 1) + "Fezz" + output.slice(B_position..output.length - 1)
        }


    }
    if (number.rem(17) == 0) {
        //A multiple of 17 reverses the order of all the words.
        output = reversestring(output, 4)
    }

    if (output == "") {
        //If none of the cases apply, just print the number.
        output = number.toString()
    }
    return (output)
}

fun reversestring(text: String, block_size: Int): String {
    var length = (text.length) / block_size
    var function_output = ""

    if (length != 0) {

        val array: MutableList<String> = ArrayList()

        for (i in 0..(length - 1)) {
            array.add(text.slice(block_size * i..block_size * (i + 1) - 1))
        }
        for (i in 0..(length - 1)) {
            function_output = function_output + array[length - 1 - i]
        }

    }
    return (function_output)

}