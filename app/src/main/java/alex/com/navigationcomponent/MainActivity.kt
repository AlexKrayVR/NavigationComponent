package alex.com.navigationcomponent

import alex.com.navigationcomponent.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*

class MainActivity : AppCompatActivity() {

    //https://habr.com/ru/post/416025/

    //Архитектурный компонент Navigation имеет плагин Gradle, называемый safeargs.
    // Он генерирует простейшие классы для type-safe доступа к аргументам экранов назначения и действий.
    // Подход safeargs построен на основе использования Bundle,
    // но требует немного дополнительного кода для большей типовой безопасности.
    // Чтобы добавить этот плагин, вставьте строку androidx.navigation.safeargs в build.gradle
    //также, нужно добавить в build.gradle (Project: ProjectName)
    // зависимость classpath "android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-alpha02":

    //Системная кнопка Back тоже работает и выполняет шаг назад. Это происходит благодаря атрибуту
    //app:defaultNavHost="true"
    //который мы указали в контейнере (NavHostFragment). Контейнер перехватывает нажатия и показывает предыдущий фрагмент.
    //Если установить его значение в false, то контейнер больше не будет обрабатывать системную кнопку Back, и Activity будет закрываться.

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        binding.apply {

            appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.searchFragment),drawerLayout)

            setSupportActionBar(toolbar)
            bottomNavigationView.setupWithNavController(navController)

            navView.setupWithNavController(navController)

        }
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp() = navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return if (item.itemId == R.id.termsFragment) {
            val action = NavGraphDirections.actionGlobalTermsFragment()
            navController.navigate(action)
            true
        } else {
            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }
    }
}