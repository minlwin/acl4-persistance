package com.jdc.students

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        navController = fragment.findNavController()

        appBarConfiguration = AppBarConfiguration.Builder(
            navController.graph
        ).setDrawerLayout(drawerLayout).build()

        setupActionBarWithNavController(navController, appBarConfiguration)
        drawerMenu.setupWithNavController(navController)

        handleFloatingActionButton()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController?.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun handleFloatingActionButton() {
        navController.addOnDestinationChangedListener { _, d, _ ->
            when (d.id) {
                R.id.courses -> {
                    fab.setOnClickListener {
                        navController.navigate(R.id.action_courses_to_edit_course)
                    }
                    fab.show()
                }

                R.id.classRooms -> {
                    fab.setOnClickListener {
                        navController.navigate(R.id.action_global_edit_class)
                    }
                    fab.show()
                }

                R.id.registrations -> {

                    fab.show()
                }

                else -> fab.hide()
            }
        }
    }

}
