package tj.rsdevteam.kotlincoroutinestest

import androidx.lifecycle.LiveData

/**
 * Created by Rustam Safarov on 6/1/22.
 * github.com/rustamsafarovrs
 */

interface MainRepository {

    fun getData(): LiveData<Event<Resource<Response>>>
}