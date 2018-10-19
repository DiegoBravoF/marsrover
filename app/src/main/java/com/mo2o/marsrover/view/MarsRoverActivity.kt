package com.mo2o.marsrover.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.mo2o.marsrover.R
import com.mo2o.marsrover.presentation.MarsRoverPresenter
import com.mo2o.marsrover.presentation.MarsRoverView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MarsRoverActivity : AppCompatActivity(), MarsRoverView {

    private val presenter = MarsRoverPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        presenter.attach(this)
        fab.setOnClickListener { view ->

        }
        inputCommad.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.commandHasChanged(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    override fun printStatus(status: String) {
        textLabel.text = status
    }

    override fun clearCommands() {
        inputCommad.setText("")
    }

    override fun changeStatusButton(enable: Boolean) {
        fab.isEnabled = enable
    }
}
