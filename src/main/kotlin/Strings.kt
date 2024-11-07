import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun removeDigitsFromUserCPF(userCPF: String): String {
    val regexValidateCPF = Regex("\\D")
    return regexValidateCPF.replace(userCPF, "")
}

fun extractEmailInformation(email: String): String {
    val beforeAtEmail = Regex("\\b[0-9A-Za-z._%+-]+")
    val afterAtEmail = Regex("(?<=@)[A-Za-z0-9.-]+\\.[A-Za-z]{2,}(\\.br)?$")

    val emailUserName = beforeAtEmail.find(email)?.value ?: ""
    val emailUserDomain = afterAtEmail.find(email)?.value ?: ""
    val isBrazilianEmail = emailUserDomain.contains(".br")

    val string = "Usuario: $emailUserName\nDominio: $emailUserDomain\nBrasileiro: $isBrazilianEmail\n"
    return string
}

fun formatDate(day: Int, month: Int, year: Int): String {
    val regexForDayAndMonth = Regex("\\d{2}")
    val formatedDay = if (regexForDayAndMonth.matches(day.toString())) day.toString() else "0$day"
    val formatedMonth = if (regexForDayAndMonth.matches(month.toString())) month.toString() else "0$month"
    return "$formatedDay/$formatedMonth/$year"
}

fun extractDateData(date: String): String {
    val extractDayFromDate = Regex("^(0?[1-9]|[12][0-9]|3[01])+")
    val extractMonthFromDate = Regex("(?<=/)(0[1-9]|1[012])")
    val extractYearFromDate = Regex("(?<=(0?[1-9]|[12][0-9]|3[01])/(?<=/)(0?[1-9]|1[012])/)((19|20)\\d\\d)")

    val formatedDay = extractDayFromDate.find(date)?.value ?: ""
    val formatedMonth = extractMonthFromDate.find(date)?.value ?: ""
    val formatedYear = extractYearFromDate.find(date)?.value ?: ""

    val newDayWithoutZero = if (formatedDay.first() == '0') formatedDay.last() else formatedDay
    val newMonthWithoutZero = if (formatedMonth.first() == '0') formatedMonth.last() else formatedMonth

    return "$newDayWithoutZero/$newMonthWithoutZero/$formatedYear"
}

fun validatePassword(password: String): String {
    val passwordValidationRegex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$")
    return if(passwordValidationRegex.matches(password)) "VALIDA" else "INVALIDA"
}

fun isAnagram(s: String, t: String): Boolean {
    val firstWord = s.split("").sorted()
    val secondWord = t.split("").sorted()
    return firstWord == secondWord
}

fun longestCommonPrefix(strs: Array<String>): String {
    if(strs.size == 1) return strs[0]

    var min = Integer.MAX_VALUE
    for(s in strs){
        min = min(min, s.length)
    }

    for(i in 0 until min){
        val char = strs[0][i]
        for(s in strs){
            if(s[i] != char){
                return s.substring(0, i)
            }
        }
    }

    return strs[0].substring(0, min)
}

fun longestCommonPrefixII(strs: Array<String>): String {
    if(strs.size == 1) return strs[0]
    val sortedStrings = strs.sorted()
    val firstString = sortedStrings.first()
    val lastString = sortedStrings.last()
    val maxLength = min(firstString.length, lastString.length)

    for (index in 0 until maxLength) {
        if (firstString[index] != lastString[index]) return firstString.substring(0, index)
    }
    return firstString.substring(0, maxLength)
}

fun invalidTransactions(transactions: Array<String>): List<String> {

    fun String.toRecord(): Record {
        val arr = this.split(",")
        return Record(
            name = arr[0],
            time = arr[1].toInt(),
            amount = arr[2].toInt(),
            city = arr[3]
        )
    }

    fun Record.asString(): String {
        return this.name + "," + this.time + "," + this.amount + "," + this.city
    }

    val records = mutableMapOf<String, MutableList<Record>>()
    val invalidRecords = mutableListOf<String>()
    transactions.forEach {
        val record = it.toRecord()
        val list = records.getOrDefault(record.name, mutableListOf<Record>())
        list.add(record)
        records.put(record.name, list)
    }

    records.forEach { name, list ->
        list.forEach { record ->
            if (!isValid(record, records)) {
                invalidRecords.add(record.asString())
            }
        }
    }

    return invalidRecords
}

private fun isValid(record: Record, records: Map<String, MutableList<Record>>): Boolean {
    if(record.amount > 1000) {
        return false
    }
    records[record.name]?.forEach { rec2 ->
        if (record.city != rec2.city && abs(record.time - rec2.time) <= 60) {
            return false
        }
    }
    return true
}

data class Record(
    val name: String,
    val time: Int,
    val amount: Int,
    val city: String,
)

