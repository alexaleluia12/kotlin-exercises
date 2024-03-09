package com.alexaleluia12
import java.io.File
import kotlin.text.Regex

class re {
    companion object {
        fun doWork() {

            val str = "an example word:cat!!"
            val rePattern = """word:\w\w\w"""
            // com scape: "word:\\w\\w\\w"
            val regex = Regex(rePattern)
            val matchResult = regex.find(str)

            if (matchResult != null) {
                println("found ${matchResult.value}")  // 'found word:cat'
            } else {
                println("did not find")
            }

            var mtc: MatchResult?
            // [c . \d \w \s]
            mtc = Regex("""iii""").find("piiig")
            println(mtc?.value) //iii
            mtc = Regex("""igs""").find("piiig")
            println(mtc?.value) // null
            mtc = Regex("""..g""").find("piiig")
            println(mtc?.value) // iig
            mtc = Regex("""\d\d\d""").find("p123g")
            println(mtc?.value)// 123
            mtc = Regex("""\w\w\w""").find("@@5bcd!!")
            println(mtc?.value) // 5bc
            println()
            // [* + ?]
            // * -> zero ou mais, + -> um ou mais, ? -> zero ou um
            mtc = Regex("""pi+""").find("piiig")
            println(mtc?.value) // piiig
            mtc = Regex("""i+""").find("piigiiii")
            println(mtc?.value) // ii (pegou apenas o primeiro grupo - menor a esquerda)
            val threeDigitsByOptionalSpaceAnyLength = """\d\s*\d\s*\d"""
            mtc = Regex(threeDigitsByOptionalSpaceAnyLength).find("xx1 2   3xx")
            println(mtc?.value) // 1 2   3
            mtc = Regex(threeDigitsByOptionalSpaceAnyLength).find("xx12  3xx")
            println(mtc?.value) // 12  3
            mtc = Regex(threeDigitsByOptionalSpaceAnyLength).find("xx123xx")
            println(mtc?.value) // 123

            // ^ -> inicio da string
            mtc = Regex("""^b\w+""").find("foobar")
            println(mtc?.value) // null (por causa da marca ^ de inicio
            mtc = Regex("""b\w+""").find("foobar")
            println(mtc?.value) // bar

            // email find re
            val lineWithEmail = "purple alice-b@google.com monkey dishwasher"
            mtc = Regex("""\w+@\w+""").find(lineWithEmail)
            println(mtc?.value) // b@google
            // [] mantem a msm semantica dos outros signais exeto para . (que se torna literal)
            // primeira parte = (\w ou . ou -) mais de uma vez
            // - dentro de [] pode indicar range [a-c] todos de a ate c, incluisivo
            // ^ no inicio de [] indica negacao do [^ab]  todos  menos a ou b
            mtc = Regex("""[\w.-]+@[\w.]+""").find(lineWithEmail)
            println(mtc?.value) // alice-b@google.com

            // captura de grupos
            mtc = Regex("""([\w.-]+)@([\w.]+)""").find(lineWithEmail)
            mtc?.let {
                println(it.groupValues[0]) // == it.value
                println(it.groupValues[1])
                println(it.groupValues[2])
            }
            val lineWithManyEmails = "purple alice@google.com, blah monkey bob@abc.com blah dishwasher"
            val emails = Regex("""[\w.-]+@[\w.]+""").findAll(lineWithManyEmails)
            for (e in emails) {
                println(e.value)
            }

            val brMarket = "B3 stock  market kel3 values kepl3 agro, mrfg3 carne petr4 gas"
            val r = Regex("""[a-z]{4}\d""").replace(brMarket, "NTS")
            println(r) // B3 stock market values NTS agro, NTS carne NTS gas


            val lt = listOf("app/src/main/resources/babynames/baby2002.html",
                "app/src/main/resources/babynames/baby2008.html",
                "app/src/main/resources/babynames/small.txt",
                "app/src/main/resources/babynames/baby2006.html")
            val ptx = Regex("""/baby.*.html""")
            // em quanque posicao
            println(ptx.containsMatchIn(lt[0])) // true
            // em quanque posicao
            val mtx = ptx.find(lt[0])
            println(mtx?.value) // /babynames/baby2002.html
            // Verifica na string TODA
            println(ptx.matches(lt[0])) // false
        }
    }
}
