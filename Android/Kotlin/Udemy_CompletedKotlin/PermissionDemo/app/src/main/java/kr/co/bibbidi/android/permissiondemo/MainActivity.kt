package kr.co.bibbidi.android.permissiondemo

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private val cameraResultLauncher : ActivityResultLauncher<String> =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()) {
                isGranted ->
                if(isGranted) {
                    Toast.makeText(this, "Permission granted for camera", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Permission denied for camera", Toast.LENGTH_LONG).show()
                }
            }

    private val cameraAndLocationResultLauncher : ActivityResultLauncher<Array<String>> =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()) {
            permissions ->
            permissions.entries.forEach{
                val permissionName = it.key
                val isGranted = it.value
                if (isGranted) { // 승인 했을 경우
                    if (permissionName == Manifest.permission.ACCESS_FINE_LOCATION) {
                        Toast.makeText(
                            this,
                            "Permission granted for location",
                            Toast.LENGTH_LONG
                        ).show()
                    } else if (permissionName == Manifest.permission.ACCESS_COARSE_LOCATION){
                        Toast.makeText(
                            this,
                            "Permission granted for COARSE",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    else {
                        Toast.makeText(
                            this,
                            "Permission granted for Camera",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else { // 승인하지 않았을 경우
                    if (permissionName == Manifest.permission.ACCESS_FINE_LOCATION) {
                        Toast.makeText(
                            this,
                            "Permission denied for fine location",
                            Toast.LENGTH_LONG
                        ).show()
                    } else if (permissionName == Manifest.permission.ACCESS_COARSE_LOCATION){
                        Toast.makeText(
                            this,
                            "Permission denied for COARSE",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            this,
                            "Permission denied for Camera",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCameraPermission : Button = findViewById<Button>(R.id.btnCameraPermission)
        btnCameraPermission.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && shouldShowRequestPermissionRationale(android.Manifest.permission.CAMERA)) { // 권한이 무시되었을 경우
                    showRationaleDialog("Permissoin Demo requires camera access",
                    "Camera cannot be used because Camera access is denied")
            } else {
                //cameraResultLauncher.launch(android.Manifest.permission.CAMERA) // 카메라 권한 승인 다이얼로그
                cameraAndLocationResultLauncher.launch(
                    arrayOf(Manifest.permission.CAMERA,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
        }
    }

    private fun showRationaleDialog(
        title: String,
        message: String,
    ) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton("Cancel"){dialog, _->
                dialog.dismiss()
            }
        builder.create().show()
    }
}