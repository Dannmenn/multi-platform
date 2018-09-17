package pl.mendroch.crossplatform.respositories

import pl.mendroch.crossplatform.common.Endpoints
import pl.mendroch.crossplatform.utils.HttpApi
import java.nio.file.Files
import java.nio.file.Path

open class FileProviderImpl(private val file: String, private val httpUtil: HttpApi) : FileProvider<Path> {
    override suspend fun getData(): Path {
        val tempFile = Files.createTempFile("file", "out")
        Files.newOutputStream(tempFile).use {
            httpUtil.getResource(Endpoints.files + file, it)
        }
        return tempFile
    }
}

class SmallFileProviderImpl(httpUtil: HttpApi) : FileProviderImpl(Endpoints.small, httpUtil)
class BigFileProviderImpl(httpUtil: HttpApi) : FileProviderImpl(Endpoints.big, httpUtil)