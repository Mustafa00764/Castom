package uz.datatalim.anim2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.datatalim.anim2.R
import uz.datatalim.anim2.mode.Note

class NoteAdapter(val list:ArrayList<Note>):RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(view: View):RecyclerView.ViewHolder(view){
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horizantal,parent,false)
//        return  HorizantalViewholder(view)
        val tv_time = view.findViewById<TextView>(R.id.tv_time)
        val tv_text = view.findViewById<TextView>(R.id.tv_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false)
        return NoteViewHolder(view)
    }

    override fun getItemCount()=list.size



    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = list[position]

        holder.apply {
            tv_time.text = note.time
            tv_text.text = note.text
        }
    }
}