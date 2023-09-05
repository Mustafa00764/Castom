package uz.datatalim.anim2.ui

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.datatalim.anim2.R
import uz.datatalim.anim2.UserRepository
import uz.datatalim.anim2.adapter.NoteAdapter
import uz.datatalim.anim2.mode.Note

class MainActivity : AppCompatActivity() {
lateinit var adapter:NoteAdapter
    lateinit var repository: UserRepository

lateinit var list:ArrayList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val bNote=findViewById<FloatingActionButton>(R.id.fab_add)


        val rvn2 = findViewById<RecyclerView>(R.id.rv_note)
        rvn2.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvn2.adapter = NoteAdapter(list)
        val dialog = Dialog(this)

        bNote.setOnClickListener {

            dialog.apply {
                setContentView(R.layout.item_dialog)
            }
            dialog.setCancelable(false)
            dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            val etValue = dialog.findViewById<EditText>(R.id.et_enter)
            val tvSave = findViewById<TextView>(R.id.tv_save)
            val tvtime = findViewById<TextView>(R.id.tv_time)
            val tvtext = findViewById<TextView>(R.id.tv_text)
            val tvCancel = dialog.findViewById<TextView>(R.id.tv_cancel)
            tvCancel.setOnClickListener{
                dialog.dismiss()
            }
            tvSave.setOnClickListener {
                val time= tvtime.text
                val text=tvtext.text
                val note=Note(null,time,text)
                repository.saveUser(note)
                loadNote()
//                repository.saveUser(user)
//                loadUsers()
//                adapter.submitList(users)
            }
            dialog.show()

        }

    }

    private fun loadNote() {
            list=ArrayList()
            list = repository.getAllUsers() as ArrayList<Note>
    }
}