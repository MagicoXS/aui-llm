package com.aui.llm.data
data class AiModel(val id: String, val label: String)
enum class AiProvider(val displayName: String, val emoji: String, val hint: String, val keyUrl: String, val models: List<AiModel>) {
    GEMINI("GEMINI","💎","AIzaSy...","aistudio.google.com", listOf(AiModel("gemini-2.5-flash","2.5 Flash"), AiModel("gemini-1.5-flash","1.5 Flash"))),
    GROQ("GROQ","⚡","gsk_...","console.groq.com", listOf(AiModel("llama-3.3-70b-versatile","Llama 3.3 70B"))),
    CLAUDE("CLAUDE","🧠","sk-ant-...","console.anthropic.com", listOf(AiModel("claude-3-5-sonnet-20241022","3.5 Sonnet"))),
    OPENAI("OPENAI","🤖","sk-proj-...","platform.openai.com", listOf(AiModel("gpt-4o-mini","GPT-4o mini"))),
    DEEPSEEK("DEEPSEEK","🐋","sk-...","platform.deepseek.com", listOf(AiModel("deepseek-chat","Chat"))),
    GROK("GROK","🌌","xai-...","console.x.ai", listOf(AiModel("grok-beta","Beta"))),
    QWEN("QWEN","🌐","sk-...","dashscope.aliyun.com", listOf(AiModel("qwen-turbo","Turbo"))),
    OPENROUTER("OPENROUTER","🚀","sk-or-v1-...","openrouter.ai", listOf(AiModel("google/gemini-2.0-flash-exp:free","Gemini Free"))),
    GITHUB("GITHUB","🐙","ghp_...","github.com", listOf(AiModel("gpt-4o","GPT-4o"))),
    ELEVENLABS("ELEVENLABS","🎙️","sk_...","elevenlabs.io", listOf(AiModel("eleven_multilingual_v2","v2"))),
    HACKERAI("HACKER AI","💀","api-key","hackerai.co", listOf(AiModel("hackerai-v1","v1"))),
    LOCAL("LOCAL","📱","On-Device - 127.0.0.1:8080","local", listOf(AiModel("qwen2.5-0.5b-local","Qwen2.5 0.5B Offline"), AiModel("llama-3.2-3b-local","Llama 3.2 On-Device"), AiModel("phi-3-mini-local","Phi 3 Mini")))
}
