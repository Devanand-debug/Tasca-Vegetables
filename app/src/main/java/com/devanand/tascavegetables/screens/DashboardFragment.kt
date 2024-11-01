package com.devanand.tascavegetables.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.devanand.tascavegetables.R
import com.devanand.tascavegetables.adapter.VegetablesAdapter
import com.devanand.tascavegetables.databinding.FragmentDashboardBinding
import com.devanand.tascavegetables.model.Vegetables
import com.devanand.tascavegetables.viewmodel.CartViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private lateinit var binding : FragmentDashboardBinding

    private val cartViewModel: CartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vegList = listOf(
            Vegetables(R.drawable.potato,"Potato","Rs. 49/- kg"),
            Vegetables(R.drawable.apple,"Apple","Rs. 149/- kg"),
            Vegetables(R.drawable.banana,"Banana","Rs. 49/- kg"),
            Vegetables(R.drawable.bhendi,"Bhendi","Rs. 79/- kg"),
            Vegetables(R.drawable.cabbage,"Cabbage","Rs. 59/- kg"),
            Vegetables(R.drawable.bit_root,"Bit Root","Rs. 10/- kg"),
            Vegetables(R.drawable.aubergine,"Aubergine","Rs. 79/- kg"),
            Vegetables(R.drawable.beans_french,"Beans French","Rs. 69/- kg"),
            Vegetables(R.drawable.bitter_gourd,"Bitter Gourd","Rs. 89/- kg"),
            Vegetables(R.drawable.broccoli,"Broccoli","Rs. 89/- kg"),
            Vegetables(R.drawable.capcicum,"Capsicum","Rs. 79/- kg"),
            Vegetables(R.drawable.carrot,"Carrot","Rs. 69/- kg"),
            Vegetables(R.drawable.cauliflower,"Cauliflower","Rs. 79/- kg"),
            Vegetables(R.drawable.coriander,"Coriander","Rs. 19/- kg"),
            Vegetables(R.drawable.cucumber,"Cucumber","Rs. 39/- kg"),
            Vegetables(R.drawable.eggplant,"EggPlant","Rs. 79/- kg"),
            Vegetables(R.drawable.ginger,"Ginger","Rs. 15/- kg"),
            Vegetables(R.drawable.green_chilly,"Green Chilly","Rs. 59/- kg"),
            Vegetables(R.drawable.tomato,"Tomato","Rs. 79/- kg"),
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
       // binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recyclerView.adapter = VegetablesAdapter(vegList, cartViewModel)


        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav)

        val cartBadge = bottomNavigationView.getOrCreateBadge(R.id.cartFragment)
        cartBadge.isVisible = false

        cartViewModel.cartCount.observe(viewLifecycleOwner){ count ->
            Log.e("cartCount2","$count")
            if (count > 0){
                cartBadge.isVisible = true
                cartBadge.number = count
            }else{
                cartBadge.isVisible = false
            }
        }

    }

}