package tj.rsdevteam.kotlincoroutinestest

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.delay
import kotlin.random.Random

/**
 * Created by Rustam Safarov on 6/1/22.
 * github.com/rustamsafarovrs
 */

class MainRepositoryImpl : MainRepository {

    override fun getData(): LiveData<Event<Resource<Response>>> {
        return liveData {
            try {
                emit(Event(Resource.loading()))
                delay(1000)
                emit(Event(Resource.success(Response(Random.nextInt(10), "Success", null))))
            } catch (e: Exception) {
                emit(Event(Resource.error("Error", null, e)))
            }
        }
    }
}