package com.aucean.vmtest.mvvm

/**
 * Created by jie on 2017/5/23.
 */

class ResponseModel<T> : Optional<T> {
    /**
     * Same as the response.status
     */
    var statusCode: Int = 0

    /**
     * usually used for error message
     */
    var message: String? = null

    /**
     * total records for array models
     */
    var totalCount: Int = 0

    /**
     * for object result which can't be simple returned as message
     */
    var result: T? = null

    override fun ifPresent(apply: (T) -> Unit): T? {
        return result?.apply {
            apply(this)
        }
    }

    override fun takeData(hasData: (T) -> Unit, noData: ()->Unit) {
        result?.run {
            hasData(this)
        } ?: noData()
    }
}
