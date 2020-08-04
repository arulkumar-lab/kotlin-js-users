package org.arului

import org.arului.modal.UserImage
import org.w3c.xhr.XMLHttpRequest

class UserImagePresenter : UserImageContract.Presenter {

    private lateinit var view: UserImageContract.View

    override fun attach(view: UserImageContract.View) {
        this.view = view
    }

    override fun loadUserImages() {
        view.showLoader()
        getAsync(API_URL) { response ->
            val userImage = JSON.parse<Array<UserImage>>(response)
            view.hideLoader()
            view.showUserImages(userImage.toList())
        }
    }

    private fun getAsync(url: String, callback: (String) -> Unit) {
        val xmlHttp = XMLHttpRequest()
        xmlHttp.open("GET", url, true);
        //xmlHttp.withCredentials = true;
        //xmlHttp.setRequestHeader("Access-Control-Allow-Origin", "*");
        //xmlHttp.setRequestHeader("Access-Control-Allow-Methods", "HEAD, GET, POST, PUT, PATCH, DELETE");
        //xmlHttp.setRequestHeader("Access-Control-Allow-Headers","Origin, Content-Type, X-Auth-Token");
        //xmlHttp.setRequestHeader("Content-Type", "application/json");
        xmlHttp.onload = {
            if (xmlHttp.readyState == 4.toShort() && xmlHttp.status == 200.toShort()) {
                callback.invoke(xmlHttp.responseText)
            }
        }
        xmlHttp.send()
    }
}