package com.jdc.students.ui.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.jdc.students.R
import com.jdc.students.ui.converter.DateFormatter
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.util.*

open class BaseFragment:Fragment() {

    private lateinit var activity: AppCompatActivity

    protected val toolbar: Toolbar
        get() = activity.toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity = requireActivity() as AppCompatActivity
        clearActions()
        toolbar.subtitle = ""
    }

    protected fun init(action:Action) = when(action){
        Action.Search -> {
            clearActions()
            toolbar.menu.findItem(R.id.search).isVisible = true
        }

        Action.Date -> {
            clearActions()
            toolbar.menu.findItem(R.id.search_date).isVisible = true
        }

        Action.None -> clearActions()
    }

    protected fun closeSearch() {
        val menuItem = toolbar.menu.findItem(R.id.search)
        menuItem?.collapseActionView()
        val searchView = menuItem?.actionView as? SearchView
        searchView?.setQuery("", false)
    }

    protected inline fun setSearchListener(crossinline listener:(String?) -> Boolean) {
        toolbar.menu.findItem(R.id.search)?.also {

            val searchView = it.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?) = listener(query).also {
                    commit(query)
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if(newText == null || newText.isEmpty()) {
                        listener(newText)
                    }

                    return true
                }

                private fun commit(text:String? = null) {

                    if(null == text || text.isEmpty()) {
                        toolbar.subtitle = ""
                    } else {
                        toolbar.subtitle = "Search by $text"
                    }

                    it.collapseActionView()
                }

            })
        }
    }

    protected inline fun setDateSearchListener(crossinline listener: (Date?) -> Unit) {
        toolbar.menu.findItem(R.id.search_date)?.also {
            it.setOnMenuItemClickListener {

                val calendar = Calendar.getInstance()
                calendar.set(Calendar.DAY_OF_MONTH, 1)

                val dialog = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { _, year, month, day ->
                    calendar.set(Calendar.YEAR, year)
                    calendar.set(Calendar.MONTH, month)
                    calendar.set(Calendar.DAY_OF_MONTH, day)

                    toolbar.subtitle = "From ${DateFormatter.format(calendar.time)}"
                    listener(calendar.time)

                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))

                dialog.show()
                true
            }
        }
    }

    private fun clearActions() {
        toolbar.menu.findItem(R.id.search)?.isVisible = false
        toolbar.menu.findItem(R.id.search_date)?.isVisible = false
    }

    enum class Action {
        Search, Date, None
    }
}