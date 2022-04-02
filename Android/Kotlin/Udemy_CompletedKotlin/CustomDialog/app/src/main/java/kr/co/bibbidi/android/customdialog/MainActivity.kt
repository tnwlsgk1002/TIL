package kr.co.bibbidi.android.customdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageButton:ImageButton = findViewById(R.id.imageButton)
        imageButton.setOnClickListener { view ->
            Snackbar.make(view, "You have clicked image button.", Snackbar.LENGTH_LONG).show()
        }

        val btn_alert_dialog: Button = findViewById(R.id.btn_open_alert)
        btn_alert_dialog.setOnClickListener {
            alertDialogFunction()
        }

        val btn_custom_dialog: Button = findViewById(R.id.btn_open_custom)
        btn_custom_dialog.setOnClickListener {
            customDialogFunction()
        }

        val btn_custom_progress_dialog: Button = findViewById(R.id.btn_open_custom_progress)
        btn_custom_progress_dialog.setOnClickListener {
            customProgressDialogFunction()
        }
    }

    fun alertDialogFunction() {
        val builder = AlertDialog.Builder(this) // 다이얼로그 만들기, Builder 객체 생성

        // Builder 설정
        builder.setTitle("Alert")
        builder.setMessage("This is Alert Dialog. Which is used to show alerts in our app.")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes") { dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        builder.setNeutralButton("Cancel") { dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked cancel\n operation cancel", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        builder.setNegativeButton("No") {dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked No", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        // Builder.create
        val alertDialog: AlertDialog = builder.create()

        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    fun customDialogFunction() {
        val customDialog = Dialog(this) // CustomDialog - 텍스트, UI 등 원하는 dialog

        customDialog.setContentView(R.layout.dialog_custom) // setContentView - ui를 Activity 클래스에 적용
        customDialog.findViewById<TextView>(R.id.tv_submit).setOnClickListener{
            Toast.makeText(applicationContext, "clicked submit", Toast.LENGTH_LONG).show()
            // applicationContext 대신 this를 사용해도 상관 없음
            // 하지만 closure 안에서는 MainActivity의 context인 applicationContext가 더 안전
            // 다음 강의에서 배울 것.
            customDialog.dismiss()
        }
        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener ({
            Toast.makeText(applicationContext, "clicked cancel", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        })

        customDialog.show()
    }

    private fun customProgressDialogFunction() {
        val customProgressDialog = Dialog(this)
        customProgressDialog.setContentView(R.layout.dialog_custom_progress)
        customProgressDialog.show()
    }
}