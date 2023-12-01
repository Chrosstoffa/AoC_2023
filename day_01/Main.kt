import java.io.File

fun main(args: Array<String>) {
    val fileName = "input.txt"

    try {
        val file = File(fileName)
        var counterSol2 = 0
        var counterSol1 = 0

        //for solution 1
        for (line in file.readLines()) {

            val numbers = line.filter { it.isDigit() }
            if (numbers.length >= 1) {
                val num = numbers[0].toString() + numbers[numbers.length - 1].toString()
                counterSol1 += num.toInt()
            }

        }

        //for solution 2
        for (line in file.readLines()) {

            val numbers = findAllDigitSequences(line).filter { it.isDigit() }
            if (numbers.length >= 1) {
                val num = numbers[0].toString() + numbers[numbers.length - 1].toString()
                counterSol2 += num.toInt()
            }

        }
        println(counterSol1)
        println(counterSol2)


    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }


}

fun findAllDigitSequences(input: String): String {
    val spelledOutDigits = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val foundDigitPairs = mutableListOf<Pair<String, Int>>()

    for (digit in spelledOutDigits) {
        var index = input.indexOf(digit)
        while (index != -1) {
            foundDigitPairs.add(digit to index)
            index = input.indexOf(digit, index + 1)
        }
    }

    var replacedString = input.toString()

    if (foundDigitPairs.size >= 1) {
        foundDigitPairs.sortBy { it.second }
        val first = foundDigitPairs.first()
        val last = foundDigitPairs.last()
        if(replacedString.contains(first.first)) {
            replacedString = replacedString.replace(first.first, getValueForString(first.first))
            if(replacedString.contains(last.first)) {
                replacedString = replacedString.replace(last.first, getValueForString(last.first))

            }
        }
        return replacedString

    }
    return input



}

fun getValueForString(value: String) : String {
    if(value.equals("one")) {
        return "one1one"
    } else if(value.equals("two")) {
        return "two2two"
    } else if(value.equals("three")) {
        return "three3three"
    } else if(value.equals("four")) {
        return "four4four"
    } else if(value.equals("five")) {
        return "five5five"
    } else if(value.equals("six")) {
        return "six6six"
    } else if(value.equals("seven")) {
        return "seven7seven"
    } else if(value.equals("eight")) {
        return "eight8eight"
    } else if(value.equals("nine")) {
        return "nine9nine"
    } else if(value.equals("zero")) {
        return "zero0zero"
    } else {
        return value
    }
}