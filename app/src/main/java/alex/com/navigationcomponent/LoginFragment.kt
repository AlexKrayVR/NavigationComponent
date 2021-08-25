package alex.com.navigationcomponent

import alex.com.navigationcomponent.databinding.FragmentHomeBinding
import alex.com.navigationcomponent.databinding.FragmentLoginBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val args: LoginFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val usernameDeepLink = args.username



        val binding = FragmentLoginBinding.bind(view)
        binding.apply {

            name.setText(usernameDeepLink)
            button.setOnClickListener {


                val userName = name.text.toString()
                val password = password.text.toString()


                val action =
                    LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(userName, password)
                findNavController().navigate(action) //compile safety if we not use by id
            }
        }
    }

}