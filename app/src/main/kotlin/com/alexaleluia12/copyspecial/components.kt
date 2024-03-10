package com.alexaleluia12.copyspecial

import java.io.File
import java.nio.file.Paths

fun listFiles(relativePaths: List<String>) {
    for (p in relativePaths) {
        val file = File(p)

        file.listFiles()?.forEach { fpath ->  println(fpath.absolutePath) }
    }
}

fun  copyFromTo(originPath: String, targetPath: String) {
    val origin = File(originPath)


    origin.listFiles()?.forEach {
        val target = File(Paths.get(targetPath, it.name).toUri())
        it.copyTo(target, overwrite = true)
    }
}

fun zip(lst: List<String>) {

}