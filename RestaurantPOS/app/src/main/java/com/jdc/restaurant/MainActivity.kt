package com.jdc.restaurant

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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
    private lateinit var shoppingCart: ShoppingCart

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("com.jdc.shop", "On Create")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cart by viewModels<ShoppingCart>()
        shoppingCart = cart

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
        Log.d("com.jdc.shop", "onCreateOptionsMenu")

        menuInflater.inflate(R.menu.main, menu)
        val item = menu.findItem(R.id.action_cart)

        val actionView = item.actionView

        shoppingCart.count.observe(this, Observer {
            item.isVisible = it != 0
            val countView = actionView.findViewById<TextView>(R.id.cartCount)
            countView.text = it.toString()
        })

        actionView.setOnClickListener {
            navController.navigate(R.id.action_global_sale)
        }

        return true
    }

    override fun onSupportNavigateUp(): Boolean {

        if(::navController.isInitialized) {
            return navController.navigateUp(appBarConfiguration)
        }
        return super.onSupportNavigateUp()
    }

}
