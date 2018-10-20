package com.mo2o.marsrover.view

import android.app.Application
import android.content.Context
import com.github.tmurakami.dexopener.DexOpenerAndroidJUnitRunner

class CustomTestRunner : DexOpenerAndroidJUnitRunner() {
    @Throws(InstantiationException::class,
            IllegalAccessException::class,
            ClassNotFoundException::class)
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(
                cl,
                "com.mo2o.marsrover.view.TestApplication",
                context)
    }
}