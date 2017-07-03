package com.knightdavion.kotlin.ibiliplayer.ui

import android.content.Context
import com.hengda.smart.jsyz.m.component.LoadingDialog

/**
 * Created by Knight_Davion on 2017/6/30.
 */
interface LoadingDialogManager {

    val loadingDialog: LoadingDialog

    fun showLoadingDialog(context: Context) {
        loadingDialog.showDialog(context, "加载中", true, null)
    }

    fun hideLaodingDialog() {
        loadingDialog.dismissDialog()
    }
}