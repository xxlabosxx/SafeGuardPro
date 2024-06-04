//package com.gustavolabos.myapplication.view
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.provider.ContactsContract.CommonDataKinds.Email
//import androidx.navigation.NavController
//import androidx.navigation.fragment.NavHostFragment
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.setupWithNavController
//import com.estudadospelanasa.safeguardpro.databinding.ActivityMainBinding
//import java.time.LocalDate
//import java.time.LocalDateTime
//
//class MainActivity : AppCompatActivity() {
//
//    //CHAMAR A TOOL BAR QUE APARECE NA PARTE SUPERIOR
//    private lateinit var appBarConfiguration: AppBarConfiguration
//
//    //CRIAR A NAVEGAÇÃO
//    private lateinit var navController: NavController
//
//    //CRIAÇÃO DO BINDING
//    private var _binding: ActivityMainBinding? = null
//    private val binding: ActivityMainBinding get() = _binding!!
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //CONFIGURA O BINDING
//        _binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
//        //Configura a navegação
//        navController = navHostFragment.navController
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//    }
//}