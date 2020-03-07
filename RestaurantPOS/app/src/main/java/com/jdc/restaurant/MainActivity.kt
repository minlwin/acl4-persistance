package com.jdc.restaurant

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.jdc.restaurant.ui.model.ShoppingCart
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cart by viewModels<ShoppingCart>()

        setSupportActionBar(toolbar)
        navController = nav_host_fragment.findNavController()

        appBarConfiguration = AppBarConfiguration(navController.graph, drawer_layout)

        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
                R.id.action_home_categories, R.id.categories -> {
                    fab.setOnClickListener {
                        navController.navigate(R.id.action_edit_category)
                    }

                    fab.show()
                }

                R.id.action_home_products, R.id.products -> {
                    fab.setOnClickListener {
                        navController.navigate(R.id.action_add_product)
                    }

                    fab.show()
                }

                else  -> fab.hide()
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {

        if(::navController.isInitialized) {
            return navController.navigateUp(appBarConfiguration)
        }
        return super.onSupportNavigateUp()
    }

}
