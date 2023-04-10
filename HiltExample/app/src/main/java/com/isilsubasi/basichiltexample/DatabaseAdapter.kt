package com.isilsubasi.basichiltexample

import android.util.Log
import javax.inject.Inject

class DatabaseAdapter @Inject constructor(var databaseService: DatabaseService){

    fun log(msg : String){
        Log.d(TAG,"DatabaseAdapter : $msg")
        databaseService.log(msg)
    }

}