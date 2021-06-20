package com.example.githubuserbfaa

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter: RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    internal var userList = ArrayList<User>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var edtNameView : TextView = itemView.findViewById(R.id.edtName)
        var edtCompanyView : TextView = itemView.findViewById(R.id.edtCompany)
        var img_profile : ImageView = itemView.findViewById(R.id.img_profile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = userList.get(position)

        holder.edtNameView.setText(data.name)
        holder.edtCompanyView.setText(data.company)

        Glide.with(holder.itemView.context)
            .load(userList.get(position).avatar)
            .into(holder.img_profile)

        holder.itemView.setOnClickListener { v ->
            Toast.makeText(v.context, userList[position].name, Toast.LENGTH_SHORT).show()
            val moveWithObject = Intent(v.context, DetailActivity::class.java)
            moveWithObject.putExtra("detail", data)
            v.context.startActivity(moveWithObject)
        }
    }


}