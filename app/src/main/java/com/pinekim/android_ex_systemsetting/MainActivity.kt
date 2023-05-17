package com.pinekim.android_ex_systemsetting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import com.pinekim.android_ex_systemsetting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    private var btnWifi: Button? = null
    private var btnBluetooth: Button? = null
    private var btnSound: Button? = null
    private var btnDisplay: Button? = null
    private var btnBattery: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnWifi = binding.btnSettingWifi
        btnBluetooth = binding.btnSettingBluetooth
        btnSound = binding.btnSettingSound
        btnDisplay = binding.btnSettingDisplay
        btnBattery = binding.btnSettingBattery

        btnWifi?.setOnClickListener { // 와이파이 연결 이동
            // ACTION_WIFI_IP_SETTINGS - 와이파이>고급 설정 / ACTION_WIFI_SETTINGS - 와이파이 설정
            val i = Intent(Settings.ACTION_WIFI_SETTINGS)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }

        btnBluetooth?.setOnClickListener { // 블루투스 연결 이동
            val i = Intent(Settings.ACTION_BLUETOOTH_SETTINGS)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }

        btnSound?.setOnClickListener { // 소리 및 진동 이동
            val i = Intent(Settings.ACTION_SOUND_SETTINGS)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }

        btnDisplay?.setOnClickListener {// 디스플레이 설정 이동
            val i = Intent(Settings.ACTION_DISPLAY_SETTINGS)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }

        btnBattery?.setOnClickListener {
            // ACTION_BATTERY_SAVER_SETTINGS - 배터리>절전모드 / ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS - 배터리 사용량 최적화
            val i = Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }
    }
}