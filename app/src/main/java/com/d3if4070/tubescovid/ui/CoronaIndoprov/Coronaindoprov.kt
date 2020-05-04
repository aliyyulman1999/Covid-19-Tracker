package com.d3if4070.tubescovid.ui.CoronaIndoprov

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.d3if4070.tubescovid.R
import com.d3if4070.tubescovid.ui.CoronaIndoprov.adapter.ProvAdapter
import com.d3if4070.tubescovid.ui.CoronaIndoprov.data.Provinsi
import kotlinx.android.synthetic.main.corona_global_fragment.*


class Coronaindoprov : Fragment() {

    companion object {
        fun newInstance() = Coronaindoprov()
    }

    private lateinit var list : RecyclerView
    private var provAdapter: ProvAdapter? = null
    private var provDatalist : ArrayList<Provinsi>? = null
    lateinit var cari : EditText
    private lateinit var viewModel: CoronaindoprovViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.coronaindoprov_fragment, container, false)
        (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.menu_dataindonesiprov)

        cari = root.findViewById(R.id.cariprov)
        list = root.findViewById(R.id.listprov)

        val layoutManager = LinearLayoutManager(requireContext())
        list.setLayoutManager(layoutManager)

        provDatalist    = ArrayList()
        provAdapter     = ProvAdapter(provDatalist)
        list.adapter    = provAdapter

        viewModel = ViewModelProvider(this).get(CoronaindoprovViewModel::class.java)

        cari.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                provAdapter!!.filter.filter(p0.toString())
            }
            override fun afterTextChanged(p0: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        viewModel.getStatus().observe(viewLifecycleOwner, Observer {
            if (it == true ) {
                progressBar.visibility = View.VISIBLE
            }else {
                progressBar.visibility = View.GONE
            }
        })

        viewModel.getData().observe(viewLifecycleOwner, Observer {
            showDataProvIndo(it)
        })

        return root
    }

    private fun showDataProvIndo(data: List<Provinsi>) {
        provDatalist?.clear()
        provDatalist?.addAll(data)
        provAdapter?.notifyDataSetChanged()
    }

}
