package alex.com.navigationcomponent

import alex.com.navigationcomponent.databinding.FragmentLoginBinding
import alex.com.navigationcomponent.databinding.FragmentWelcomeBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private val args: WelcomeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val binding = FragmentWelcomeBinding.bind(view)
        binding.apply {

            userName.text = args.username
            userPassword.text = args.password

            ok.setOnClickListener {
                val action = WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment()
                findNavController().navigate(action)
            }


        }

    }
}