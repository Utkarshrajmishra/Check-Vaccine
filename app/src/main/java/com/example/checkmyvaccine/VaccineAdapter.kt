package com.example.checkmyvaccine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VaccineAdapter:RecyclerView.Adapter<VaccineAdapter.VaccineViewHolder>() {

  private  val allvaccine:ArrayList<Vaccine> = ArrayList()

    inner class VaccineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val hosname= itemView.findViewById<TextView>(R.id.name)
        val timefrom=itemView.findViewById<TextView>(R.id.from)
        val timeto=itemView.findViewById<TextView>(R.id.to)
        val fees=itemView.findViewById<TextView>(R.id.fee)
        val centeraddrress=itemView.findViewById<TextView>(R.id.address)
        val vaccinetype=itemView.findViewById<TextView>(R.id.vaccinetype)

        val minage=itemView.findViewById<TextView>(R.id.min_age)
        val minvacc=itemView.findViewById<TextView>(R.id.vaccineava)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineViewHolder {
        val view =VaccineViewHolder(
            LayoutInflater.from(parent. context).inflate(
                R.layout.item_list, parent, false
            )
        )
        return view
    }
    override fun onBindViewHolder(holder: VaccineViewHolder, position: Int) {
       val currentItem=allvaccine[position]

             holder.hosname.text=currentItem.namevac
             holder.timefrom.text=currentItem.timefrom
              holder.timeto.text=currentItem.timeto
        holder.centeraddrress.text=currentItem.addressvac
        holder.fees.text=currentItem.fee_type
        holder.vaccinetype.text=currentItem.vaccinebrand
        holder.minage.text=currentItem.minagelimit
        holder.minvacc.text=currentItem.availablecapacity

    }

    fun updateNews(updatedNews: ArrayList<Vaccine>) {
        allvaccine.clear()
        allvaccine.addAll(updatedNews)

        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return allvaccine.size
    }
}
