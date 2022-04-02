package kr.co.bibbidi.android.coroutinesdemo

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    var customProgressDialog: Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnExecute: Button = findViewById(R.id.btn_execute)
        btnExecute.setOnClickListener {
            lifecycleScope.launch {
                showProgressDialog()
                execute("Task executed successfully")
            }
            // execute("Task executed successfully") // 메인스레드에서 suspend function을 실행 x
            // 라이프 사이클 스코프 : 모든 액티비티 클래스의 코루틴을 적절히 처리하기 위해 구축된 코루틴 블록
            //
            /*
            for (i in 1..100000) {
                Log.e("delay : ", "" + i)
            } // 로그 입력값이 쌓임.
            Toast.makeText(
                this@MainActivity, "Done",
                Toast.LENGTH_LONG
            ).show()
            // 비추천
            // coroutine을 사용하면 오래 걸리는 작업을
            // background의 다른 스레드로 넘겨서 ui 스레드가 차단되지 않고
            // 계속 실행 -> 사용자가 막힘없이 앱을 사용할 수 있도록 만듦
            */
        }

    }
    private suspend fun execute(result:String) { // suspend : 코루틴 함수 키워드
        withContext(Dispatchers.IO) {
            for (i in 1..10000) {
                Log.e("delay : ", "" + i)
            } // 로그 입력값이 쌓임.

            runOnUiThread {
                cancelProgressDialog()
                Toast.makeText(
                    this@MainActivity, result,
                    Toast.LENGTH_SHORT
                ).show() // Toast : foreground 또는 ui 작업 -> Dispatchers.IO에서 작동 X
            }
        }
    } // withContext : 프로세스가 완료될 때까지 작업을 다른 스레드로 이동시키기 위해 만들어진 메소드
    // 그런 다음 원래 스레드로 다시 이동

    // 뭔가를 실행하는 동안 사용자가 응답을 기다리길 원하면

    private fun cancelProgressDialog() { // progress dialog 취소, 다른 방법으로 x
        if (customProgressDialog != null) {
            customProgressDialog?.dismiss()
            customProgressDialog = null
        }
    }
    private fun showProgressDialog() {
        customProgressDialog = Dialog(this@MainActivity)

        customProgressDialog?.setContentView(R.layout.dialog_custom_progress)

        customProgressDialog?.show()
    }
}