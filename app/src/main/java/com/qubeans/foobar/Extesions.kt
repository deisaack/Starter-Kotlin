package com.qubeans.foobar

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: String?, duration: Int = Toast.LENGTH_SHORT) {
    if (message != null) {
        Toast.makeText(this, message, duration).show()
    }
}