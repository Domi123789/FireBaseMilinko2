package hr.milinko.firebasemilinko

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.milinko.firebasemilinko.databinding.TextItemBinding

class TextAdapter (
    private val list: ArrayList<Tekst>,
    private val th: Context,
    private val listener: (Int)->Unit
    ):
    RecyclerView.Adapter <TextAdapter.ViewHolder>()


    {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextAdapter.ViewHolder {
            val v= TextItemBinding.inflate(LayoutInflater.from(th), parent, false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: TextAdapter.ViewHolder, position: Int) {
            holder.bindItem(list[position],th)
            holder.itemView.setOnClickListener{
                listener(position) }
        }

        override fun getItemCount(): Int {
            return list.size
        }


        class ViewHolder (private var itemBinding: TextItemBinding): RecyclerView.ViewHolder(itemBinding.root){
                fun bindItem (text: Tekst, th:Context){
                    itemBinding.text.text=text.text
                    itemBinding.description.text=text.description
                    itemBinding.number.text=text.id.toString()}
        }
}