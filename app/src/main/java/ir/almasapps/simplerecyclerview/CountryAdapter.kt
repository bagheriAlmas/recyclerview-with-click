package ir.almasapps.simplerecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(var context:Context,var list:List<Country>,var recyclerVeiwLayoutType : Int, val itemClickListener:(Country)->Unit) : RecyclerView.Adapter<CountryAdapter.Holder>() {
    inner class Holder(itemView: View,val itemClickListener:(Country)->Unit) : RecyclerView.ViewHolder(itemView){

        var imgFlag : ImageView = itemView.findViewById(R.id.item_imgFlag)
        var txtName : TextView = itemView.findViewById(R.id.item_txtName)
        var txtContinent : TextView = itemView.findViewById(R.id.item_txtContinent)
        var txtPopulation : TextView = itemView.findViewById(R.id.item_txtPopulation)

        fun bindData(context: Context,country: Country){
            imgFlag.setImageResource(country.image)
            txtName.text = country.name
            txtContinent.text = country.continent
            txtPopulation.text = country.population

            itemView.setOnClickListener{
                itemClickListener(country)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var view = LayoutInflater.from(context).inflate(R.layout.list_items_linear,parent,false)

        if (recyclerVeiwLayoutType==2){
            view = LayoutInflater.from(context).inflate(R.layout.list_items_grid,parent,false)
        }

        return Holder(view,itemClickListener)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(context,list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}