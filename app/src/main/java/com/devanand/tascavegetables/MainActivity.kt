package com.devanand.tascavegetables

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.devanand.tascavegetables.databinding.ActivityMainBinding
import com.devanand.tascavegetables.viewmodel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val cartViewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{ _, destination, _ ->

            binding.bottomNav.visibility = if (destination.id == R.id.loginFragment){
                View.GONE
            }else{
                View.VISIBLE
            }

        }

        binding.bottomNav.setOnItemSelectedListener { item ->

            when (item.itemId){
                R.id.dashboardFragment -> {
                    if (navController.currentDestination?.id != R.id.dashboardFragment){
                        navController.navigate(R.id.dashboardFragment)
                    }
                    true
                }

                R.id.cartFragment -> {
                    if (navController.currentDestination?.id != R.id.cartFragment){
                        navController.navigate(R.id.cartFragment)
                    }
                    true
                }
                else -> false
            }

        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}