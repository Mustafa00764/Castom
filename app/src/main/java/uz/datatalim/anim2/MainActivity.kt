package uz.datatalim.anim2

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val bSimDialog=findViewById<Button>(R.id.b_SimpleDialog)
        val bCusDialog=findViewById<Button>(R.id.b_CustomDialog)

        val dialog = Dialog(this)

        bSimDialog.setOnClickListener {
            val dialog=AlertDialog.Builder(this)
            dialog.setIcon(R.drawable.ic_android)
            dialog.setMessage("bu yerda sizning reklamangiz bo'lishi mumkin edi")
            dialog.setTitle("Bu sizning reklamangiz")
            dialog.setCancelable(false)
            dialog.setPositiveButton("yes",object :DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(this@MainActivity,"yes tugmasi bosildi",Toast.LENGTH_SHORT).show()
                }

            })
            dialog.setNegativeButton("no",object :DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(this@MainActivity,"no tugmasi bosuldi",Toast.LENGTH_SHORT).show()
                }

            })
            dialog.show()
        }

        bCusDialog.setOnClickListener {

            dialog.apply {
                setContentView(R.layout.item_dialog)
            }
            dialog.setCancelable(false)
            dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            val etValue = dialog.findViewById<EditText>(R.id.et_enter)
            val bDone = dialog.findViewById<Button>(R.id.b_done)
            val ivCansel = dialog.findViewById<ImageView>(R.id.iv_cansel)
            ivCansel.setOnClickListener{
                dialog.dismiss()
            }
            dialog.show()

        }
    }
}