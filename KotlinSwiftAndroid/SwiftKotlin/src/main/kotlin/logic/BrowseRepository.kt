package logic

/**
 * Created by agallo on 2/1/18.
 */
import platform.Foundation.*
import platform.darwin.NSObject
import kotlinx.cinterop.*

open class BrowseRepository() {

    fun loadData(urlString: String, completion: (ArrayList<BrowseProduct>) -> Unit) {
        val request = RequestService()
        request.asyncRequest(urlString) { data ->
            parseJsonResponse(data, completion)
        }
    }

    private fun parseJsonResponse(data: NSData, completion: (ArrayList<BrowseProduct>) -> Unit) {
        val jsonObject = memScoped {
            val errorVar = alloc<ObjCObjectVar<NSError?>>()
            val result = NSJSONSerialization.JSONObjectWithData(data, 0, errorVar.ptr)
            val error = errorVar.value
            if (error != null) {
                throw Error("JSON parsing error: $error")
            }
            result!!
        }
        val dict = jsonObject.reinterpret<NSDictionary>()
        val response = dict.dictValueForKey("response")!!
        val browse = response.dictValueForKey("browse")!!
        val productCollection = browse.arrayValueForKey("product_collection")!!

        val browseProducts = arrayListOf<BrowseProduct>()
        for (i in 0 until productCollection.count - 1) {
            val obj = productCollection.objectAtIndex(i)
            if(obj != null) {
                val product = obj.reinterpret<NSDictionary>()
                val name = product.stringValueForKey("product_name")
                val manufacturer = product.stringValueForKey("manufacturer")
                val price = product.stringValueForKey("list_price")
                val sku = product.stringValueForKey("sku")
                if(name != null && manufacturer != null && sku != null && price != null) {
                    browseProducts.add(BrowseProduct(name, manufacturer, price, sku))
                }
            }
        }
        completion(browseProducts)
    }
}
