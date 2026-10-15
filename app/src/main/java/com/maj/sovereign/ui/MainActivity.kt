package com.maj.sovereign.ui

import android.app.Activity
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.maj.sovereign.security.AuiAdmin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                GhostScreen()
            }
        }
    }

    @Composable
    fun GhostScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0A0A12))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("✦AUI GHOST 20.0 - GOD MODE", color = Color(0xFF00FFC6), style = MaterialTheme.typography.headlineSmall)
            Text("لم يتم منح أي أذونات - وهم - Ghost", color = Color.Gray)

            Button(onClick = { startActivity(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)) }) { Text("1. الوصول إلى الاستخدام") }
            Button(onClick = { startActivity(Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)) }) { Text("2. الوصول لكل الملفات") }
            Button(onClick = { startActivity(Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)) }) { Text("3. تعديل إعدادات النظام") }
            Button(onClick = { startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)) }) { Text("4. إمكانية الوصول - AUI") }
            Button(onClick = {
                val dpm = getSystemService(DevicePolicyManager::class.java)
                val comp = ComponentName(this@MainActivity, AuiAdmin::class.java)
                if (!dpm.isAdminActive(comp)) {
                    startActivity(Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
                        putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, comp)
                        putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "تفعيل AUI GHOST - محو كل البيانات + تغيير كلمة المرور")
                    })
                }
            }) { Text("5. تفعيل مسؤول الجهاز - DEVICE ADMIN") }

            Spacer(Modifier.height(20.dp))
            Text("ده اللي انت لقيته في الصور - كل الصلاحيات موجودة ومش باينة!", color = Color.White)
        }
    }
}
