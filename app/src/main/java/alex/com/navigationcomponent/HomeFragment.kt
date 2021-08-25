package alex.com.navigationcomponent

import alex.com.navigationcomponent.databinding.FragmentHomeBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment(R.layout.fragment_home) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentHomeBinding.bind(view)
        binding.apply {
            loginButton.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
                findNavController().navigate(action) //compile safety if we use by id
            }
        }

    }
}