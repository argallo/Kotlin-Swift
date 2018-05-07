package logic

/**
 * Created by agallo on 2/1/18.
 */

import platform.Foundation.*
import platform.darwin.NSObject
import kotlinx.cinterop.*

open class RequestService() {
    private var requestInProgress = false

    internal fun asyncRequest(url: String, completionHandler: (NSData) -> Unit): Boolean {
        if (requestInProgress) return false
        requestInProgress = true

        val delegate = object : NSObject(), NSURLSessionDataDelegateProtocol {
            val receivedData = NSMutableData()

            override fun URLSession(session: NSURLSession, dataTask: NSURLSessionDataTask, didReceiveData: NSData) {
                receivedData.appendData(didReceiveData)
            }

            override fun URLSession(session: NSURLSession, task: NSURLSessionTask, didCompleteWithError: NSError?) {
                requestInProgress = false // Only main thread accesses the fetcher, so it's safe to clear the flag here.

                val response = task.response
                if (response == null || response.reinterpret<NSHTTPURLResponse>().statusCode.toInt() != 200) {
                    return
                }

                if (didCompleteWithError != null) {
                    return
                }

                // TODO: report errors.

                completionHandler(receivedData)
            }
        }

        val session = NSURLSession.sessionWithConfiguration(
                NSURLSessionConfiguration.defaultSessionConfiguration(),
                delegate,
                delegateQueue = NSOperationQueue.mainQueue()
        )

        session.dataTaskWithURL(NSURL(URLString = url)).resume()

        return true
    }

}

internal fun NSDictionary.stringValueForKey(key: String): String? =
        this.valueForKey(key)?.let { it.reinterpret<NSString>().toString() }

internal fun NSDictionary.dictValueForKey(key: String): NSDictionary? =
        this.valueForKey(key)?.let { it.reinterpret<NSDictionary>() }

internal fun NSDictionary.arrayValueForKey(key: String): NSArray? =
        this.valueForKey(key)?.let { it.reinterpret<NSArray>() }

internal fun NSDictionary.intValueForKey(key: String): Int? =
        this.valueForKey(key)?.let { it.reinterpret<NSNumber>().integerValue().toInt() }

