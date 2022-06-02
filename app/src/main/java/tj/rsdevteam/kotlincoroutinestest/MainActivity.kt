package tj.rsdevteam.kotlincoroutinestest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import tj.rsdevteam.kotlincoroutinestest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.getDataResource.observe(this) {
            it.getContentIfNotHandled()?.let { rs ->
                when (rs.status) {
                    Status.LOADING -> {

                    }
                    Status.SUCCESS -> {
                        viewModel.onGetDataResourceSuccess(rs.data)
                    }
                    Status.ERROR -> {

                    }
                }
            }
        }

    }
}