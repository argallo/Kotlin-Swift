package logic

import platform.Foundation.*
import platform.darwin.NSObject
import kotlinx.cinterop.*

open class Words {



    fun getWords(): String? {
        return "Two apps using business Logic"
    }

    fun inside(completionHandler: (String) -> Unit) {
        completionHandler("HI")
    }

    fun testing(completionHandler: (String) -> Unit) {
        val url = NSURL.URLWithString(URLString = "https://www.wayfair.com/v/category/display?&category_id=413892&curpage=1&itemsperpage=24&_show_summary=true&_format=json")
        inside() { string ->
            print(string)
        }
    }

    fun test() {
        val urlString = "https://www.wayfair.com/v/category/display?&category_id=413892&curpage=1&itemsperpage=24&_show_summary=true&_format=json"
        val repo = BrowseRepository()
        repo.loadData(urlString) { browseProductList ->
            print(browseProductList)
        }
    }

    fun test2() {}



}
