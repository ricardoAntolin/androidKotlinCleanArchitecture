package com.rantolin.cleanarchitecture.presentation.ui.fragments

import android.support.v4.app.Fragment
import java.math.BigInteger
import java.security.SecureRandom

open class BaseFragment : Fragment {
    var fragmentId:String? = null

    constructor(){
        generateId()
    }

    fun generateId(){
        var hash = ""
        this.javaClass.simpleName.map { hash = hash + BigInteger(1, SecureRandom()).toString() + it.toInt() + it}
        fragmentId = hash
    }

}