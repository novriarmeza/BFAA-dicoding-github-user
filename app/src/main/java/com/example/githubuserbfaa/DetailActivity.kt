package com.example.githubuserbfaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var dataUser : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        iconBack.setOnClickListener{
            finish()
        }
        supportActionBar?.elevation?.compareTo(0)

        dataUser = intent.getParcelableExtra("detail")!!

        edtUsername.setText(dataUser.username)
        edtName.setText(dataUser.name)
        edtRepository.setText(dataUser.repository)
        edtFollowers.setText(dataUser.followers)
        edtFollowing.setText(dataUser.following)
        edtLocation.setText(dataUser.location)
        edtCompany.setText(dataUser.company)
        Glide.with(this).load(dataUser.avatar).into(img_profile)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}