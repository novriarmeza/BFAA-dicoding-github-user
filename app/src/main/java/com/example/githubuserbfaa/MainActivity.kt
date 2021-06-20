package com.example.githubuserbfaa

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var edtName: Array<String>
    private lateinit var edtUserName: Array<String>
    private lateinit var edtCompany: Array<String>
    private lateinit var edtRepository: Array<String>
    private lateinit var edtFollowers: Array<String>
    private lateinit var edtFollowing: Array<String>
    private lateinit var edtAvatar: TypedArray
    private lateinit var edtLocation: Array<String>

    private var users = arrayListOf<User>()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.elevation?.compareTo(0)

        val listView: RecyclerView = findViewById(R.id.rv)

        adapter = UserAdapter()
        listView.adapter = adapter

        itemlist()
        showRecyclerView()
        showData()

    }

    private fun itemlist() {
        edtUserName = resources.getStringArray(R.array.username)
        edtName = resources.getStringArray(R.array.name)
        edtLocation = resources.getStringArray(R.array.location)
        edtRepository = resources.getStringArray(R.array.repository)
        edtCompany = resources.getStringArray(R.array.company)
        edtFollowers = resources.getStringArray(R.array.followers)
        edtFollowing = resources.getStringArray(R.array.following)
        edtAvatar = resources.obtainTypedArray(R.array.avatar)
    }

    private fun showRecyclerView(){
        val layoutManager = LinearLayoutManager(this)
        rv?.setLayoutManager(layoutManager)
        rv?.setHasFixedSize(true)
    }

    private fun showData() {
        for (position in edtName.indices) {
            val user = User(
                edtUserName[position],
                edtName[position],
                edtRepository[position],
                edtFollowers[position],
                edtFollowing[position],
                edtLocation[position],
                edtCompany[position],
                edtAvatar.getResourceId(position, -1)
            )
            users.add(user)
        }
        adapter.userList = users
    }
}