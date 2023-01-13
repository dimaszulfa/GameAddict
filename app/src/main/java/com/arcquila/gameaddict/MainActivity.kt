package com.arcquila.gameaddict

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.arcquila.gameaddict.databinding.ActivityMainBinding
import com.arcquila.gameaddict.ui.favorite.FavoriteFragment
import com.arcquila.gameaddict.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFramgent(HomeFragment())
        binding.navigation.setOnItemSelectedListener {
            navigationMenus(it)
        }


    }

    private fun loadFramgent(fragment: Fragment) {
        val transaction = supportFragmentManager
        val fragment = fragment
        transaction.beginTransaction().replace(R.id.content, fragment).commit()

    }

    private fun navigationMenus(v: MenuItem): Boolean {
        return when (v.itemId) {
            R.id.navigation_home -> {
                loadFramgent(HomeFragment())
                true
            }
            R.id.navigation_favorite -> {
                loadFramgent(FavoriteFragment())
                true
            }
            else -> {
                Toast.makeText(
                    this@MainActivity,
                    "There is no option menu anymore, we may fix this trouble asap",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
        }
    }


}