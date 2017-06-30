package com.example.kd.dialog

import android.support.v7.app.AppCompatActivity
import com.hengda.smart.jsyz.m.component.LoadingDialog
import com.knightdavion.kotlin.ibiliplayer.ui.LoadingDialogManager

open class BaseActivity : AppCompatActivity(), LoadingDialogManager {
    override val loadingDialog by lazy { LoadingDialog(this) }
}
