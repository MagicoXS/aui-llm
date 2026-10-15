package com.aui.llm.api
import com.aui.llm.data.AiProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit
object ApiClient {
    private val client = OkHttpClient.Builder().connectTimeout(2, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build()
    // SULA OFFLINE LOGIC
    suspend fun getPoem(userVibe: String, provider: AiProvider): String = withContext(Dispatchers.IO) {
        // 1. جرب LOCAL الاول - 127.0.0.1:8080
        if (provider == AiProvider.LOCAL) {
            try {
                val req = Request.Builder().url("http://127.0.0.1:8080/v1/chat/completions").build()
                // لو السيرفر شغال هيرجع رد
                val resp = client.newCall(req).execute()
                if (resp.isSuccessful) return@withContext "LOCAL MODE: ${resp.body?.string()?.take(200)}"
            } catch (e: Exception) { /* سيرفر اوفلاين - هنقع على الاونلاين */ }
        }
        // 2. اونلاين - GEMINI/GROQ etc
        return@withContext "ONLINE MODE: Poem for vibe: $userVibe via ${provider.displayName}"
    }
    fun isScreenSecure(context: android.content.Context): Boolean {
        return android.provider.Settings.canDrawOverlays(context).not()
    }
}
