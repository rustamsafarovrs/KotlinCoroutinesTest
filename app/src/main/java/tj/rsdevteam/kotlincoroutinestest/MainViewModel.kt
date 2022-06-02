package tj.rsdevteam.kotlincoroutinestest

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * Created by Rustam Safarov on 6/1/22.
 * github.com/rustamsafarovrs
 */

class MainViewModel : ViewModel() {

    private val TAG: String? = javaClass.simpleName

    private val repository: MainRepository = MainRepositoryImpl()

    val response = MutableLiveData<String>()

    /**
     * Network
     *
     */

    private val getData = MutableLiveData<Unit>()

    val getDataResource = Transformations.switchMap(getData) {
        repository.getData()
    }

    init {
        getData.postValue(Unit)
    }

    /**
     * Content
     *
     */

    fun onGetDataResourceSuccess(data: Response?) {
        val tmp = data!!.data!!
        Log.i(TAG, "onGetDataResourceSuccess: $tmp")

        response.postValue(data.toString())
    }

}